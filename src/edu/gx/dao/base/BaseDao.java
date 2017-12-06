package edu.gx.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import edu.gx.dao.service.impl.SystemContext;
import edu.gx.user.model.Pager;

@SuppressWarnings("unchecked")
@Transactional
public class BaseDao<T>  implements IBaseDao<T> {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * 创建一个Class的对象来获取泛型的class
	 */
	private Class<?> clz;
	
	public Class<?> getClazz(){
		if(null==clz){
			//获取泛型的Class对象
		 clz =  (Class<?>)(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
		}
		return clz;
	}
	
	protected Session getSession(){
		System.out.println(sessionFactory);
		//return sessionFactory.openSession();
		return sessionFactory.getCurrentSession();
	}
@Override
public T add(T t) {
	getSession().save(t);
	return t;
}
@Override
public void update(T t) {
	getSession().update(t);		
}

@Override
public void delete(Serializable id) {
	getSession().delete(this.load(id));
}

@Override
public T load(Serializable id) {
	return (T)getSession().load(getClazz(),id);
}
@Override
public T get(Serializable id){
	return (T)getSession().get(getClazz(),id);
}


	private String initSort(String hql) {
		String sort = SystemContext.getSort();
		String order = SystemContext.getOrder();
		if(null!=sort && !"".equals(sort.trim())){
			hql += " order by "+sort;
			if(!"desc".equals(order)){
				hql += " asc";
			}else{
				hql += " desc";
			}
		}
		return hql;
	}

	private void setParameter(Query query, Object[] args) {
		if(null!=args && args.length>0){
			for(int i=0;i<args.length;i++){
				query.setParameter(i, args[i]);
			}
		}
	}

	private void setAliasParameter(Query query, Map<String, Object> alias) {
		if(null!=alias){
			Set<String> keys = alias.keySet();
			for(String key : keys){
				Object val = alias.get(key);
				if(val instanceof Collection){
					//查询条件是列表
					query.setParameterList(key, (Collection)val);
				}else{
					query.setParameter(key, alias.get(key));
				}
			}
		}
		
	}
	public List<T> list(String hql, Object[] args, Map<String, Object> alias) {
		hql = initSort(hql);
		Query query = getSession().createQuery(hql); 
		setAliasParameter(query,alias);
		setParameter(query,args);
		return query.list();
	}
	public List<T> list(String hql,Object [] args){
		
		return list(hql,args,null);
	}
	public List<T> list(String hql) {
		return this.list(hql,null);
	}

	@Override
	public List<T> list(String hql, Object arg) {
		return list(hql,new Object[]{arg});
	}
	
	
	private String getCountHql(String hql, boolean isHql) {
     	String e = hql.substring(hql.indexOf("FROM"));
		String c = "select count(*) " + e;
		if(isHql){
			c.replaceAll("fetch", "");
		}
		return c;
	}
	private void setPager(Query query, Pager pager) {
		Integer pageSize = SystemContext.getPageSize();
		Integer pageOffset = SystemContext.getPageOffset();
		if(pageOffset==null||pageOffset<0) pageOffset = 0;
		if(pageSize==null||pageSize<0) pageSize = 10;
		pager.setSize(pageSize);
		pager.setOffset(pageOffset);
		query.setFirstResult(pageOffset).setMaxResults(pageSize);
	}
	@Override
	public <N extends Object>Pager<N> findBySql(String sql, Object[] args,Map<String, Object> alias, Class<?> clz, boolean hasEntity) {
		sql = initSort(sql);
		String cq = getCountHql(sql,false);
		SQLQuery sq = getSession().createSQLQuery(sql);
		SQLQuery cquery = getSession().createSQLQuery(cq);
		setAliasParameter(sq, alias);
		setAliasParameter(cquery, alias);
		setParameter(sq, args);
		setParameter(cquery, args);
		Pager<N> pages = new Pager<N>();
		setPager(sq, pages);
		if(hasEntity) {
			sq.addEntity(clz);
		} else {
			sq.setResultTransformer(Transformers.aliasToBean(clz));
		}
		List<N> datas = sq.list();
		pages.setDatas(datas);
		long total = ((BigInteger)cquery.uniqueResult()).longValue();
		pages.setTotal(total);
		return pages;
	}
}

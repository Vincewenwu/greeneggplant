package edu.gx.dao.base;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import edu.gx.user.model.Pager;

/**
 * ������DAO���������������а�����Hibernate�����л��������Ͷ�SQL�Ĳ���
 * @author Administrator
 *
 * @param <T>
 */
public interface IBaseDao<T> {
    
	/**
	/**
	 * ��Ӷ���
	 * @param t
	 * @return
	 */
	public T add(T t);
	/**
	 * ���¶���
	 * @param t
	 */
	public void update(T t);
	/**
	 * ����idɾ������
	 * @param id
	 */
	public void delete(Serializable id);
	/**
	 * ����id���ض���
	 * @param id
	 * @return
	 */
	public T load(Serializable id);
	
	public T get(Serializable id);
	
	
	public abstract List<T> list(String hql, Object[] args);

	public abstract List<T> list(String hql, Object arg);

	public abstract List<T> list(String hql);
    
	public <N extends Object>Pager<N> findBySql(String sql, Object[] args,Map<String, Object> alias, Class<?> clz, boolean hasEntity);
			
}

package edu.gx.dao.base;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import edu.gx.user.model.Pager;

/**
 * 公共的DAO处理对象，这个对象中包含了Hibernate的所有基本操作和对SQL的操作
 * @author Administrator
 *
 * @param <T>
 */
public interface IBaseDao<T> {
    
	/**
	/**
	 * 添加对象
	 * @param t
	 * @return
	 */
	public T add(T t);
	/**
	 * 更新对象
	 * @param t
	 */
	public void update(T t);
	/**
	 * 根据id删除对象
	 * @param id
	 */
	public void delete(Serializable id);
	/**
	 * 根据id加载对象
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

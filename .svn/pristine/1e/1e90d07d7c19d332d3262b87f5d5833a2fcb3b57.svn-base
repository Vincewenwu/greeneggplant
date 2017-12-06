package edu.gx.service.base;

import java.io.Serializable;

public interface IBaseService<T> {
	
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
	public T findByIdLoad(Serializable id);
	
	public T findById(Serializable id);
}

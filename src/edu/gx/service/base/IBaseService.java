package edu.gx.service.base;

import java.io.Serializable;

public interface IBaseService<T> {
	
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
	public T findByIdLoad(Serializable id);
	
	public T findById(Serializable id);
}

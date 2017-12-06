package edu.gx.service.base;

import java.io.Serializable;

import edu.gx.dao.base.BaseDao;
import edu.gx.dao.base.IBaseDao;

public abstract class BaseService<T> implements IBaseService<T>{

protected abstract  IBaseDao<T> getDao();
	
	@Override
	public T add(T t) {
		return getDao().add(t);
	}

	@Override
	public void update(T t) {
		getDao().update(t);
	}

	@Override
	public void delete(Serializable id) {
		getDao().delete(id);
	}

	@Override
	public T findByIdLoad(Serializable id) {
		return getDao().load(id);
	}
	
	@Override
	public T findById(Serializable id){
		return getDao().get(id);
	}

}

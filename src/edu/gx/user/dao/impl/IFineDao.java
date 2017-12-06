package edu.gx.user.dao.impl;


import java.util.List;
import java.util.Map;

import edu.gx.dao.base.IBaseDao;
import edu.gx.user.model.Book;
import edu.gx.user.model.Fine;
import edu.gx.user.model.Fineinfo;
import edu.gx.user.model.Library;
import edu.gx.user.model.User;
public interface IFineDao extends IBaseDao<Fine> {
	List<Fine> find(String hql, Object[] args, Map<String, Object> alias);
}

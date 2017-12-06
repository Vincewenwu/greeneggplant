package edu.gx.user.dao.impl;

import java.util.List;
import java.util.Map;

import edu.gx.dao.base.IBaseDao;
import edu.gx.user.model.User;
import edu.gx.user.model.Userinfo;

public interface IUserDao extends IBaseDao<User> {

	List<User> find(String hql, Object[] args, Map<String, Object> alias);
}

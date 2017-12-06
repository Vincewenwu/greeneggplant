package edu.gx.dao.service;

import java.util.List;
import java.util.Map;

import edu.gx.service.base.IBaseService;
import edu.gx.user.model.Bookinfo;
import edu.gx.user.model.Pager;
import edu.gx.user.model.User;
import edu.gx.user.model.UserBorrow;
import edu.gx.user.model.Userinfo;

public interface IUserService extends IBaseService<User> {
	public List<User> find(String hql,Object[] args, Map<String, Object> alias);
	public Pager<Userinfo> getPagerBySql(String sql,Object [] args,Map<String,Object> alias,int page,int pageSize,String sort,String order);
	public List<User> list(String hql);
	
	public Pager<UserBorrow> getPagerBySql1(String sql, Object[] args,
			Map<String, Object> alias, int page, int pageSize, String sort,
			String order);
}

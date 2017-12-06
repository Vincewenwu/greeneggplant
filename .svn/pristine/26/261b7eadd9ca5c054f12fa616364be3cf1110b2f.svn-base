package edu.gx.dao.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import edu.gx.dao.base.IBaseDao;
import edu.gx.dao.service.IUserService;
import edu.gx.service.base.BaseService;
import edu.gx.user.dao.impl.IUserDao;
import edu.gx.user.model.Book;
import edu.gx.user.model.Bookinfo;
import edu.gx.user.model.Pager;
import edu.gx.user.model.User;
import edu.gx.user.model.UserBorrow;
import edu.gx.user.model.Userinfo;
@Service
public class UserService extends BaseService<User> implements IUserService{

	@Resource(name="userDao")
	private IUserDao userDao;
	
	@Override
	public IBaseDao getDao() {
		return userDao;
	}
	@Override
	public List<User> find(String hql, Object[] args, Map<String, Object> alias) {
		List<User> u=userDao.find(hql,args, alias);
		return  u;
	}
	@Override
	public List<User> list(String hql) {
		return userDao.list(hql);
	}
	@Override
	public Pager<Userinfo> getPagerBySql(String sql, Object[] args,
			Map<String, Object> alias, int page, int pageSize, String sort,
			String order) {
//		SystemContext.setSort("sort");
//		SystemContext.setOrder("order");
		SystemContext.setPageSize(pageSize);
		SystemContext.setPageOffset((page-1)*pageSize);
		return userDao.findBySql(sql, args, alias,Userinfo.class,false);
	}
	@Override
	public Pager<UserBorrow> getPagerBySql1(String sql, Object[] args,
			Map<String, Object> alias, int page, int pageSize, String sort,
			String order) {
//		SystemContext.setSort("sort");
//		SystemContext.setOrder("order");
		SystemContext.setPageSize(pageSize);
		SystemContext.setPageOffset((page-1)*pageSize);
		return userDao.findBySql(sql, args, alias,UserBorrow.class,false);
	}

}

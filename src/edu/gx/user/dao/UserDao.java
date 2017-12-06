package edu.gx.user.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import edu.gx.dao.base.BaseDao;
import edu.gx.dao.base.IBaseDao;
import edu.gx.user.dao.impl.IUserDao;
import edu.gx.user.model.User;

@Repository(value="userDao")
public class UserDao extends BaseDao<User> implements IUserDao{
	
	public List<User> find(String hql,Object[] args, Map<String, Object> alias){
		return this.list(hql,args,alias);
	}
}

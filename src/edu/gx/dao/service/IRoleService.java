package edu.gx.dao.service;

import java.util.List;
import java.util.Map;

import edu.gx.service.base.IBaseService;
import edu.gx.user.model.Book;
import edu.gx.user.model.Library;
import edu.gx.user.model.Role;
import edu.gx.user.model.User;

public interface IRoleService extends IBaseService<Role> {
	public  List<Role> list(String hql);
}

package edu.gx.dao.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import edu.gx.dao.base.IBaseDao;
import edu.gx.dao.service.IBookService;
import edu.gx.dao.service.ILibraryService;
import edu.gx.dao.service.IRoleService;
import edu.gx.service.base.BaseService;
import edu.gx.user.dao.impl.IBookDao;
import edu.gx.user.dao.impl.ILibraryDao;
import edu.gx.user.dao.impl.IRolekDao;
import edu.gx.user.model.Book;
import edu.gx.user.model.Library;
import edu.gx.user.model.Role;
@Service
public class RoleService extends BaseService<Role> implements IRoleService{

	@Resource(name="roleDao")
	private IRolekDao iRolekDao;
	
	@Override
	public IBaseDao getDao() {
		return iRolekDao;
	}

	@Override
	public List<Role> list(String hql) {
		return iRolekDao.list(hql);
	}


}

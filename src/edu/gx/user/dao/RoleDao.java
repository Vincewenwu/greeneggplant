package edu.gx.user.dao;

import org.springframework.stereotype.Repository;
import edu.gx.dao.base.BaseDao;
import edu.gx.user.dao.impl.ILibraryDao;
import edu.gx.user.dao.impl.IRolekDao;
import edu.gx.user.model.Library;
import edu.gx.user.model.Role;

@Repository(value="roleDao")
public class RoleDao extends BaseDao<Role> implements IRolekDao{
	
}

package edu.gx.user.dao;

import org.springframework.stereotype.Repository;
import edu.gx.dao.base.BaseDao;
import edu.gx.user.dao.impl.ILibraryDao;
import edu.gx.user.model.Library;

@Repository(value="libarayDao")
public class LibraryDao extends BaseDao<Library> implements ILibraryDao{
	
}

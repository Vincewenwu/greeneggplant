package edu.gx.dao.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import edu.gx.dao.base.IBaseDao;
import edu.gx.dao.service.IBookService;
import edu.gx.dao.service.ILibraryService;
import edu.gx.service.base.BaseService;
import edu.gx.user.dao.impl.IBookDao;
import edu.gx.user.dao.impl.ILibraryDao;
import edu.gx.user.model.Book;
import edu.gx.user.model.Library;
import edu.gx.user.model.Libraryinfo;
import edu.gx.user.model.Librarytypeinfo;
import edu.gx.user.model.Pager;
@Service
public class LibraryService extends BaseService<Library> implements ILibraryService{

	@Resource(name="libarayDao")
	private ILibraryDao libarayDao;
	
	@Override
	public IBaseDao getDao() {
		return libarayDao;
	}

	@Override
	public List<Library> list(String hql) {
		return libarayDao.list(hql);
	}
	@Override
	public Pager<Libraryinfo> getPagerBySql(String sql, Object[] args,
			Map<String, Object> alias, int page, int pageSize, String sort,
			String order) {
/*		SystemContext.setSort("sort");
		SystemContext.setOrder("order");*/
		SystemContext.setPageSize(pageSize);
		SystemContext.setPageOffset((page-1)*pageSize);
		return libarayDao.findBySql(sql, args, alias,Libraryinfo.class,false);
	}

}

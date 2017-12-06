package edu.gx.dao.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import edu.gx.dao.base.IBaseDao;
import edu.gx.dao.service.IBookService;
import edu.gx.dao.service.ILibraryService;
import edu.gx.dao.service.ILibraryTypeService;
import edu.gx.service.base.BaseService;
import edu.gx.user.dao.impl.IBookDao;
import edu.gx.user.dao.impl.ILibraryDao;
import edu.gx.user.dao.impl.ILibraryTypeDao;
import edu.gx.user.model.Book;
import edu.gx.user.model.Bookinfo;
import edu.gx.user.model.Library;
import edu.gx.user.model.Librarytype;
import edu.gx.user.model.Librarytypeinfo;
import edu.gx.user.model.Pager;
@Service
public class LibraryTypeService extends BaseService<Librarytype> implements ILibraryTypeService{

	@Resource(name="libaraytypeDao")
	private ILibraryTypeDao libaraytypeDao;
	
	@Override
	public IBaseDao getDao() {
		return libaraytypeDao;
	}

	@Override
	public List<Librarytype> list(String hql) {
		return libaraytypeDao.list(hql);
	}
	@Override
	public Pager<Librarytypeinfo> getPagerBySql(String sql, Object[] args,
			Map<String, Object> alias, int page, int pageSize, String sort,
			String order) {
/*		SystemContext.setSort("sort");
		SystemContext.setOrder("order");*/
		SystemContext.setPageSize(pageSize);
		SystemContext.setPageOffset((page-1)*pageSize);
		return libaraytypeDao.findBySql(sql, args, alias,Librarytypeinfo.class,false);
	}


}

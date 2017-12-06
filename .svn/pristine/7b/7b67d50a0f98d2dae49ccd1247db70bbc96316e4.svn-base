package edu.gx.dao.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import edu.gx.dao.base.IBaseDao;
import edu.gx.dao.service.IBookService;
import edu.gx.dao.service.IFineService;
import edu.gx.dao.service.ILibraryService;
import edu.gx.service.base.BaseService;
import edu.gx.user.dao.impl.IBookDao;
import edu.gx.user.dao.impl.IFineDao;
import edu.gx.user.dao.impl.ILibraryDao;
import edu.gx.user.model.Book;
import edu.gx.user.model.Borrowinfo;
import edu.gx.user.model.Fine;
import edu.gx.user.model.Fineinfo;
import edu.gx.user.model.Library;
import edu.gx.user.model.Libraryinfo;
import edu.gx.user.model.Librarytypeinfo;
import edu.gx.user.model.Pager;
import edu.gx.user.model.User;
@Service
public class FineService extends BaseService<Fine> implements IFineService{

	@Resource(name="fineDao")
	private IFineDao fineDao;
	
	@Override
	public IBaseDao getDao() {
		return fineDao;
	}
	@Override
	public List<Fine> find(String hql, Object[] args, Map<String, Object> alias) {
		List<Fine> u=fineDao.find(hql,args, alias);
		return  u;
	}
	@Override
	public Pager<Fineinfo> getPagerBySql(String sql, Object[] args,
			Map<String, Object> alias, int page, int pageSize, String sort,
			String order) {
	/*	SystemContext.setSort("sort");
	    SystemContext.setOrder("order");*/
		SystemContext.setPageSize(pageSize);
		SystemContext.setPageOffset((page-1)*pageSize);
		return fineDao.findBySql(sql,args,alias,Fineinfo.class,false);
	}
	@Override
	public List<Fine> list(String string) {
		
		return fineDao.list(string);
	}
	

}

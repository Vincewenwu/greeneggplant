package edu.gx.dao.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import edu.gx.dao.base.IBaseDao;
import edu.gx.dao.service.IBookService;
import edu.gx.service.base.BaseService;
import edu.gx.user.dao.impl.IBookDao;
import edu.gx.user.model.Book;
import edu.gx.user.model.Bookinfo;
import edu.gx.user.model.Library;
import edu.gx.user.model.Pager;
@Service
public class BookService extends BaseService<Book> implements IBookService{

	@Resource(name="bookDao")
	private IBookDao bookDao;
	
	@Override
	public IBaseDao getDao() {
		return bookDao;
	}

	@Override
	public List<Book> list(String hql) {
		return bookDao.list(hql);
	}

	@Override
	public Pager<Bookinfo> getPagerBySql(String sql, Object[] args,
			Map<String, Object> alias, int page, int pageSize, String sort,
			String order) {
/*		SystemContext.setSort("sort");
		SystemContext.setOrder("order");*/
		SystemContext.setPageSize(pageSize);
		SystemContext.setPageOffset((page-1)*pageSize);
		return bookDao.findBySql(sql, args, alias,Bookinfo.class,false);
	}

	@Override
	public Book load(Serializable id) {
		 
		return bookDao.load(id);
	}

	



}

package edu.gx.dao.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import edu.gx.dao.base.IBaseDao;
import edu.gx.dao.service.IBookService;
import edu.gx.dao.service.IBorrowService;
import edu.gx.service.base.BaseService;
import edu.gx.user.dao.impl.IBookDao;
import edu.gx.user.dao.impl.IBorrowDao;
import edu.gx.user.model.Book;
import edu.gx.user.model.Bookinfo;
import edu.gx.user.model.Borrow;
import edu.gx.user.model.Borrowinfo;
import edu.gx.user.model.FineManager;
import edu.gx.user.model.Library;
import edu.gx.user.model.Pager;
@Service
public class BorrowService extends BaseService<Borrow> implements IBorrowService{

	@Resource(name="borrowDao")
	private IBorrowDao borrowDao;
	
	@Override
	public IBaseDao getDao() {
		return borrowDao;
	}
	@Override
	public Pager<Borrowinfo> getPagerBySql(String sql, Object[] args,
			Map<String, Object> alias, int page, int pageSize, String sort,
			String order) {
	/*	SystemContext.setSort("sort");
	    SystemContext.setOrder("order");*/
		SystemContext.setPageSize(pageSize);
		SystemContext.setPageOffset((page-1)*pageSize);
		return borrowDao.findBySql(sql,args,alias,Borrowinfo.class,false);
	}
	@Override
	public List<Borrow> list(String hql) {
		return borrowDao.list(hql);
	}
	@Override
	public Borrow load(Serializable id) {
		System.out.println(borrowDao.load(id));/*这句话不能删*/
		return borrowDao.load(id);
	}
	@Override
	public Pager<FineManager> getPagerBySql1(String sql, Object[] args,
			Map<String, Object> alias, int page, int pageSize, String sort,
			String order) {
	/*	SystemContext.setSort("sort");
	    SystemContext.setOrder("order");*/
		SystemContext.setPageSize(pageSize);
		SystemContext.setPageOffset((page-1)*pageSize);
		return borrowDao.findBySql(sql,args,alias,FineManager.class,false);
	}
}

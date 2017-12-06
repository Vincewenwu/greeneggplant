package edu.gx.dao.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import edu.gx.service.base.IBaseService;
import edu.gx.user.model.Book;
import edu.gx.user.model.Bookinfo;
import edu.gx.user.model.Borrow;
import edu.gx.user.model.Borrowinfo;
import edu.gx.user.model.FineManager;
import edu.gx.user.model.Library;
import edu.gx.user.model.Pager;
import edu.gx.user.model.User;

public interface IBorrowService extends IBaseService<Borrow> {
	public Pager<Borrowinfo> getPagerBySql(String sql, Object[] args,
			Map<String, Object> alias, int page, int pageSize, String sort,
			String order);
	public List<Borrow> list(String hql);
	
	public Borrow load(Serializable id);
	
	public Pager<FineManager> getPagerBySql1(String sql, Object[] args,
			Map<String, Object> alias, int page, int pageSize, String sort,
			String order) ;
}

package edu.gx.dao.service;

import java.util.List;
import java.util.Map;

import edu.gx.service.base.IBaseService;
import edu.gx.user.model.Book;
import edu.gx.user.model.Borrowinfo;
import edu.gx.user.model.Fine;
import edu.gx.user.model.Fineinfo;
import edu.gx.user.model.Library;
import edu.gx.user.model.Libraryinfo;
import edu.gx.user.model.Librarytypeinfo;
import edu.gx.user.model.Pager;
import edu.gx.user.model.User;

public interface IFineService extends IBaseService<Fine> {
	public List<Fine> find(String hql, Object[] args, Map<String, Object> alias);
	public Pager<Fineinfo> getPagerBySql(String sql, Object[] args,
			Map<String, Object> alias, int page, int pageSize, String sort,
			String order);
	public List<Fine> list(String string);
}

package edu.gx.dao.service;

import java.util.List;
import java.util.Map;

import edu.gx.service.base.IBaseService;
import edu.gx.user.model.Book;
import edu.gx.user.model.Library;
import edu.gx.user.model.Libraryinfo;
import edu.gx.user.model.Librarytypeinfo;
import edu.gx.user.model.Pager;
import edu.gx.user.model.User;

public interface ILibraryService extends IBaseService<Library> {
	public  List<Library> list(String hql);
	public Pager<Libraryinfo> getPagerBySql(String sql, Object[] args,
			Map<String, Object> alias, int page, int pageSize, String sort,
			String order);
}

package edu.gx.dao.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import edu.gx.service.base.IBaseService;
import edu.gx.user.model.Book;
import edu.gx.user.model.Bookinfo;
import edu.gx.user.model.Library;
import edu.gx.user.model.Pager;
import edu.gx.user.model.User;

public interface IBookService extends IBaseService<Book> {
	public  List<Book> list(String hql);
	public Pager<Bookinfo> getPagerBySql(String sql,Object [] args,Map<String,Object> alias,int page,int pageSize,String sort,String order);
	public Book load(Serializable id);
}

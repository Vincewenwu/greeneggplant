package edu.gx.dao.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import edu.gx.service.base.IBaseService;
import edu.gx.user.model.Book;
import edu.gx.user.model.Bookinfo;
import edu.gx.user.model.Library;
import edu.gx.user.model.Pager;
import edu.gx.user.model.Snewsinfo;
import edu.gx.user.model.Sysnews;
import edu.gx.user.model.User;
import edu.gx.user.model.Userinfo;
import edu.gx.user.model.booktypeinfo;

public interface ISysnewsService extends IBaseService<Sysnews> {
	public  List<Sysnews> list(String hql);
	public Pager<booktypeinfo> getPagerBySql(String sql,Object [] args,Map<String,Object> alias,int page,int pageSize,String sort,String order);
	public Pager<Bookinfo> getPagerBySql1(String sql,Object [] args,Map<String,Object> alias,int page,int pageSize,String sort,String order);

	public Pager<Snewsinfo> pageSnewsinfo(String sql,Object [] args,Map<String,Object> alias,int page,int pageSize,String sort,String order);

}

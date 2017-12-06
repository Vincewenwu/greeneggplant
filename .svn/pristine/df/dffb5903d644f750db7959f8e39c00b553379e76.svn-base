package edu.gx.dao.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import edu.gx.dao.service.impl.SystemContext;
import edu.gx.service.base.IBaseService;
import edu.gx.user.model.Book;
import edu.gx.user.model.Bookinfo;
import edu.gx.user.model.Library;
import edu.gx.user.model.Mailmessage;
import edu.gx.user.model.Messageinfo;
import edu.gx.user.model.Pager;
import edu.gx.user.model.User;
import edu.gx.user.model.UserBorrow;

public interface IMailService extends IBaseService<Mailmessage> {
	public  List<Mailmessage> list(String hql);
	public Mailmessage load(Serializable id);
	public Pager<Messageinfo> getPagerBySql1(String sql, Object[] args,
			Map<String, Object> alias, int page, int pageSize, String sort,
			String order) ;
}

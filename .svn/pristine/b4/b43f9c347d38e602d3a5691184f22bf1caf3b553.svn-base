package edu.gx.dao.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import edu.gx.dao.base.IBaseDao;
import edu.gx.dao.service.IBookService;
import edu.gx.dao.service.IMailService;
import edu.gx.service.base.BaseService;
import edu.gx.user.dao.impl.IBookDao;
import edu.gx.user.dao.impl.IMailDao;
import edu.gx.user.model.Book;
import edu.gx.user.model.Bookinfo;
import edu.gx.user.model.Library;
import edu.gx.user.model.Mailmessage;
import edu.gx.user.model.Messageinfo;
import edu.gx.user.model.Pager;
import edu.gx.user.model.UserBorrow;
@Service
public class MailService extends BaseService<Mailmessage> implements IMailService{

	@Resource(name="mailDao")
	private IMailDao mailDao;
	
	@Override
	public IBaseDao getDao() {
		return mailDao;
	}

	@Override
	public List<Mailmessage> list(String hql) {
		return mailDao.list(hql);
	}

	@Override
	public Mailmessage load(Serializable id) {
		return mailDao.load(id);
	}

	@Override
	public Pager<Messageinfo> getPagerBySql1(String sql, Object[] args,
			Map<String, Object> alias, int page, int pageSize, String sort,
			String order) {
//		SystemContext.setSort("sort");
//		SystemContext.setOrder("order");
		SystemContext.setPageSize(pageSize);
		SystemContext.setPageOffset((page-1)*pageSize);
		return mailDao.findBySql(sql, args, alias,Messageinfo.class,false);
	}



}

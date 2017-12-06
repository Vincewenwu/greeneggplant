package edu.gx.dao.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import edu.gx.dao.base.IBaseDao;
import edu.gx.dao.service.IBookService;
import edu.gx.dao.service.ISysnewsService;
import edu.gx.service.base.BaseService;
import edu.gx.user.dao.impl.IBookDao;
import edu.gx.user.dao.impl.ISysnewsDao;
import edu.gx.user.model.Book;
import edu.gx.user.model.Bookinfo;
import edu.gx.user.model.Library;
import edu.gx.user.model.Pager;
import edu.gx.user.model.Snewsinfo;
import edu.gx.user.model.Sysnews;
import edu.gx.user.model.booktypeinfo;
@Service
public class SysnewsService extends BaseService<Sysnews> implements ISysnewsService{

	@Resource(name="sysnewsDao")
	private ISysnewsDao iSysnewsDao;
	
	@Override
	public IBaseDao getDao() {
		return iSysnewsDao;
	}

	@Override
	public List<Sysnews> list(String hql) {
		
		return iSysnewsDao.list(hql);
	}
	@Override
	public Pager<booktypeinfo> getPagerBySql(String sql, Object[] args,
			Map<String, Object> alias, int page, int pageSize, String sort,
			String order) {
/*		SystemContext.setSort("sort");
		SystemContext.setOrder("order");*/
		SystemContext.setPageSize(pageSize);
		SystemContext.setPageOffset((page-1)*pageSize);
		return iSysnewsDao.findBySql(sql, args, alias,booktypeinfo.class,false);
	}
	@Override
	public Pager<Bookinfo> getPagerBySql1(String sql, Object[] args,
			Map<String, Object> alias, int page, int pageSize, String sort,
			String order) {
/*		SystemContext.setSort("sort");
		SystemContext.setOrder("order");*/
		SystemContext.setPageSize(pageSize);
		SystemContext.setPageOffset((page-1)*pageSize);
		return iSysnewsDao.findBySql(sql, args, alias,Bookinfo.class,false);
	}

	@Override
	public Pager<Snewsinfo> pageSnewsinfo(String sql, Object[] args,
			Map<String, Object> alias, int page, int pageSize, String sort,
			String order) {
		SystemContext.setPageSize(pageSize);
		SystemContext.setPageOffset((page-1)*pageSize);
		return iSysnewsDao.findBySql(sql, args, alias,Snewsinfo.class,false);
	}
	
	
}

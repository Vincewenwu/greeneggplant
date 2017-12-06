package edu.gx.dao.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import edu.gx.dao.base.IBaseDao;
import edu.gx.dao.service.IBookService;
import edu.gx.dao.service.IDatailsService;
import edu.gx.service.base.BaseService;
import edu.gx.user.dao.impl.IBookDao;
import edu.gx.user.dao.impl.IDatailDao;
import edu.gx.user.model.Book;
import edu.gx.user.model.Bookinfo;
import edu.gx.user.model.Datails;
import edu.gx.user.model.Library;
import edu.gx.user.model.Pager;
@Service
public class DatailService extends BaseService<Datails> implements IDatailsService{

	@Resource(name="datailsDao")
	private IDatailDao datailsDao;
	
	@Override
	public IBaseDao getDao() {
		return datailsDao;
	}
	@Override
	public Pager<Datails> getPagerBySql(String sql, Object[] args,
			Map<String, Object> alias, int page, int pageSize, String sort,
			String order) {
/*		SystemContext.setSort("sort");
		SystemContext.setOrder("order");*/
		SystemContext.setPageSize(pageSize);
		SystemContext.setPageOffset((page-1)*pageSize);
		return datailsDao.findBySql(sql, args, alias,Datails.class,false);
	}
	@Override
	public List<Datails> list(String hql) {
		// TODO Auto-generated method stub
		return datailsDao.list(hql);
	}
}

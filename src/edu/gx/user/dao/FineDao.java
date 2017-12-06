package edu.gx.user.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import edu.gx.dao.base.BaseDao;
import edu.gx.user.dao.impl.IFineDao;
import edu.gx.user.dao.impl.ILibraryDao;
import edu.gx.user.model.Fine;
import edu.gx.user.model.Library;
import edu.gx.user.model.User;

@Repository(value="fineDao")
public class FineDao extends BaseDao<Fine> implements IFineDao{

	@Override
	public List<Fine> find(String hql, Object[] args, Map<String, Object> alias) {
		return this.list(hql,args,alias);}
}

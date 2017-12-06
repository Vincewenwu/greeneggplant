package edu.gx.dao.service.impl;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import edu.gx.dao.base.IBaseDao;
import edu.gx.dao.service.IOverrecordService;
import edu.gx.service.base.BaseService;
import edu.gx.user.dao.impl.IOverrecoedDao;
import edu.gx.user.model.Overrecord;
@Service
public class OverrecordService extends BaseService<Overrecord> implements IOverrecordService{

	@Resource(name="overrecoedDao")
	private IOverrecoedDao overrecoedDao;
	
	@Override
	public IBaseDao getDao() {
		return overrecoedDao;
	}

}

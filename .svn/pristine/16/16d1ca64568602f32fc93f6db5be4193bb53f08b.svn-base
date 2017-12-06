package edu.gx.dao.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import edu.gx.dao.base.IBaseDao;
import edu.gx.dao.service.IBookService;
import edu.gx.dao.service.ILosetlibraryService;
import edu.gx.service.base.BaseService;
import edu.gx.user.dao.impl.IBookDao;
import edu.gx.user.dao.impl.ILoselibraryDao;
import edu.gx.user.model.Book;
import edu.gx.user.model.Bookinfo;
import edu.gx.user.model.Library;
import edu.gx.user.model.Loselibrary;
import edu.gx.user.model.Pager;
@Service
public class LoseLibraryService extends BaseService<Loselibrary> implements ILosetlibraryService{

	@Resource(name="loselibrryDao")
	private ILoselibraryDao iLoselibraryDao;
	
	@Override
	public IBaseDao getDao() {
		return iLoselibraryDao;
	}


}

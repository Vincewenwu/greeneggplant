package edu.gx.user.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import edu.gx.dao.base.BaseDao;
import edu.gx.dao.base.IBaseDao;
import edu.gx.user.dao.impl.IBookDao;
import edu.gx.user.dao.impl.IBorrowDao;
import edu.gx.user.dao.impl.IUserDao;
import edu.gx.user.model.Book;
import edu.gx.user.model.Bookinfo;
import edu.gx.user.model.Borrow;
import edu.gx.user.model.Pager;
import edu.gx.user.model.User;

@Repository(value="borrowDao")
public class BorrowDao extends BaseDao<Borrow> implements IBorrowDao{


	
}

package edu.gx.user.controls;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.gx.common.utils.MD5Util;
import edu.gx.common.utils.NowTime;
import edu.gx.common.utils.WeatherUtil;
import edu.gx.dao.service.IBorrowService;
import edu.gx.dao.service.IDatailsService;
import edu.gx.dao.service.IRoleService;
import edu.gx.dao.service.ISysnewsService;
import edu.gx.dao.service.IUserService;
import edu.gx.user.model.Bookinfo;
import edu.gx.user.model.Borrow;
import edu.gx.user.model.Datails;
import edu.gx.user.model.Library;
import edu.gx.user.model.Pager;
import edu.gx.user.model.Role;
import edu.gx.user.model.Sysnews;
import edu.gx.user.model.User;
import edu.gx.user.model.UserBorrow;
import edu.gx.user.model.Userinfo;
import edu.gx.user.model.booktypeinfo;

@Scope("prototype")
public class UserAction extends ActionSupport {
	@Autowired
	private IUserService iUserService;
	@Autowired
	private IRoleService iRoleService;
	@Autowired
	private ISysnewsService iSysnewsService;
	@Autowired
	private IBorrowService iBorrowService;
	@Autowired
	private IDatailsService iDatailsService;
	List<Datails> datasys = null;
	private List<Role> role = null;
	private User user;
	private List<Borrow> borrow =null;
	private int count = 0;
	private int size = 5;

	private String message = null;

	public String getMessage() {

		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * 登录验证
	 * 
	 * @return
	 */
	public String index() {
		List<Userinfo> userinfolist = null;
		List<Sysnews> sysnews = null;
		List<booktypeinfo> booktype = null;
		String whattime = null;
		Pager<Bookinfo> bookin = null;
		NowTime time = new NowTime();
	
		String name = user.getUserName();
		String password = MD5Util.GetMD5Code(user.getPassword());
		String sql = "SELECT `user`.userID,`user`.userName,`user`.`password`,`user`.libraryCard,`user`.sex,`user`.mail,`user`.phone, `user`.borrow,`user`.borrowingAmount,`user`.roleID,role.roleName,role.orAdmin,role.borrowBooksLength FROM `user` INNER JOIN role ON `user`.roleID = role.roleID where user.userName= '"
				+ name + "' and user.password= '" + password + "' ";
		Pager<Userinfo> userinfo = iUserService.getPagerBySql(sql, null, null,
				pager, size, null, null);
		userinfolist = userinfo.getDatas();
		if (!userinfolist.isEmpty()) {
			ActionContext.getContext().getSession().put("userinfolist", userinfolist);
			int userID = userinfolist.get(0).getUserID(); /* 获取list的行和列 */
			ActionContext.getContext().getSession().put("userID", userID);
			System.out.println("好了");
			sysnews = iSysnewsService.list("from Sysnews where resuserId= '"
					+ userID + "' ORDER BY transmissiontime DESC ");
			
			if (time.AMorPM() == 1) {
				whattime = "下午好！";
			}else {
				whattime = "上午好！";
			}
			if(!sysnews.isEmpty()){
				if (time.fanhuishifouguoqi(sysnews.get(0).getTransmissiontime().toString()) > 3) { // 如果超过三天登录一次就发送系统消息
					try {
						borrow= iBorrowService.list("from Borrow where userId= " + userID  );
						if(borrow.size()>0){
							String sql1 = "SELECT borrow.bookID,librarytype.libraryType,librarytype.libraryTypeID  FROM borrow INNER JOIN `user` ON `user`.userID = borrow.userID INNER JOIN book ON borrow.bookID = book.bookID INNER JOIN librarytype ON book.libraryTypeID = librarytype.libraryTypeID and `user`.userID= '"
									+ userID + "' GROUP BY librarytype.libraryType ";
							Pager<booktypeinfo> bookt = iSysnewsService.getPagerBySql(
									sql1, null, null, 1, 10, null, null);
							booktype = bookt.getDatas();
							  for(int z=0;z<booktype.size();z++){
									Sysnews s= new Sysnews();
								  if (booktype.get(0).getBookID()!=null) { //根据用户借书的书本类型推荐同种类型的最新书本
			  							String sql2 = "SELECT book.bookID,book.bookOnlyCoding,book.bookName,book.price,book.author,book.publishingCompany,book.publishTime,book.stock,book.abstruct,book.libraryPagination,book.buildTime,book.libraryID,library.libraryName,librarytype.libraryType,book.picture,book.libraryTypeID FROM book INNER JOIN library ON book.libraryID = library.libraryID INNER JOIN librarytype ON book.libraryTypeID = librarytype.libraryTypeID where book.libraryTypeID= '"
			  									+ booktype.get(z).getLibraryTypeID()
			  									+ "'  ORDER BY book.publishTime DESC";
			  							bookin = iSysnewsService.getPagerBySql1(sql2, null,
			  									null, 1, 10, null, null);
			  						for (int i = 0; i < bookin.getSize(); i++) {  //如果已有类型对应的书就不重新添加
			  							if(bookin.getDatas().get(i).getBookID()==booktype.get(z).getBookID()){
			  								 continue;
			  								 }else{
			  									s.setMessagecontent(userinfolist.get(0).getUserName()+ whattime + "我们有新出的图书《"+ bookin.getDatas().get(0).getBookName() + "》");
			  						    	break;
			  								 }		
			  							}
			  								s.setSenduserId(6);// 这里具体点可以根据管理员ID查 我就不查了，直接找
										s.setSendusertype(1);
										s.setResuserId(userID);
										s.setResusertype(userinfolist.get(0).getRoleID());
										s.setTransmissiontime(time.BorrowDate());
										s.setWhetherornottoread(false);
										iSysnewsService.add(s);
			  						}  
                    		  }
						}else{
							Sysnews s= new Sysnews();
							String sql2 = "SELECT book.bookID,book.bookOnlyCoding,book.bookName,book.price,book.author,book.publishingCompany,book.publishTime,book.stock,book.abstruct,book.libraryPagination,book.buildTime,book.libraryID,library.libraryName,librarytype.libraryType,book.picture,book.libraryTypeID FROM book INNER JOIN library ON book.libraryID = library.libraryID INNER JOIN librarytype ON book.libraryTypeID = librarytype.libraryTypeID  ORDER BY book.publishTime DESC";
							bookin = iSysnewsService.getPagerBySql1(sql2, null,
									null, 1, 1000, null, null);
							s.setMessagecontent(userinfolist.get(0).getUserName()+ whattime + "我们有新出的图书《"+ bookin.getDatas().get(0).getBookName() + "》");
							s.setSenduserId(6);// 这里具体点可以根据管理员ID查 我就不查了，直接找
							s.setSendusertype(1);
							s.setResuserId(userID);
							s.setResusertype(userinfolist.get(0).getRoleID());
							s.setTransmissiontime(time.BorrowDate());
							s.setWhetherornottoread(false);
							iSysnewsService.add(s);
						}
						
					 } catch (Exception e) {
						 e.printStackTrace();
					}
				}else{
					System.out.println("没到三天");
				}
			}else{  //第一次登陆的话就差最新的书
				String sql2 = "SELECT book.bookID,book.bookOnlyCoding,book.bookName,book.price,book.author,book.publishingCompany,book.publishTime,book.stock,book.abstruct,book.libraryPagination,book.buildTime,book.libraryID,library.libraryName,librarytype.libraryType,book.picture,book.libraryTypeID FROM book INNER JOIN library ON book.libraryID = library.libraryID INNER JOIN librarytype ON book.libraryTypeID = librarytype.libraryTypeID  ORDER BY book.publishTime DESC";
				bookin = iSysnewsService.getPagerBySql1(sql2, null,
						null, 1, 1000, null, null);
				System.out.println("第一次来");
				if (time.AMorPM() == 1) {
					whattime = "下午好！";
				} else {
					whattime = "上午好！";
				}
				Sysnews s= new Sysnews();
				s.setMessagecontent(userinfolist.get(0).getUserName()
						+ whattime + "我们有新出的图书《"
						+ bookin.getDatas().get(0).getBookName() + "》");
					s.setSenduserId(6);// 这里具体点可以根据管理员ID查 我就不查了，直接找
					s.setSendusertype(1);
					s.setResuserId(userID);
					s.setResusertype(userinfolist.get(0).getRoleID());
					s.setTransmissiontime(time.BorrowDate());
				
					s.setWhetherornottoread(false);
					iSysnewsService.add(s);
			}
			
			message = "true";
		} else {
			message = "false";
			System.out.println("不好");
		}
		datasys= iDatailsService.list("from Datails");
	 	ActionContext.getContext().put("datasys", datasys);
		return message;
	}

	/**
	 * 跳转注册页面
	 * 
	 * @return
	 */
	public String register() {
		return "register";
	}

	/**
	 * 生成订单号 当前时间加上两位随机数
	 * 
	 * @return
	 */
	public static String sjs() {
		String sjs = "";
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		// Math.random()返回0.0-1.0之间的随机小数
		int x = (int) (Math.random() * 100);
		if (x < 10) {
			x = x + 9;
		} else if (x == 100) {
			x--;
		}
		sjs = sdf.format(d) + x;
		return sjs;
	}

	/**
	 * 注册用户
	 * 
	 * @return
	 */
	public String add() {
		User u = new User();
		u.setBorrow(true);
		u.setBorrowingAmount(0);
		u.setLibraryCard(sjs());
		u.setMail(user.getMail());
		if (user.getSex() == "1") {
			u.setSex("男");
		} else {
			u.setSex("女");
		}
		u.setUserName(user.getUserName());
		u.setPassword(MD5Util.GetMD5Code(user.getPassword()));
		u.setPhone(user.getPhone());
		u.setRoleID(user.getRoleID());
		User i = iUserService.add(u);
		if (i != null) {
			ActionContext.getContext().put("message", "新增成功");
		} else {
			ActionContext.getContext().put("message", "新增失败");
		}
		loadselect();
		return "list";
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	public String update() {
		User u = new User();
		u.setBorrow(true);
		u.setBorrowingAmount(0);
		u.setLibraryCard(sjs());
		u.setMail(user.getMail());
		if (user.getSex() == "1") {
			u.setSex("男");
		} else {
			u.setSex("女");
		}

		u.setUserName(user.getUserName());
		u.setPassword(MD5Util.GetMD5Code(user.getPassword()));
		u.setPhone(user.getPhone());
		u.setRoleID(user.getRoleID());
		u.setUserID(user.getUserID());
		iUserService.update(u);
		loadselect();
		ActionContext.getContext().put("message", "修改成功");
		return "list";
	}

	private String mohuuserName = null;

	public String getMohuuserName() {
		return mohuuserName;
	}

	public void setMohuuserName(String mohuuserName) {
		this.mohuuserName = mohuuserName;
	}

	public String loadselect() {
		List<Userinfo> userinfolist = null;
		try {
			if (mohuuserName != null) {
				mohuuserName = new String(mohuuserName.getBytes("ISO-8859-1"),
						"UTF-8");
				if (mohuuserName == null) {
					String sql = "SELECT `user`.userID,`user`.userName,`user`.`password`,`user`.libraryCard,`user`.sex,`user`.mail,`user`.phone, `user`.borrow,`user`.borrowingAmount,`user`.roleID,role.roleName,role.orAdmin,role.borrowBooksLength FROM `user` INNER JOIN role ON `user`.roleID = role.roleID";
					Pager<Userinfo> user = iUserService.getPagerBySql(sql,
							null, null, pager, size, null, null);
					userinfolist = user.getDatas();
					List<User> userlist = iUserService.list("from Book");
					count = userlist.size();
					pagercount = count / size;
					if (count % size > 0) {
						pagercount++;
					} else {
					}
				} else {
					String sql = "SELECT `user`.userID,`user`.userName,`user`.`password`,`user`.libraryCard,`user`.sex,`user`.mail,`user`.phone, `user`.borrow,`user`.borrowingAmount,`user`.roleID,role.roleName,role.orAdmin,role.borrowBooksLength FROM `user` INNER JOIN role ON `user`.roleID = role.roleID WHERE `user`.userName LIKE '%"
							+ mohuuserName + "%'";
					Pager<Userinfo> user = iUserService.getPagerBySql(sql,
							null, null, pager, size, null, null);
					userinfolist = user.getDatas();
					count = userinfolist.size();
					pagercount = count / size;
					if (count % size > 0) {
						pagercount++;
					} else {
					}
				}
			} else {
				if (mohuuserName == null) {
					String sql = "SELECT `user`.userID,`user`.userName,`user`.`password`,`user`.libraryCard,`user`.sex,`user`.mail,`user`.phone, `user`.borrow,`user`.borrowingAmount,`user`.roleID,role.roleName,role.orAdmin,role.borrowBooksLength FROM `user` INNER JOIN role ON `user`.roleID = role.roleID";
					Pager<Userinfo> user = iUserService.getPagerBySql(sql,
							null, null, pager, size, null, null);
					userinfolist = user.getDatas();
					List<User> userlist = iUserService.list("from Book");
					count = userlist.size();
					pagercount = count / size;
					if (count % size > 0) {
						pagercount++;
					} else {
					}
				} else {
					String sql = "SELECT `user`.userID,`user`.userName,`user`.`password`,`user`.libraryCard,`user`.sex,`user`.mail,`user`.phone, `user`.borrow,`user`.borrowingAmount,`user`.roleID,role.roleName,role.orAdmin,role.borrowBooksLength FROM `user` INNER JOIN role ON `user`.roleID = role.roleID WHERE `user`.userName LIKE '%"
							+ mohuuserName + "%'";
					Pager<Userinfo> user = iUserService.getPagerBySql(sql,
							null, null, pager, size, null, null);
					userinfolist = user.getDatas();
					count = userinfolist.size();
					pagercount = count / size;
					if (count % size > 0) {
						pagercount++;
					} else {
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ActionContext.getContext().getSession().put("users", userinfolist);
		if (ActionContext.getContext().getSession().get("role") == null) {
			selrelo();
		}
		return "load";
	}

	public void selrelo() {
		role = iRoleService.list("from Role");
		ActionContext.getContext().getSession().put("role", role);
	}

	public String delect() {
		String[] ids = id.split(",");
		int[] num = new int[ids.length];
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(ids[i]);
		}
		for (int zj : num) {
			iUserService.delete(zj);
		}
		if (num.length > 0) {
			loadselect();
			ActionContext.getContext().put("message", "删除成功");
		} else {
		}
		return "list";
	}

	/* 分页 */
	public String First() {

		if (ee == 1) { /* 这是首页情况 */
			pager = 1;
		} else if (ee == 2) {/* 上一页 */
			if (pager > 1) {
				pager--;
			} else {
				ActionContext.getContext().put("message", "已是首页");
			}
		} else if (ee == 3) { /* 下一页 */
			if (pager < pagercount) {
				pager++;
			} else {
				ActionContext.getContext().put("message", "已是尾页");
			}
		} else if (ee == 4) {
			pager = pagercount;
		} else {

		}

		System.out.println(pagercount);
		System.out.println(pager);
		loadselect();
		return "list";

	}

	private int pager = 1;

	public int getPager() {
		return pager;
	}

	public void setPager(int pager) {
		this.pager = pager;
	}

	private int pagercount = 1;

	public int getPagercount() {
		return pagercount;
	}

	public void setPagercount(int pagercount) {
		this.pagercount = pagercount;
	}

	private int ee;

	public int getEe() {
		return ee;
	}

	public void setEe(int ee) {
		this.ee = ee;
	}

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

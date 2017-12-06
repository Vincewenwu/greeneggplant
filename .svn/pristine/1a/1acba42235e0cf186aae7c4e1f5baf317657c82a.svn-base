package edu.gx.user.controls;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.gx.dao.service.IBorrowService;
import edu.gx.dao.service.IFineService;
import edu.gx.dao.service.IMailService;
import edu.gx.user.model.Borrow;
import edu.gx.user.model.Fine;
import edu.gx.user.model.FineManager;
import edu.gx.user.model.Mailmessage;
import edu.gx.user.model.Pager;
import edu.gx.user.model.User;
import edu.gx.user.model.Userinfo;

@Scope("prototype")
//@Controller("book.BookAction")
public class FineAction extends ActionSupport {
	
	@Autowired
	private IBorrowService iBorrowService;
	@Autowired
	private IFineService iFineService;
	private  int count=0;
	private  int size=5;
	/**
	 * 查询罚款表
	 * @return
	 */
	public String loadFine(){
		List<FineManager> fineManager=null;
		String sql="SELECT fi.fineID,fi.userID,fi.bookID,fi.borrowID,fi.forfeit,fi.fineTypeID,fi.payment,ft.fineTypeName, us.userName,us.libraryCard,us.mail,us.phone FROM fine AS fi INNER JOIN finetype AS ft ON fi.fineTypeID= ft.fineTypeID AND fi.fineTypeID = ft.fineTypeID INNER JOIN `user` AS us ON fi.userID= us.userID AND fi.userID = us.userID";
		Pager<FineManager> fim =iBorrowService.getPagerBySql1(sql, null, null, pager, size, null, null);
		fineManager = fim.getDatas();
		List<Fine> userlist=iFineService.list("from Fine");
    	count=userlist.size();
		pagercount= count/size;
		    if(count%size>0){
		    	pagercount++;
		    }else{
		  }
		ActionContext.getContext().put("fine", fineManager);
		return "fine";
		
	}
	/**
	 * 超期付费
	 * @return
	 */
	public String chaoqifukaun(){
		Fine fi=new Fine();
		fi=iFineService.findById(fineID);
		fi.setPayment(true);
		iFineService.update(fi);
		loadFine();
		 ActionContext.getContext().put("message", "缴费成功");
		return "fine";
		}
	
	/*分页*/
	public String First(){
		
			 if(ee==1){ /* 这是首页情况*/
				  pager=1;  
			  }else
		     if(ee==2){/* 上一页*/
				if(pager>1){
				  pager--;  
				 }else{
						ActionContext.getContext().put("message", "已是首页");
				 }
			  }else
			  if(ee==3){ /*下一页*/
		     	if(pager<pagercount){
				  pager++;  
					  }else{
							ActionContext.getContext().put("message", "已是尾页");
					  }
			  }else 
			    if(ee==4){
				  pager=pagercount;  
			  }else{
				  
			  }
			 loadFine();
			  System.out.println(pagercount);
		 System.out.println(pager);
		return "fine";
		
	}
	@Autowired
	private IMailService imailService;
	private List<Mailmessage> mailmessage =null;
	public void aaa(){
		Mailmessage mail=new Mailmessage();
		/*mail.setUserId(1);
		mail.setRemail("1");
		mail.setSendmail("1");
		mail.setMailtitle("您好！");
		mail.setContextType("pop3");
		mail.setFilename("无");
		mail.setFilename1("无");
		mail.setCreationtime(BorrowDate());
		mail.setExpecttosendtime(BorrowDate());
		mail.setNumberofretries(1);
		mail.setActualtime(BorrowDate());*/
		mailmessage= imailService.list("from Mailmessage where emailId="+3);
		System.out.println(mailmessage);
	}/**
	 * 当前时间
	 * @return
	 */
	public Timestamp BorrowDate(){
		SimpleDateFormat sf=null;
		 Calendar c=null;
		 Date date = null; 
			 sf=new SimpleDateFormat("yyyy-MM-dd");
			  c=Calendar.getInstance();
			 c.add(c.DAY_OF_MONTH, 0);
		try {
			  date = sf.parse(sf.format(c.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Timestamp timestamp = new Timestamp(date.getTime()); 
		return timestamp;
	}
	
	private int ee;
	public int getEe() {
		return ee;
	}
	public void setEe(int ee) {
		this.ee = ee;
	}
	
	private  int pagercount=1;
	public int getPagercount() {
		return pagercount;
	}
	public void setPagercount(int pagercount) {
		this.pagercount = pagercount;
	}
	
	private  int pager=1;
	public int getPager() {
		return pager;
	}
	public void setPager(int pager) {
		this.pager = pager;
	}
	
	private int fineID;
	public void setFineID(int fineID) {
		this.fineID = fineID;
	}
	public void setBroid(int broid) {
		this.fineID = broid;
	}
}

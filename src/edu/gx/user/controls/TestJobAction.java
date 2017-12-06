package edu.gx.user.controls;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionContext;
import com.sun.mail.util.MailSSLSocketFactory;

import edu.gx.dao.service.IBorrowService;
import edu.gx.dao.service.IDatailsService;
import edu.gx.dao.service.IMailService;
import edu.gx.dao.service.IUserService;
import edu.gx.user.model.Borrow;
import edu.gx.user.model.Borrowinfo;
import edu.gx.user.model.Mailmessage;
import edu.gx.user.model.Pager;
import edu.gx.user.model.UserBorrow;
import edu.gx.user.model.Userinfo;
@Scope("prototype")
public class TestJobAction {
	@Autowired
	private IBorrowService iBorrowService;
	@Autowired
	private IUserService iUserService;
	@Autowired
	private IMailService imailService;
	
	private List<Borrow> borrow =null;
	private Borrow borrow1 =null;
	List<UserBorrow> userinfolist=null;
	private List<Mailmessage> mailmessage =null;
	public void doJob() {
		System.out.println(new Date()+"1");
		borrow=iBorrowService.list("from Borrow");
		if(borrow!=null && borrow.size()>0){
			for(int i =0;i<borrow.size();i++){
			 if(!borrow.get(i).getWhetherReturn()){   //读取米有还的书
				String sql="SELECT `user`.userID,`user`.roleID,role.borrowBooksLength,borrow.borrowDate,borrow.borrowID,`user`.mail,`user`.userName,book.bookName FROM `user` INNER JOIN role ON `user`.roleID = role.roleID INNER JOIN borrow ON borrow.userID = `user`.userID INNER JOIN book ON book.bookID = borrow.bookID where borrow.borrowID= '"+borrow.get(i).getBorrowId()+"' ";
				Pager<UserBorrow> userinfo=iUserService.getPagerBySql1(sql, null, null, 1, borrow.size(), null, null);
				userinfolist = userinfo.getDatas();
				if(userinfolist.size()>0){
					long days=fanhuishifouguoqi(userinfolist.get(0).getBorrowDate().toString());
					if(days-userinfolist.get(0).getBorrowBooksLength()>0){
						System.out.println(days-userinfolist.get(0).getBorrowBooksLength());
						//更新订单状态  用户下单超过自定义天数天未支付 自动关闭该订单
						borrow1=new Borrow();
						borrow1=iBorrowService.load(userinfolist.get(0).getBorrowID());
						System.out.println(borrow1+"心累 ");
						borrow1.setWhetherExtended(true);
						iBorrowService.update(borrow1);
						System.out.println("更新成功");
						//发送邮件
					}
					if((days-3)-userinfolist.get(0).getBorrowBooksLength()>0){
						Mailmessage mail=new Mailmessage();
						mail.setUserId(userinfolist.get(0).getUserID());
						mail.setRemail(userinfolist.get(0).getMail());
						mail.setSendmail(userinfolist.get(0).getMail());
						mail.setMailtitle("您好！"+userinfolist.get(0).getUserName()+"根据您"+userinfolist.get(0).getBorrowDate()+"书名为《"+userinfolist.get(0).getBookName()+"》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！");
						mail.setContextType("pop3");
						mail.setFilename("无");
						mail.setFilename1("无");
						mail.setCreationtime(BorrowDate());
						mail.setExpecttosendtime(BorrowDate());
						mailmessage= imailService.list("from Mailmessage where userId="+userinfolist.get(0).getUserID());
						mail.setNumberofretries(1);
						mail.setActualtime(BorrowDate());
						String title=mail.getMailtitle();
						imailService.add(mail);
						mail(userinfolist.get(0).getMail(),title);//发送邮件
						System.out.println("新增成功");
					}
				}
			 }
		}
		}
	}
	/**
	 * 计算借阅天数
	 * @param date
	 * @return
	 */
	public long fanhuishifouguoqi(String date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date one;  
        Date two; 
        long days=0;  
        try {  
            one = df.parse(date); /*借阅时间 */
            two = df.parse(BorrowDate().toString());  /* 当前时间*/
            long time1 = one.getTime();  
            long time2 = two.getTime();  
            long diff = 0 ;  
            if(time1<time2) {  
                diff = time2 - time1;  
            } else { 
            } 
            days = diff / (1000 * 60 * 60 * 24);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }
		return days;
	}
	/**
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
	
	public void mail(String mail,String title){
		 Properties prop = new Properties();
	        // 开启debug调试，以便在控制台查看
	        prop.setProperty("mail.debug", "true");
	        // 设置邮件服务器主机名
	        prop.setProperty("mail.host", "smtp.qq.com");
	        // 发送服务器需要身份验证
	        prop.setProperty("mail.smtp.auth", "true");
	        // 发送邮件协议名称
	        prop.setProperty("mail.transport.protocol", "smtp");

	        // 开启SSL加密，否则会失败
	        MailSSLSocketFactory sf = null;
			try {
				sf = new MailSSLSocketFactory();
			} catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        sf.setTrustAllHosts(true);
	        prop.put("mail.smtp.ssl.enable", "true");
	        prop.put("mail.smtp.ssl.socketFactory", sf);

	        // 创建session
	        Session session = Session.getInstance(prop);

	        // 通过session得到transport对象
	        Transport ts = null;
			try {
				ts = session.getTransport();
			} catch (NoSuchProviderException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        // 连接邮件服务器：邮箱类型，帐号，授权码代替密码（更安全）
	        try {
				ts.connect("smtp.qq.com", "1010789554", "ukgyonykdfjpbfib");
			} catch (MessagingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        // 后面的字符是授权码，用qq密码失败了

	        // 创建邮件
	        Message message = null;
			try {
				message = createSimpleMail(session,mail,title);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        // 发送邮件
	        try {
				ts.sendMessage(message, message.getAllRecipients());
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				ts.close();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	private String dantitle;
	private String youxiang;
	private Integer uid;
	public String getDantitle() {
		return dantitle;
	}
	public void setDantitle(String dantitle) {
		this.dantitle = dantitle;
	}
	public String getYouxiang() {
		return youxiang;
	}
	public void setYouxiang(String youxiang) {
		this.youxiang = youxiang;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String sendmail(){
		String mohulbtName=null;
		try {
			mohulbtName = new String(dantitle.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Mailmessage mail=new Mailmessage();
		mail.setUserId(uid);
		mail.setRemail(youxiang);
		List<Userinfo> userinfolist= (List<Userinfo>) ActionContext.getContext().getSession().get("userinfolist");
		mail.setSendmail(userinfolist.get(0).getMail());
		mail.setMailtitle(mohulbtName);
		mail.setContextType("pop3");
		mail.setFilename("无");
		mail.setFilename1("无");
		mail.setCreationtime(BorrowDate());
		mail.setExpecttosendtime(BorrowDate());
		mail.setNumberofretries(1);
		mail.setActualtime(BorrowDate());
		imailService.add(mail);
		
		 Properties prop = new Properties();
	        // 开启debug调试，以便在控制台查看
	        prop.setProperty("mail.debug", "true");
	        // 设置邮件服务器主机名
	        prop.setProperty("mail.host", "smtp.qq.com");
	        // 发送服务器需要身份验证
	        prop.setProperty("mail.smtp.auth", "true");
	        // 发送邮件协议名称
	        prop.setProperty("mail.transport.protocol", "smtp");
	        // 开启SSL加密，否则会失败
	        MailSSLSocketFactory sf = null;
			try {
				sf = new MailSSLSocketFactory();
			} catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        sf.setTrustAllHosts(true);
	        prop.put("mail.smtp.ssl.enable", "true");
	        prop.put("mail.smtp.ssl.socketFactory", sf);

	        // 创建session
	        Session session = Session.getInstance(prop);

	        // 通过session得到transport对象
	        Transport ts = null;
			try {
				ts = session.getTransport();
			} catch (NoSuchProviderException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        // 连接邮件服务器：邮箱类型，帐号，授权码代替密码（更安全）
	        try {
				ts.connect("smtp.qq.com", "你的扣扣", "扣扣授权码");
			} catch (MessagingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        // 后面的字符是授权码，用qq密码失败了

	        // 创建邮件
	        Message message = null;
			try {
				message = createSimpleMail(session,youxiang,mohulbtName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        // 发送邮件
	        try {
				ts.sendMessage(message, message.getAllRecipients());
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				ts.close();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        List<Borrowinfo> borrowinfo=null;
	 		String sql="SELECT bw.borrowID,bw.userID,bw.bookID,bw.borrowDate,bw.whetherReturn,bw.actualReturnTime, bw.renewNumber,bw.whetherExtended,bw.borrowingStatus,us.userName,us.libraryCard,us.borrow,bk.bookName,us.borrowingAmount,us.roleID,bk.price,us.mail FROM borrow AS bw INNER JOIN book AS bk ON bk.bookID = bk.bookID AND bw.bookID = bk.bookID INNER JOIN `user` AS us ON bw.userID = us.userID";
	 	    Pager<Borrowinfo> lib=iBorrowService.getPagerBySql(sql, null, null, 1, 5, "bw.actualReturnTime", "desc");
	 		borrowinfo=lib.getDatas();
	 		borrow=iBorrowService.list("from Borrow");
	 		ActionContext.getContext().put("borrowinfo", borrowinfo);
	        return "fanhui";
	}
	  /**
     * @Method: createSimpleMail
     * @Description: 创建一封只包含文本的邮件
     */
    public static MimeMessage createSimpleMail(Session session,String mail,String title)
            throws Exception {
        // 创建邮件对象
        MimeMessage message = new MimeMessage(session);
        // 指明邮件的发件人
        message.setFrom(new InternetAddress("1010789554@qq.com"));
        // 指明邮件的收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail.toString().trim()));
        // 邮件的标题
        message.setSubject(title);
        // 邮件的文本内容
        message.setContent("发送邮件成功！", "text/html;charset=UTF-8");
        // 返回创建好的邮件对象
        return message;
  }
   
}

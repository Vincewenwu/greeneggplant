package edu.gx.user.controls;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.gx.common.utils.NowTime;
import edu.gx.dao.service.IDatailsService;
import edu.gx.dao.service.IMailService;
import edu.gx.dao.service.ISysnewsService;
import edu.gx.user.model.Datails;
import edu.gx.user.model.Libraryinfo;
import edu.gx.user.model.Messageinfo;
import edu.gx.user.model.Pager;
import edu.gx.user.model.Snewsinfo;
import edu.gx.user.model.Sysnews;

@Scope("prototype")
// @Controller("book.BookAction")
public class MessageAction extends ActionSupport {
	@Autowired
	private IMailService imailService;
	@Autowired
	private ISysnewsService iSysnewsService;
	@Autowired
	private IDatailsService iDatailsService;

	Pager<Messageinfo> message = null;
	Pager<Snewsinfo> snewsinfo = null;
	
	List<Messageinfo> messageinfo = null;
	List<Snewsinfo> listsnewsinfo = null;
	List<Datails> datasys = null;

	private Datails datails;
	
	public String mail() {
		try {
			int id = (Integer) ActionContext.getContext().getSession()
					.get("userID");
			String sql = "SELECT mailmessage.EmailID,mailmessage.userID,mailmessage.remail,mailmessage.sendmail, mailmessage.mailtitle,`user`.userName,mailmessage.actualtime FROM mailmessage INNER JOIN `user` ON mailmessage.userID = `user`.userID where mailmessage.userID= '"
					+ id + "' ";
			message = imailService.getPagerBySql1(sql, null, null, 1, 1000, null,
					null);
			messageinfo = message.getDatas();
				ActionContext.getContext().getSession()
				.put("messageinfo", messageinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "news";
	}

	public String systme() {
		try {
			int id =(Integer) ActionContext.getContext().getSession()
					.get("userID");
			System.out.println(id);
			String sql = "SELECT sysnews.systeminformationID,sysnews.senduserID,sysnews.sendusertype,sysnews.resuserID,sysnews.resusertype,sysnews.messagecontent,sysnews.transmissiontime,sysnews.Whetherornottoread,sysnews.readtime,`user`.userName,role.roleName FROM sysnews INNER JOIN `user` ON sysnews.senduserID = `user`.userID INNER JOIN role ON `user`.roleID = role.roleID where sysnews.resuserID= '"
						+ id + "' ORDER BY sysnews.transmissiontime DESC";
			snewsinfo= iSysnewsService.pageSnewsinfo(sql, null, null, 1, 1000, null, null);
			listsnewsinfo=snewsinfo.getDatas();
			ActionContext.getContext().getSession().put("listsnewsinfo", listsnewsinfo);
			int count=0;
			for (int i = 0; i < listsnewsinfo.size(); i++) {
				if(!listsnewsinfo.get(i).getWhetherornottoread()){
					count++;
				}
			}
			ActionContext.getContext().getSession().put("count", count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "system";
	}
	/**
	 * 系统信息修改为已读
	 * @return
	 */
	public String yidu(){
		Sysnews sysnew=null;
		sysnew =iSysnewsService.findById(id);
		sysnew.setWhetherornottoread(true);
	    NowTime time=new NowTime();
		sysnew.setReadtime(time.BorrowDate());
		iSysnewsService.add(sysnew);
		systme();
		return "system";
		
	}
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String notice(){
		datasys= iDatailsService.list("from Datails");
	 	ActionContext.getContext().put("datasys", datasys);
		return "noticejsp";
		
	}
	/**
	 * 跳回首页的时候加载图片
	 * @return
	 */
	public String shouye(){
		datasys= iDatailsService.list("from Datails");
	 	ActionContext.getContext().put("datasys", datasys);
		return "shouye";
		
	}
	/**
	 * 审核公告
	 */
	public String shenhe(){
       Datails t=new Datails();
       t=iDatailsService.findById(id);
       t.setChangedbystate(true);
       iDatailsService.update(t);
       shouye();
		return "noticejsp";
		
	}
	/**
	 * 公告保存
	 * @return
	 */
	public String addxintongg(){
		 String path=ServletActionContext.getServletContext().getRealPath("/upload");//这里是哟保存的路径
 		if(file!=null){
 			File destFile=new File(path,fileFileName);
 			try {
 				System.out.println(fileFileName+"--"+fileContentType);
 				FileUtils .copyFile(file, destFile);
 			} catch (IOException e) {
 				e.printStackTrace();
 			}
 		}
		Datails t=new Datails();
		t.setDetailsTypeId(1);
		t.setTitle(datails.getTitle());
		t.setArticle(datails.getArticle());
		t.setSource(datails.getSource());
		NowTime time=new NowTime();
		t.setExpectthereleasedate(datails.getExpectthereleasedate());
		t.setThepicture(fileFileName);
		t.setPublishcontent(datails.getPublishcontent());
		t.setCreaterId(6);//这里可以根据数据查
		t.setCreatertime(time.BorrowDate());
		t.setChangedbystate(false);
		iDatailsService.add(t);
		
		notice();
		return "noticejsp";
	}

	public Datails getDatails() {
		return datails;
	}
	public void setDatails(Datails datails) {
		this.datails = datails;
	}
	
	private File file;
	private String fileFileName;
	private String fileContentType;
	private String savePath;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}	
	
	
}

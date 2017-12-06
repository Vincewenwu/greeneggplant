package edu.gx.user.controls;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.gx.dao.service.IBookService;
import edu.gx.dao.service.ILibraryService;
import edu.gx.dao.service.ILibraryTypeService;
import edu.gx.dao.service.IRoleService;
import edu.gx.user.model.Book;
import edu.gx.user.model.Bookinfo;
import edu.gx.user.model.Library;
import edu.gx.user.model.Libraryinfo;
import edu.gx.user.model.Librarytype;
import edu.gx.user.model.Librarytypeinfo;
import edu.gx.user.model.Pager;
import edu.gx.user.model.Role;
import edu.gx.user.model.User;
import edu.gx.user.model.Userinfo;
@Scope("prototype")
//@Controller("book.BookAction")
public class BookAction extends ActionSupport {
	
	@Autowired
	private IBookService iBookService;
	@Autowired
 	private ILibraryService iLibraryService;
	@Autowired
	private ILibraryTypeService iLibraryTypeService;
	@Autowired
	private  IRoleService iRoleService;
	
	
	private List<Book> book =null;
	private List<Library> library =null;
	private List<Role> role =null;
	private List<Librarytype> librarytype =null;
	private  int count=0;
	private  int size=5;
	
	private String mohuName=null;
	public String getMohuName() {
		return mohuName;
	}
	public void setMohuName(String mohuName) {
		this.mohuName = mohuName;
	}
	private String mohulbtName;
	
	public String getMohulbtName() {
		return mohulbtName;
	}
	public void setMohulbtName(String mohulbtName) {
		this.mohulbtName = mohulbtName;
	}
	/**
	 * 图书馆查询
	 * @return
	 */
     public String library(){
    	 List<Libraryinfo> iibrarytypeinfo=null;
 		try {
 			 if(mohulbtName!=null){
 				 mohulbtName = new String(mohulbtName.getBytes("ISO-8859-1"), "UTF-8");
 					if(mohulbtName==null){
 						String sql="SELECT library.libraryID,library.libraryName FROM library";
 						Pager<Libraryinfo> lib=iLibraryService.getPagerBySql(sql, null, null, pager, size, null, null);
 						iibrarytypeinfo=lib.getDatas();
 						library=iLibraryService.list("from Library");
 				    	count=library.size();
 				    	 pagercount= count/size;
 						    if(count%size>0){
 						    	pagercount++;
 						    }else{
 						  }
 					}
 					else{
 						String sql="SELECT library.libraryID,library.libraryName FROM library WHERE libraryName LIKE '%"+mohulbtName+"%'";
 						Pager<Libraryinfo> lib=iLibraryService.getPagerBySql(sql, null, null, pager, size, null, null);
 						iibrarytypeinfo=lib.getDatas();
 						count=iibrarytypeinfo.size();
 				    	 pagercount= count/size;
 						    if(count%size>0){
 						    	pagercount++;
 						    }else{
 						  }
 					}
 			  }else{
 				 if(mohulbtName==null){
						String sql="SELECT library.libraryID,library.libraryName FROM library";
						Pager<Libraryinfo> lib=iLibraryService.getPagerBySql(sql, null, null, pager, size, null, null);
						iibrarytypeinfo=lib.getDatas();
						library=iLibraryService.list("from Library");
				    	count=library.size();
				    	 pagercount= count/size;
						    if(count%size>0){
						    	pagercount++;
						    }else{
						  }
					}
					else{
						String sql="SELECT library.libraryID,library.libraryName FROM library WHERE libraryName LIKE '%"+mohulbtName+"%'";
						Pager<Libraryinfo> lib=iLibraryService.getPagerBySql(sql, null, null, pager, size, null, null);
						iibrarytypeinfo=lib.getDatas();
						count=iibrarytypeinfo.size();
				    	 pagercount= count/size;
						    if(count%size>0){
						    	pagercount++;
						    }else{
						  }
					}
 			  }
 		} catch (UnsupportedEncodingException e) {
 			e.printStackTrace();
 		}
 		   	ActionContext.getContext().put("lirb", iibrarytypeinfo);
	    return "library";
      }
	/** 查询图书馆类型
	 * libraryManager
	 * @return
	 */
	public String libraryManager(){
		List<Librarytypeinfo> iibrarytypeinfo=null;
		try {
			 if(mohulbtName!=null){
				 mohulbtName = new String(mohulbtName.getBytes("ISO-8859-1"), "UTF-8");
					if(mohulbtName==null){
						String sql="SELECT librarytype.libraryTypeID,librarytype.libraryType FROM librarytype";
						Pager<Librarytypeinfo> lib=iLibraryTypeService.getPagerBySql(sql, null, null, pager, size, null, null);
						iibrarytypeinfo=lib.getDatas();
						librarytype=iLibraryTypeService.list("from Librarytype");
				    	count=librarytype.size();
				    	 pagercount= count/size;
						    if(count%size>0){
						    	pagercount++;
						    }else{
						  }
					}
					else{
						String sql="SELECT librarytype.libraryTypeID,librarytype.libraryType FROM librarytype WHERE libraryType LIKE '%"+mohulbtName+"%'";
						Pager<Librarytypeinfo> lib=iLibraryTypeService.getPagerBySql(sql, null, null, pager, size, null, null);
						iibrarytypeinfo=lib.getDatas();
						count=iibrarytypeinfo.size();
				    	 pagercount= count/size;
						    if(count%size>0){
						    	pagercount++;
						    }else{
						  }
					}
			  }else{
				  if(mohulbtName==null){
						String sql="SELECT librarytype.libraryTypeID,librarytype.libraryType FROM librarytype";
						Pager<Librarytypeinfo> lib=iLibraryTypeService.getPagerBySql(sql, null, null, pager, size, null, null);
						iibrarytypeinfo=lib.getDatas();
						librarytype=iLibraryTypeService.list("from Librarytype");
				    	count=librarytype.size();
				    	 pagercount= count/size;
						    if(count%size>0){
						    	pagercount++;
						    }else{
						  }
					}
					else{
						String sql="SELECT librarytype.libraryTypeID,librarytype.libraryType FROM librarytype WHERE libraryType LIKE '%"+mohulbtName+"%'";
						Pager<Librarytypeinfo> lib=iLibraryTypeService.getPagerBySql(sql, null, null, pager, size, null, null);
						iibrarytypeinfo=lib.getDatas();
						count=iibrarytypeinfo.size();
				    	 pagercount= count/size;
						    if(count%size>0){
						    	pagercount++;
						    }else{
						  }
					}
			  }
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		   	ActionContext.getContext().put("libtype", iibrarytypeinfo);
		return "librarytype";
	}
	/**
	 * 图书书本类型新增
	 * @return
	 */
	public String addlbt(){
		Librarytype liy=new Librarytype();
		liy.setLibraryType(lbt.getLibraryType());
		iLibraryTypeService.add(liy);
		libraryManager();
		ActionContext.getContext().put("message", "新增成功");
		return "librarytype";
	}
	/**
	 * 图书馆类型新增
	 * @return
	 */
	public String addlibrary(){
		Library lbi=new Library();
		lbi.setLibraryName(lb.getLibraryName());
		iLibraryService.add(lb);
		library();  
		ActionContext.getContext().put("message", "新增成功");
		return "library";
	}
	/** 图书书本类型修改
	 * @return
	 */
	public String updatelbt(){
		Librarytype liy=new Librarytype();
		liy.setLibraryType(lbt.getLibraryType());
		liy.setLibraryTypeId(lbt.getLibraryTypeId());
		iLibraryTypeService.update(liy);
		libraryManager();
		ActionContext.getContext().put("message", "修改成功");
		return "librarytype";
	}
	/** 图书馆类型修改
	 * @return
	 */
	public String updatelibrary(){
		Library lbi=new Library();
		lbi.setLibraryId(lb.getLibraryId());
		lbi.setLibraryName(lb.getLibraryName());
		iLibraryService.update(lb);
		library();
		ActionContext.getContext().put("message", "修改成功");
		return "library";
	}
	/**
	 * 删除图书书本类型
	 * @return
	 */
			public String lbtdelect(){
				String message="";
				String [] ids = id.split(",");
				int [] num=new int[ids.length];
				for(int i=0;i<num.length;i++){
					num[i]=Integer.parseInt(ids[i]);
				}
				for(int zj : num){
					iLibraryTypeService.delete(zj);
				}
				if(num.length>0){
					message="删除成功";
					libraryManager();
				}else{
					message="删除失败";
				}
				  ActionContext.getContext().put("message",message);
				 return "librarytype";	
			}
   /**
   * 删除图书馆类型
   * @return
   * 	 */
	public String delectlibrary(){
		 	String message="";
			String [] ids = id.split(",");
			int [] num=new int[ids.length];
			for(int i=0;i<num.length;i++){
				num[i]=Integer.parseInt(ids[i]);
			}
			for(int zj : num){
				iLibraryService.delete(zj);
				}
			if(num.length>0){
				library();
		 	}else{
				}
			ActionContext.getContext().put("message", "删除成功");
			 return "library";	
			}
	
		//	查询book列表加分页
		public String index(){
			List<Bookinfo> bookInfoList=null;
			try {
	       	if(mohuName!=null){
				mohuName = new String(mohuName.getBytes("ISO-8859-1"), "UTF-8");
				if(mohuName==null){
		    		String sql="SELECT book.bookID,book.bookOnlyCoding,book.bookName,book.price,book.author,book.publishingCompany,book.publishTime,book.stock,book.abstruct,book.libraryPagination,book.buildTime,book.libraryID,library.libraryName,librarytype.libraryType,book.picture,book.libraryTypeID FROM book INNER JOIN library ON book.libraryID = library.libraryID INNER JOIN librarytype ON book.libraryTypeID = librarytype.libraryTypeID";
		    		Pager<Bookinfo> book1 = iBookService.getPagerBySql(sql, null, null, pager, size, null, null);
		    		bookInfoList = book1.getDatas();
		    		book=iBookService.list("from Book");
			    	count=book.size();
			    	 pagercount= count/size;
					    if(count%size>0){
					    	pagercount++;
					    }else{
					  }
		    	}else  {
		    		String  sql="SELECT book.bookID,book.bookOnlyCoding,book.bookName,book.price,book.author,book.publishingCompany,book.publishTime,book.stock,book.abstruct,book.libraryPagination,book.buildTime,book.libraryID,library.libraryName,librarytype.libraryType,book.picture,book.libraryTypeID FROM book INNER JOIN library ON book.libraryID = library.libraryID INNER JOIN librarytype ON book.libraryTypeID = librarytype.libraryTypeID WHERE book.bookName LIKE '%"+mohuName+"%'";
		    		Pager<Bookinfo> book1 = iBookService.getPagerBySql(sql, null, null, pager, size, null, null);
		    		bookInfoList = book1.getDatas();
			    	count=bookInfoList.size();
			    	 pagercount= count/size;
					    if(count%size>0){
					    	pagercount++;
					    }else{
					  }
		    	}
				}else{
					if(mohuName==null){
			    		String sql="SELECT book.bookID,book.bookOnlyCoding,book.bookName,book.price,book.author,book.publishingCompany,book.publishTime,book.stock,book.abstruct,book.libraryPagination,book.buildTime,book.libraryID,library.libraryName,librarytype.libraryType,book.picture,book.libraryTypeID FROM book INNER JOIN library ON book.libraryID = library.libraryID INNER JOIN librarytype ON book.libraryTypeID = librarytype.libraryTypeID";
			    		Pager<Bookinfo> book1 = iBookService.getPagerBySql(sql, null, null, pager, size, null, null);
			    		bookInfoList = book1.getDatas();
			    		book=iBookService.list("from Book");
				    	count=book.size();
				    	 pagercount= count/size;
						    if(count%size>0){
						    	pagercount++;
						    }else{
						  }
			    	}else  {
			    		String  sql="SELECT book.bookID,book.bookOnlyCoding,book.bookName,book.price,book.author,book.publishingCompany,book.publishTime,book.stock,book.abstruct,book.libraryPagination,book.buildTime,book.libraryID,library.libraryName,librarytype.libraryType,book.picture,book.libraryTypeID FROM book INNER JOIN library ON book.libraryID = library.libraryID INNER JOIN librarytype ON book.libraryTypeID = librarytype.libraryTypeID WHERE book.bookName LIKE '%"+mohuName+"%'";
			    		Pager<Bookinfo> book1 = iBookService.getPagerBySql(sql, null, null, pager, size, null, null);
			    		bookInfoList = book1.getDatas();
				    	count=bookInfoList.size();
				    	 pagercount= count/size;
						    if(count%size>0){
						    	pagercount++;
						    }else{
						  }
			    	}
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
    	library=iLibraryService.list("from Library");
 	    System.out.println(library);
 	    librarytype=iLibraryTypeService.list("from Librarytype");
	    System.out.println(librarytype);
	    role=iRoleService.list("from Role");
        ActionContext.getContext().put("book", bookInfoList);
     	ActionContext.getContext().put("library", library);
    	ActionContext.getContext().put("librarytype", librarytype);
    	ActionContext.getContext().put("role", role);
		return "list";
    	}	
	
		//	查询book列表加分页
		public String indexsys(){
			List<Bookinfo> bookInfoList=null;
			try {
	       	if(mohuName!=null){
				mohuName = new String(mohuName.getBytes("ISO-8859-1"), "UTF-8");
				String [] sss=mohuName.split("《");
				int z=0;
				   for(String item:sss){
					   System.out.println(item.substring(0, item.length()-1));
					   z++;
					   String bookn=item.substring(0, item.length()-1);
					   if(z==2){
						   String  sql="SELECT book.bookID,book.bookOnlyCoding,book.bookName,book.price,book.author,book.publishingCompany,book.publishTime,book.stock,book.abstruct,book.libraryPagination,book.buildTime,book.libraryID,library.libraryName,librarytype.libraryType,book.picture,book.libraryTypeID FROM book INNER JOIN library ON book.libraryID = library.libraryID INNER JOIN librarytype ON book.libraryTypeID = librarytype.libraryTypeID WHERE book.bookName LIKE '%"+bookn+"%'";
				    		Pager<Bookinfo> book1 = iBookService.getPagerBySql(sql, null, null, pager, size, null, null);
				    		bookInfoList = book1.getDatas();
					    	count=bookInfoList.size();
					    	 pagercount= count/size;
							    if(count%size>0){
							    	pagercount++;
							    }else{
							  }
						  }
					   }
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
    	library=iLibraryService.list("from Library");
 	    System.out.println(library);
 	    librarytype=iLibraryTypeService.list("from Librarytype");
	    System.out.println(librarytype);
	    role=iRoleService.list("from Role");
        ActionContext.getContext().put("book", bookInfoList);
     	ActionContext.getContext().put("library", library);
    	ActionContext.getContext().put("librarytype", librarytype);
    	ActionContext.getContext().put("role", role);
    	List<Userinfo> userinfolist=(List<Userinfo>) ActionContext.getContext().getSession().get("userinfolist");
     String re=null;
    	if(userinfolist.get(0).getRoleID()==1){
    		re="list";
      }else{
    	  List<Bookinfo> bookInfoList1=null;
  		String sql="SELECT book.bookID,book.bookOnlyCoding,book.bookName,book.price,book.author,book.publishingCompany,book.publishTime,book.stock,book.abstruct,book.libraryPagination,book.buildTime,book.libraryID,library.libraryName,librarytype.libraryType,book.picture,book.libraryTypeID FROM book INNER JOIN library ON book.libraryID = library.libraryID INNER JOIN librarytype ON book.libraryTypeID = librarytype.libraryTypeID where book.bookID="+bookInfoList.get(0).getBookID()+"";
  			Pager<Bookinfo> lib=iBookService.getPagerBySql(sql, null, null, 1, -1, null, null);
  			bookInfoList1=lib.getDatas();
  		 ActionContext.getContext().put("lirlist", bookInfoList1);
    	  re="second";
      }
    	return re;
    }
	
		//新增图书 
		public String add(){
			 String path=ServletActionContext.getServletContext().getRealPath("/upload");/*这里是哟保存的路径*/
	       		if(file!=null){
	       			File destFile=new File(path,fileFileName);
	       			try {
	       				System.out.println(fileFileName+"--"+fileContentType);
	       				FileUtils .copyFile(file, destFile);
	       			} catch (IOException e) {
	       				e.printStackTrace();
	       			}
	       		}
			String message;
		    Book book1=new Book();
		   book1.setAbstruct(pbook.getAbstruct());
		   book1.setAuthor(pbook.getAuthor());
		   book1.setBookId(pbook.getBookId());
		   book1.setBookName(pbook.getBookName());
           book1.setBookOnlyCoding(pbook.getBookOnlyCoding());
           book1.setBuildTime(pbook.getBuildTime());
           book1.setLibraryId(pbook.getLibraryId());
           book1.setLibraryPagination(pbook.getLibraryPagination());
           book1.setLibraryTypeId(pbook.getLibraryTypeId());
           book1.setPicture(fileFileName);
           book1.setPrice(pbook.getPrice());
           book1.setPublishingCompany(pbook.getPublishingCompany());
           book1.setPublishTime(pbook.getPublishTime());
           book1.setStock(pbook.getStock());
           Book i= iBookService.add(book1);
           if(i!=null){
    		   index();
    		   ActionContext.getContext().put("message", "新增成功");
    		   message="load";
    	   }else{
    		   message="message";
    	   }
            return message;	
		}
		/**
		 * 修改图书
		 * @return
		 */
		public String update(){
			 Book book1=new Book();
			 String path=ServletActionContext.getServletContext().getRealPath("/upload");/*这里是哟保存的路径*/
	       		if(file!=null){
	       			File destFile=new File(path,fileFileName);
	       			try {
	       				System.out.println(fileFileName+"--"+fileContentType);
	       				FileUtils .copyFile(file, destFile);
	       			} catch (IOException e) {
	       				e.printStackTrace();
	       			}
	       		}else{
	       		}
	       		String lijing=null;
	       		if(file!=null){
	       	        lijing=fileFileName;
	       		}else{
	       			book1= iBookService.load(pbook.getBookId());
	       			System.out.println(book1);
	       			lijing=book1.getPicture().toString(); 
	       		}
		   book1.setAbstruct(pbook.getAbstruct());
		   book1.setAuthor(pbook.getAuthor());
		   book1.setBookId(pbook.getBookId());
		   book1.setBookName(pbook.getBookName());
           book1.setBookOnlyCoding(pbook.getBookOnlyCoding());
           book1.setBuildTime(pbook.getBuildTime());
           book1.setLibraryId(pbook.getLibraryId());
           book1.setLibraryPagination(pbook.getLibraryPagination());
           book1.setLibraryTypeId(pbook.getLibraryTypeId());
           book1.setPicture(lijing);
           book1.setPrice(pbook.getPrice());
           book1.setPublishingCompany(pbook.getPublishingCompany());
           book1.setPublishTime(pbook.getPublishTime());
           book1.setStock(pbook.getStock());
              iBookService.update(book1);
               index();
               ActionContext.getContext().put("message", "修改成功");
            return "load";	
		}
		
		

/**
 * 删除图书
 * @return
 */
		public String delect(){
			String message="";
			String [] ids = id.split(",");
			int [] num=new int[ids.length];
			for(int i=0;i<num.length;i++){
				num[i]=Integer.parseInt(ids[i]);
			}
			for(int zj : num){
               iBookService.delete(zj);
			}
			if(num.length>0){
				message="删除成功";
	              index();
			}else{
				message="删除失败";
			}
			  ActionContext.getContext().put("message", message);
			 return "load";	
		}

/**
 * 分页图书
 * @return
 */
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
				  
				  System.out.println(pagercount);
			 System.out.println(pager);
			  index();
			return "list";
			
		}
		/**
		 * 分页图书书本类型 
		 * @return
		 */
				public String Firsttype(){
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
						  System.out.println(pagercount);
					 System.out.println(pager);
					 libraryManager();
					return "librarytype";
					
				}
				/**
				 * 分页图书馆 
				 * @return
				 */
						public String Firstlibrary(){
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
								  System.out.println(pagercount);
							 System.out.println(pager);
							 library();
							return "library";
						}
		
		/**
		 * 参数区		
		 */	
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


		private String id;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		
		private Book pbook;
	      public Book getPbook() {
			return pbook;
		   }
		  public void setPbook(Book pbook) {
		  	this.pbook = pbook;
		  }
		  
		  private Librarytype lbt; 
		  
		  
		public Librarytype getLbt() {
			return lbt;
		}
		public void setLbt(Librarytype lbt) {
			this.lbt = lbt;
		}
		
		 private Library lb; 

		public Library getLb() {
			return lb;
		}
		public void setLb(Library lb) {
			this.lb = lb;
		}
		private  int pager=1;
		public int getPager() {
			return pager;
		}
		public void setPager(int pager) {
			this.pager = pager;
		}
		
		private  int pagercount=1;
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
}

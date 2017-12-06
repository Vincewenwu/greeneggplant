package com.bs.base.common;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
public class BaseAction extends ActionSupport{
	
	protected static final String MESSAGE="message";
	protected Integer page=1;
	protected Integer pageSize=10;
	protected String sort=null;
	protected String order=null;
	
	/** 
	  * @Fields request : 得到request对象
	  */ 
	protected HttpServletRequest request = ServletActionContext.getRequest();
	/** 
	  * @Fields response : 得到response对象
	  */ 
	protected HttpServletResponse response = ServletActionContext.getResponse();
	
	
	/** 
	  * @Title: outJsonUTFString 
	  * @Description: 以json格式返回
	  * @param @param response 输出
	  * @param @param json json格式字符串
	  * @return void
	  * @throws 
	  */
	protected void outJsonUTFString(HttpServletResponse response, String json) {
		response.setContentType("text/javascript;charset=UTF-8");
		try {
			outString(response, json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** 
	  * @Title: outHtmlUTFString 
	  * @Description: 放回HTML格式的数据 
	  * @param @param response
	  * @param @param json
	  * @return void
	  * @throws 
	  */
	protected void outHtmlUTFString(HttpServletResponse response, String json){
		response.setContentType("text/html;charset=UTF-8");
		try {
			outString(response, json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/** 
	  * @Title: outJsonPlainString 
	  * @Description: ContentType为text/plain 
	  * @param @param response 输出
	  * @param @param json json格式字符串
	  * @return void
	  * @throws 
	  */
	protected void outJsonPlainString(HttpServletResponse response, String json){
		response.setContentType("text/plain;charset=UTF-8");
		try {
			outString(response, json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** 
	  * @Title: outJsonString 
	  * @Description: ContentType为text/json格式 
	  * @param @param response
	  * @param @param json
	  * @return void
	  * @throws 
	  */
	protected void outJsonString(HttpServletResponse response, String json){
		response.setContentType("text/json;charset=UTF-8");
		try {
			outString(response, json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** 
	  * @Title: outXMLString 
	  * @Description: 以xml形式返回
	  * @param @param response 输出
	  * @param @param xmlStr xml串
	  * @return void
	  * @throws 
	  */
	protected void outXMLString(HttpServletResponse response, String xmlStr) {
		response.setContentType("application/xml;charset=UTF-8");
		try {
			outString(response, xmlStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 
	  * @Title: outString 
	  * @Description: 输出字符串
	  * @param response 返回
	  * @param str 传回的字符串
	  * @return void
	  * @throws 
	  */
	private void outString(HttpServletResponse response, String str) {
		try {
			PrintWriter out = response.getWriter();
			out.println(str);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	
}

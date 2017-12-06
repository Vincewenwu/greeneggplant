<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	<link rel="stylesheet" href="css/style.css" type="text/css"></link>
	 <script type="text/javascript" src="js/jquery.js"></script>
	 <script type="text/javascript">   
	 var bool=true;
           $(function(){
       var selectroleid= $("#selectroleid").val();
	  if(selectroleid==1){
           bool=true;
	  }else{  
	    bool=false;
	  };
	 if(selectroleid==null){
	  window.location.href="<%=path%>/login.jsp";
	  }
    });
    
	 function tushuguanli(){
	 if(bool){
	 var url= $("#huoqulianjie").val();
	 window.location.href=url;
	 }else{
	 alert("权限不对应");
	  };
	 }  
	  function xitongguanli(){
	   if(bool){
	var url= $("#xitongguanli").val();
	 window.location.href=url;
	  }else{
	 alert("权限不对应");
	 }
	 }
	 
	  function jieshu(){
	 var url= $("#jieshu").val();
	 window.location.href=url;
	 } 
	 
	 function shoufei(){
	 if(bool){
	 var url= $("#shoufei").val();
	 window.location.href=url;
	 }else{
	 alert("权限不对应");
	  };
	 } 
	  function message(){
	 var url= $("#message").val();
	 window.location.href=url;
	 } 
	  function gonggao(){
	   if(bool){
	 var url= $("#gonggao").val();
	 window.location.href=url;
	 }else{
	 alert("权限不对应");
	  };
	
	 } 
	 
	   function refDaojieshu(){
	 window.location.href="<%=path%>/jieshu/borrowBorrow.html";
	 } 
	 </script>
  </head>
  
  <body>
<%--   我是${user.userName}<br> --%>
  <div id="container">
	<div id="header">
		
	</div>
	<div id="border">
		<div id="main">
			<div id="left">
				<div id="menu">
					<ul>
						<li> <select id="gonggao" onchange="gonggao()" > 
                            <option style="display: none" value="0">公告</option> 
                             <option  value="<%=path%>/mess/noticeNews.html"> 
                                                                                                     系统公告                                                  
                            </option> 
                           </select>
                           </li>
						<li></li>
						<li><li> <select id="message" onchange="message()" > 
                            <option style="display: none" value="0">信息查看</option> 
                            <option  value="<%=path%>/mess/mailNews.html"> 
                                                                                                     邮件留言                                                         
                            </option> 
                            <option  value="<%=path%>/mess/systmeNews.html"> 
                                                                                                     系统留言                                                      
                            </option> 
                           </select>
                           </li>
						<li></li>
						<li> <select id="huoqulianjie" onchange="tushuguanli()" onclick="shouqi()"> 
                            <option style="display: none" value="0">图书管理</option> 
                            <option  value="<%=path%>/note/libraryManagerBook.html"> 
                                                                                                       图书类型
                            </option> 
                            <option  value="<%=path%>/note/libraryBook.html">  
                                                                                                       书馆管理
                             </option> 
                              <option  value="<%=path%>/note/indexBook.html">  
                                                                                                         图书信息     
                            </option> 
                           </select>
                           </li>
						<li></li>
						<li><select id="shoufei" onchange="shoufei()" onclick=""> 
                            <option style="display: none" value="0">业务查询</option> 
                            <option  value="<%=path%>/fine/loadFineMoney.html"> 
                                                                                     收费管理                                                                   
                            </option> 
                           </select>
                           </li>
						<li></li>
						<li></li>
						<li> <select id="jieshu" onchange="jieshu()"> 
                            <option style="display: none" value="0">借书管理</option> 
                              <option  value="<%=path%>/jieshu/borrowBorrow.html">  
                                                                                                           我要借书
                            </option> 
                            <option  value="<%=path%>/jieshu/borrowcordBorrow.html">  
                                                                                                             借书记录
                            </option> 
                           </select>
                          </li>
						<li> <select id="xitongguanli" onchange="xitongguanli()"> 
                            <option style="display: none" value="0">系统管理</option> 
                              <option  value="<%=path%>/log/loadselectLogin.html">  
                                                                                                               用户管理          
                            </option> 
                           </select>
                         </li>
					</ul>
					
					<form  style="display: none">
					 <c:forEach items="${userinfolist}" var="user">
                       <input id="selectroleid" value="${user.roleID }"> 
                     </c:forEach>
                     </form>
			  </div>
				<div id="menubottom">
					<ul>
						<li><a href="index.htm">主页</a></li>
						<li><a href="login.jsp">登录</a></li>
						<li><a href="login.html">注销</a></li>
					</ul>
				</div>
			</div>
			<div id="right">	
				<div class="content">
					<h3></h3>
				    <strong>
				    没进入大学时，有人告诉我，在大学里，最具有价值的地方是——图书馆，因为那里是大学的心脏，是知识的中心；在大学里，你最不能忘记的也是——图书馆，因为那里拥有浩如烟海的文献，各种有价值的知识、信息蕴藏其中，是培养学生获取、分析、处理信息的独立学习能力等综合素质的最好去处。</strong>				    <strong>
				    图书馆与繁华无关，与喧嚣无关，它把窗里的世界与窗外的世界隔开，窗里的世界是安详平和的，窗外的世界却是纷纷攘攘的。它像一座宫殿，据记者智慧光芒与知识宝库的宫殿，阵阵幽香传承着历史与时代的气息，书并不是沉默地躺在宫殿里，而是被渴望获得知识学子的借阅。
				    </strong>
				    <p>&nbsp;</p>
					
				</div>
				<div class="product" onclick="refDaojieshu()">
				  <h3>&nbsp;</h3>  
					<marquee direction="left" scrolldelay="150"> 
					 <c:forEach items="${datasys}" var="b">
					  <c:if test="${b.changedbystate==true }">
					     <img width=200 height=250  src='${pageContext.request.contextPath}/upload/${b.thepicture }'/>
					  </c:if>
					 </c:forEach>
					<div class="clear"></div>
			  </div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div id="footerend"></div>
	
</div>
  </body>
</html>

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
    
    <title>邮件信息</title>
       <script type="text/javascript" src="js/jquery.js"></script> 
	 <script type="text/javascript">
	 var selectroleid;
	  $(function(){
	var message=null;
	   message="${message}";
	  if(message!=""){
	   alert(message);
	  }else{
	  }
	    selectroleid= $("#selectroleid").val();
	   if(selectroleid==null){
	  window.location.href="<%=path%>/login.jsp";
	  }
    });
    </script> 
    <style>  
.keleyitable { 
width: 1200px;  
background-color: bef4c1;

}  
  
.keleyitable table {  
margin-top:10px;  
}  
.klytd {width:100px;text-align:right  ;
}  
.hvttd {  
width:800px}  
</style>  
<body>
 <div style="width: 200;height:50; margin: auto; font-size:25; float: right;"><a href="<%=path%>/mess/shouyeNews.html">首页</a> </div>
<div style="margin:0px auto;" class="keleyitable"><h2>邮件列表</h2>  
 <c:forEach items="${messageinfo}" var="mess">
  <table  style="margin:20">                        
   <tr><td class="klytd"><font color="5e3196">邮件时间：</font> </td><td class="hvttd"><font color="5e3196">${mess.actualtime }</font>  </td></tr>   
   <tr><td class="klytd"><font color="5e3196">发送人：</font></td><td class ="hvttd"><font color="5e3196">${mess.sendmail }</font> </td></tr>   
   <tr><td class="klytd"><font color="5e3196">内容：</font></td><td class ="hvttd"><font color="5e3196">${mess.mailtitle }</font> </td></tr> 
  </table>  
  ╚---------------------------------------------------------------------------------------------------------------------------------------------------------------------╝
 </c:forEach>
</div> 
	<form style="display: none">
         <c:forEach items="${userinfolist}" var="user">
         <input id="selectroleid" value="${user.roleID }"> 
       </c:forEach>
    </form>  
</body>
  
</html>

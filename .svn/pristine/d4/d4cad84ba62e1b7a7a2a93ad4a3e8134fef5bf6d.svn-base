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
    
    <title>借书界面</title>
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
    
    function fanhui(){
   window.location.href="<%=path%>/jieshu/borrowBorrow.action";
    }
    var broid;
    function jieyue(id){
    broid=id;
     window.location.href="<%=path%>/jieshu/querenfukaunBorrow.action?broid="+broid;
    }
    </script>
    <style type="text/css">
    #tishi{
      display:none; margin: -370 0 0 -130;background: ;width: 500;height: 100;font-size: 16;border: 2px solid #000000;border-radius:15px;
    }
    </style>
  </head>
  
  <body>
   <div style="margin: auto; width:1300;height:600">
   <c:forEach items="${fineinfo }" var="lir">
           <div style="width:450 ;height: 550 ;float: left;"></div>
         <div style="width:850 ;height: 550; float: left; "> 
             <div style="margin: 160 0 0 250">
                 <table>
                 <tr>
                 <th>图书书名称：</th>
                   <td >${lir.bookName }</td>
                 </tr>
                 <tr>
                 <th>用&nbsp;户&nbsp;名&nbsp;称：</th>
                  <td>${lir.userName }</td>
                 </tr>
                 <tr>
                 <th>应缴金额：</th>
                  <td>${lir.forfeit }</td>
                 </tr>
                 
                 </table>
                 <div>
                  <a href="javascript:jieyue(${lir.borrowID })">确认收款</a>
                    <a href="javascript:fanhui()">返回</a>
                  </div>
             </div>
         </div>
       </c:forEach>
   </div>

 <form  style="display: none">
         <c:forEach items="${userinfolist}" var="user">
        <input id="selectroleid" value="${user.roleID }"> 
       </c:forEach>
    </form>  
    </body>
  
</html>

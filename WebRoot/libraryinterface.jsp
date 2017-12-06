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
    
    function tishi(){
    $("#tishi").css("display","block");
    }
    
    function likai(){
    $("#tishi").css("display","none");
    }
    function fanhui(){
   window.location.href="<%=path%>/jieshu/borrowBorrow.action";
    }
    var jbid;
    function jieyue(id){
    jbid=id;
     window.location.href="<%=path%>/jieshu/borrowOKBorrow.action?jbid="+jbid+"&selectroleid="+selectroleid;
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
   <c:forEach items="${lirlist }" var="lir">
         <div style="width:450 ;height: 550 ;float: left;"><img alt="" width="450" height="550" src="${pageContext.request.contextPath}/upload/${lir.picture }"></div>
         <div style="width:850 ;height: 550; float: left; "> 
             <div style="margin: 160 0 0 250">
                 <table>
                 <tr>
                 <th>图书书名称：</th>
                   <td >${lir.bookName }</td>
                 </tr>
                 <tr>
                 <th>所属图书馆：</th>
                  <td>${lir.libraryName }</td>
                 </tr>
                 <tr>
                 <th>图书 &nbsp;&nbsp;类型：</th>
                  <td>${lir.libraryType }</td>
                 </tr>
                 <tr>
                   <th>价 &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;格：</th>
                     <td>${lir.price }/￥</td>
                 </tr>
                  <tr>
                   <th>库 &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;存：</th>
                     <td>${lir.stock }/本</td>
                 </tr>
                 </table>
                 <div style="margin: 50" id="anniu"  onmouseover="tishi()" onmouseout="likai()"><a href="javascript:" style="color:red;" >注意事项</a></div>
                
                  <div>
                  <a href="javascript:jieyue(${lir.bookID })">借阅</a>
                    <a href="javascript:fanhui()">返回</a>
                  </div>
                   <div id="tishi" > 普通借阅者根据注册的用户借阅证实现借书操作，1个月内实现续借，<br>
                                                                                                                         超过1个月每天按照0.1元价格缴纳租金，普通用户可以查看自己的<br>
                                                                                                                         借阅历史，遗失和报废需要缴纳书本费用以及借出天数乘以0.1元的租金。
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

<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>新用户注册</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <STYLE  type="text/css">
td{font-size:12px;line-height:30px;}
div{font-size:12px;line-height:30px;}
.p1{border-left:1 #61B4D3 solid;  border-bottom:1 #61B4D3 solid; background-color:#D3EAF3;text-align:right;}
.p2{border-left:1 #cccccc solid;  border-bottom:1 #cccccc solid; }
.p3{border-right:1 #cccccc solid;  border-bottom:1 #cccccc solid; }
.font_error{font-size:12px;color:#ff0000;}
.font_true{font-size:12px;color:#56B429;}
.STYLE2 {
	font-size: large;
	font-weight: bold;
}
.STYLE3 {
	color: #0000FF;
	font-weight: bold;
	font-size: 24px;
}
</STYLE>
	 <script type="text/javascript">
	   function login(){
	       window.location.href="login.jsp"; 
	   }
	   function register(){
	     var password=$("#password").val();
	     var userName=$("#userName").val();
	      var querenmima=$("#querenmima").val();
	         var mail=$("#mail").val();
	          var phone=$("#phone").val();
	   if(userName!="" && password!="" && mail!="" && phone!=""){
	     $("#regi").submit();
	   }else{
	   alert("请填完整注册信息");
	    }
	   }
	    function dlyzmBlur(ele){
         var querenmima = $("#querenmima").next();
         var $p = $("#password").next();
      }
	  </script>
  </head>
  
  <BODY >
<DIV align="center"><BR>
  <BR>
  <span class="STYLE3">以下为必填项</span><BR>
 <BR>
</DIV>
 <form id="regi" action="<%=path%>/log/addLogin.action" method="post">
   <TABLE width="762" border="0" cellspacing="0" cellpadding="0" align="center">
  <TR>
    <TD class="STYLE2" style="border-top:1 #61B4D3 solid;" width="120">用户名：</TD>
	<TD width="180" class="p2" style="border-top:1 #cccccc solid;">&nbsp; <INPUT name="user.userName" id="userName" type="text" size="27" onBlur="checkUser(username);"></TD>
	<TD class="p3" style="border-top:1 #cccccc solid;"><DIV id="userNameInfor">4-20个字符(可使用字母、数字、下划线)</DIV>	</TD>
  </TR>
  <TR>
    <TD class="STYLE2" >密码：</TD>
	<TD class="p2">&nbsp;<INPUT name="user.password" id="password" type="password" size="27"> </TD>
	<TD class="p3"><DIV id="passinfor">密码由6-16个字符(可使用字母、数字、下划线)</DIV></TD>
  </TR>
   <TR>
    <TD class="STYLE2"> 确认密码：</TD>
	<TD class="p2">&nbsp;<INPUT name="querenmima" id="querenmima" type="password" size="27" onblur="dlyzmBlur()"></TD>
	<TD class="p3"><DIV id="repassinfor">请再输入一遍您上面输入的密码</DIV></TD>
  </TR>
   <TR>
    <TD class="STYLE2"> 邮箱：</TD>
	<TD class="p2">&nbsp;<INPUT name="user.mail" id="mail" type="text" size="27" ></TD>
	<TD class="p3"><DIV id="">请输入邮箱</DIV></TD>
  </TR>
  <TR>
    <TD class="STYLE2"> 电话：</TD>
	<TD class="p2">&nbsp;<INPUT  name="user.phone" id="phone" type="text" size="27" ></TD>
	<TD class="p3"><DIV id="">请输入电话号码</DIV></TD>
  </TR>
  <TR>
    <TD class="STYLE2"> 性别：</TD>
	<TD class="p2">&nbsp;<input id="man" type="radio" checked="checked" name="user.sex" value="男" />男
       <input id="woman" type="radio"  name="user.sex" value="女"/>女<br></TD>
	<TD class="p3"><DIV id=""></DIV></TD>
  </TR>
  <TR>
    <TD colspan="3" align="center" height="50" class="p2" style="border-right:1 #cccccc solid;"><a class="STYLE2"  href="javascript:register()">确认</a> <a href="javascript:"><span class="STYLE2" >重置</span></a></TD>
  </TR>
</TABLE>
 </form>
</BODY>

</html>

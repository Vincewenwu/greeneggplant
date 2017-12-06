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
    
    <title>图书列表</title> 
     <script type="text/javascript" src="js/jquery.js"></script> 
	 <script type="text/javascript">
	 
	  $(function(){
	var message=null;
	   message="${message}";
	  if(message!=""){
	   alert(message);
	  }else{
	  
	  }
	   var selectroleid= $("#selectroleid").val();
	   if(selectroleid==null){
	  window.location.href="<%=path%>/login.jsp";
	  }
    });
    var bid;
    function meneedborrowbook(id){
            window.location.href="<%=path%>/jieshu/borrowjiemianBorrow.action?bid="+id;       
     }
	 </script>
	 <style type="text/css">
	
/*教材右边*/
.book-wrap{
	width: 978px;
	padding: 10px;
}
.book dl{
	float: left;
	margin: 10px;
	width: 143px;
}
.book dl dt{
	border: 1px solid #dee8ef;
	padding: 7px 10px 5px 10px;

}
.book dl dt img{
	width: 123px;
	height: 177px;
	font-size: 0;
}
.book dl dd{
	text-align: center;
	margin-top: 5px;
}
.book dl dd p:first-child a{
	font-size: 14px;
	color: #333;
}
.book dl dd p:nth-child(2){
	font-size: 14px;
	color: #999;
}
.book dl dd p:nth-child(3){
	font-size: 16px;
	color: red;
}
.book dl dd p:nth-child(3) s{
	color: #999;
	font-size: 12px;
}
	 </style>
  </head>
<body>
     <div style="width: 1300;height: 50;font-size: 16;border: 2px solid #000000;border-radius:15px;margin: auto;">
      <div style="width: 200;height:50; margin: auto; font-size:25; float: right;"><a href="<%=path%>/mess/shouyeNews.html">首页</a> </div>
       <div style="width: 200;height:50; margin: auto; font-size:25;">用户借书界面</div>
      	<c:forEach items="${librarytype }" var="lbt">
      	<div style="float: left;">
		<h1>${lbt.libraryType}<span></span>
		</h1>
		   <div class="book-wrap fr">
		   <c:forEach items="${lir }" var="lb">
		     <c:if test="${lb.libraryTypeID==lbt.libraryTypeId}">
		  	<div class="book clearfix">
				<dl>
					<dt><a href="detail.html"><img alt="" width="296" height="300" src="${pageContext.request.contextPath}/upload/${lb.picture }"></a></dt>
					<dd>
						<p><a href="">${lb.bookName }</a></p>
						<p>数量：${lb.stock }</p>
						<p><a href="javascript:meneedborrowbook(${lb.bookID })">我要借书</a></p>
					</dd>
				</dl>
			 </div>
			 </c:if>
			 </c:forEach>
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

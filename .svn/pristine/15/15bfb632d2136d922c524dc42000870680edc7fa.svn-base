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
    
    <title>My JSP 'userManager.jsp' starting page</title>
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
	    if(selectroleid!=1){
	  window.location.href="<%=path%>/login.jsp";
	  }
    });
    

	
	 var bool=true;
	  function open(){
	 document.getElementById('biaoliangmima').innerHTML = '确认密码';
          $("#userName").val("");
         /*$("#password")*/
           $("#sex").val("");
            $("#mail").val("");
             $("#phone").val("");
              $("#role").val("");
	  url="<%=path%>/log/addLogin.action";
	   document.getElementById("fm").action=url;
	/*    $("#bookOnlyCoding").val(""); */
	  var aiin = document.getElementById("dlg");
	  
	  if(bool){
	  		  aiin.style.display = 'block';
	  		  bool=false;
	  	  }else{
	  	   aiin.style.display = 'none';
	  		  bool=true;
	  	  }
	  	}
	  	  var bool=true;
	  	  var id=null ;
	  function update(){
	  	 document.getElementById('biaoliangmima').innerHTML = '原密码';
	   url="<%=path%>/log/updateLogin.action";
	   document.getElementById("fm").action=url;
	    if(id!=null){
	   var tableId = document.getElementById("booktable");
         $("#userName").val(tableId.rows[index].cells[1].innerHTML);
         /*  $("#password").val(tableId.rows[index].cells[2].innerHTML); */
         if(tableId.rows[index].cells[4].innerHTML=="男"){
          $("#sex").val(1);
         }else{
          $("#sex").val(2);
         }
            $("#mail").val(tableId.rows[index].cells[5].innerHTML);
             $("#phone").val(tableId.rows[index].cells[6].innerHTML);
              $("#role").val(tableId.rows[index].cells[9].innerHTML);
                $("#userID").val(tableId.rows[index].cells[13].innerHTML);
	  var aiin = document.getElementById("dlg");
	  if(bool){
	  		  aiin.style.display = 'block';
	  		  bool=false;
	  	  }else{
	  	   aiin.style.display = 'none';
	  		  bool=true;
	  	  }
	    }else{
	    alert("请选择一行");
	    }
	  	}
	  	
	   var check;
        function checkaaaaa(e){
         check=document.getElementById("sele"+e).checked;
        }
	   	function clicke(x,e){
	  	var bool=  $("#dlg").css("display");
	  	if(bool){
	  	  $("#dlg").css("display","none");
	  	}
	  	index=x; 
	  	   id=e; 
	  	  /* 点击当前行把当前行的input狗上 */
	  	  if(check){
	  	     document.getElementById("sele"+e).checked=false; 
	    	/*  $(":checkbox[id=sele"+e+"]").attr("checked", false);  */
	    	 check=false;
    	 }else{
	  	  document.getElementById("sele"+e).checked="true"; 
	  	 
	  	  /*   $(":checkbox[id=sele"+e+"]").attr("checked", true);  */
	  	      check=true;
	  	 }
          //获取当前所在行数  
        }
	 function save(){
	     var password=$("#password").val();
	     var userName=$("#userName").val();
	     var querenmima=$("#querenmima").val();
	     var mail=$("#mail").val();
	     var phone=$("#phone").val();
	   if(userName!="" && password!="" && mail!="" && phone!=""){
	    if(querenmima==password){
	        $("#fm").submit();
	    }else{
	     alert("密码不一致");
	    };
	   }else{
	   alert("请填完整注册信息");
	     };
	   };
	   
	    function deletebook(){
	  	var cartItemIdArray = new Array();
	  	alert("id");
	    	$("input[name='checkboxBtn']:checked").each(function() {
					//2. 获取复选框的值，即其他元素的前缀
					var id = $(this).val();
					cartItemIdArray.push(id);
				});
	   if(cartItemIdArray.length!=0){
	   alert("宁确定要删除"+cartItemIdArray.length+"数据");
	       window.location.href="<%=path%>/log/delectLogin.action?id="+cartItemIdArray;
	        var meg=$("#deleteMs").val();
	  }else{
	  alert("请选择至少一行");
	   }  
	 }
	 
	  function firstpager(e){
	   ee=e;
	  pager=$("#pagernow").val();
	  pagercount=$("#zuidayem").val();
	    window.location.href="<%=path%>/log/FirstLogin.action?ee="+ee+"&pager="+pager+"&pagercount="+pagercount;
	 }
	  var mohuuserName=null;
	 function selectbook(){
	     mohuuserName= $("#selectname").val();
	      window.location.href="<%=path%>/log/loadselectLogin.action?mohuuserName="+encodeURIComponent(mohuuserName);
	 }
	</script>

  </head>
  
  <body>
  <!--  table显示数据 -->
<table  align="left" width="680" border="0" cellspacing="2" style="position:relative"cellpadding="0">
  <tr>
    <td align="center" height="50px" bgcolor="#999999">用户管理     <font color="#FF0000">深色的为修改目标</font>    <a style="float: right; width: 200 ;font-size: 20" href="<%=path%>/mess/shouyeNews.html">首页</a> </td>
  </tr>
  <tr>
    <td align="center" bgcolor="#999999"><table width="1250" height="500" bgcolor="#CCCCCC"  border="1" bordercolor="B1BCEC" cellspacing="0" cellpadding="0">
      <tr valign="top">
        <td><table id="booktable" width="1250" height="450" border="0" >
          <tr  height="2px"> <!-- bgcolor="B1BCEC" -->
            <td width="0" align="center" valign="middle" bgcolor="#B1BCEC">选择</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">用户名</td>
            <td width="89.5" align="center" valign="middle"  bgcolor="#B1BCEC">密码</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">借书证</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">性别</td>
            <td width="129.5" align="center" valign="middle" bgcolor="#B1BCEC">邮箱</td>
            <td width="69.5" align="center" valign="middle" bgcolor="#B1BCEC">电话</td>
            <td width="69.5" align="center" valign="middle" bgcolor="#B1BCEC">是否可借阅</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">借阅数量</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">角色</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">是否管理员</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">可借书时长</td>
            </tr>
             <c:forEach items="${users }" var="u">
          <tr onclick="clicke(this.sectionRowIndex,${u.userID })" onmouseover="checkaaaaa(${u.userID})" height="10px">
          <td align="center"  valign="middle" > <input type="checkbox"  id="sele${u.userID }"  name="checkboxBtn" onclick="xiugai(${u.userID })" value="${u.userID }" style="width: 20;height: 20"> </td>
            <td align="center"  valign="middle" >${ u.userName}</td>
            <td align="center" valign="middle" >${ u.password}</td>
            <td align="center" valign="middle" >${ u.libraryCard}</td>
            <td align="center" valign="middle" >${ u.sex}</td>
            <td align="center" valign="middle" >${ u.mail}</td>
            <td align="center" valign="middle" >${ u.phone}</td>
             <td align="center" valign="middle" >${ u.borrow}</td> 
            <td align="center" valign="middle" >${u.borrowingAmount }</td>
            <td align="center" valign="middle" >${ u.roleName}</td>
            <td align="center" valign="middle" >${ u.orAdmin}</td>
            <td align="center" valign="middle" >${ u.borrowBooksLength}</td>
   
            <td align="center" style="display: none" valign="middle" bgcolor="#FFFFFF">${ u.roleID}</td>
            <td align="center" style="display: none" valign="middle" bgcolor="#FFFFFF">${ u.userID}</td>
            </tr>
                </c:forEach>
        </table>
        </td>
      </tr>
    </table></td>
  </tr>
  <tr>  
    <td align="center" valign="middle" bgcolor="#999999">第${pager }页　共${pagercount }页　<a href="javascript:firstpager(1)">首页</a>　 <a href="javascript:firstpager(2)">上一页</a>　<a href="javascript:firstpager(3)">下一页</a>　<a href="javascript:firstpager(4)">尾页</a>
        <input type="text" id="pagernow"   value="${pager }"   style="display: none" >
          <input type="text" id="zuidayem"   value="${pagercount }"   style="display: none" >
 </td> 
  </tr>
</table>
<!-- 增删查改 -->
<div id="tb" style="position:absolute; float: left; margin:5px 10px 0 0">
	<div>
		&nbsp;<a href="javascript:open()"><img width="20" height="20" src="images/edit_add.png"></img></a>
		&nbsp;<a href="javascript:update()"><img   width="20" height="20"  src="images/pencil.png"></img></a>
		&nbsp;<a href="javascript:deletebook(this)"><img  width="20" height="20" src="images/cut.png"></img></a>
	</div>
	<div>
		&nbsp;用户名：&nbsp;<input type="text"   id="selectname"  size="20"/>
		<a href="javascript:selectbook()"><img  width="15" height="15"  src="images/search.png"></img></a>
	</div>
</div>


<!-- 新增 和修改 -->
<div id="dlg" class="" style="position:absolute; margin:100px 100px 110px 230px ; background-color:yellow; width: 730px;height: 450px;
        padding: 10px 20px;display: none">
  <form id="fm"  method="post" enctype="multipart/form-data">
  	<table cellspacing="8px;">
  		<tr>
  			<td>用户名：</td>
  			<td colspan="2"><input class="" id="userName" name="user.userName"  required="true" /></td>
  		 <td>电话：</td>
  			<td colspan="2"><input class="" id="phone" name="user.phone" /></td>
  		 <tr>
  		  <td>新密码：</td>
  			<td colspan="2"><input class="" id="password" name="user.password" type="password" required="true" /></td>
  				<td>邮箱：</td>
  			<td colspan="2"><input class="" id="mail" name="user.mail"  required="true"/></td>
  		</tr>
  		<tr>
  		<td id="biaoliangmima"></td>
  			<td colspan="2"><input class="" id="querenmima" name="querenmima" type="password"  required="true"/></td>
  				<td>性别：</td>
  			<TD class="p2">&nbsp;
  			<select id="sex" name="user.sex">
             <option  value="0">请选择类别</option>
                 <option  value="1" >
                                                         男 
                 </option>
                 <option  value="2" >
                                                       女
                 </option>
             </select>
          </TD>
  		</tr>
  	    <tr>
  			<td>角色类型：</td>
  			<td colspan="2">
            <select id="roleID" name="user.roleID">
             <option  value="0">请选择类别</option>
                <c:forEach items="${role}" var="ro">
                 <option  value="${ro.roleId }" >
                     ${ro.roleName}
                 </option>
               </c:forEach>
             </select>
            </td>
  		</tr>
  		<tr>
  		   <td colspan="6">
             <input style="margin-left: 300px" type="button" onclick="save()" value="保存">
             <input style="margin-left: 300px"  type="button"  value="重置">
  		  </td>
  		</tr>
  		<tr style="display: none">
  			<td >
  			<input class="" id="userID" name="user.userID"  required="true"/>
  			</td>
  		</tr>
  	</table>
  </form>
    	<form  style="display: none">
					 <c:forEach items="${userinfolist}" var="user">
                       <input id="selectroleid" value="${user.roleID }"> 
                     </c:forEach>
                     </form>
</div>
<input  type="hidden"  id="deleteMs" value="${deleteMsg}"  >
  <script type="text/javascript" src="js/datetime.js"></script> 
      <SCRIPT LANGUAGE="JavaScript">  
    var trs = document.getElementById('booktable').getElementsByTagName('tr');  
       window.onload = function(){
        for( var i=0; i<trs.length; i++ ){
         trs[i].onmousedown = function(){  
          tronmousedown(this);  
         };  
        };  
       };  
       function tronmousedown(obj){  
        for( var o=0; o<trs.length; o++ ){  
         if( trs[o] == obj ){  
          trs[o].style.backgroundColor = '#8851d5';  
         }  
         else{  
          trs[o].style.backgroundColor = '';  
         };  
        };  
       };  
    </SCRIPT>  
  </body>
  
</html>

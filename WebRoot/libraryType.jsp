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
    
    <title>图书馆类型管理</title> 
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
	  url="<%=path%>/note/addlbtBook.action";
	   document.getElementById("fm").action=url;
	   $("#libraryType").val("");
         $("#libraryTypeId").val("");
	  $("#dlg").css("display","none");
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
	   url="<%=path%>/note/updatelbtBook.action";
	   document.getElementById("fm").action=url;
	    if(id!=null){
	  var tableId = document.getElementById("booktable");
         $("#libraryType").val(tableId.rows[index].cells[1].innerHTML);
         $("#libraryTypeId").val(tableId.rows[index].cells[2].innerHTML);
	  $("#dlg").css("display","none");
	  var aiin = document.getElementById("dlg");
	  if(bool){
	  		  aiin.style.display = 'block';
	  		  bool=false;
	  	  }else{
	  	 /*  id=null; */
	  	   aiin.style.display = 'none';
	  	 /*   $(":checkbox[name=checkboxBtn]").attr("checked", false); */
	  		  bool=true;
	  	  }
	    }else{
	    alert("请选择一行");
	    }
	  	}
	  	var index;
	  	
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
         function xiugai(e){
       	   } 
	   
	   var url;
	   function save(){
	   $("#fm").submit();
	   }
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
	       window.location.href="<%=path%>/note/lbtdelectBook.action?id="+cartItemIdArray;
	        var meg=$("#deleteMs").val();
	  }else{
	  alert("请选择至少一行");
	   }  
	 }
	 var ee;
	 var pager;
	 var pagercount;
	 function firstpager(e){
	   ee=e;
	  pager=$("#pagernow").val();
	  pagercount=$("#zuidayem").val();
	    window.location.href="<%=path%>/note/FirsttypeBook.action?ee="+ee+"&pager="+pager+"&pagercount="+pagercount;
	 }
	  var mohuName;
	 function selectbook(){
	     mohuName= $("#selectname").val();
	      window.location.href="<%=path%>/note/libraryManagerBook.action?mohulbtName="+encodeURIComponent(mohuName);
	 }
	
	 </script>
  </head>
  
<body>
  <!--  table显示数据 -->
<table  align="left" width="680" border="0" cellspacing="2" style="position:relative"cellpadding="0">
  <tr>
    <td align="center" height="50px" bgcolor="#999999">图书类型    <font color="#FF0000">深色的为修改目标</font>    <a style="float: right; width: 200 ;font-size: 20" href="<%=path%>/mess/shouyeNews.html">首页</a> </td>
  </tr>
  <tr>
    <td align="center" bgcolor="#999999"><table width="1250" height="500" bgcolor="#CCCCCC"  border="1" bordercolor="B1BCEC" cellspacing="0" cellpadding="0">
      <tr valign="top">
        <td><table id="booktable" width="1250" height="450" border="0" >
          <tr  height="2px"> <!-- bgcolor="B1BCEC" -->
            <td width="0" align="center" valign="middle" bgcolor="#B1BCEC">选择</td>
            <td width="" align="center" valign="middle" bgcolor="#B1BCEC">图书类型名称</td>
             <td width="" align="center" valign="middle" bgcolor="#B1BCEC">图书类型名称编码</td>
            
            </tr>
            <c:forEach items="${libtype}" var="lib">
          <tr onclick="clicke(this.sectionRowIndex,${lib.libraryTypeID })" onmouseover="checkaaaaa(${lib.libraryTypeID })" height="10px">
          <td align="center"  valign="middle" > <input type="checkbox"  id="sele${lib.libraryTypeID }"  name="checkboxBtn" onclick="xiugai(${lib.libraryTypeID })" value="${lib.libraryTypeID }" style="width: 20;height: 20"> </td>
            <td align="center"  valign="middle" >${ lib.libraryType}</td>
           <td align="center"  valign="middle" >${ lib.libraryTypeID}</td>
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
     <!--  <select name="select" size="1" onchange="window.location = this.options(this.selectedIndex).value">
        <option selected="selected">1</option>
        <option value="借还2.html">2</option>
      </select> -->
页</td>
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
		&nbsp;书本类型名称：&nbsp;<input type="text"   id="selectname"  size="20"/>
		<a href="javascript:selectbook()"><img  width="15" height="15"  src="images/search.png"></img></a>
	</div>
</div>

<!-- 新增 和修改 -->
<div id="dlg" class="" style="position:absolute;margin:150px 100px 160px 500px ; background-color:yellow;
     width:350px; height150px;   display: none">
  <form id="fm"  method="post" >
  	<table cellspacing="8px;">
  		<tr>
  		<td style="width: 150px">图书类型名称：</td>
  	    <td style="width: 150px"><input class="" id="libraryType" name="lbt.libraryType"  required="true" /></td>
  		<tr>
  		<tr>
  		   <td colspan="2">
             <input style="margin-left: 100px" type="button" onclick="save()" value="保存">
             <input style="margin-left: 0px"  type="button"  value="重置">
  		  </td>
  		</tr>
  		<tr style="display: none">
  			<td >
  			<input class="" id="libraryTypeId" name="lbt.libraryTypeId"  required="true"/>
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

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
    
    <title>罚款表</title> 
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
    
	  	  var id=null ;
	  	var index;
	  	 var check;
        function checkaaaaa(e){
         check=document.getElementById("sele"+e).checked;
        }
	function clicke(x,e,event){
	  	var bool=  $("#dlg").css("display");
	  	if(bool){
	  	  $("#dlg").css("display","none");
	  	}
	  	index=x; 
	  	   id=e; 
	  	  if(check){
	  	     document.getElementById("sele"+e).checked=false; 
	    	 check=false;
    	 }else{
	  	  document.getElementById("sele"+e).checked="true"; 
	  	  /*   $(":checkbox[id=sele"+e+"]").attr("checked", true);  */
	  	      check=true;
	  	 };
	  	  xzb=event.clientX;
          yzb=event.clientY;
            $("#test").css("display","block");
	  	  document.getElementById("test").style.margin=yzb; 
          //获取当前所在行数  
        }
	   var url;
	   function save(){
	   $("#fm").submit();
	   }
	 var ee;
	 var pager;
	 var pagercount;
	 function firstpager(e){
	   ee=e;
	  pager=$("#pagernow").val();
	  pagercount=$("#zuidayem").val();
	    window.location.href="<%=path%>/fine/FirstMoney.action?ee="+ee+"&pager="+pager+"&pagercount="+pagercount;
	 }
	   function chaoqifukaun(){
	   var tableId = document.getElementById("booktable");
	     var bool=tableId.rows[index].cells[3].innerHTML;
	     if(bool=="已支付"){
	      alert("不能从复支付");
	     }else{
	     var fineID=tableId.rows[index].cells[8].innerHTML;
	   window.location.href="<%=path%>/fine/chaoqifukaunMoney.action?fineID="+fineID;
	     }
	 }
	  var mohuName;
	 function selectbook(){
	     mohuName= $("#selectname").val();
	      window.location.href="<%=path%>/note/indexBook.action?mohuName="+encodeURIComponent(mohuName);
	 }
      function guanbi(e){
      $("#borrow").css("display","none");
      }
      
	 </script>
  </head>
  
<body>
  <!--  table显示数据 -->
<table  align="left" width="680" border="0" cellspacing="2" style="position:relative"cellpadding="0">
  <tr>
    <td align="center" height="50px" bgcolor="#999999">罚款单表<font color="#FF0000">深色的为修改目标</font>    <a style="float: right; width: 200 ;font-size: 20" href="<%=path%>/mess/shouyeNews.html">首页</a> </td>
  </tr>
  <tr>
    <td align="center" bgcolor="#999999"><table width="1250" height="500" bgcolor="#CCCCCC"  border="1" bordercolor="B1BCEC" cellspacing="0" cellpadding="0">
      <tr valign="top">
        <td><table id="booktable" width="1250" height="450" border="0" >
          <tr  height="2px"> <!-- bgcolor="B1BCEC" -->
            <td width="0" align="center" valign="middle" bgcolor="#B1BCEC">选择</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">超期费用</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">支付否</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">罚款类型</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">借阅人</td>
            <td width="129.5" align="center" valign="middle" bgcolor="#B1BCEC">借书卡号</td>
            <td width="69.5" align="center" valign="middle" bgcolor="#B1BCEC">邮箱</td>
            <td width="69.5" align="center" valign="middle" bgcolor="#B1BCEC">电话</td>
            </tr>
            <c:forEach items="${fine}" var="b">
          <tr onclick="clicke(this.sectionRowIndex,${b.fineID },event)" onmouseover="checkaaaaa(${b.fineID })" height="10px">
          <td align="center"  valign="middle" > <input type="checkbox"  id="sele${b.fineID }"  name="checkboxBtn"  value="${b.fineID }" style="width: 20;height: 20"> </td>
            <td align="center" valign="middle" >${ b.forfeit}</td>
            
               <c:if test="${b.payment==true}">
            <td align="center" valign="middle" >已支付</td>
              </c:if>
               <c:if test="${ b.payment==false}">
              <td align="center" valign="middle" >未支付</td>
              </c:if>
              
            <td align="center" valign="middle" >${ b.fineTypeName}</td>
            <td align="center" valign="middle" >${ b.userName}</td>
            <td align="center" valign="middle" >${ b.libraryCard}</td>
            <td align="center" valign="middle" >${ b.mail}</td>
             <td align="center" valign="middle" >${ b.phone}</td> 
             
    <td align="center" style="display: none" valign="middle" bgcolor="#FFFFFF">${ b.fineID}</td>
            <td align="center" style="display: none" valign="middle" bgcolor="#FFFFFF">${ b.userID}</td>
            <td align="center" style="display: none" valign="middle" bgcolor="#FFFFFF">${ b.bookID}</td>
            <td align="center" style="display: none" valign="middle" bgcolor="#FFFFFF">${ b.borrowID}</td>
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
		&nbsp;书本名称：&nbsp;<input type="text"   id="selectname"  size="20"/>
		<a href="javascript:selectbook()"><img  width="15" height="15"  src="images/search.png"></img></a>
	</div>
</div>
<div id="test"style="display:none; position:absolute;width: 100;height: 50;background: green;">
       <a href="javascript:chaoqifukaun()" style="font-size: 20">超期付款</a>
</div>

<!-- 新增 和修改 -->
<div id="dlg" class="" style="position:absolute;margin:100px 100px 110px 230px ; background-color:yellow; width: 730px;height: 450px;
        padding: 10px 20px;display: none">
  <form id="fm"  method="post" enctype="multipart/form-data">
  	<table cellspacing="8px;">
  		<tr>
  			<td>编码：</td>
  			<td colspan="2"><input class="" id="bookOnlyCoding" name="pbook.bookOnlyCoding"  required="true" /></td>
  		  <td>名称：</td>
  			<td colspan="2"><input class="" id="bookName" name="pbook.bookName"  required="true" /></td>
  		<tr>
  			<td>作者：</td>
  			<td colspan="2"><input class="" id="author" name="pbook.author"  required="true"/></td>
  			<td>出版社：</td>
  			<td colspan="2"><input class="" id="publishingCompany" name="pbook.publishingCompany"  required="true"/></td>
  		</tr>
  		<tr>
  			<td>出版时间：</td>
  			<td colspan="2"><input class="sang_Calender" id="publishTime" name="pbook.publishTime" /></td>
  			<td>图书库存：</td>
  			<td colspan="2"><input class="" id="stock" name="pbook.stock"  required="true"/></td>
  		</tr>
  		<tr>
  			<td>图书单价：</td>
  			<td colspan="2"><input class="" id="price" name="pbook.price"  required="true" value="0"/></td>
  			<td>入库时间：</td>
  			<td colspan="2"><input class="sang_Calender" id="buildTime" name="pbook.buildTime"  required="true"/>
  		</tr>
  	    <tr>
  			<td>图书类别：</td>
  			<td colspan="2">
            <select id="libraryTypeID" name="pbook.libraryTypeId"> 
             <option  value="0">请选择类别</option> 
                <c:forEach items="${librarytype}" var="libtype">  
                 <option  value="${libtype.libraryTypeId }"  >  
                     ${libtype.libraryType}  
                 </option>  
               </c:forEach>  
             </select>
            </td>
  			<td>图书页数：</td>
  			<td colspan="2"><input class=""  id="libraryPagination" name="pbook.libraryPagination" /></td>
  		</tr>
  		<tr>
  		<td>图书所在分馆：</td>
  		   <td colspan="2"><select id="libraryID" name="pbook.libraryId">  
  			   <option value="0">请选择管所</option> 
                <c:forEach items="${library}" var="lib">  
                 <option value="${lib.libraryId }">  
                     ${lib.libraryName}  
                 </option>  
               </c:forEach>  
             </select></td>
  		</tr>
  		
  		<tr>
  			<td>图书封面：</td>
  			<td colspan="4"><input id="picture" name="file"  type="file"/></td>
  			<td style="display: none" colspan="4"><input id="ybpicture"   name="pbook.picture" /></td>
  		</tr>
  		
  		<tr>
  			<td colspan="5">
  				<textarea rows="10" cols="50" name="pbook.abstruct" id="abstruct" ></textarea>
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
  			<input class="" id="bookId" name="pbook.bookId"  required="true"/>
  			</td>
  		</tr>
  	</table>
  </form>
  </div>
  <!-- 新增借书 -->
<div id="borrow" class="" style="position:absolute;margin:100px 100px 110px 330px ; background-color:yellow; width: 530px;height: 150px;
        padding: 10px 20px;display: none">
  <form id="bor"  method="post" enctype="multipart/form-data">
  	<table >
  		<tr>
  			<td>借书名：</td>
  			<td colspan="2"><input class="" id="userName" name="user.userName"  /></td>
  		    <td>卡号：</td>
  			<td colspan="2"><input class="" id="libraryCard" name="user.libraryCard"   /></td>
  			</tr>
  		 <tr>
  		   <td colspan="6">
             <input style="margin-left: 200px;margin-top:22" type="button" onclick="saveBorrow()" value="保存">
             <input style="margin-left: 250px;margin-top:-22;float:left;"  type="button"  value="重置">
               <input style="margin-left: 300px;margin-top:-22;float:left;"  type="button" onclick="guanbi(this)"  value="关闭">
  		  </td>
  		</tr>
  		
  		<tr style="display: none">
  			<td >
  			<input class="" id="bookId" name="pbook.bookId"  required="true"/>
  			</td>
  		</tr>
  	</table>
  </form>
 </div>
    	<form  style="display: none">
					 <c:forEach items="${userinfolist}" var="user">
                       <input id="selectroleid" value="${user.roleID }"> 
                     </c:forEach>
        </form>
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

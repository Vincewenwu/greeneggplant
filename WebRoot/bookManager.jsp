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
    
    <title>图书管理</title> 
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
	  url="<%=path%>/note/addBook.action";
	   document.getElementById("fm").action=url;
	   $("#bookOnlyCoding").val("");
         $("#bookName").val("");
         $("#author").val("");
         $("#publishingCompany").val("");
          $("#publishTime").val("");
          $("#stock").val("");
        $("#price").val("");
       /*   $("#picture").val(tableId.rows[index].cells[8].innerHTML);  */
         $("#abstruct").val("");
          $("#libraryPagination").val("");
        $("#buildTime").val("");
        
        $("#libraryTypeId").val("");
          $("#libraryId").val("");
          $("#bookId").val("");
	  $("#dlg").css("display","none");
	   $("#borrow").css("display","none");
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
	    $("#borrow").css("display","none");
	   url="<%=path%>/note/updateBook.action";
	   document.getElementById("fm").action=url;
	    if(id!=null){
	  var tableId = document.getElementById("booktable");
         $("#bookOnlyCoding").val(tableId.rows[index].cells[1].innerHTML);
         $("#bookName").val(tableId.rows[index].cells[2].innerHTML);
         $("#author").val(tableId.rows[index].cells[3].innerHTML);
         $("#publishingCompany").val(tableId.rows[index].cells[4].innerHTML);
          $("#publishTime").val(tableId.rows[index].cells[5].innerHTML);
          $("#stock").val(tableId.rows[index].cells[6].innerHTML); 
        $("#price").val(tableId.rows[index].cells[7].innerHTML); 
       /*   $("#picture").val(tableId.rows[index].cells[8].innerHTML);  */
         $("#abstruct").val(tableId.rows[index].cells[9].innerHTML); 
          $("#libraryPagination").val(tableId.rows[index].cells[10].innerHTML); 
        $("#buildTime").val(tableId.rows[index].cells[11].innerHTML);
       $("#libraryTypeID").val(tableId.rows[index].cells[12].innerHTML);
        $("#libraryID").val(tableId.rows[index].cells[13].innerHTML);
          $("#bookId").val(tableId.rows[index].cells[14].innerHTML);
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
	       window.location.href="<%=path%>/note/delectBook.action?id="+cartItemIdArray;
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
	    window.location.href="<%=path%>/note/FirstBook.action?ee="+ee+"&pager="+pager+"&pagercount="+pagercount;
	 }
	  var mohuName;
	 function selectbook(){
	     mohuName= $("#selectname").val();
	      window.location.href="<%=path%>/note/indexBook.action?mohuName="+encodeURIComponent(mohuName);
	 }
	  var bool=true;
	  function jieyue(){
	  if(id!=null){
	  if(bool){
	   $("#borrow").css("display","block");
	    bool=false;
	  }else{
	   $("#borrow").css("display","none");
	   bool=true;
	    }
	    }else{
          alert("请选择至少一行");
        }
      }
      var selectroleid;
      /*   借书 */
      function saveBorrow(){
       selectroleid=$("#roleID").val();
      document.getElementById("bor").action="<%=path%>/jieshu/borrowguanliyBorrow.action?jbid="+id;
        $("#bor").submit();
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
    <td align="center" height="50px" bgcolor="#999999">图书书本管理 <font color="#FF0000">深色的为修改目标</font>    <a style="float: right; width: 200 ;font-size: 20" href="<%=path%>/mess/shouyeNews.html">首页</a> </td>
  </tr>
  <tr>
    <td align="center" bgcolor="#999999"><table width="1250" height="500" bgcolor="#CCCCCC"  border="1" bordercolor="B1BCEC" cellspacing="0" cellpadding="0">
      <tr valign="top">
        <td><table id="booktable" width="1250" height="450" border="0" >
          <tr  height="2px"> <!-- bgcolor="B1BCEC" -->
            <td width="0" align="center" valign="middle" bgcolor="#B1BCEC">选择</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">图书唯一编码</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">图书名称</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">作者</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">出版社</td>
            <td width="129.5" align="center" valign="middle" bgcolor="#B1BCEC">出版时间</td>
            <td width="69.5" align="center" valign="middle" bgcolor="#B1BCEC">库存</td>
            <td width="69.5" align="center" valign="middle" bgcolor="#B1BCEC">图书单价</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">图片路径</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">内容简介</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">图书页数</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">入库时间</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">所属图书馆</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">图书类别</td>
            </tr>
            <c:forEach items="${book}" var="b">
          <tr onclick="clicke(this.sectionRowIndex,${b.bookID })" onmouseover="checkaaaaa(${b.bookID })" height="10px">
          <td align="center"  valign="middle" > <input type="checkbox"  id="sele${b.bookID }"  name="checkboxBtn" onclick="xiugai(${b.bookID })" value="${b.bookID }" style="width: 20;height: 20"> </td>
            <td align="center"  valign="middle" >${ b.bookOnlyCoding}</td>
            <td align="center" valign="middle" >${ b.bookName}</td>
            <td align="center" valign="middle" >${ b.author}</td>
            <td align="center" valign="middle" >${ b.publishingCompany}</td>
            <td align="center" valign="middle" >${ b.publishTime}</td>
            <td align="center" valign="middle" >${ b.stock}</td>
             <td align="center" valign="middle" >${ b.price}</td> 
            <td align="center" valign="middle" ><img width=90 height=80 src='${pageContext.request.contextPath}/upload/${b.picture }'/></td>
            <td align="center" valign="middle" >${ b.abstruct}</td>
            <td align="center" valign="middle" >${ b.libraryPagination}</td>
            <td align="center" valign="middle" >${ b.buildTime}</td>
   
            <td align="center" style="display: none" valign="middle" bgcolor="#FFFFFF">${ b.libraryTypeID}</td>
            <td align="center" style="display: none" valign="middle" bgcolor="#FFFFFF">${ b.libraryID}</td>
            <td align="center" style="display: none" valign="middle" bgcolor="#FFFFFF">${ b.bookID}</td>
           <td align="center" valign="middle" >${ b.libraryName}</td>
            <td align="center" valign="middle" >${ b.libraryType}</td>
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
		&nbsp;<a href="javascript:jieyue(this)"><img  width="20" height="20" src="images/borrowbook/borrow.png"></img></a>
	</div>
	<div>
		&nbsp;书本名称：&nbsp;<input type="text"   id="selectname"  size="20"/>
		<a href="javascript:selectbook()"><img  width="15" height="15"  src="images/search.png"></img></a>
	</div>
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

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
    
    <title>借书记录表</title> 
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
	  	 var bool=true;
	  	  var id=null ;
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
	     /*还书 */
	 function huanshu(){
	  var tableId = document.getElementById("booktable");
	  var bool=tableId.rows[index].cells[3].innerHTML;
	    if(bool=="代还"){
      var uid=tableId.rows[index].cells[13].innerHTML;
      var bid=tableId.rows[index].cells[14].innerHTML;
      var broid=tableId.rows[index].cells[15].innerHTML;
      var roid=tableId.rows[index].cells[16].innerHTML;
	     window.location.href="<%=path%>/jieshu/huanshuBorrow.action?uid="+uid+"&bid="+bid+"&broid="+broid+"&roid="+roid;
       }else{
         alert("此书已还");
       }
	 }
	/*  报废书本 */
	  function baofei(){
	  var tableId = document.getElementById("booktable");
	  var bool=tableId.rows[index].cells[3].innerHTML;
	    if(bool=="代还"){
      var uid=tableId.rows[index].cells[13].innerHTML;
      var bid=tableId.rows[index].cells[14].innerHTML;
      var broid=tableId.rows[index].cells[15].innerHTML;
      var roid=tableId.rows[index].cells[16].innerHTML;
      var price=tableId.rows[index].cells[12].innerHTML;
	     window.location.href="<%=path%>/jieshu/baofeiBorrow.action?uid="+uid+"&bid="+bid+"&broid="+broid+"&roid="+roid+"&price="+price;
       }else{
         alert("此书已还");
       }
	 }
	 /* 付款 */
	  function chaoqifukaun(){
	   var tableId = document.getElementById("booktable");
	  var broid=tableId.rows[index].cells[15].innerHTML;
	   window.location.href="<%=path%>/jieshu/chaoqifukaunBorrow.action?broid="+broid;
	 }
	/*  续借 */
	   function xujie(){
	   var tableId = document.getElementById("booktable");
	  var broid=tableId.rows[index].cells[15].innerHTML;
	   window.location.href="<%=path%>/jieshu/chaoqifukaunBorrow.action?broid="+broid;
	 }
	/*  发邮 */
	 function fayou(){
	   var tableId = document.getElementById("booktable");
	  var  youxiang=tableId.rows[index].cells[17].innerHTML;
	  var uid=tableId.rows[index].cells[13].innerHTML;
	  var dantitle="你好!"+tableId.rows[index].cells[8].innerHTML+"根据您"+tableId.rows[index].cells[2].innerHTML+"书名为《"+tableId.rows[index].cells[10].innerHTML +"》的借书记录，现在已经到期了，请尽快还书，不然将会以每天0.1毛的超期记录费用进行扣费，谢谢合作";
	  window.location.href="<%=path%>/mess/sendmailMail.action?dantitle="+dantitle+"&youxiang="+encodeURIComponent(youxiang)+"&uid="+uid;
	 }
	 var ee;
	 var pager;
	 var pagercount;
	/*  分页 */
	 function firstpager(e){  
	   ee=e;
	  pager=$("#pagernow").val();
	  pagercount=$("#zuidayem").val();
	    window.location.href="<%=path%>/jieshu/borrowbookBorrow.action?ee="+ee+"&pager="+pager+"&pagercount="+pagercount;
	 }
	  var mohuName;
	/*   查询书本 */
	 function selectbook(){
	     mohuName= $("#selectname").val();
	      window.location.href="<%=path%>/jieshu/borrowcordBorrow.action?mohulbtName="+encodeURIComponent(mohuName);
	 }
	
	
	 </script>
	 
  </head>
  
<body>
  <!--  table显示数据 -->
<table  align="left" width="680" border="0" cellspacing="2" style="position:relative"cellpadding="0">
  <tr>
    <td align="center" height="50px" bgcolor="#999999">借书记录   <font color="#FF0000">深色的为修改目标</font>    <a style="float: right; width: 200 ;font-size: 20" href="<%=path%>/mess/shouyeNews.html">首页</a> </td>
  </tr>
  <tr>
    <td align="center" bgcolor="#999999"><table width="1250" height="500" bgcolor="#CCCCCC"  border="1" bordercolor="B1BCEC" cellspacing="0" cellpadding="0">
      <tr valign="top">
        <td><table id="booktable" width="1250" height="450" border="0" >
          <tr  height="2px"> <!-- bgcolor="B1BCEC" -->
            <td width="0" align="center" valign="middle" bgcolor="#B1BCEC">选择</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">借书卡号</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">借阅时间</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">是否归还</td>
            <td width="120.5" align="center" valign="middle" bgcolor="#B1BCEC">实际归还时间</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">续借次数</td>
            <td width="80" align="center" valign="middle" bgcolor="#B1BCEC">是否超期</td>
            <td width="69.5" align="center" valign="middle" bgcolor="#B1BCEC">借阅状态</td>
            <td width="69.5" align="center" valign="middle" bgcolor="#B1BCEC">借阅人</td>
          
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">是否可借书</td>
              <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">图书名称</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">借阅数量</td>
            <td width="89.5" align="center" valign="middle" bgcolor="#B1BCEC">图书价格</td>
            </tr>
            <c:forEach items="${borrowinfo}" var="b">
          <tr onclick="clicke(this.sectionRowIndex,${b.borrowID },event)" onmouseover="checkaaaaa(${b.borrowID })" height="10px">
          <td align="center"  valign="middle" > <input type="checkbox"  id="sele${b.borrowID }"  name="checkboxBtn"  value="${b.borrowID }" style="width: 20;height: 20"> </td>
                <td align="center" valign="middle" >${b.libraryCard }</td>
            <td align="center"  valign="middle">${ b.borrowDate}</td>
              <c:if test="${b.whetherReturn==false}">
               <td align="center"  valign="middle" style="color: red" >代还</td>
              </c:if>
               <c:if test="${ b.whetherReturn==true}">
               <td align="center" valign="middle"  >已还</td>
              </c:if>
          <%--   <td align="center" valign="middle" >${ b.actualReturnTime}</td> --%>
            
            
             <c:if test="${b.actualReturnTime!=null}">
               <td align="center"  valign="middle" >${b.actualReturnTime }</td>
              </c:if>
               <c:if test="${ b.actualReturnTime==null}">
               <td align="center" valign="middle"  >---------</td>
              </c:if>
              
            <td align="center" valign="middle" >${ b.renewNumber}</td>
             <c:if test="${b.whetherExtended==true}">
            <td align="center" valign="middle" >超期</td>
              </c:if>
               <c:if test="${ b.whetherExtended==false}">
              <td align="center" valign="middle" >未超期</td>
              </c:if>
            
             <c:if test="${b.borrowingStatus==true}">
             <td align="center" valign="middle" >借阅中</td>
              </c:if>
               <c:if test="${ b.borrowingStatus==false}">
               <td align="center" valign="middle" >已还</td>
              </c:if>
          
                <td align="center" valign="middle" >${ b.userName}</td> 
     
               <c:if test="${b.borrow==true}">
             <td align="center" valign="middle" >是</td>
              </c:if>
               <c:if test="${ b.borrow==false}">
               <td align="center" valign="middle" >否</td>
              </c:if>
              
          
            <td align="center" valign="middle" >${ b.bookName}</td>
            <td align="center" valign="middle" >${ b.borrowingAmount}</td>
            <td align="center" valign="middle" >${ b.price}</td>
            
            <td align="center" style="display: none" valign="middle" >${ b.userID}</td>
            <td align="center" style="display: none" valign="middle" >${ b.bookID}</td>
            <td align="center" style="display: none" valign="middle" >${ b.borrowID}</td>
            <td align="center" style="display: none" valign="middle" >${ b.roleID}</td>
            <td align="center" style="display: none" valign="middle" >${ b.mail}</td>
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
			</div>
	<div>
		&nbsp;借阅卡号：&nbsp;<input type="text"   id="selectname"  size="20"/>
		<a href="javascript:selectbook()"><img  width="15" height="15"  src="images/search.png"></img></a>
	</div>
</div>

<div id="test"style="display:none; position:absolute;width: 100;height: 140;background: green;">
      <a href="javascript:huanshu()" style="font-size: 20">还    书</a><br>
      <a href="javascript:baofei()" style="font-size: 20">报   废</a><br>
      <a href="javascript:xujie()" style="font-size: 20">续   借</a><br>
      <a href="javascript:chaoqifukaun()" style="font-size: 20">收   费</a><br>
       <a href="javascript:fayou()" style="font-size: 20">发   邮</a><br>
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

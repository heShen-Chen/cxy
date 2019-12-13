<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 管理中心 - 栏目列表 </title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jquery.autotextarea.js"></script>
</head>
<body>
<div id="dcWrap">
<%@include file="head.jsp"%>
<!-- dcHead 结束 -->
 <%@include file="left.jsp"%>
 <div id="dcMain">
   <!-- 当前位置 -->
<div id="urHere">DouPHP 管理中心<b>></b><strong>栏目列表</strong> </div>   <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3><a href="categoryadd.jsp" class="actionBtn add">添加栏目</a>栏目列表</h3>
   
        <div id="list">
    <form name="action" method="post" action="deleteAllServlet" onsubmit="return delSelectedItems();">
    <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
     <tr>
      <th width="22" align="center"><input name='chkall' type='checkbox' id='chkall' onclick='selectcheckbox(this.form)' value='check'></th>
      <th width="40" align="center">编号</th>
      <th align="left">栏目名称</th>
      
      <th width="80" align="center">操作</th>
     </tr>
        <c:forEach var="item" items="${list}">
            <tr>
                <td align="center"><input type="checkbox" name="checkbox[]" value="${item.id}"/></td>
                <td align="center">${item.id}</td>
                <td><a href="editItemsServlet?id=${item.id}">${item.itemname}</a></td>

                <td align="center">
                    <a href="editItemsServlet?id=${item.id}">编辑</a> | <a href="deleteItemsServlet?id=${item.id}" onclick="return delItems();">删除</a>
                </td>
            </tr>
        </c:forEach>
         </table>
    <div class="action">

     <input name="submit" class="btn" type="submit" value="批量删除" />
    </div>
    </form>
    </div>
    <div class="clear"></div>
   
 </div>
 <div class="clear"></div>
<%@include file="boot.jsp"%><!-- dcFooter 结束 -->
<div class="clear"></div> </div>
 <script type="text/javascript">

     function  delItems() {
         if(confirm("是否删除所选记录")) {
             return true;
         }else {
             return false;
         }
     }
     function delSelectedItems() {
         var  b=false;//默认没有选中
         for (var i=0;i<document.action.elements.length;i++){
             var e =document.action.elements[i];
             if(e.name!='chkall'&&e.disabled!=true&&e.name!='submit'){
                 if(e.checked){
                     b=true;
                     break;
                 }
             }
         }
         if (!b){
             alert("请选择要删除的项目");
             return false
         } else{
             if (confirm("是否删除所选记录")){
                 return true;
             } else{
                 return false;
             }
         }
     }
 </script>
</body>
</html>
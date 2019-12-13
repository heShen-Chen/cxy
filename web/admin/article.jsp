<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DouPHP 管理中心 - 文章列表 </title>
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
<div id="urHere">DouPHP 管理中心<b>></b><strong>文章列表</strong> </div>   <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3><a href="AddArticleIndexServlet" class="actionBtn add">添加文章</a>文章列表</h3>
    <div class="filter">
        <form action="ArticleServlet" method="post">
            <select name="itemid">
                <option value="all">未分类</option>
                <c:forEach items="${listitems}" var="items">
                    <option value="${items.id}"> ${items.itemname}</option>
                </c:forEach>
            </select>
            <input name="title" type="text" class="inpMain" value="" size="20" />
            <input name="submit" class="btnGray" type="submit" value="筛选" />
        </form>
    
    </div>
        <div id="list">
    <form name="action" method="post" action="deleteSelectedArticleServlet" onsubmit="return delSelectedArticle(this.form);">
    <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
     <tr>
      <th width="22" align="center"><input name='chkall' type='checkbox' id='chkall' onclick='selectcheckbox(this.form)' value='check'></th>
      <th width="40" align="center">编号</th>
      <th align="left">文章名称</th>
      <th width="150" align="center">文章分类</th>
      <th width="80" align="center">添加日期</th>
      <th width="80" align="center">操作</th>
     </tr>
        <c:forEach items="${pageBean.list}" var="article" varStatus="varstatus">
            <tr>
                <td align="center"><input type="checkbox" name="checkbox[]" value="${article.id}" /></td>
                <td align="center">${(pageBean.pageNum-1)*pageBean.pageSize+varstatus.count}</td>
                <td><a href="EditArticleServlet?id=${article.id}">${article.title}</a></td>
                <td align="center"><a href="">${article.itemname}</a></td>
                <td align="center">${article.tdate}</td>
                <td align="center">
                    <a href="EditArticleServlet?id=${article.id}">编辑</a> | <a href="deleteArticleServlet?id=${article.id}" onclick="javascript:return delarticleOk();">删除</a>
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
     <c:url var="firstUrl" value="ArticleServlet">
         <c:param name="pageNum" value="1"></c:param>
         <c:param name="itemid" value="${itemid}"></c:param>
         <c:param name="title" value="${title}"></c:param>
     </c:url>
     <div class="pager">总计 ${pageBean.totalRecord} 个记录，共 ${pageBean.totalPage} 页，当前第 ${pageBean.pageNum} 页
         | <a href="${firstUrl}">第一页</a>
         <c:choose>
             <c:when test="${pageBean.pageNum>1}">
                 <c:url var="preUrl" value="ArticleServlet">
                     <c:param name="pageNum" value="${pageBean.pageNum-1}"></c:param>
                     <c:param name="itemid" value="${itemid}"></c:param>
                     <c:param name="title" value="${title}"></c:param>
                 </c:url>
                 <a href="${preUrl}">上一页</a>
             </c:when>
             <c:otherwise>
                 上一页
             </c:otherwise>
         </c:choose>
         <c:choose>
             <c:when test="${pageBean.pageNum<pageBean.totalPage}">
                 <c:url var="nextUrl" value="ArticleServlet">
                     <c:param name="pageNum" value="${pageBean.pageNum+1}"></c:param>
                     <c:param name="itemid" value="${itemid}"></c:param>
                     <c:param name="title" value="${title}"></c:param>
                 </c:url>
                 <a href="${nextUrl}">下一页</a>
             </c:when>
             <c:otherwise>
                 下一页
             </c:otherwise>
         </c:choose>
         <a href="ArticleServlet?pageNum=${pageBean.totalPage}">最末页</a></div>           </div>
 </div>
 <div class="clear"></div>
<%@include file="boot.jsp"%><!-- dcFooter 结束 -->
<div class="clear"></div> </div>
 <script type="text/javascript">
     function  delarticleOk() {
         if(confirm("是否要删除文章")){
             return true;
         }else {
             return false;
         }
         return confirm("是否要删除文章");
     }
     function  delSelectedArticle(form) {
         var  b=false;//默认没有选中
         for (var i = 0; i < document.action.elements.length; i++) {
             var e = document.action.elements[i];
             // alert(e.name+e.checked);
             //如果不是全选表单项，并且能用
             if (e.name != 'chkall' && e.disabled!= true && e.name!='submit'){
                 if(e.checked){
                     b=true;//如果有一个选项被选 中，则把b修改为true
                     break;
                 }
             }
         }
         if(!b){//如果没有选项被选中
             alert("请选择要删除的文章");
             return false;
         }else {

             if(confirm("是否删除所选记录")) {
                 return true;
             }else {
                 return false;
             }
         }
     }
 </script>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DouPHP 管理中心 - 添加文章 </title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jquery.autotextarea.js"></script>
    <script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.all.js"></script>
    <link href="../ueditor/themes/default/css/ueditor.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8" src="../ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
<div id="dcWrap">
<%@include file="head.jsp"%>
<!-- dcHead 结束 --> 
<%@include file="left.jsp"%>
 <div id="dcMain">
   <!-- 当前位置 -->
<div id="urHere">DouPHP 管理中心<b>></b><strong>修改文章</strong> </div>   <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
            <h3><a href="article.jsp" class="actionBtn">文章列表</a>修改文章</h3>
    <form action="EditArticleSubmitServlet" method="post" >
     <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
      <input type="hidden" name="id" value="${article.id}"/>

         <tr>
       <td width="90" align="right">文章名称</td>
       <td>
        <input type="text" name="title" value="${article.title}" size="80" class="inpMain" />
       </td>
      </tr>
      <tr>
       <td align="right">文章分类</td>
       <td>
        <select name="itemid">
         <c:forEach items="${listitems}" var="item">
          <option value="${item.id}" <c:if test="${item.id==article.itemid}">selected</c:if> >${item.itemname}</option>
         </c:forEach>
                          </select>
       </td>
      </tr>
            <tr>
       <td align="right" valign="top">文章描述</td>
       <td>
        <!-- KindEditor -->

        <!-- /KindEditor -->
           <textarea id="editor" name="content" type="text/plain" style="width: 1000px ; height: 500px">
         ${article.content}
        </textarea>
           <script type="text/javascript">
               UE.getEditor('editor');</script>
       </td>
            </tr>
      <tr>
       <td>添加日期</td>
       <td>
        <input type="date" name="tdate" value="${article.tdate}">
       </td>
      </tr>
      <tr>
       <td></td>
       <td>
        <input name="submit" class="btn" type="submit" value="提交" />
       </td>
      </tr>
     </table>
    </form>
 </div>
 </div>
 <div class="clear"></div>
 <%@include file="boot.jsp"%><!-- dcFooter 结束 -->
 <div class="clear"></div> </div>
<script type="text/javascript">

</script>
</body>
</html>
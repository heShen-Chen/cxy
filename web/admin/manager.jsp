<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DouPHP 管理中心 - 网站管理员 </title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
</head>
<body>
<div id="dcWrap">
<%@include file="head.jsp"%>
<!-- dcHead 结束 --> <%@include file="left.jsp"%>
 <div id="dcMain">
   <!-- 当前位置 -->
<div id="urHere">DouPHP 管理中心<b>></b><strong>网站管理员</strong> </div>   <div id="manager" class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
    <h3><a href="manageradd.jsp" class="actionBtn">添加管理员</a>网站管理员</h3>
        <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
     <tr>
      <th width="30" align="center">编号</th>
      <th align="left">管理员名称</th>
      <th align="center">E-mail地址</th>
      <th align="center">添加时间</th>
     
      <th align="center">操作</th>
     </tr>
            <c:forEach items="${userList}" var="item">
                <tr>
                    <td align="center">1</td>
                    <td>${item.username}</td>
                    <td align="center">${item.email}</td>
                    <td align="center">${item.tdate}</td>

                    <td align="center"><a href="editAdminServlet?id=${item.id}">编辑</a> | <a href="deleteAdminServlet?id=${item.id}" onclick="javascript:return delUserOk();">删除</a></td>
                </tr>
            </c:forEach>

         </table>
                       </div>
 </div>
 <div class="clear"></div>

    <script  type="text/javascript">
        function  delUserOk() {
            return confirm("是否要删除该用户?");
        }
    </script>
<%@include file="boot.jsp"%>
    <!-- dcFooter 结束 -->
<div class="clear"></div> </div>
</body>
</html>
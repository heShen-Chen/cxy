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
<!-- dcHead 结束 --> 
<%@include file="left.jsp"%>
 <div id="dcMain">
   <!-- 当前位置 -->
<div id="urHere">DouPHP 管理中心<b>></b><strong>网站管理员</strong> </div>   <div id="manager" class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
    <h3><a href="manager.jsp" class="actionBtn">返回列表</a>网站管理员</h3>
            <form action="EditManagerSubmitServlet" method="post">
     <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
      <tr>
       <td width="100" align="right">管理员名称</td>
       <td>
        <input type="text" name="username" size="40" value="${user.username}" class="inpMain" />
       </td>
      </tr>
      <tr>
       <td width="100" align="right">E-mail地址</td>
       <td>
        <input type="text" name="email" size="40" value="${user

        .email}"  class="inpMain" />
       </td>
      </tr>
      <tr>
       <td align="right">密码</td>
       <td>
        <input type="password" name="password" size="40" value="${user.password}"  class="inpMain" />
       </td>
      </tr>
      <tr>
       <td align="right">确认密码</td>
       <td>
        <input type="password" name="password_confirm"value="${user.password}"  size="40" class="inpMain" />
       </td>
      </tr>
      <tr>
       <td align="right">添加日期</td>
       <td>
        <input type="date" name="tdate" size="40" value="${user.tdate}" class="inpMain" />
       </td>
      </tr>
      <tr>
       <td></td>
       <td>
        <input type="hidden" name="id" value="${user.id}" />
        <input type="submit" name="submit" class="btn" value="提交" />
       </td>
      </tr>
     </table>
    </form>
                   </div>
 </div>
 <div class="clear"></div>
<%@include file="boot.jsp"%><!-- dcFooter 结束 -->
<div class="clear"></div> </div>
</body>
</html>
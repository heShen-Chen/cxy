<%--
  Created by IntelliJ IDEA.
  User: 17710
  Date: 2019/12/2
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="dcHead">
    <div id="head">
        <div class="logo"><a href="index.jsp"><img src="images/dclogo.gif" alt="logo"></a></div>
        <div class="nav">

            <ul class="navRight">
                <li class="M noLeft"><a href="JavaScript:void(0);">您好，${user.username}</a>
                    <div class="drop mUser">
                        <a href="editAdminServlet?id=${user.id}">编辑我的个人资料</a>

                    </div>
                </li>
                <li class="noRight"><a href="LoginOutServlet"
                                       onclick="javascript:return conExit();">退出</a></li>
            </ul>
        </div>
    </div>
</div>

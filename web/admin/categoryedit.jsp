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
<div id="urHere">DouPHP 管理中心<b>></b><strong>修改栏目</strong> </div>   <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3><a href="categoryadd.jsp" class="actionBtn add">添加栏目</a></h3>
   
        <div id="list">
    <form name="action" method="post" action="editItemsSubmitServlet">
    <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
          <tr>
              <input type="hidden" name="id" value="${item.id}">
      <td width="18%">栏目标题</td>
			  <td width="82%" align="left"><input type="text" name="itemname" style="width: 100%; height: 30px;"></input></td>
     
     </tr>
         <tr>
			 <td  colspan="2"><input type="submit" value="提交" style="width: 100px;height: 30px"></input> <input type="reset" value="取消" style="width: 100px;height: 30px"></td>
     </tr>
        
         </table>
    </form>
    </div>
    <div class="clear"></div>
               </div>
 </div>
 <div class="clear"></div>
<%@include file="boot.jsp"%><!-- dcFooter 结束 -->
<div class="clear"></div> </div>
 <script type="text/javascript">
 
 onload = function()
 {
   document.forms['action'].reset();
 }

 function douAction()
 {
     var frm = document.forms['action'];

     frm.elements['new_cat_id'].style.display = frm.elements['action'].value == 'category_move' ? '' : 'none';
 }
 
 </script>
</body>
</html>
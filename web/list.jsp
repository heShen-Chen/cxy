<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <script type="text/css">
        .list ul li[class=currentStyle] a{color: #ff4808;}
        .list ul .currentStyle a {    color: #f7bf01;}
        .currentStyle a{ color: #ff4808;}
        .listR{float: right;overflow: hidden;height: 100%;width: 600px;}
    </script>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <base href="<%=basePath%>">
<meta http-equiv="x-ua-compatible" content="ie=8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>青春聊职</title>

<link href="Css/style.css" rel="stylesheet" type="text/css" />
<!--Announced by Visual SiteBuilder 9-->
<link rel="stylesheet" type="text/css" href="Css/_sitegray_d.css" />
<script language="javascript" src="Scripts/_sitegray.js"></script>
<!-- CustomerNO:77656262657232300201465c -->
<link rel="stylesheet" type="text/css" href="Css/index.vsb.css" />
<script type="text/javascript" src="Scripts/vsbscreen.min.js" id="_vsbscreen" devices="pc|pad"></script>
<script type="text/javascript" src="Scripts/counter.js"></script>

</head>
<body>
<div>
<script language="javascript" src="Scripts/dynclicks.js"></script><SCRIPT>   
function showimagecloseu0()   
{   
    var obju0=document.getElementById("adu0");   
    obju0.style.display = 'none';   
};   
//水平             //上下
var xu0 = 0;yu0 = 0;   
   
var xinu0 = true; yinu0 = true;   
var stepu0 = 1;   
   
var delayu0 = 88;   
 
var obju0=document.getElementById("adu0");
var bdyu0 = document.body;  
    if (document.compatMode && document.compatMode != "BackCompat")
        bdyu0 = document.documentElement;
    else
        bdyu0 = document.body;
function floatADu0()
{
    var bdy_scrollTop = document.body.scrollTop | document.documentElement.scrollTop;
    var Lu0=Tu0=0;   
    var Ru0= bdyu0.clientWidth-obju0.offsetWidth;  
    var Bu0 = bdyu0.clientHeight-obju0.offsetHeight; 
    obju0.style.left = xu0 + bdyu0.scrollLeft+"px";   
    obju0.style.top = yu0 + bdy_scrollTop+"px";   
    xu0 = xu0 + stepu0*(xinu0?1:-1);    
    if(xu0 < Lu0) 
    { 
        xinu0 = true;
        xu0 = Lu0;
    }  
    if(xu0 > Ru0)
    { 
        xinu0 = false; 
        xu0 = Ru0;
    }  
    yu0 = yu0 + stepu0*(yinu0?1:-1);    
    if(yu0 < Tu0) 
    { 
        yinu0 = true; 
        yu0 = Tu0; 
    }
    if(yu0 > Bu0) 
    { 
        yinu0 = false; 
        yu0 = Bu0; 
    }
} 
var itlu0;
if(window.navigator.userAgent.indexOf("MSIE")>=1)
{
    window.attachEvent('onload', adftu0);
}
else
{
    window.addEventListener('load',adftu0, false);
}
function adftu0()
{
    itlu0 = setInterval("floatADu0()", delayu0);   
}
    obju0.onmouseover=function(){clearInterval(itlu0);};   
    obju0.onmouseout=function(){itlu0=setInterval("floatADu0()", delayu0)};      
   
</SCRIPT></div>
<div id="head">
    <div class="logo">
<!-- 网站logo图片地址请在本组件"内容配置-网站logo"处填写 -->
<a href=""><img src="Picture/logo.png" width="411" height="85" border="0" ></a></div>
    <div class="hear_right">
      <div class="flash">    
        
  <img src="Picture/wz_cx.png" width="409" height="38" />  </div>
   </div>
   <div class="clear"></div>
</div>
<!---------导航-----------> 
<div class="menu">
<div class="nav" id="nav">
<ul>
   	<li><a href="">首页</a>
				</li>
	<li><a href="">学校概况</a>
				</li>
	<li><a href="">师资队伍</a>
				</li>
	<li><a href="">教学科研</a>
				</li>
	<li><a href="">招生就业</a>
				</li>
	<li><a href="">党建工作</a>
				</li>
	<li><a href="">学团在线</a>
				</li>
	<li><a href="">合作交流</a>
				</li>
	<li><a href="">图书馆</a>
				</li>
	<li><a href="">信息服务</a>
				</li>
	<li><a href="">校内办公</a>
				</li>
	<li><a href="">信息门户</a>
				</li></ul>
        </div>
</div>

<img id="articlePicture" src="Picture/gimg.jpg" style="display:none">

<script type="text/javascript" src="Scripts/jquery.min.js"></script>
<script type="text/javascript" src="Scripts/script.js"></script>
<script src="Scripts/responsiveslides.min.js"></script>
<script type="text/javascript"> 
//ImgHeight_video();//banner视频高度
Nav('#nav');;//导航
snavWidth();//导航子菜单的宽
ImgHeight()  //焦点图幻灯片切换高度
navMin();  //手机端下拉菜单
Menu('.in_mbtn','.navm');//手机版导航
//图片切换开始
$(function () {
     var str= $("#articlePicture").attr("src").substring(7);
 $("#articlePicture").attr("src",str);
    $("#slider").responsiveSlides({
    auto: true,
    slide:1000,
    pager: true,
    timeout: 4000,
    nav: true,
    speed: 2500,
    // 对应外层div的class : slide_container
    namespace: "slide"
    });
});
</script>
  <script type="text/javascript">
window.onload = function(){
 var SDmodel = new scrollDoor();
   SDmodel.sd(["m01","m02"],["c01","c02"],"sd01","sd02");
   
}
$(document).ready(function(e) {
    // 得到显示的栏目名称
    var stritem=$("#itemname").text();
    // 左侧栏目列表中，找到属性a等于要显示栏目名称的li，把该li的样式设置为currentStyle，其他的同级样式都去掉currentStyle
    $(".list ul li[a='"+stritem+"']").addClass("currentStyle").siblings().removeClass("currentStyle");

});
</script>
<!--代码部分begin-->
<!------中间------>
<div style="height: 650px; width:100% ">
    <%--L--%>
    <div class="list" style="float: left; width: 250px; overflow:hidden; height: 100%; padding-left: 200px; padding-top: 30px">
        <span>您所在的位置：主页></span><span id="itemname">${items.itemname}</span>
        <ul>
            <c:forEach items="${itemlist}" var="item">
                <li  class="${item.itemname}" style="line-height: 50px;height: 50px; width:250px ;border-bottom: 1px solid #f7bf01;">
                    <a  href="FindAllWithPage?itemid=${item.id}">${item.itemname}</a></li>
            </c:forEach>
        </ul>
    </div>
        <%--R--%>
    <div class="listR" style="width: 950px; float: right; ">
        <div style="margin-left: 20px; height: 60px;line-height: 60px;font-size: 30px;border-bottom: 2px solid #444444">${items.itemname}</div>
        <div style="height: 10px;"></div>
        <div style="margin-left: 50px; ">
            <c:forEach var="item" items="${pageBean.list}">
            <ul>
                <li>
                    <div style="height: 30px ;line-height: 30px;background: #888888;"><a href="ContentServlet?id=${item.id}">${item.title}</a><span>${newsitem.tdate}</span></div>
                    <div style="height: 80px; border: 1px solid #888888;"><a href="ContentServlet?id=${item.id}">${fn:substring(item.content,1, 50)}...</div>
                </li>
            </ul>
            </c:forEach>
        </div>
        <div>
            <span><a href="FindAllWithPage?pageNum=1&itemid=${items.id}">第一页</a></span>
            <span>
                        <c:choose>
                            <c:when test="${pageBean.pageNum==1}">
                                上一页
                            </c:when>
                            <c:otherwise>
                                <a href="FindAllWithPage?pageNum=${pageBean.pageNum-1}&itemid=${items.id}"> 上一页</a>
                            </c:otherwise>
                        </c:choose>
                     </span>
            <span>
                        <!--如果已到最后一页，则下一页不能有超链接-->
                        <c:choose>
                            <c:when test="${pageBean.pageNum==pageBean.totalPage}">
                                下一页
                            </c:when>
                            <c:otherwise>
                                  <a href="FindAllWithPage?pageNum=${pageBean.pageNum+1}&itemid=${items.id}">下一页<a></a>
                            </c:otherwise>
                        </c:choose>
                      </span>
            <span>第<input type="text" value="${pageBean.pageNum}" />页/共<a>${pageBean.totalPage }</a>页</span>
            <span><a href="FindAllWithPage?pageNum=${pageBean.totalPage}&itemid=${items.id}">最后一页</a></span>
        </div>
    </div>
</div>
<!------底部------>
<%@include file="foot.jsp"%>
</body>
</html>

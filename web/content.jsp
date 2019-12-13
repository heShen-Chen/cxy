<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <base href="<%=basePath%>">
<meta http-equiv="x-ua-compatible" content="ie=8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>青春聊职</title><META Name="keywords" Content="聊城职业技术学院" />

<link href="Css/style.css" rel="stylesheet" type="text/css" />
<!--Announced by Visual SiteBuilder 9-->
<link rel="stylesheet" type="text/css" href="Css/_sitegray_d.css" />
<script language="javascript" src="Scripts/_sitegray.js"></script>
<!-- CustomerNO:77656262657232300201465c -->
<link rel="stylesheet" type="text/css" href="Css/index.vsb.css" />
<script type="text/javascript" src="Scripts/vsbscreen.min.js" id="_vsbscreen" devices="pc|pad"></script>
<script type="text/javascript" src="Scripts/counter.js"></script>
<script type="text/javascript">_jsq_(1001,'/index.jsp',-1,1454634763)</script>
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
<a href="" ><img src="Picture/logo.png" width="411" height="85" border="0" ></a></div>
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
				</li>
</ul>
        </div>

</div>
<!--banner开始-->
<%--<article id="banner" class="banner">--%>
<%--</article>--%>
<!--banner结束 -->
<img id="articlePicture" src="Picture/gimg.jpg" style="display:none">
<script>_showDynClickBatch(['dynclicks_u8_10207'],[10207],"wbnews", 1446739676)</script>
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
//cover();
tab('#tab01');//校园时讯tab选项卡切换；
tab('#tab02');
var downBegan = 0;
var downEnd = 0;
var downStartFlag = true;
var sWSon = document.documentElement.clientWidth ;
        if(sWSon>900){
            $(document).on("mousewheel DOMMouseScroll", function (e) {
                var delta = (e.originalEvent.wheelDelta && (e.originalEvent.wheelDelta > 0 ? 1 : -1)) ||  // chrome & ie
                            (e.originalEvent.detail && (e.originalEvent.detail > 0 ? -1 : 1));              // firefox
                if (delta > 0) {
                 if($(document).scrollTop()==0){
                            downStartFlag = true;
                            $(".banner").slideDown(300);
                            $('.content').css('margin-top','0');
                            $('.header').removeClass('current')
                            $('.topWrap').show(10);
                            //$(".pageDown").show();
                            //$(".content").slideUp(500);
                        }
                } else if (delta < 0) {
                  if($(".banner").css('display')=='block'&& downStartFlag){
                             downStartFlag = false;
                            downBegan = Date.parse(new Date());
                            $(".banner").slideUp(300);
                            $('.content').css('margin-top','59px')
                            $('.header').addClass('current')
                            $('.topWrap').hide(0);
                            //alert(1)
                            //$(".pageDown").hide();
                            //$(".content").slideDown(200);
                         }
                         if(!downStartFlag){
                             downStartFlag = false;
                            downEnd = Date.parse(new Date());
                            if(downEnd - downBegan <=300){
                                e = e || window.event;  
                            if(e.preventDefault) {  
                            // Firefox  
                              e.preventDefault();  
                              e.stopPropagation();  
                            } else {  
                              // IE  
                              e.cancelBubble=true;  
                              e.returnValue = false;  
                          }  
                          return false;  
                            }
                         }
                }
            });
        }else{
            $(window).unbind ('scroll');
            $('.topWrap').css({display:'none'});
            $('.header').removeClass('current');
        }
var scrollTop = $(document).scrollTop();
if(scrollTop <=200){
    $('.banner').css('display','block')
    }else{
    $('.banner').css('display','none')
    }
</script>

  <script type="text/javascript">
$(function(){
	$("#KinSlideshow").KinSlideshow();
})


function scrollDoor(){
}
scrollDoor.prototype = {
 sd : function(menus,divs,openClass,closeClass){
  var _this = this;
  if(menus.length != divs.length)
  {
   alert("菜单层数量和内容层数量不一样!");
   return false;
  }    
  for(var i = 0 ; i < menus.length ; i++)
  { 
   _this.$(menus[i]).value = i;    
   _this.$(menus[i]).onmousemove= function(){
     
    for(var j = 0 ; j < menus.length ; j++)
    {      
     _this.$(menus[j]).className = closeClass;
     _this.$(divs[j]).style.display = "none";
    }
    _this.$(menus[this.value]).className = openClass; 
    _this.$(divs[this.value]).style.display = "block";    
   }
  }
  },
 $ : function(oid){
  if(typeof(oid) == "string")
  return document.getElementById(oid);
  return oid;
 }
}
window.onload = function(){
 var SDmodel = new scrollDoor();
   SDmodel.sd(["m01","m02"],["c01","c02"],"sd01","sd02");
}
</script>
<!--代码部分begin-->
<!------中间------>
<div id="conter">
   <!--代码滚动-->
   <div class="con_mid">
   <div style="margin:0 auto;width:1200px">
   <div class="con_mid_gd">
   <div id="demo">
    <div id="indemo">
    <div id="demo1">
     </div>
    <div id="demo2"></div>
    </div>
    </div>
    <script>
    <!--
    var speed=15; //数字越大速度越慢
    var tab=document.getElementById("demo");
    var tab1=document.getElementById("demo1");
    var tab2=document.getElementById("demo2");
    tab2.innerHTML=tab1.innerHTML;
    function Marquee(){
    if(tab2.offsetWidth-tab.scrollLeft<=0)
    tab.scrollLeft-=tab1.offsetWidth
    else{
    tab.scrollLeft++;
    }
    }
    var MyMar=setInterval(Marquee,speed);
    tab.onmouseover=function() {clearInterval(MyMar)};
    tab.onmouseout=function() {MyMar=setInterval(Marquee,speed)};
    -->
    </script>
    <!--向右滚动代码结束--> 
   </div></div>
   </div>
   <div class="clear"></div>
   <!--正文-->
  <div class="con_zw">
      <h3>${itemNews.content}</h3>

</div>
<!------底部------>
<%@include file="foot.jsp"%>
</body>
</html>

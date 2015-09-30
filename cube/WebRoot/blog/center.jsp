<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<title>blog</title>
		<link href="<%=path%>/blog/css/bootstrap.css" rel='stylesheet' type='text/css' />
		<link href="<%=path%>/blog/css/style.css" rel="stylesheet" type="text/css" media="all" />
		<link href="<%=path%>/angular/ng-animation.css" rel="stylesheet" type="text/css" media="all" />
		<script src="<%=path%>/angular/angular.min.js"></script>
		<script src="<%=path%>/angular/angular-ui-router.js"></script>
		<script src="<%=path%>/angular/angular-animate.min.js"></script>
		<script src="<%=path%>/jqury/jquery-2.1.4.min.js"></script>
		<script src="<%=path%>/blog/js/app.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	</head>
	<body ng-app="blog">
		<div class="header">
			<div class="container">
				<div class="logo">
					<a href="<%=path%>/blog/center.jsp"><h1>
							我是首页
						</h1>
					</a>
				</div>
				<div class="pages"><!--
					<ul>
						<li>
							<a class="active" href="index.html">undetermined4</a>
						</li>
						<li>
							<a href="3dprinting.html">undetermined3</a>
						</li>

					</ul>
				--></div>
				<div class="navigation">
					<ul>
						<li>
							<a href="contact.html">魔方</a>
						</li>
						<li>
							<a href="contact.html">待定</a>
						</li>
						<li>
							<a ui-sref="about">关于</a>
						</li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<!--首页主体 -->
		<div class="container">
			<div class="header-bottom" >
				<div class="search col-md-1" >
					<input type="text" class="form-control" placeholder="搜索..."/>
				</div>
				<div class="col-md-1">
					<button class="btn btn-default" type="" ui-sref="search">确定</button>
				</div>
				<div class="col-md-5">
					<span >搜索</span>
				</div>
				<div class="clearfix"></div>
    		</div>
		</div>
		<div >
			<div ui-view class="">
				
			</div>
		</div>
			<div class="footer" id="foot">
				<div class="footer-top">
					<div class="container">
						<div class="col-md-3 footer-links">
							<h4>
								Other pages and things
							</h4>
							<a href="#">Design a creative Blog</a>
							<a href="#">Design a iPad Website</a>
							<a href="#">Single Page sales portfolio </a>
							<a href="#">Flat product website in Photoshop</a>
							<a href="#">Design a creative Blog</a>
							<a href="#">Design a iPad Website</a>
							<a href="#">Single Page sales portfolio </a>
							<a href="#">Flat product website</a>
						</div>
						<div class="col-md-3 footer-links span_66">
							<a href="#">Flat product website in Photoshop</a>
							<a href="#">Design a creative Blog</a>
							<a href="#">Design a iPad Website </a>
						</div>
						<div class="col-md-3 footer-links">
							<h4>
								提供素材
							</h4>
							<a href="http://huaban.com/">花瓣</a>
							<a href="http://www.yestone.com/">yestone</a>
							<a href="http://www.5icool.org/">酷站代码</a>
							<a href="#">Flat product website</a>
							<a href="#">Design a creative Blog</a>
						</div>
						<div class="col-md-3 footer-links">
							<h4>
								Other pages and things
							</h4>
							<a href="#">Blaz Robar</a>
							<a href="#">Nick Toranto</a>
							<a href="#">Joisp Kelava</a>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="footer-bottom">
					<div class="container">
						<div class="copyrights">
							<p>
								James © 2015 All rights reserved | Template by
								<a href="">待定</a>
							</p>
						</div>
					</div>
				</div>
			</div>
			<img alt="" src="images/top.png" id="rtt" style="cursor:pointer;">
	</body>
</html>
<script type="text/javascript">
//动态回滚顶部 转自酷站
function myEvent(obj,ev,fn){
	if(obj.attachEvent){
		obj.attachEvent('on'+ev,fn);
	}else{
		obj.addEventListener(ev,fn,false);
	}
}
myEvent(window,'load',function(){
	var oRTT=document.getElementById('rtt');
	var pH=document.documentElement.clientHeight;
	var timer=null;
	var scrollTop;
	window.onscroll=function(){
		scrollTop=document.documentElement.scrollTop||document.body.scrollTop;
		if(scrollTop>=pH){
			oRTT.style.display='block';
		}else{
			oRTT.style.display='none';
		}
		return scrollTop;
	};
	oRTT.onclick=function(){
		clearInterval(timer);
		timer=setInterval(function(){
			var now=scrollTop;
			var speed=(0-now)/10;
			speed=speed>0?Math.ceil(speed):Math.floor(speed);
			if(scrollTop==0){
				clearInterval(timer);
			}
			document.documentElement.scrollTop=scrollTop+speed;
			document.body.scrollTop=scrollTop+speed;
		}, 30);
	}
});
</script>
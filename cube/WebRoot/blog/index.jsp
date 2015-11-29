<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html ng-app>
<head>
<title>blog</title>
	<title>blog</title>
		<link href="css/bootstrap.css" rel='stylesheet'
			type='text/css' />
		<link href="css/style.css" rel="stylesheet"
			type="text/css" media="all" />
		<script src="../angular/angular.min.js"></script>
		<script src="../angular/angular-ui-router.js"></script>
		<script src="../jqury/jquery-2.1.4.min.js"></script>
		<script src="js/app.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<div class="header">
			<div class="container">
				<div class="logo">
					<a href="index.html"><h1>
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
							<a href="contact.html">Advertise</a>
						</li>
						<li>
							<a href="about.html">About Us</a>
						</li>
						<li>
							<a class="active" href="contact.html">Contact Us</a>
						</li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<!--首页主体 -->
		<div  ng-app="blog">
			<div ui-view>
		
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
								Relevant Articles
							</h4>
							<a href="#">Design a creative Blog</a>
							<a href="#">Design a iPad Website</a>
							<a href="#">Single Page sales portfolio </a>
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
	</body>
</html>
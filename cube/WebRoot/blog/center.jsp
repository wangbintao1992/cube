<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<title>blog</title>
		<link href="<%=path%>/blog/css/bootstrap.css" rel='stylesheet'
			type='text/css' />
		<link href="<%=path%>/blog/css/style.css" rel="stylesheet"
			type="text/css" media="all" />
		<script src="<%=path%>/angular/angular.min.js"></script>
		<script src="<%=path%>/angular/angular-ui-router.js"></script>
		<script type="text/javascript" src="<%=path%>/blog/js/app.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	</head>
	<body>
		<div class="container" ng-app="headApp">
			<div ui-view="head"></div>
		</div>
		<div class="container">
			<div class="content">
				<div class="col-md-7 content-left">
					<div class="article">
						<h5 class="head">
							in recent news
						</h5>
						<h6>
							Software
						</h6>
						<a class="title" href="single.html">DeltaMaker â The new kid
							on the block An Elegant 3D Printer and a new wicked ass thing</a>
						<a href="single.html"><img src="images/a1.jpg" alt="" />
						</a>
						<p>
							Products were inspired by Behance's research of especially
							productive teams in the creative industry. Hundreds of
							individuals and teams were interviewed, and Behance chronicled
							the work habits and best practices of creative leaders.
						</p>
						<p>
							The paper products were initially designed by and for the Behance
							team as a way to stay organized. In 2007, at the insistence of
							friends who wanted Action Pads of their own...
						</p>
					</div>
					<div class="article">
						<h6>
							Printers
						</h6>
						<a class="title" href="single.html">Nokia offering customers
							printable STL phone cases for the Lumia 820 and things </a>
						<a href="single.html"><img src="images/a2.jpg" alt="" />
						</a>
						<p>
							This week Nokia announced it is giving away files for printable
							case for itâs new Lumia 820 range. This week Nokia a files for
							printable case for itâs new Lumia 820 range. This week Nokia
							announced it is giving away files for printable case for itâs
							new Lumia 820 range. This week Nokia announced it is giving away
							files for printable case for itâs new Lumia 820 range.
						</p>
					</div>
				</div>
				<div class="col-md-5 content-right">
					<div class="content-right-top" ng-app="articlesList" ng-controller="articlesCtrl">
						<h5 class="head">
							Popular
						</h5>
						<div ng-repeat ="article in data" ng-cloak class="ng-cloak">
							<a href="single.html">
							<div class="editor text-center">
								<h3>
									{{article.title}}
								</h3>
								<p>
									{{article.label}}
								</p>
								<label>
									2 Days Ago
								</label>
								<span></span>
							</div> </a>
						</div>
					</div>
					<div class="editors-pic-grids">
						<h5>
							Editors Pick
						</h5>
						<div class="editors-pic">
							<div class="e-pic">
								<a href="single.html"><img src="images/ep1.jpg" alt="" />
								</a>
							</div>
							<div class="e-pic-info">
								<a href="single.html">MarkerBot Announces the âReplicator
									2xâ For the Experimental</a>
								<span></span>
								<label>
									2 Days Ago
								</label>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="editors-pic">
							<div class="e-pic">
								<a href="single.html"><img src="images/ep2.jpg" alt="" />
								</a>
							</div>
							<div class="e-pic-info">
								<a href="single.html">3D Printed Record â the next
									revolution?</a>
								<span></span>
								<label>
									2 Days Ago
								</label>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="editors-pic">
							<div class="e-pic">
								<a href="single.html"><img src="images/ep3.jpg" alt="" />
								</a>
							</div>
							<div class="e-pic-info">
								<a href="single.html">MarkerBot Announces the âReplicator
									2xâ For the Experimental</a>
								<span></span>
								<label>
									2 Days Ago
								</label>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="editors-pic">
							<div class="e-pic">
								<a href="single.html"><img src="images/ep4.jpg" alt="" />
								</a>
							</div>
							<div class="e-pic-info">
								<a href="single.html">3D Printed Record â the next
									revolution?</a>
								<span></span>
								<label>
									2 Days Ago
								</label>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="features">
					<h5>
						Featured news
					</h5>
					<h2>
						Nokia offering customers printable STL phone cases for the Lumia
						820
					</h2>
				</div>
				<div class="col-md-7 content-left">
					<div class="article">
						<h5 class="head">
							in recent news
						</h5>
						<h6>
							Software
						</h6>
						<a class="title" href="single.html">DeltaMaker – The new kid
							on the block An Elegant 3D Printer and a new wicked ass thing</a>
						<a href="single.html"><img src="images/a1.jpg" alt="" /> </a>
						<p>
							Products were inspired by Behance's research of especially
							productive teams in the creative industry. Hundreds of
							individuals and teams were interviewed, and Behance chronicled
							the work habits and best practices of creative leaders.
						</p>
						<p>
							The paper products were initially designed by and for the Behance
							team as a way to stay organized. In 2007, at the insistence of
							friends who wanted Action Pads of their own...
						</p>
					</div>
				</div>
				<div class="col-md-5 content-right content-right-top">
					<h5 class="head">
						Popular
					</h5>
					<a href="single.html">
						<div class="editor text-center">
							<h3>
								DeltaMaker – The new kid on the block An Elegant 3D Printer
							</h3>
							<p>
								A new cheap ass 3D Printer worth checking out
							</p>
							<label>
								2 Days Ago
							</label>
							<span></span>
						</div> </a>
					<a href="single.html">
						<div class="editor text-center">
							<h3>
								DeltaMaker – The new kid on the block An Elegant 3D Printer
							</h3>
							<p>
								A new cheap ass 3D Printer worth checking out
							</p>
							<label>
								2 Days Ago
							</label>
							<span></span>
						</div> </a>
					<a href="single.html">
						<div class="editor text-center">
							<h3>
								Software Review: Autodesk Inventor Fusion for Mac
							</h3>
							<p>
								3D Printing, 3D Software
							</p>
							<label>
								3 Days Ago
							</label>
							<span></span>
						</div> </a>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
				<div class="footer">
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
							Konstructs © 2015 All rights reserved | Template by
							<a href="http://w3layouts.com"> W3layouts</a>
						</p>
					</div>
				</div>
			</div>
		</div>	
	</body>
		<script type="text/javascript">
			var app = angular.module('articlesList', []);
			app.controller('articlesCtrl', function($scope,$http) {
				$http.get('<%=basePath%>test.html').success(function(repo){
				$scope.data = repo});
			});
		</script>
</html>
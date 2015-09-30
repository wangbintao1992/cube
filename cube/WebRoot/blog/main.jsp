<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--首页主体-->
<div class="container">
	<!-- 主体 -->
	<div class="content">
		<div class="col-md-7 content-left" ng-controller="topCtrl">
			<h5 class="head">
				hot article
			</h5>
			<div ng-repeat="top in data" ng-cloak class="ng-cloak">
				<div class="article" ui-sref="article({id:top.id})">
					<a class="title" href="single.html">{{top.title}}</a>
					<a href="single.html"><img src="images/a1.jpg" alt="" /> </a>
					<p>
						{{top.label}}
					</p>
					<p>
						{{top.summary}}
					</p>
				</div>
			</div>
		</div>
		<div class="col-md-5 content-right">
			<div class="content-right-top" ng-controller="articlesCtrl">
				<h5 class="head">
					top
				</h5>
				<div ng-repeat="article in data" ng-cloak class="ng-cloak">
					<a ui-sref="article({id:article.id})">
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
						<a href="single.html"><img src="images/ep1.jpg" alt="" /> </a>
					</div>
					<div class="e-pic-info">
						<a href="single.html">MarkerBot Announces the aReplicator
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
						<a href="single.html"><img src="images/ep2.jpg" alt="" /> </a>
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
						<a href="single.html"><img src="images/ep3.jpg" alt="" /> </a>
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
						<a href="single.html"><img src="images/ep4.jpg" alt="" /> </a>
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
				about author
			</h5>
			<h2>
				Java
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
				<a class="title" href="single.html">DeltaMaker – The new kid on
					the block An Elegant 3D Printer and a new wicked ass thing</a>
				<a href="single.html"><img src="images/a1.jpg" alt="" /> </a>
				<p>
					Products were inspired by Behance's research of especially
					productive teams in the creative industry. Hundreds of individuals
					and teams were interviewed, and Behance chronicled the work habits
					and best practices of creative leaders.
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
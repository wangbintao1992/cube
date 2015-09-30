	<div class="container">
		<div class="content">
			<div class="single-page" ng-controller="getSingleArticle" ng-model="data">
			<div class="print-main">
				<h3>
					{{data.title}}
				</h3>
				<a href="single.html">
					{{data.summary}}
				</a>
				<p class="sub_head">
					Posted on
				    on {{data.inputTime}}
				</p>
				<img ng-src="{{data.imgPath}}"/>
				<p class="ptext">
					{{data.content}}
				</p>
				{{data.inputTime}}
			</div>
		</div>
			<div class="col-md-7 single-content-left">
				评论待定
			</div>
			<div class="col-md-5 content-right content-right-top">
			<h5 class="head">top</h5>	
				<div ng-controller="articlesCtrl">
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
					<h5>Editors Pick</h5>
					<div class="editors-pic">
						<div class="e-pic">
							<a href="single.html"><img src="images/ep1.jpg" alt="" /></a>
						</div>
						<div class="e-pic-info">
							<a href="single.html">MarkerBot Announces the ‘Replicator 2x’  For the Experimental</a>
							<span></span>
							<label>2 Days Ago</label>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="editors-pic">
						<div class="e-pic">
							<a href="single.html"><img src="images/ep2.jpg" alt="" /></a>
						</div>
						<div class="e-pic-info">
							<a href="single.html">3D Printed Record – the next revolution?</a>
							<span></span>
							<label>2 Days Ago</label>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="editors-pic">
						<div class="e-pic">
							<a href="single.html"><img src="images/ep3.jpg" alt="" /></a>
						</div>
						<div class="e-pic-info">
							<a href="single.html">MarkerBot Announces the ‘Replicator 2x’  For the Experimental</a>
							<span></span>
							<label>2 Days Ago</label>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="editors-pic">
						<div class="e-pic">
							<a href="single.html"><img src="images/ep4.jpg" alt="" /></a>
						</div>
						<div class="e-pic-info">
							<a href="single.html">3D Printed Record – the next revolution?</a>
							<span></span>
							<label>2 Days Ago</label>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>	
			<div class="clearfix"></div>
		</div>
	</div>

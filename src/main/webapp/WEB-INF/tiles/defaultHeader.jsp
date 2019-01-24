<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<meta charset="utf-8" />
		<title>Dashboard - Saral Report Designer</title>

		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->

		<!-- text fonts -->
		<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="assets/js/ace-extra.min.js"></script>

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
		<script src="js/jquery-3.3.1.js"></script>
		<script src="ckeditor/ckeditor.js"></script>
		<script src="js/jquery.popupoverlay.js"></script>
	
		<script src="js/jquery-ui.js"></script>
		<script src="js/jscolor.js"></script>
		<link rel="stylesheet" href="css/jquery-ui.css" />
		<link rel="stylesheet" href="css/dataTables.jqueryui.min.css" />
		
		
		<div id="navbar" class="navbar navbar-default          ace-save-state">
		<div class="navbar-container ace-save-state" id="navbar-container">
			<button type="button" class="navbar-toggle menu-toggler pull-left"
				id="menu-toggler" data-target="#sidebar">
				<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span>

				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>

			<div class="navbar-header pull-left">
				<a href="index.html" class="navbar-brand"> <small> <i
						class="fa fa-leaf"></i> Saral Haryana - Reporting Tool
				</small>
				</a>
			</div>

			<div class="navbar-buttons navbar-header pull-right"
				role="navigation">
				<ul class="nav ace-nav">

					<li class="light-blue dropdown-modal"><a
						data-toggle="dropdown" href="#" class="dropdown-toggle"> <img
							class="nav-user-photo" src="assets/images/avatars/user.jpg"
							alt="Jason's Photo" /> <span class="user-info"> <small>Welcome,</small>
								${user_name}
						</span> <i class="ace-icon fa fa-caret-down"></i>
					</a>

						<ul
							class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li><a href="#"> <i class="ace-icon fa fa-cog"></i>
									Settings
							</a></li>
							<li><a href="#" onclick="roles();"> <i
									class="ace-icon fa fa-user"></i> Roles
							</a></li>

							<li class="divider"></li><c:url value="/logout" var="logoutUrl" />

							<li><a href="${logoutUrl}"><i class="ace-icon fa fa-power-off"></i>
									Logout
							</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<!-- /.navbar-container -->
	</div>
		
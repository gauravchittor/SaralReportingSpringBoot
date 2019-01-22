<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<style>
		table{
	        width: 75%;
	        margin-bottom: 20px;
			border-collapse: collapse;
	    }
	    table, th, td{
	        border: 1px solid #cdcdcd;
	    }
	    table th, table td{
	        padding: 10px;
	        text-align: left;
	    }
	</style>
</head>

<body class="no-skin">
	
	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>

		<div id="sidebar"
			class="sidebar                  responsive                    ace-save-state">
			<script type="text/javascript">
					try{ace.settings.loadState('sidebar')}catch(e){}
				</script>

			<div class="sidebar-shortcuts" id="sidebar-shortcuts">
				<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
					<button class="btn btn-success">
						<i class="ace-icon fa fa-signal"></i>
					</button>

					<button class="btn btn-info">
						<i class="ace-icon fa fa-pencil"></i>
					</button>

					<button class="btn btn-warning">
						<i class="ace-icon fa fa-users"></i>
					</button>

					<button class="btn btn-danger">
						<i class="ace-icon fa fa-cogs"></i>
					</button>
				</div>

				<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
					<span class="btn btn-success"></span> <span class="btn btn-info"></span>

					<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
				</div>
			</div>
			<!-- /.sidebar-shortcuts -->

			<ul class="nav nav-list">
				<li class="active"><a href="index.html"> <i
						class="menu-icon fa fa-tachometer"></i> <span class="menu-text">
							Dashboard </span>
				</a> <b class="arrow"></b></li>

				<li class=""><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-pencil-square-o"></i> <span
						class="menu-text"> Reports </span> <b
						class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>

					<ul class="submenu">
						<li class=""><a href="/DesignReptPage"> <i
								class="menu-icon fa fa-caret-right"></i> Design Reports
						</a> <b class="arrow"></b></li>

						<!-- <li class=""><a href="/fetchReportList"> <i
								class="menu-icon fa fa-caret-right"></i> View Reports
						</a> <b class="arrow"></b></li> -->
						<li class=""><a href="/fetchReportName?sign_no=${sign_no}"> <i
								class="menu-icon fa fa-caret-right"></i> Update Reports
						</a> <b class="arrow"></b></li>
					</ul>
				</li>

				<li class=""><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-pencil-square-o"></i> <span
						class="menu-text">Having Operations </span> <b
						class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>

					<ul class="submenu">
						<!-- 	<li class="">
								<a href="">
									<i class="menu-icon fa fa-caret-right"></i>
									Design Reports
								</a>
								<i class="menu-icon fa fa-caret-right"></i>
								<input type="submit"  class="btn btn-purple no-border" id="desrpt" value="Design Report" />

								<b class="arrow"></b>
							</li> -->
						<li class=""><a href="/havingfunctionslist"> <i
								class="menu-icon fa fa-caret-right"></i> Having Reports
						</a> <b class="arrow"></b></li>

						
					</ul>
				</li>
				
				<li class=""><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-pencil-square-o"></i> <span
						class="menu-text">Report Viewer </span> <b
						class="arrow fa fa-angle-down"></b>
						</a> <b class="arrow"></b>

						<ul class="submenu">
							<li class=""><a href="/fetchReportList?sign_no=${sign_no}"> <i
								class="menu-icon fa fa-caret-right"></i> View Reports
							</a> <b class="arrow"></b></li>
					</ul>
				</li>
				<li class=""><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-desktop"></i> <span class="menu-text">
							UI &amp; Elements </span> <b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>

					<ul class="submenu">
						<li class=""><a href="#" class="dropdown-toggle"> <i
								class="menu-icon fa fa-caret-right"></i> Layouts <b
								class="arrow fa fa-angle-down"></b>
						</a> <b class="arrow"></b>

							<ul class="submenu">
								<li class=""><a href="top-menu.html"> <i
										class="menu-icon fa fa-caret-right"></i> Top Menu
								</a> <b class="arrow"></b></li>

								<li class=""><a href="two-menu-1.html"> <i
										class="menu-icon fa fa-caret-right"></i> Two Menus 1
								</a> <b class="arrow"></b></li>

								<li class=""><a href="two-menu-2.html"> <i
										class="menu-icon fa fa-caret-right"></i> Two Menus 2
								</a> <b class="arrow"></b></li>

								<li class=""><a href="mobile-menu-1.html"> <i
										class="menu-icon fa fa-caret-right"></i> Default Mobile Menu
								</a> <b class="arrow"></b></li>

								<li class=""><a href="mobile-menu-2.html"> <i
										class="menu-icon fa fa-caret-right"></i> Mobile Menu 2
								</a> <b class="arrow"></b></li>

								<li class=""><a href="mobile-menu-3.html"> <i
										class="menu-icon fa fa-caret-right"></i> Mobile Menu 3
								</a> <b class="arrow"></b></li>
							</ul></li>

						<li class=""><a href="typography.html"> <i
								class="menu-icon fa fa-caret-right"></i> Typography
						</a> <b class="arrow"></b></li>

						<li class=""><a href="elements.html"> <i
								class="menu-icon fa fa-caret-right"></i> Elements
						</a> <b class="arrow"></b></li>

						<li class=""><a href="buttons.html"> <i
								class="menu-icon fa fa-caret-right"></i> Buttons &amp; Icons
						</a> <b class="arrow"></b></li>

						<li class=""><a href="content-slider.html"> <i
								class="menu-icon fa fa-caret-right"></i> Content Sliders
						</a> <b class="arrow"></b></li>

						<li class=""><a href="treeview.html"> <i
								class="menu-icon fa fa-caret-right"></i> Treeview
						</a> <b class="arrow"></b></li>

						<li class=""><a href="jquery-ui.html"> <i
								class="menu-icon fa fa-caret-right"></i> jQuery UI
						</a> <b class="arrow"></b></li>

						<li class=""><a href="nestable-list.html"> <i
								class="menu-icon fa fa-caret-right"></i> Nestable Lists
						</a> <b class="arrow"></b></li>

						<li class=""><a href="#" class="dropdown-toggle"> <i
								class="menu-icon fa fa-caret-right"></i> Three Level Menu <b
								class="arrow fa fa-angle-down"></b>
						</a> <b class="arrow"></b>

							<ul class="submenu">
								<li class=""><a href="#"> <i
										class="menu-icon fa fa-leaf green"></i> Item #1
								</a> <b class="arrow"></b></li>

								<li class=""><a href="#" class="dropdown-toggle"> <i
										class="menu-icon fa fa-pencil orange"></i> 4th level <b
										class="arrow fa fa-angle-down"></b>
								</a> <b class="arrow"></b>

									<ul class="submenu">
										<li class=""><a href="#"> <i
												class="menu-icon fa fa-plus purple"></i> Add Product
										</a> <b class="arrow"></b></li>

										<li class=""><a href="#"> <i
												class="menu-icon fa fa-eye pink"></i> View Products
										</a> <b class="arrow"></b></li>
									</ul></li>
							</ul></li>
					</ul></li>

				<li class=""><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-list"></i> <span class="menu-text">
							Tables </span> <b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>

					<ul class="submenu">
						<li class=""><a href="tables.html"> <i
								class="menu-icon fa fa-caret-right"></i> Simple &amp; Dynamic
						</a> <b class="arrow"></b></li>

						<li class=""><a href="jqgrid.html"> <i
								class="menu-icon fa fa-caret-right"></i> jqGrid plugin
						</a> <b class="arrow"></b></li>
					</ul></li>

				<li class=""><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-pencil-square-o"></i> <span
						class="menu-text"> Forms </span> <b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>

					<ul class="submenu">
						<li class=""><a href="form-elements.html"> <i
								class="menu-icon fa fa-caret-right"></i> Form Elements
						</a> <b class="arrow"></b></li>

						<li class=""><a href="form-elements-2.html"> <i
								class="menu-icon fa fa-caret-right"></i> Form Elements 2
						</a> <b class="arrow"></b></li>

						<li class=""><a href="form-wizard.html"> <i
								class="menu-icon fa fa-caret-right"></i> Wizard &amp; Validation
						</a> <b class="arrow"></b></li>

						<li class=""><a href="wysiwyg.html"> <i
								class="menu-icon fa fa-caret-right"></i> Wysiwyg &amp; Markdown
						</a> <b class="arrow"></b></li>

						<li class=""><a href="dropzone.html"> <i
								class="menu-icon fa fa-caret-right"></i> Dropzone File Upload
						</a> <b class="arrow"></b></li>
					</ul></li>

				<li class=""><a href="widgets.html"> <i
						class="menu-icon fa fa-list-alt"></i> <span class="menu-text">
							Widgets </span>
				</a> <b class="arrow"></b></li>

				<li class=""><a href="calendar.html"> <i
						class="menu-icon fa fa-calendar"></i> <span class="menu-text">
							Calendar <span class="badge badge-transparent tooltip-error"
							title="2 Important Events"> <i
								class="ace-icon fa fa-exclamation-triangle red bigger-130"></i>
						</span>
					</span>
				</a> <b class="arrow"></b></li>

				<li class=""><a href="gallery.html"> <i
						class="menu-icon fa fa-picture-o"></i> <span class="menu-text">
							Gallery </span>
				</a> <b class="arrow"></b></li>

				<li class=""><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-tag"></i> <span class="menu-text">
							More Pages </span> <b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>

					<ul class="submenu">
						<li class=""><a href="profile.html"> <i
								class="menu-icon fa fa-caret-right"></i> User Profile
						</a> <b class="arrow"></b></li>

						<li class=""><a href="inbox.html"> <i
								class="menu-icon fa fa-caret-right"></i> Inbox
						</a> <b class="arrow"></b></li>

						<li class=""><a href="pricing.html"> <i
								class="menu-icon fa fa-caret-right"></i> Pricing Tables
						</a> <b class="arrow"></b></li>

						<li class=""><a href="invoice.html"> <i
								class="menu-icon fa fa-caret-right"></i> Invoice
						</a> <b class="arrow"></b></li>

						<li class=""><a href="timeline.html"> <i
								class="menu-icon fa fa-caret-right"></i> Timeline
						</a> <b class="arrow"></b></li>

						<li class=""><a href="search.html"> <i
								class="menu-icon fa fa-caret-right"></i> Search Results
						</a> <b class="arrow"></b></li>

						<li class=""><a href="email.html"> <i
								class="menu-icon fa fa-caret-right"></i> Email Templates
						</a> <b class="arrow"></b></li>

						<li class=""><a href="login.html"> <i
								class="menu-icon fa fa-caret-right"></i> Login &amp; Register
						</a> <b class="arrow"></b></li>
					</ul></li>

				<li class=""><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-file-o"></i> <span class="menu-text">
							Other Pages <span class="badge badge-primary">5</span>
					</span> <b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>

					<ul class="submenu">
						<li class=""><a href="faq.html"> <i
								class="menu-icon fa fa-caret-right"></i> FAQ
						</a> <b class="arrow"></b></li>

						<li class=""><a href="error-404.html"> <i
								class="menu-icon fa fa-caret-right"></i> Error 404
						</a> <b class="arrow"></b></li>

						<li class=""><a href="error-500.html"> <i
								class="menu-icon fa fa-caret-right"></i> Error 500
						</a> <b class="arrow"></b></li>

						<li class=""><a href="grid.html"> <i
								class="menu-icon fa fa-caret-right"></i> Grid
						</a> <b class="arrow"></b></li>

						<li class=""><a href="blank.html"> <i
								class="menu-icon fa fa-caret-right"></i> Blank Page
						</a> <b class="arrow"></b></li>
					</ul></li>
			</ul>
			<!-- /.nav-list -->

			<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
				<i id="sidebar-toggle-icon"
					class="ace-icon fa fa-angle-double-left ace-save-state"
					data-icon1="ace-icon fa fa-angle-double-left"
					data-icon2="ace-icon fa fa-angle-double-right"></i>
			</div>
		</div>

		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
						</li>
						<li class="active">Dashboard</li>
					</ul>
					<!-- /.breadcrumb -->

					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon"> <input type="text"
								placeholder="Search ..." class="nav-search-input"
								id="nav-search-input" autocomplete="off" /> <i
								class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
						</form>
					</div>
					<!-- /.nav-search -->
				</div>

				<div class="page-content">
					<div class="ace-settings-container" id="ace-settings-container">
						<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
							id="ace-settings-btn">
							<i class="ace-icon fa fa-cog bigger-130"></i>
						</div>

						<div class="ace-settings-box clearfix" id="ace-settings-box">
							<div class="pull-left width-50">
								<div class="ace-settings-item">
									<div class="pull-left">
										<select id="skin-colorpicker" class="hide">
											<option data-skin="no-skin" value="#438EB9">#438EB9</option>
											<option data-skin="skin-1" value="#222A2D">#222A2D</option>
											<option data-skin="skin-2" value="#C6487E">#C6487E</option>
											<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
										</select>
									</div>
									<span>&nbsp; Choose Skin</span>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox"
										class="ace ace-checkbox-2 ace-save-state"
										id="ace-settings-navbar" autocomplete="off" /> <label
										class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox"
										class="ace ace-checkbox-2 ace-save-state"
										id="ace-settings-sidebar" autocomplete="off" /> <label
										class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox"
										class="ace ace-checkbox-2 ace-save-state"
										id="ace-settings-breadcrumbs" autocomplete="off" /> <label
										class="lbl" for="ace-settings-breadcrumbs"> Fixed
										Breadcrumbs</label>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2"
										id="ace-settings-rtl" autocomplete="off" /> <label
										class="lbl" for="ace-settings-rtl"> Right To Left
										(rtl)</label>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox"
										class="ace ace-checkbox-2 ace-save-state"
										id="ace-settings-add-container" autocomplete="off" /> <label
										class="lbl" for="ace-settings-add-container"> Inside <b>.container</b>
									</label>
								</div>
							</div>
							<!-- /.pull-left -->

							<div class="pull-left width-50">
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2"
										id="ace-settings-hover" autocomplete="off" /> <label
										class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2"
										id="ace-settings-compact" autocomplete="off" /> <label
										class="lbl" for="ace-settings-compact"> Compact
										Sidebar</label>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2"
										id="ace-settings-highlight" autocomplete="off" /> <label
										class="lbl" for="ace-settings-highlight"> Alt. Active
										Item</label>
								</div>
							</div>
							<!-- /.pull-left -->
						</div>
						<!-- /.ace-settings-box -->
					</div>
					<!-- /.ace-settings-container -->

					<div class="page-header">
						<h1>
							Design Reports
							<!-- 	<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									Design Reports
								</small>  -->
						</h1>
					</div>
					<!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<!-- <div style="width: 80%; float: none; margin: auto;">
								<H3 align="center">Design Report</H3>
							</div>
							 <div class="alert alert-block alert-success">
									<button type="button" class="close" data-dismiss="alert">
										<i class="ace-icon fa fa-times"></i>
									</button>

									<i class="ace-icon fa fa-check green"></i>

									Welcome to
									<strong class="green">
										Saral Haryana
										<small>(v1.0)</small>
									</strong>,
										Report Designer.
								</div> -->

							<div class="hr hr32 hr-dotted"></div>
							<div id="hdndivval">
								<input type="hidden" name="deptid" value=${department_id} id="deptid" />
							</div>

							<div class="container" id="reprt2"
								style="height: 200px; width: 80%; float: none; margin: auto; display: none; background-color: aliceblue;">
							

								<h3>Please select Service below :</h3>
								<select id="selectedRecord" name="selectedRecord"
									style="width: 600px">
									<option value="0">Please Select</option>
								</select> <input type="submit" class="btn btn-purple no-border"
									id="getcol" value="Get Columns" />

							</div>

							<div class="hr hr32 hr-dotted"></div>

							<div class="container" id="selcol" style="display: none;">
								<div class="container " id="collist"
									style="width:350px; float: left;">
									<h4 align="left">Please select Service Attributes below :</h4>
									<div class="container" id="ContentPlaceHolder1_CheckBoxList1"
										style="overflow: scroll; height: 300px; width: 70%; float: left; BACKGROUND-COLOR: aliceblue;">
									</div>
								</div>
								<div class="container " id="applInfoCollist"
									style="width:350px; float: left;">
									<h4 align="left">Please select ApplInfo Columns below:</h4>
									<div class="container" id="ContentPlaceHolder2_CheckBoxList2"
										style="overflow: scroll; height: 300px; width: 70%; float: left; BACKGROUND-COLOR: aliceblue;">
									</div>
								</div>
								<div class="container" id="selcollist"
									style="width: 400px; float: left;">
									<H4 align="left">Selected columns for report</H4>
									<div id="sortable1"
										style="overflow: scroll; height: 150px; width: 80%; float: left; background-color: aliceblue;">
										<ul id="sortable" class="cus-jquery-tabs"
											style="cursor: pointer;">
										</ul>
									</div>
									<div id="sortable5"
										style="overflow: scroll; height: 150px; width: 80%; float: left; background-color: aliceblue;">
										<ul id="sortableB" class="cus-jquery-tabs"
											style="cursor: pointer;">
										</ul>
									</div>
								</div>
							</div>
							<div id="selcol1" style="display: none;">
								<br><br><br>
								<div class="container"
									style="width: 100%; float: none; margin: auto;">
									<H3 align="center">Please fill the required details to
										design report</H3>
									<br /> <br />
									<div id="customReportDesigner"
										style="width: 100%; float: none; margin: auto;">
										<form id="mycustreport" method="post"
											enctype="multipart/form-data">
											<input type="hidden" id="hddnJSONB" name="hddnJSONB" />
											<input type="hidden" id="hddnJSON" name="hddnJSON" /> <input
												type="hidden" id="departmentID" name="departmentID" value="" />
											<input type="hidden" id="serviceID" name="serviceID" value="" />
											<input type="hidden" id="userID" name="userID" value=${user_id} /> 
											<input type="hidden" id="sign_no" name="sign_no" value=${sign_no} /> 
											<input type="hidden" id="selectedColList" name="selectedColList" />
											<!-- <input type="hidden" id="selectedColListB" name="selectedColListB" /> -->
											<input type="hidden" id="whrclsJSON" name="whrclsJSON" />
											<input type="hidden" id="hvngclsJSON" name="hvngclsJSON" />
											<div class="form-group">
												<label class="control-label col-sm-3" for="rpName">Report
													Name:</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="rpName"
														placeholder="Enter Report Name" name="rpName"
														required="required">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-3" for="rpColor">
													Table Color:</label>
												<div class="col-sm-9">
													<input class="jscolor form-control" id="rpColor"
														name="rpColor" value="FFFFFF">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-3" for="tooltip">
													Tool-tip:</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="tooltip"
														placeholder="Enter Tool-tip" name="tooltip">
												</div>
											</div>

											<div class="form-group">
												<label class="control-label col-sm-3" for="bgtext">Report
													Background text:</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="bgtext"
														placeholder="Enter Background text " name="bgtext">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-3" for="rpGrpBy">
													Select Group By:</label>
												<div class="col-sm-9">
													<select  multiple class="form-control" name="rpGrpBy" id="rpGrpBy">
														<option value="0">Please Select</option>
													</select>
												</div>
											</div>
											<input class="form-group" type="hidden" name="grpIdName"
												id="grpIdName" />
											<div class="form-group">
												<label class="control-label col-sm-3" for="rpWhrCondition">WHERE
													Condition :</label>
												<div class="col-sm-3">
													<select class="form-control" name="rpGrpBy2" id="rpGrpBy2">
														<option value="0">Please Select</option>
													</select>
												</div>
												<div class="col-sm-2">
													<select class="form-control" name="rpWhrCondition" id="rpWhrCondition">
														<option value="0">Please Select</option>
													</select>	
												</div>
												<div class="col-sm-2">
													<input type="text" class="form-control" id="rpWhrCondition2"
														placeholder="Enter Condition Value" name="rpWhrCondition2">
												</div>
												<div class="col-sm-1">
													<input type="button" style=""
												class="btn no-border" value="Add More"
												onclick="javascript:AddWhrCondition()" />
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-3" for="rpWhrConditionGridView">Where 
													Condition Grid View:</label>
												<div>
													<table id="rpWhrConditionGridView">
														<thead>
															<tr>
																<th class="col-sm-1"><button class="btn no-border .delete-row" type="button" onclick="javascript:DeleteThisRow()">Delete Row</button></th>
																<th style="display: none;" class="col-sm-1">ColumnId</th>
																<th class="col-sm-4">Column</th>
																<th class="col-sm-2">Condition</th>
																<th class="col-sm-1">Value</th>
															</tr>
														</thead>
														<tbody>
														
														</tbody>
													</table>
												</div>
											</div>
											
											<div class="form-group">
												<label class="control-label col-sm-3" for="rpWhrCondition">Having
													Condition :</label>
													<div class="col-sm-3">
													<select class="form-control" name="rpGrpBy3" id="rpGrpBy3">
														<option value="0">Please Select</option>
													</select>
												</div>
												<div class="col-sm-2">
													<select class="form-control" name="rphvngCondition" id="rphvngCondition">
														<option value="0">Please Select</option>
													</select>
												</div>
												<div class="col-sm-2">
													<input type="text" class="form-control" id="rphvngCondition2"
														placeholder="Enter Condition Value" name="rphvngCondition2">
												</div>
												<div class="col-sm-1">
													<input type="button" style=""
												class="btn no-border" value="Add More"
												onclick="javascript:AddHvngCondition()" />
												</div>
												<!-- <div class="col-sm-9">
													<select class="form-control" name="rphvngCondition" id="rphvngCondition">
														<option value="0">Please Select</option>
													</select>	
												</div> -->
											</div>
											
											<div class="form-group">
												<label class="control-label col-sm-3" for="rpHvngConditionGridView">Having 
													Condition Grid View:</label>
												<div>
													<table id="rpHvngConditionGridView">
														<thead>
															<tr>
																<th class="col-sm-1"><button class="btn no-border .delete-row" type="button" onclick="javascript:DeleteThisHvngRow()">Delete Row</button></th>
																<th style="display: none;" class="col-sm-1">ColumnId</th>
																<th class="col-sm-4">Column</th>
																<th class="col-sm-2">Condition</th>
																<th class="col-sm-1">Value</th>
															</tr>
														</thead>
														<tbody>
														
														</tbody>
													</table>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-3" for="rpHeader">Report
													Header Text:</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="rpHeader"
														placeholder="Enter Report Header Text" name="rpHeader">
												</div>
											</div>

											<script>
													CKEDITOR.replace('rpHeader');
												</script>

											<div class="form-group">
												<label class="control-label col-sm-3" for="rpFooter">
													Report Footer Text:</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="rpFooter"
														placeholder="Enter Report Footer Text" name="rpFooter">
												</div>
											</div>
											<script>
													CKEDITOR.replace('rpFooter');
												</script>
											
											<div class="form-group">
												<input type="submit" style=""
												class="btn btn-purple no-border" value="Save Report Design"
												onclick="javascript:MyJsonFunction()" />
											</div>
											
										</form>
										<div id="customDesign" style="width: 400px;"></div>

									</div>
								</div>
							</div>
							<div id="MarkAggregationAndGrouping"
								class="cus-setting-panel-div" style="display: none;">
								<div class="cus-setting-panel" style="width: 400%; background:">
									Setting Panel <img src="../img/settings-gears.png"
										class="img-responsive cus-setting-gear" /> <a
										style="cursor: pointer;"
										onclick="javascript: ClosePopUpMysettings(this);"> <img
										src="../img/close.png" class="img-responsive cus-close" /></a>
								</div>
								<div class="cus-settingbody" style="width: 100%; padding: 10px;">
									<div id="MarkAggregationAndGrouping_Header"
										style="color: red; font-weight: bold; margin-bottom: 10px;"></div>
									<label for="AggregationCheckbox"> <input
										id="EnableAggregation" type="checkbox" name="vehicle"
										value="AggregationCheckbox" /> Enable Aggregation
									</label><br /> <label for="InputParameterCheckbox"> <input
										id="InputParameter" type="checkbox" name="vehicle"
										value="InputParameterCheckbox" /> Input Parameter
									</label><br /> <label for="OutputParameterCheckbox"> <input
										id="OutputParameter" type="checkbox" name="vehicle"
										value="OutputParameterCheckbox" /> Output Parameter
									</label><br /> <label style="display: none;" for="GroupingCheckbox">
										<input style="display: none;" id="EnableGrouping"
										type="checkbox" name="vehicle" value="GroupingCheckbox" />
										Enable Grouping
									</label><br /> <input type="button" id="btnsetAggregationAndGrouping"
										value="Apply" class="cus-setting-apply"
										onclick="javascript: SaveGRoupingAndAggregation(this);" />
									<div id="MarkAggregationAndGrouping_Status"></div>
								</div>

							</div>
							<br /> <br /> <br /> <br />



							<!-- <div class="hr hr32 hr-dotted"></div> -->
							<div id="JSONTEXT"
								style="color: black; font-size: 20px; text-decoration: double; display: none;"></div>
							<div id="JSONTEXTB"
								style="color: black; font-size: 20px; text-decoration: double; display: none;"></div>


							<!-- PAGE CONTENT ENDS -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- /.main-content -->



		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script src="assets/js/jquery-2.1.4.min.js"></script>

	<!-- <![endif]-->

	<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
	<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="/js/jquery.tabletojson.min.js"></script>
	<script src="/js/underscore-min.js"></script>

	<!-- page specific plugin scripts -->

	<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->
	<script src="assets/js/jquery-ui.custom.min.js"></script>
	<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="assets/js/jquery.easypiechart.min.js"></script>
	<script src="assets/js/jquery.sparkline.index.min.js"></script>
	<!-- 	<!-- <script src="assets/js/jquery.flot.min.js"></script> 
		<script src="assets/js/jquery.flot.pie.min.js"></script>
		<script src="assets/js/jquery.flot.resize.min.js"></script> -->

	<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
	
			//Add row to Where condition grid
			AddWhrCondition = function(){
				var ColumnId = $("#rpGrpBy2").val();				
				var Column = $("#rpGrpBy2 option:selected").text();
	            var Condition = $("#rpWhrCondition").val();
	            var Value = $("#rpWhrCondition2").val();
	            if(ColumnId=="" || Column=="Please Select" || Condition==0){
	            	alert("Please select values from dropdown");
	            	return false;
	            }
	            var markup = "<tr><td><input type='checkbox' name='recordgridwhr' id='recordgridwhr'></td><td style='display:none;'>" + ColumnId + "</td><td>" + Column + "</td><td>" + Condition + "</td><td>" + Value + "</td></tr>";
	            $("#rpWhrConditionGridView tbody").append(markup);
	            
			};
			
	        //add row to having grid
	        AddHvngCondition = function(){
	        	var ColumnId = $("#rpGrpBy3").val();
				var Column = $("#rpGrpBy3 option:selected").text();
	            var Condition = $("#rphvngCondition").val();
	            var Value = $("#rphvngCondition2").val();
	            if(ColumnId=="" || Column=="Please Select" || Condition=="0"){
	            	alert("Please select values from dropdown");
	            	return false;
	            }
	            var markup = "<tr><td><input type='checkbox' name='recordgridHvng' id='recordgridHvng'></td><td style='display:none;'>" + ColumnId + "</td><td>" + Column + "</td><td>" + Condition + "</td><td>" + Value + "</td></tr>";
	            $("#rpHvngConditionGridView tbody").append(markup);
	            
			};
			
			//to remove from Having condition grid
			DeleteThisHvngRow = function(){
	            $("#rpHvngConditionGridView tbody").find('input[name="recordgridHvng"]').each(function(){
	            	if($(this).is(":checked")){
	                    //$(this).parents("tr").remove();
	            		$(this).parent().parent().remove();
	                }
	            });
	        };
			
	        //to remove from where condition grid
			DeleteThisRow = function(){
	            $("#rpWhrConditionGridView tbody").find('input[name="recordgridwhr"]').each(function(){
	            	if($(this).is(":checked")){
	                    //$(this).parents("tr").remove();
	            		$(this).parent().parent().remove();
	                }
	            });
	        };
			
			//Submit function to calculate values
	        MyJsonFunction = function(){
	        	/*  var abc = $("#JSONTEXT").text();
	             $("#selectedColList").val(abc); */	             
	             var abcB = $("#JSONTEXTB").text();
	             var abc = $("#JSONTEXT").text(); 
	             if(abc!="" && abcB!=""){
	             var l1 = abcB.substring(0, abcB.length-1);
	        	 var l2 = abc.substring(1, abc.length);
	        	 var finalObj = l1 + "," + l2;
	             $("#selectedColList").val(finalObj);
	             } else if(abc=="" && abcB!=""){
	            	$("#selectedColList").val(abcB);
	             }  else if(abcB=="" && abc!=""){
	            	$("#selectedColList").val(abc);
	             } 
	             
	             var nvg = $("#rpGrpBy").val();
	             //var nmg = $("#rpGrpBy option:selected").text();
	             var tobesave = nvg;
	             $("#grpIdName").val(tobesave);
	             
	             /* var desc = CKEDITOR.instances['rpckHeader'].getData(); */
	             var desc = CKEDITOR.instances['rpHeader'].getData();
	             $("#rpHeader").val(desc);
	             
	             var desc1 = CKEDITOR.instances['rpFooter'].getData();
	             $("#rpFooter").val(desc1);
	             
	         /*   //to remove first column from table
					$("#rpWhrConditionGridView tr").each(function() {
						$(this).find("td:eq(0)").remove();
						$(this).find("th:eq(0)").remove();
					});
		            
					//to remove first column from table
					$("#rpHvngConditionGridView tr").each(function() {
						$(this).find("td:eq(0)").remove();
						$(this).find("th:eq(0)").remove();
					});
					 */
					 
					//create json of table values
					var table1 = $('#rpWhrConditionGridView').tableToJSON();
					function arrUnique(arr) {
						   	var cleaned = [];
						    table1.forEach(function(itm) {
						        var unique = true;
						        cleaned.forEach(function(itm2) {
						            if (_.isEqual(itm, itm2)) unique = false;
						        });
						        if (unique)  cleaned.push(itm);
						    });
						    return cleaned;
						}
					var uniqueStandards = arrUnique(table1);
					for(var i = 0; i < uniqueStandards.length; i++) {
						delete uniqueStandards[i]['Delete Row'];
					}
					table1 = {"Where": uniqueStandards};//make myrows the parent object
					var tab1 = JSON.stringify(table1);
					$("#whrclsJSON").val(tab1);
					alert(tab1);
					
					//create json of table values
					var table = $('#rpHvngConditionGridView').tableToJSON();
					function arrUniqueB(arr) {
						   	var cleaned = [];
						    table.forEach(function(itm) {
						        var unique = true;
						        cleaned.forEach(function(itm2) {
						            if (_.isEqual(itm, itm2)) unique = false;
						        });
						        if (unique)  cleaned.push(itm);
						    });
						    return cleaned;
						}
					var uniqueStandardsB = arrUniqueB(table);
					for(var i = 0; i < uniqueStandardsB.length; i++) {
						delete uniqueStandardsB[i]['Delete Row'];
					} 	
					table = {"Having": uniqueStandardsB};//make myrows the parent object
					var tab2 = JSON.stringify(table);
					$("#hvngclsJSON").val(tab2);
					alert(tab2);

	        }
    	</script>
	<script type="text/javascript">
		 var addition = [];
		 var additionB = [];
	      var querystring = '';
	      var Declarequerystring = '';
	      var wherequerystring = '';
		$(document).ready(function(){
				
	    		
	    			$.ajax({
	    				type : "get",
	    				url : "/DesignReport",
	    				dataType : 'json',
	    				/* contentType : 'application/json; charset=utf-8', */
	    				data : {
	    					deptid : $('#deptid').val(),
	    					action : "fetchService"
	    				},
	    				contentType : 'application/json',
	    				success : function(responseJson) {
	    					console.log(responseJson);
	    					 $("#reprt2").show();
	    					 var $select = $("#selectedRecord");                         
	    				        $select.find("option").remove();
	    				        $("<option>").val(0).text("Please Select").appendTo($select);		
	    				        $.each(responseJson, function(key, value) {              
	    				            $("<option>").val(key).text(value).appendTo($select); 
	    				        });
	    				}
	    			});
	    		
	    		
	    		$('#getcol').click(function() {
	    			 var sid = $('#selectedRecord').val();
	    			 if(sid=="0" || sid==""){
	    				 alert("Please select Service from drop-down");
	    				 return false;
	    			 }
	    			$.ajax({
	    				type : "post",
	    				url : '/DesignReportCol',
	    				data : {
	    					deptid : $('#deptid').val(),
	    					serviceid: $('#selectedRecord').val(),
	    					action : "fetchColumns"
	    				},
	    				success : function(responseJson1) {
	    					$("#selcol").show();
	    					console.log(responseJson1);
	    					$('#ContentPlaceHolder1_CheckBoxList1').empty();
	    						   $.each(responseJson1, function(key, value) {               
	    				            /*  $('#ContentPlaceHolder1_CheckBoxList1').append('<input name="colmn" type="checkbox" value="'+ key +'"/> '+ value +'<br/>'); */
	    				           $('#ContentPlaceHolder1_CheckBoxList1').append('<input type="checkbox"  name="colmn" value="'+ key +'"/> ' +  '<label for="'+ key +'" >'+value.trim()+'</label>' +'<br/>');
	    				         
	    				        });
	    						   $('#departmentID').val($('#deptid').val());
	    						   $('#serviceID').val($('#selectedRecord').val());
	    							abc();	       
	    				}
	    			});
	    		});
	    		
	    		
	    		//To fetch where conditions #rpWhrCondition
	    		$('#getcol').click(function() {
	    			$.ajax({
	    				type : "post",
	    				url : '/fetchWhereConditions',
	    				data : {},
	    				success : function(responseJsonWhere) {
	    					//$("#selcol").show();
	    					console.log(responseJsonWhere);
	    					//$('#rpWhrCondition').empty();
	    						   $.each(responseJsonWhere, function(key, value) {               
	    				            /*  $('#ContentPlaceHolder1_CheckBoxList1').append('<input name="colmn" type="checkbox" value="'+ key +'"/> '+ value +'<br/>'); */
	    				           //$('#ContentPlaceHolder1_CheckBoxList1').append('<input type="checkbox"  name="colmn" value="'+ key +'"/> ' +  '<label for="'+ key +'" > '+ value.trim() +'</label>' +'<br/>');
	    				           var newOption = $('<option/>');
	    							newOption.text(key);
	    							newOption.attr('value', value);
	    							$('#rpWhrCondition').append(newOption);
	    				        });
	    					//abc();	       
	    				}
	    			});
	    		});
	    		
	    		//To fetch Having conditions #rphvngCondition
	    		$('#getcol').click(function() {
	    			$.ajax({
	    				type : "post",
	    				url : '/fetchHavingConditions',
	    				data : {},
	    				success : function(responseJsonHvng) {
	    					//$("#selcol").show();
	    					console.log(responseJsonHvng);
	    					//$('#rphvngCondition').empty();
	    						   $.each(responseJsonHvng, function(key, value) {               
	    				            /*  $('#ContentPlaceHolder1_CheckBoxList1').append('<input name="colmn" type="checkbox" value="'+ key +'"/> '+ value +'<br/>'); */
	    				           //$('#ContentPlaceHolder1_CheckBoxList1').append('<input type="checkbox"  name="colmn" value="'+ key +'"/> ' +  '<label for="'+ key +'" > '+ value.trim() +'</label>' +'<br/>');
	    				           var newOption = $('<option/>');
	    							newOption.text(key);
	    							newOption.attr('value', value);
	    							$('#rphvngCondition').append(newOption);
	    				        });
	    					//abc();	       
	    				}
	    			});
	    		});
	    		
	    		//To fetch Appl Info Columns #ContentPlaceHolder2_CheckBoxList2applInfoCollist
	    		$('#getcol').click(function() {
	    			$.ajax({
	    				type : "post",
	    				url : '/fetchApplInfoCol',
	    				data : {},
	    				success : function(responseJsonAppInfoCol) {
	    					$("#selcol1").show();
	    					console.log(responseJsonAppInfoCol);
	    					$('#ContentPlaceHolder2_CheckBoxList2').empty();
	    						   $.each(responseJsonAppInfoCol, function(key, value) {               
	    				              //	$('#ContentPlaceHolder2_CheckBoxList2').append('<input name="colmn" type="checkbox" value="'+ key +'"/> '+ value +'<br/>');
	    				           		$('#ContentPlaceHolder2_CheckBoxList2').append('<input type="checkbox"  name="colmn" value="'+ key +'"/> ' +  '<label for="'+ key +'" >'+value.trim() +'</label>' +'<br/>');
			    				          /*  var newOption = $('<option/>');
			    							newOption.text(key);
			    							newOption.attr('value', value);
			    							$('#rphvngCondition').append(newOption); */
	    				        });
	    					initColJs();	       
	    				}
	    			});
	    		});
	    		
	    		
	  		   $('#mycustreport').submit(function (e){
		 			 e.preventDefault();
		            $.ajax({
		                type: "post",
		                url: "/SaveReport",
		                data: $(this).serialize(),
						success:function(result){
							console.log("My ajax 1");
							console.log(result);
							 $('#customDesign').text(result);
							 console.log("My ajax");
							 e.preventDefault();
						}
		            });
		        });
	    		
	    		var url = document.URL;
	    		function abc(){
	    			$('#ContentPlaceHolder1_CheckBoxList1').find('input[type="checkbox"]').on('change', function () {
	    			
	          		  if ($(this).prop("checked") == true) {
	                var number = $(this).next('label').text();
	                var index = addition.map(function (e) { return e.key; }).indexOf(number); // check if exists in array
	                if (index !== -1) {
	                    var numberTobeusedRandomly = 1;
	                    var next_suggested_Name = $(this).next('label').text() + "_" + numberTobeusedRandomly;
	                    while (addition.map(function (e) { return e.key; }).indexOf(next_suggested_Name) !== -1) {
	                        numberTobeusedRandomly = numberTobeusedRandomly + 1;
	                        next_suggested_Name = $(this).next('label').text() + "_" + numberTobeusedRandomly;
	                    }
	                    //
	                    var AnotherFieldName = prompt('"' + $(this).next('label').text() + '"' + " field is already taken !! Kindly enter another Name for this field.", next_suggested_Name);
	                    if (AnotherFieldName != null) {
	                        //addition[AnotherFieldName] = $(this).val();
	                        if (addition.map(function (e) { return e.key; }).indexOf(AnotherFieldName) !== -1) {
	                            $(this).prop("checked", false);
	                            $(this).next('label').css('color', 'black');
	                            alert('Choose another field name !!');
	                        }
	                        else {
	                            $(this).next('label').text(AnotherFieldName);
	                            $(this).next('label').css('color', 'red');
	                            AppendToSortable('ul#sortable', '<li InputParameter="0" OutputParameter="0" isactive="0" aggregation="0" grouping="0" ondblclick="javascript:CheckAggregationandGrouping(this);" key="' + $(this).next('label').text() + '" value="' + $(this).val() + '" class="ui-state-default tagme ui-sortable-handle ui-draggable ui-draggable-handle"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>' + $(this).next('label').text() + '<span a="a" class="cus-li-label disable-label">A</span><span In="In" class="cus-li-label disable-label">I</span><span Ou="Ou" class="cus-li-label disable-label">O</span><span style="display:none;"  g="g" class="cus-li-label disable-label">G</span></li>', $(this).next('label').text(), $(this).val());

	                        }
	                    }
	                    else {
	                        $(this).prop("checked", false);
	                        $(this).next('label').css('color', 'black');
	                    }
	                }
	                else {

	                    $(this).next('label').css('color', 'blue');
	                    //add item to tag system
	                    AppendToSortable('ul#sortable', '<li isactive="0" InputParameter="0" OutputParameter="0" aggregation="0" grouping="0" ondblclick="javascript:CheckAggregationandGrouping(this);" key="' + $(this).next('label').text() + '" value="' + $(this).val() + '" class="ui-state-default tagme ui-sortable-handle ui-draggable ui-draggable-handle"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>' + $(this).next('label').text() + '<span a="a" class="cus-li-label disable-label">A</span><span In="In" class="cus-li-label disable-label">I</span><span Ou="Ou" class="cus-li-label disable-label">O</span><span style="display:none;"  g="g" class="cus-li-label disable-label">G</span></li>', $(this).next('label').text(), $(this).val());
	                }
	            }
	            else {
	                //debugger;
	                //delete addition[$(this).next('label').text()];
	                $(this).next('label').css('color', 'black');
	                DeleteFromSortable($(this).val(), $(this).next('label').text());
	            }

	            $('#ContentPlaceHolder1_dsfkjsfbsdfjbsfskdjfbsdkbfsdjbfsjkbfkjbkfjbkjsbfsdkjbfjkdsfsjhbfdkuyhvfeuhkhvdvkjhbfkjhbjhbdfkuyufdjbhjhbfdvkjkjbhvfdjbvfjbjbjbxcxvvdfjhbhb').val(JSON.stringify(addition));
	            $('#JSONTEXT').html(JSON.stringify(addition));
	            /* var abc = $("#JSONTEXT").text(); */
	            $("#hddnJSON").val(JSON.stringify(addition));
	            initSelBox_Product();
	            //alert(text);
	        	});
	    		}
	    		
	    		
	    		function initColJs(){
	    			$('#ContentPlaceHolder2_CheckBoxList2').find('input[type="checkbox"]').on('change', function () {
	    			
	          		  if ($(this).prop("checked") == true) {
	                var number = $(this).next('label').text();
	                var index = additionB.map(function (e) { return e.key; }).indexOf(number); // check if exists in array
	                if (index !== -1) {
	                    var numberTobeusedRandomly = 1;
	                    var next_suggested_Name = $(this).next('label').text() + "_" + numberTobeusedRandomly;
	                    while (additionB.map(function (e) { return e.key; }).indexOf(next_suggested_Name) !== -1) {
	                        numberTobeusedRandomly = numberTobeusedRandomly + 1;
	                        next_suggested_Name = $(this).next('label').text() + "_" + numberTobeusedRandomly;
	                    }
	                    //
	                    var AnotherFieldName = prompt('"' + $(this).next('label').text() + '"' + " field is already taken !! Kindly enter another Name for this field.", next_suggested_Name);
	                    if (AnotherFieldName != null) {
	                        //addition[AnotherFieldName] = $(this).val();
	                        if (additionB.map(function (e) { return e.key; }).indexOf(AnotherFieldName) !== -1) {
	                            $(this).prop("checked", false);
	                            $(this).next('label').css('color', 'black');
	                            alert('Choose another field name !!');
	                        }
	                        else {
	                            $(this).next('label').text(AnotherFieldName);
	                            $(this).next('label').css('color', 'red');
	                            AppendToSortableB('ul#sortableB', '<li InputParameter="0" OutputParameter="0" isactive="0" aggregation="0" grouping="0" key="' + $(this).next('label').text() + '" value="' + $(this).val() + '" class="ui-state-default tagme ui-sortable-handle ui-draggable ui-draggable-handle"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>' + $(this).next('label').text() + '<span a="a" class="cus-li-label disable-label">A</span><span In="In" class="cus-li-label disable-label">I</span><span Ou="Ou" class="cus-li-label disable-label">O</span><span style="display:none;"  g="g" class="cus-li-label disable-label">G</span></li>', $(this).next('label').text(), $(this).val());

	                        }
	                    }
	                    else {
	                        $(this).prop("checked", false);
	                        $(this).next('label').css('color', 'black');
	                    }
	                }
	                else {

	                    $(this).next('label').css('color', 'blue');
	                    //add item to tag system
	                    AppendToSortableB('ul#sortableB', '<li isactive="0" InputParameter="0" OutputParameter="0" aggregation="0" grouping="0" key="' + $(this).next('label').text() + '" value="' + $(this).val() + '" class="ui-state-default tagme ui-sortable-handle ui-draggable ui-draggable-handle"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>' + $(this).next('label').text() + '<span a="a" class="cus-li-label disable-label">A</span><span In="In" class="cus-li-label disable-label">I</span><span Ou="Ou" class="cus-li-label disable-label">O</span><span style="display:none;"  g="g" class="cus-li-label disable-label">G</span></li>', $(this).next('label').text(), $(this).val());
	                }
	            }
	            else {
	                //debugger;
	                //delete addition[$(this).next('label').text()];
	                $(this).next('label').css('color', 'black');
	                DeleteFromSortableB($(this).val(), $(this).next('label').text());
	            }

	            //$('#ContentPlaceHolder1_dsfkjsfbsdfjbsfskdjfbsdkbfsdjbfsjkbfkjbkfjbkjsbfsdkjbfjkdsfsjhbfdkuyhvfeuhkhvdvkjhbfkjhbjhbdfkuyufdjbhjhbfdvkjkjbhvfdjbvfjbjbjbxcxvvdfjhbhb').val(JSON.stringify(additionB));
	            $('#JSONTEXTB').html(JSON.stringify(additionB));
	            /* var abc = $("#JSONTEXT").text(); */
	            $("#hddnJSONB").val(JSON.stringify(additionB));
	            initSelBox_Product();
	            //alert(text);
	        	});
	    		}
			});
		
		
		//append selected columns in dropdown list
	     function initSelBox_Product() {
			
			try{
		    	var titelliste= $("#hddnJSON").val();
		    	if(titelliste!=""){
		    		var a = JSON.parse(titelliste);
		    	}		    	
		    	var titellisteB = $("#hddnJSONB").val();
		    	if(titellisteB!=""){
		    		var b = JSON.parse(titellisteB);
		    	}
		    	if(titelliste!="" && titellisteB!=""){
		    		var o = b.concat(a);
		    	}else if(titelliste!="" && titellisteB==""){
		    		var o = a;
		    	}else if(titelliste=="" && titellisteB!=""){
		    		var o = b;
		    	}
		    	console.log(o);
		    	$('#rpGrpBy, #rpGrpBy2, #rpGrpBy3').empty();
		    	//$('#rpGrpBy2').empty();
		    	var newOption1 = $('<option/>');
				newOption1.text("Please Select");
				newOption1.attr('value', "0");
				$('#rpGrpBy2, #rpGrpBy3').append(newOption1);
	 
				var length = (o.length);
				for(var j = 0; j < length; j++)
					{
						var newOption = $('<option/>');
						newOption.text(o[j].key);
						newOption.attr('value', o[j].Value);
						$('#rpGrpBy, #rpGrpBy2, #rpGrpBy3').append(newOption);
						//$('#rpGrpBy2').append(newOption);
					}
			} catch(err){
				console.log(err);
			}
	    	/* var o = JSON.parse(titelliste); */
	    	
		}
		
			
		
		
	//append to sortable list
	function AppendToSortable(element, item, key, value) {
	    $(element).append(item);
	    var addition_Property = {};
	    addition_Property['key'] = key;
	    addition_Property['Value'] = value;
	    addition_Property['Ag'] = "0";
	    addition_Property['Gr'] = "0";
	    addition_Property['In'] = "0";
	    addition_Property['Ou'] = "0";
	    addition.push(addition_Property);
	    //

	    $("#sortable").sortable({
	        change: function (event, ui) {
	            // alert($(ui.item).attr('key'));
	            // alert($(ui.item).attr('value'));
	            // drop and rebuild addition array again as per new alignment

	        },
	        stop: function (event, ui) {
	            checkifeventofdragisAlive = '1';
	            addition = [];
	            $(this).parent().find('li').each(function (index, item) {
	                var addition_Property = {};
	                addition_Property['key'] = $(this).attr('key');
	                addition_Property['Value'] = $(this).attr('value');
	                addition_Property['Ag'] = $(this).attr('aggregation');
	                addition_Property['Gr'] = $(this).attr('grouping');
	                addition_Property['In'] = $(this).attr('InputParameter');
	                addition_Property['Ou'] = $(this).attr('OutputParameter');
	                addition.push(addition_Property);
	            });
	            $('#ContentPlaceHolder1_dsfkjsfbsdfjbsfskdjfbsdkbfsdjbfsjkbfkjbkfjbkjsbfsdkjbfjkdsfsjhbfdkuyhvfeuhkhvdvkjhbfkjhbjhbdfkuyufdjbhjhbfdvkjkjbhvfdjbvfjbjbjbxcxvvdfjhbhb').val(JSON.stringify(addition));
	            $('#JSONTEXT').html(JSON.stringify(addition));
	            event.stopPropagation();
	            event.stopImmediatePropagation();
	            checkifeventofdragisAlive = '0';
	        }
	    });
	}

	
	//To append in sortable for initjson
	function AppendToSortableB(element, item, key, value) {
	    $(element).append(item);
	    var additionB_Property = {};
	    additionB_Property['key'] = key;
	    additionB_Property['Value'] = value;
	    additionB_Property['Ag'] = "0";
	    additionB_Property['Gr'] = "0";
	    additionB_Property['In'] = "0";
	    additionB_Property['Ou'] = "0";
	    additionB.push(additionB_Property);
	    //

	    $("#sortableB").sortable({
	        change: function (event, ui) {
	            // alert($(ui.item).attr('key'));
	            // alert($(ui.item).attr('value'));
	            // drop and rebuild addition array again as per new alignment

	        },
	        stop: function (event, ui) {
	            checkifeventofdragisAlive = '1';
	            additionB = [];
	            $(this).parent().find('li').each(function (index, item) {
	                var additionB_Property = {};
	                additionB_Property['key'] = $(this).attr('key');
	                additionB_Property['Value'] = $(this).attr('value');
	                additionB_Property['Ag'] = $(this).attr('aggregation');
	                additionB_Property['Gr'] = $(this).attr('grouping');
	                additionB_Property['In'] = $(this).attr('InputParameter');
	                additionB_Property['Ou'] = $(this).attr('OutputParameter');
	                additionB.push(additionB_Property);
	            });
	            //$('#ContentPlaceHolder1_dsfkjsfbsdfjbsfskdjfbsdkbfsdjbfsjkbfkjbkfjbkjsbfsdkjbfjkdsfsjhbfdkuyhvfeuhkhvdvkjhbfkjhbjhbdfkuyufdjbhjhbfdvkjkjbhvfdjbvfjbjbjbxcxvvdfjhbhb').val(JSON.stringify(additionB));
	            $('#JSONTEXTB').html(JSON.stringify(additionB));
	            event.stopPropagation();
	            event.stopImmediatePropagation();
	            checkifeventofdragisAlive = '0';
	        }
	    });
	}
	
	
	//code for Aggregation and Grouping
			var checkifeventofdragisAlive = '0';
	        function CheckAggregationandGrouping(element) {
	            if (checkifeventofdragisAlive == '0') {
	                $('span.loading_Personal').html('');
	                $('ul#sortable').find('li').attr('isactive', '0');
	                $(element).attr('isactive', '1');
	                $('#EnableGrouping').prop('checked', $(element).attr('grouping') == '1' ? true : false); // set filled value
	                $('#EnableAggregation').prop('checked', $(element).attr('aggregation') == '1' ? true : false);
	                $('#OutputParameter').prop('checked', $(element).attr('OutputParameter') == '1' ? true : false);
	                $('#InputParameter').prop('checked', $(element).attr('InputParameter') == '1' ? true : false);
	                $('#MarkAggregationAndGrouping_Status').html('');
	                $('#MarkAggregationAndGrouping_Header').html('');
	                $('#MarkAggregationAndGrouping_Header').html($(element).attr('key'));
	                $('#loadingwholepage').show();
	                $(element).css('z-index', '999999');
	                var destination = $(element).offset();
	                $('#MarkAggregationAndGrouping').css({ top: destination.top - ($('#MarkAggregationAndGrouping').height()), left: destination.left });
	                $('#MarkAggregationAndGrouping').show(800);
	            }
	        };
		
		//code to remove selected item from list
        function DeleteFromSortable(value, key) {

            var index = addition.map(function (e) { return e.key; }).indexOf(key);
            if (index !== -1) addition.splice(index, 1);
            var elementToRemove = 'ul#sortable > li[key="' + key + '"][value="' + value + '"]';
            $(elementToRemove).remove();
        }
		
		//code to remove selected item from Init list
        function DeleteFromSortableB(value, key) {

            var index = additionB.map(function (e) { return e.key; }).indexOf(key);  
            if (index !== -1) additionB.splice(index, 1);
            var elementToRemove = 'ul#sortableB > li[key="' + key + '"][value="' + value + '"]';
            $(elementToRemove).remove();
        }
	
        function ClosePopUpMysettings(element) {
            $('#loadingwholepage').hide(1000);
            $('#MarkAggregationAndGrouping').hide(200);
            $('#MarkAggregationAndGrouping_Header').html('');
            $('#EnableGrouping').prop('checked', false);
            $('#EnableAggregation').prop('checked', false);
            $('span.loading_Personal').html('');
        }
        function SaveGRoupingAndAggregation(element) {
            $('span.loading_Personal').html('Saving....');
            $('#MarkAggregationAndGrouping_Status').html('Saving....');
            $('#loadingwholepage').hide(1000);
            //if (index !== -1) addition.splice(index, 1);
            //debugger;
            var index = addition.map(function (e) { return e.key; }).indexOf($('ul#sortable').find('li[isactive="1"]').attr('key'));
            if ($('#EnableGrouping').prop("checked") == true) {
                $('ul#sortable').find('li[isactive="1"]').attr('grouping', '1');
                addition[index].Gr = "1";
                $('ul#sortable').find('li[isactive="1"]').find('span[g="g"]').removeClass('disable-label').addClass('enable-label');
            }
            else {
                $('ul#sortable').find('li[isactive="1"]').attr('grouping', '0');
                addition[index].Gr = "0";
                $('ul#sortable').find('li[isactive="1"]').find('span[g="g"]').removeClass('enable-label').addClass('disable-label');
            }
            if ($('#EnableAggregation').prop("checked") == true) {
                $('ul#sortable').find('li[isactive="1"]').attr('aggregation', '1');
                addition[index].Ag = "1";
                $('ul#sortable').find('li[isactive="1"]').find('span[a="a"]').removeClass('disable-label').addClass('enable-label');
            }
            else {
                $('ul#sortable').find('li[isactive="1"]').attr('aggregation', '0');
                addition[index].Ag = "0";
                $('ul#sortable').find('li[isactive="1"]').find('span[a="a"]').removeClass('enable-label').addClass('disable-label');
            }

            //input and output
            if ($('#InputParameter').prop("checked") == true) {
                $('ul#sortable').find('li[isactive="1"]').attr('InputParameter', '1');
                addition[index].In = "1";
                $('ul#sortable').find('li[isactive="1"]').find('span[In="In"]').removeClass('disable-label').addClass('enable-label');
            }
            else {
                $('ul#sortable').find('li[isactive="1"]').attr('InputParameter', '0');
                addition[index].In = "0";
                $('ul#sortable').find('li[isactive="1"]').find('span[In="In"]').removeClass('enable-label').addClass('disable-label');
            }

            if ($('#OutputParameter').prop("checked") == true) {
                $('ul#sortable').find('li[isactive="1"]').attr('OutputParameter', '1');
                addition[index].Ou = "1";
                $('ul#sortable').find('li[isactive="1"]').find('span[Ou="Ou"]').removeClass('disable-label').addClass('enable-label');
            }
            else {
                $('ul#sortable').find('li[isactive="1"]').attr('OutputParameter', '0');
                addition[index].Ou = "0";
                $('ul#sortable').find('li[isactive="1"]').find('span[Ou="Ou"]').removeClass('enable-label').addClass('disable-label');
            }
            $('ul#sortable').find('li').attr('isactive', '0'); // deactivate all
            //reset
            $('#MarkAggregationAndGrouping').hide(200);
            $('#MarkAggregationAndGrouping_Header').html('');
            $('#EnableGrouping').prop('checked', false);
            $('#EnableAggregation').prop('checked', false);
            $('#InputParameter').prop('checked', false);
            $('#OutputParameter').prop('checked', false);
            $('span.loading_Personal').html('');
            $('#ContentPlaceHolder1_dsfkjsfbsdfjbsfskdjfbsdkbfsdjbfsjkbfkjbkfjbkjsbfsdkjbfjkdsfsjhbfdkuyhvfeuhkhvdvkjhbfkjhbjhbdfkuyufdjbhjhbfdvkjkjbhvfdjbvfjbjbjbxcxvvdfjhbhb').val(JSON.stringify(addition));
            $('#JSONTEXT').html(JSON.stringify(addition));
        }
        $(function () {
            $("#sortable").sortable({
                change: function (event, ui) {
                    // alert($(ui.item).attr('key'));
                    // alert($(ui.item).attr('value'));
                    // drop and rebuild addition array again as per new alignment
                },
                stop: function (event, ui) {
                    checkifeventofdragisAlive = '1';
                    addition = [];
                    $(this).parent().find('li').each(function (index, item) {
                        var addition_Property = {};
                        addition_Property['key'] = $(this).attr('key');
                        addition_Property['Value'] = $(this).attr('value');
                        addition_Property['Ag'] = $(this).attr('aggregation');
                        addition_Property['Gr'] = $(this).attr('grouping');
                        addition_Property['In'] = $(this).attr('InputParameter');
                        addition_Property['Ou'] = $(this).attr('OutputParameter');
                        addition.push(addition_Property);
                    });
                    $('#ContentPlaceHolder1_dsfkjsfbsdfjbsfskdjfbsdkbfsdjbfsjkbfkjbkfjbkjsbfsdkjbfjkdsfsjhbfdkuyhvfeuhkhvdvkjhbfkjhbjhbdfkuyufdjbhjhbfdvkjkjbhvfdjbvfjbjbjbxcxvvdfjhbhb').val(JSON.stringify(addition));
                    $('#JSONTEXT').html(JSON.stringify(addition));
                    //$("selectedColList").val(JSON.stringify(addition));
                    event.stopPropagation();
                    event.stopImmediatePropagation();
                    checkifeventofdragisAlive = '0';
                }
            });
            $("#sortable").disableSelection();
        });
        
		</script>
	<script>
			function roles(){
				 var $select = $("#lrole");                         
			        var responseJson = '<%= session.getAttribute("hm") %>';
			        var rp = JSON.parse(responseJson);
			        $select.find("ul").remove();
			        $.each(rp, function(key, value) {              
			            $("<ul>").text(value).appendTo($select); 
			        });
				$("#roleModal").modal();
			}
		</script>

	<div id="roleModal" class="modal fade" role="dialog"
		style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header header-border'">
					<button type="button" class="close" data-dismiss="modal">
						X</button>
					<h4 class="modal-title">Assigned Role to the user-
						${user_name}</h4>
				</div>
				<div class="modal-body">

					<div class="col-lg-12">
						<li id="lrole" class="list-group-item">

							<ul>

							</ul>

						</li>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">
						<i class="fa fa-times-circle"></i>&nbsp;Close
					</button>
				</div>
			</div>

		</div>
	</div>
</body>
</html>



<%-- <html>

<head>
<title>First Web Application</title>
</head>

<body>
	Welcome ${sign_no}!! <a href="/list-todos">Click here</a> to manage your todo's.
	${user_id}
	${user_name}
	${department_level_name}
	${department_id}
	${designation_id}
	${designation_name}
	${hm}
</body>

</html> --%>
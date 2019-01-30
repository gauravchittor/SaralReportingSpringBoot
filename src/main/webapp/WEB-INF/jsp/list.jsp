<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="myexample" class="panel panel-default">
	<div class="panel-heading">
		<strong>
			<span class="glyphicon glyphicon-list"></span> Address List
		</strong>
		<div class="btn-group pull-right">
			<a href="javascript:void(0);" class="btn btn-default btn-sm" onclick="refresh('address')" title="Refresh Address">
				<span class="glyphicon glyphicon-refresh"></span>
			</a>
			
			<input type="button" onclick="CreateTableFromJSON()" value="Show report" />
							<p id="showData"></p>
		</div>
	</div>
	<div class="panel-body">
	
		<table id="example" class="table table-bordered table-condensed table-hover table-striped"> 
		
		</table>
		<!-- <table class="table table-bordered table-condensed table-hover table-striped">
			
		</table> -->
		
	</div>
		<div class="panel-footer">
			Showing ${number+1} to ${size} of ${totalElements}
			<ul class="pagination pull-right" style="margin:-7px;">
				<c:choose>
					<c:when test="${current == 1}">
						<li class="disabled"><a href="">First</a></li>
						<li class="disabled"><a href="">Prev</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="javascript:void(0);" onclick="list('1')">First</a></li>
						<li><a href="javascript:void(0);" onclick="list('${current - 1}')">Prev</a></li>
					</c:otherwise>
				</c:choose>
				<c:forEach begin="${begin}" end="${end}" var="i">
					<c:choose>
						<c:when test="${i == current}">
							<li class="active"><a href="" onclick="list('${i}')">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="javascript:void(0);" onclick="list('${i}')">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${current == totalPages}">
						<li class="disabled"><a href="">Next</a></li>
						<li class="disabled"><a href="">Last</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="javascript:void(0);" onclick="list('${current + 1}')">Next</a></li>
						<li><a href="javascript:void(0);" onclick="list('${totalPages}')">Last</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
</div>

<script src="js/jquery-3.3.1.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/dataTables.jqueryui.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="css/jquery-ui.css" />
<link rel="stylesheet" href="css/dataTables.jqueryui.min.css" />
<script src="js/jquery.boot.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script>
	function CreateTableFromJSON() {

        //Code for dynamic datatables
        var cols = [];
        var data = ${addresses};
        var exampleRecord = data[0];
        
        //get keys in object. This will only work if your statement remains true that all objects have identical keys
        var keys = Object.keys(exampleRecord);
        
        //for each key, add a column definition
        keys.forEach(function(k) {
          cols.push({
            title: k,
            data: k
            //optionally do some type detection here for render function
          });
        });
        
        //initialize DataTables
        var table = $('#example').DataTable({
        	columns: cols,
	        "pageLength": 150,
	        "pagingType": "simple",
	        "paging": false,
	        "scrollY": "500px",
	        "scrollCollapse": true,
	        bDestroy: true
        });
        
        //add data and draw
        table.clear();
        table.rows.add(data).draw();
           
		}
	
/* 	function CreateTableFromJSON2(data) {

        //Code for dynamic datatables
        var cols = [];
        var data = data;
        var exampleRecord = data[0];
        
        //get keys in object. This will only work if your statement remains true that all objects have identical keys
        var keys = Object.keys(exampleRecord);
        
        //for each key, add a column definition
        keys.forEach(function(k) {
          cols.push({
            title: k,
            data: k
            //optionally do some type detection here for render function
          });
        });
        
        //initialize DataTables
        var table = $('#example').DataTable({
        	columns: cols,
	        "pageLength": 150,
	        "pagingType": "simple",
	        "paging": false,
	        "scrollY": "500px",
	        "scrollCollapse": true,
	        bDestroy: true
        });
        
        //add data and draw
        table.clear();
        table.rows.add(data).draw();
           
		} */
	
	
	function list(page) {
		modifyData(page);
	}

	function modifyData(suffix) {
		$.ajax({
			type : "GET",
			url : '/viewSelectedReportData?page='+suffix,
			data : {
				deptid : $('#deptid').val(),
				reportId : ${reportId},
				service_id : ${service_id},
				sign_no : "\"${sign_no}\"",
				
			},
			success : function(data) {
				//console.log("This is data " +data);
				 //$("#myform").replaceWith(data);
				
				window.location.href='/viewSelectedReportData?page='+suffix;
				
			}
		});
	}

</script>
<script type="text/javascript">
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
<script type="text/javascript">
	$(document).ready(function(){
			
		var count = ${totalPages};
		for(var n = 1; n<=count; n++) {
			$('#selectPageNum').append($('<option>', { 
		        value: n,
		        text : n 
		    }));
		}
		
		CreateTableFromJSON();
		
		<c:set var="path" value="${pageContext.request.contextPath}"/>
		
	});
</script>
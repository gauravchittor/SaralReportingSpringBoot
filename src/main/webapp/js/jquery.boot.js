$(function() {
	$("#userList").click(function() {
		fetchList("user");
	});
	
	$("#addressList").click(function() {
		fetchList("address");
	});
});

var pageConstant = "?page=1";

function addForm(type) {
	modifyData(type+"/form");
}

function editForm(type, id) {
	modifyData(type+"/edit/"+id);
}

function fetchList(type) {
	modifyData(type+"/list"+pageConstant);
}

function refresh(type) {
	modifyData(type+"/refresh"+pageConstant);
}


function deleteData(type, id) {
	toastr.warning("<div>Are you sure you want to delete this?</div>" +
			"<div class='btn-group pull-right'>" +
			"<button type='button' id='confirmationYes' class='btn btn-xs btn-default'><i class='glyphicon glyphicon-ok'></i> Yes</button>" +
			"<button type='button' class='btn btn-xs btn-default clear'><i class='glyphicon glyphicon-remove'></i> No</button>" +
			"</div>", "Delete Confirmation", {
		allowHtml:true,
		closeButton:true,
		onShown: function() {
			$("#confirmationYes").click(function() {
				$.ajax({
					type : "GET",
					url : "/mightyjava/"+type+"/delete/"+id,
					success : function(data) {
						fetchList(type);
						toastr.success(data.message, "Delete Confirmation", {
							closeButton:true
						});
					}
				});
			});
		}
	});
}
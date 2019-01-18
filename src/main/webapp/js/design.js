

$(document).ready(function() {
	$('#desrpt').click(function() {
		$.ajax({
			type : "post",
			url : 'DesignReport',
			data : {
				deptid : $('#deptid').val(),
				action : "fetchService"
			},
			success : function(responseJson) {
				console.log(responseJson);
				 var $select = $("#selectedRecord");                         
			        $select.find("option").remove();
			        $("<option>").val(0).text("Please Select").appendTo($select);		
			        $.each(responseJson, function(key, value) {               
			            $("<option>").val(key).text(value).appendTo($select);
			        });
			}
		});
	});
	
	$('#getcol').click(function() {
		$.ajax({
			type : "post",
			url : 'DesignReport',
			data : {
				deptid : $('#deptid').val(),
				serviceid: $('#selectedRecord').val(),
				action : "fetchColumns"
			},
			success : function(responseJson1) {
				console.log(responseJson1);
			        $.each(responseJson1, function(key, value) {               
			            $('#ContentPlaceHolder1_CheckBoxList1').append('<input name="colmn" type="checkbox" value="'+ key +'"/> ' +  '<label for="'+ key +'" /> ' +'<br/>');
			        });
			}
		});
	});
	
});



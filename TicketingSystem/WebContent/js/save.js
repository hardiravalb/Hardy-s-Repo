$scope.save = function() {
	$.ajax({
		type : "GET",
		url : "TicketingSystemRESTWS.java/addticket",
		data : "{'custId':'" + $scope.custId + "','comments':'"
				+ $scope.comments + "','createdBy':'" + $scope.createdBy + "',"
				+ "'assignedTo':'" + $scope.assignedTo + "','status':'"
				+ $scope.status + "'}",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		success : function(msg) {
			alert(msg.d);
			alert("done");
		},
		error : function(msg) {
			alert(msg.d);
			alert("error");
		}
	});
};
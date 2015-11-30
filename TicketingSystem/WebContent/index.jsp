<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myapp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticketing System</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script type="text/javascript" src="js/angular.min.js"></script>
</head>
<body ng-controller="ticketController" ng-submit="save()">
	<div class="container">
		<h3>Tickets</h3>
		<table cellspacing="2" cellpadding="2" border="1"
			class="table table-striped">
			<tr>
				<th>Customer Name</th>
				<th>Comments</th>
				<th>Created By</th>
				<th>Assigned To</th>
				<th>Status</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<tr ng-repeat="tick in listTickets"
				ng-class="{'selected':$index == selectedRow}"
				ng-click="setClickedRow($index)">
				<td>{{tick.custId}}</td>
				<td>{{tick.comments}}</td>
				<td>{{tick.createdBy}}</td>
				<td>{{tick.assignedTo}}</td>
				<td>{{tick.status}}</td>
				<td><button class="btn" ng-click="editTicket(user.id)">
						<span class="glyphicon glyphicon-pencil"></span>  Edit
					</button></td>
				<td><a href="" ng-click="deleteTicket(user.id)"
					class="btn btn-small btn-danger">Delete</a></td>
			</tr>
		</table>
		<style>
.selected {
	font-weight: bold;
}
</style>
		<script type="text/javascript">
			var myapp = angular.module('myapp', []);
			myapp
					.controller(
							'ticketController',
							function($scope, $http) {
								$http
										.get(
												'http://localhost:8080/TicketingSystem/rest/ticket/getTickets')
										.success(
												function(response) {
													$scope.listTickets = response.ticket;
												});
								$scope.selectedRow = null; // initialize our variable to null
								$scope.setClickedRow = function(index) { //function that sets the value of selectedRow to current index
									$scope.selectedRow = index;
								}
								$scope.editTicket = function(id) {
									$scope.hideform = false;
									if (id == 'new') {
										$scope.edit = true;
										$scope.incomplete = true;
										$scope.custId = '';
										$scope.createdBy = '';
										$scope.assignedTo = '';
										$scope.status = '';
										$scope.comments = '';

									} else {
										$scope.edit = false;

									}
								};

							});
		</script>
		<hr>
		<button class="btn btn-success" ng-click="editTicket('new')">
			<span></span>  Create New Ticket
		</button>
		<hr>

		<form class="form-horizontal" ng-hide="hideform">
			<h3 ng-show="edit">Create New Ticket:</h3>
			<h3 ng-hide="edit">Edit Ticket:</h3>
			<div class="form-group">
				<label class="col-sm-2 control-label">Customer Name:</label>
				<div class="col-sm-10">
					<input type="text" ng-model="custId" ng-disabled="!edit"
						placeholder="Customer name ">
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Created By:</label>
				<div class="col-sm-10">
					<input type="text" ng-model="createdBy" ng-disabled="!edit"
						placeholder="Ticket created by">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Assigned To:</label>
				<div class="col-sm-10">
					<input type="text" ng-model="assignedTo"
						placeholder="Ticket assigned to">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Status:</label>
				<div class="col-sm-10">
					<select ng-model="status">
						<option value="new">New</option>
						<option value="open">Open</option>
						<option value="closed">Closed</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Comments:</label>
				<div class="col-sm-10">
					<textarea rows="3" cols="30" ng-model="comments"
						placeholder="Comments "></textarea>
				</div>
			</div>
			<hr>
			<button class="btn btn-success" ng-disabled="error || incomplete">
				<span class="glyphicon glyphicon-save"></span>  Save Changes
			</button>
		</form>
	</div>

</body>
</html>
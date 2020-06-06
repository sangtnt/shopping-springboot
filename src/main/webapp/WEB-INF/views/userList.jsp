<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">User Table</h1>
	<!-- <p class="mb-4">
						DataTables is a third party plugin that is used to generate the
						demo table below. For more information about DataTables, please
						visit the <a target="_blank" href="https://datatables.net">official
							DataTables documentation</a>.
					</p> -->

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Users Information</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Username</th>
							<th>Full Name</th>
							<th>Balance</th>
							<th>Email</th>
							<th>Gender</th>
							<th>Phone Number</th>
							<th>Status</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Username</th>
							<th>Full Name</th>
							<th>Balance</th>
							<th>Email</th>
							<th>Gender</th>
							<th>Phone Number</th>
							<th>Status</th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach var="user" items="${users}">
							<tr>
								<td>${user.username}</td>
								<td>${user.fullname}</td>
								<td>${user.balance}</td>
								<td>${user.email }</td>
								<td>${user.gender }</td>
								<td>${user.phone }</td>
								<td><c:if test="${user.status}">
										<span style="color: green"> active </span>
									</c:if> <c:if test="${user.status==false}">
										<span style="color: red"> inactive </span>
									</c:if></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->

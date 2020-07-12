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
							<th>Image</th>
							<th>Email</th>
							<th>Gender</th>
							<th>Phone Number</th>
							<th colspan="3"><a href="/admin/user/createUser">
									<button class="btn btn-outline-success btn-block">Add
										new</button>
							</a></th>

						</tr>
					</thead>
					<tfoot>

					</tfoot>
					<tbody>
						<c:forEach var="user" items="${users}">
							<tr>
								<td>${user.username}</td>
								<td>${user.fullname}</td>
								<td><img height="50px" width="50px" src="${user.image }"></td>
								<td>${user.email }</td>
								<td>${user.gender }</td>
								<td>${user.phone }</td>
								<td><a
									href="/admin/user/addPermission?username=${user.username }">
										<button class="btn btn-dark">
											<i class="fas fa-users"></i>
										</button>
								</a></td>
								<td><a
									href="/admin/user/editUser?username=${user.username}"><button
											type="button" class="btn btn-outline-dark">
											<i class="far fa-edit"></i>
										</button></a></td>
								<c:if test="${user.products.size()==0&&user.orders.size()==0 }">
									<td>
										<form action="/admin/user/deleteUser" method="POST">
											<input name="username" value="${user.username }"
												type="hidden" />
											<button class="btn btn-danger btn-block" type="submit">
												<i class="far fa-trash-alt"></i>
											</button>
										</form>
									</td>
								</c:if>
								<c:if test="${(user.orders.size()>0||user.products.size()>0)&&user.status==true}">
									<td>
										<a href="/admin/user/deactivateUser?username=${user.username }">
											<button class="btn btn-warning btn-block" type="button">
												Deactivate
											</button>
										</a>
									</td>
								</c:if>
								<c:if test="${(user.orders.size()>0||user.products.size()>0)&&user.status==false}">
									<td>
										<a href="/admin/user/activateUser?username=${user.username }">
											<button class="btn btn-success btn-block" type="button">
												Activate
											</button>
										</a>
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<!-- /.container-fluid -->

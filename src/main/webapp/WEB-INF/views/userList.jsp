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
							<!-- <th colspan="2">
								<button class="btn btn-outline-success btn-block">Add new</button>
							</th> -->
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
<<<<<<< HEAD
								
								<td><a href="/admin/user/editUser?username=${user.username}"><i
						class="far fa-edit"></i></a></td>
								
								
								<c:if test="${user.products.size()==0 }">
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
=======
								<td>
									<form action="/admin/user/deleteUser" method="POST">
										<input name="username" value="${user.username }"
											type="hidden" />
										<button class="btn btn-danger btn-block" type="submit">
											<i class="far fa-trash-alt"></i>
										</button>
									</form>
								</td>
>>>>>>> 15ed26bf5e5c82b4ec2512a71a1719dc5cf3dbcb
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
<a href="/admin/user/createUser">Create</a>
</div>
<!-- /.container-fluid -->

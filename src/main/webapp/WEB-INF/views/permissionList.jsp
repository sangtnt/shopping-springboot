<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Permission Table</h1>
	<!-- <p class="mb-4">
						DataTables is a third party plugin that is used to generate the
						demo table below. For more information about DataTables, please
						visit the <a target="_blank" href="https://datatables.net">official
							DataTables documentation</a>.
					</p> -->

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Permissions</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Role</th>
							<th>
								<a href="/admin/permission/add">
									<button class="btn btn-outline-success btn-block">Add new</button>
								</a>
							</th>
						</tr>
					</thead>
					<tfoot>
						
					</tfoot>
					<tbody>
						<c:forEach var="item" items="${pers}">
							<tr>
								<td>${item.permissionName }</td>
								<td>
									<form action="/admin/permission/delete" method="POST">
										<input name="id" value="${item.id }" type="hidden" />
										<button class="btn btn-danger btn-block" type="submit">
											<i class="far fa-trash-alt"></i>
										</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->

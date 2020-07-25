<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Product Table</h1>
	<!-- <p class="mb-4">
						DataTables is a third party plugin that is used to generate the
						demo table below. For more information about DataTables, please
						visit the <a target="_blank" href="https://datatables.net">official
							DataTables documentation</a>.
					</p> -->

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Product
				Information</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Name</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Brand</th>
							<th>Origin</th>
							<th>Category</th>
							<th colspan="2">
								<a href="/admin/product/addPro">
									<button class="btn btn-outline-success btn-block">Add new</button>
								</a>
							</th>
						</tr>
					</thead>
					<tfoot>
						
					</tfoot>
					<tbody>
						<c:forEach var="pro" items="${pros}">
							<tr>
								<td>${pro.name}</td>
								<td>${pro.price }</td>
								<td>${pro.quantity}</td>
								<td>${pro.brand}</td>
								<td>${pro.origin}</td>
								<td>${pro.cat.name}</td>
								<td><a href="/admin/product/editPro?proId=${pro.id }">
										<button class="btn btn-dark btn-block" type="button">
											<i class="fas fa-edit"></i>
										</button>
								</a></td>
								<td>
									<form action="/admin/product/deletePro" method="POST">
										<input name="proId" value="${pro.id }" type="hidden" />
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
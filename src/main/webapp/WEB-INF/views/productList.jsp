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
							<th>#</th>
							<th>Name</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Description</th>
							<th>Date</th>
							<th>Category</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>#</th>
							<th>Name</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Description</th>
							<th>Date</th>
							<th>Category</th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach var="pro" items="${pros}">
							<tr>
								<td>${pro.id}</td>
								<td>${pro.name}</td>
								<td>${pro.price }</td>
								<td>${pro.quantity}</td>
								<td>${pro.description}</td>
								<td>${pro.date}</td>
								<td>${pro.cat.name}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->
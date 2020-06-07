<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Order Table</h1>
	<!-- <p class="mb-4">
						DataTables is a third party plugin that is used to generate the
						demo table below. For more information about DataTables, please
						visit the <a target="_blank" href="https://datatables.net">official
							DataTables documentation</a>.
					</p> -->

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Order List</h6>
			<%-- <div class="pagination">
								<c:forEach var="item" items="${pagi}">
									<div class="pagination-item">
										${item}
									</div>
								</c:forEach>
							</div> --%>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Order ID</th>
							<th>Username</th>
							<th>Fullname</th>
							<th>Email</th>
							<th>Phone</th>
							<th>Status</th>
						</tr>
					</thead>
					<tfoot>
					</tfoot>
					<tbody>
						<c:forEach var="order" items="${orders}">
							<tr>
								<td><a href="/admin/order/orderDetail?orderId=${order.id }">
										${order.id} </a></td>
								<td>${order.user.username}</td>
								<td>${order.user.fullname }</td>
								<td>${order.user.email }</td>
								<td>${order.user.phone }</td>
								<td><c:if test="${order.is_Accepted==false }">
										<button class="btn btn-primary">Accept</button>
									</c:if> <c:if test="${order.is_Accepted }">
										<span style="color: green">Accepted</span>
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

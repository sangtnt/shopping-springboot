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
								<td>${order.fullname }</td>
								<td>${order.phone }</td>
								<td><c:if test="${order.status ==0}">
										<form method="POST">
											<input name="orderId" value="${order.id }" type="hidden">
											<input name="orderStatus" value="1" type="hidden">
											<button formaction="/admin/order/changeOrder" type="submit"
												class="btn btn-primary">Accept</button>
										</form>
									</c:if> <c:if test="${order.status ==1}">
										<form method="POST">
											<input name="orderId" value="${order.id }" type="hidden">
											<input name="orderStatus" value="2" type="hidden">
											<button formaction="/admin/order/changeOrder" type="submit"
												class="btn btn-dark">Wrap</button>
										</form>
									</c:if> <c:if test="${order.status ==2}">
										<form method="POST">
											<input name="orderId" value="${order.id }" type="hidden">
											<input name="orderStatus" value="3" type="hidden">
											<button formaction="/admin/order/changeOrder" type="submit"
												class="btn btn-info">Delivery</button>
										</form>
									</c:if> <c:if test="${order.status ==3}">
										<form method="POST">
											<input name="orderId" value="${order.id }" type="hidden">
											<input name="orderStatus" value="4" type="hidden">
											<button formaction="/admin/order/changeOrder" type="submit"
												class="btn btn-success">Complete</button>
										</form>
									</c:if> <c:if test="${order.status ==4}">
										<span style="color: green; font-weight: bold">Completed</span>
									</c:if> <c:if test="${order.status ==5}">
										<span style="color: red; font-weight: bold">Canceled</span>
									</c:if></td>
								<c:if test="${order.status !=5 &&order.status !=4}">
									<td>
										<form method="POST">
											<input name="orderId" value="${order.id }" type="hidden">
											<input name="orderStatus" value="5" type="hidden">
											<button formaction="/admin/order/changeOrder" type="submit"
												class="btn btn-danger">Cancel</button>
										</form>
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

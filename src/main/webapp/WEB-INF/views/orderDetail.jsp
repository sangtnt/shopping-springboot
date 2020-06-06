<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Begin Page Content -->
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-12 col-sm-12 order-detail">
			<div class="order-title">
				<h2>Order #${order.id }</h2>
			</div>
			<div class="order-date">${order.date}</div>

		</div>
	</div>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">User:
				${order.user.username }</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Product Name</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Subtotal</th>
						</tr>
					</thead>
					<tfoot class="order-foot">
						<tr>
							<td colspan="3" class="order-foot-left">SubTotal:</td>
							<td class="order-foot-right">${order.subTotal }</td>
						</tr>
						<tr>
							<td colspan="3" class="order-foot-left">Discount:</td>
							<td class="order-foot-right">${order.discount }</td>
						</tr>
						<tr>
							<td colspan="3" class="order-foot-left">Additional fees:</td>
							<td class="order-foot-right">${order.additionalFees }</td>
						</tr>
						<tr>
							<td colspan="3" class="order-foot-left">Shipping & Handling:</td>
							<td class="order-foot-right">${order.shipping }</td>
						</tr>
						<tr class="grand-total">
							<td colspan="3" class="order-foot-left">GrandTotal:</td>
							<td class="order-foot-right">${order.grandTotal }</td>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach var="item" items="${order.order_details}">
							<tr>
								<td>${item.product.name }</td>
								<td>${item.product.price }</td>
								<td>${item.quantity }</td>
								<td>${item.subTotal }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<!-- /.container-fluid -->

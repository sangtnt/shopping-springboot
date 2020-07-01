<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg"
	data-setbg="/resources/static/img/breadcrumb.jpg">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<div class="breadcrumb__text">
					<h2>Orders</h2>
					<div class="breadcrumb__option">
						<a href="/">Home</a> <span>Orders</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Breadcrumb Section End -->

<c:if test="${orders.size()>0 }">
	<!-- Shoping Cart Section Begin -->
	<section class="shoping-cart spad">
		<div class="container">
			<c:forEach var="order" items="${orders }">
				<form action="/auth/addToCart" method="POST">
					<div class="row">
						<div class="col-lg-12 single-order">
							<div class="row">
								<div class="order-seller">
									<div>${order.date }</div>
									<div class="order-status">
										<c:if test="${order.status==0 }">Waiting...</c:if>
										<c:if test="${order.status==1 }">Accepted</c:if>
										<c:if test="${order.status==2 }">Wrapping...</c:if>
										<c:if test="${order.status==3 }">Shipping</c:if>
										<c:if test="${order.status==4 }">Completed</c:if>
										<c:if test="${order.status==5 }">Canceled</c:if>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-12">
									<div class="shoping__cart__table">
										<table>
											<thead>
												<tr>
													<th class="shoping__product">Products</th>
													<th>Price</th>
													<th>Quantity</th>
													<th>Total</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${order.order_details}" var="item">
													<tr>
														<td class="shoping__cart__item"><img
															src="${item.product.image }" alt=""> <input
															name="proId" value="${item.product.id }" type="hidden">
															<input name="quantity" value="${item.quantity }"
															type="hidden">
															<h5>${item.product.name }</h5></td>
														<td class="shoping__cart__price">$${item.product.getDiscountPrice()}</td>
														<td class="shoping__cart__price">${item.quantity }</td>
														<td class="shoping__cart__total">$${item.product.getDiscountPrice()*item.quantity
															}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="total-order col-lg-12">Total:
									$${order.grandTotal }</div>
								<div class="col-lg-12">
									<div class="shoping__cart__btns">
										<c:if test="${order.status==0 ||order.status==1 }">
											<a href="/order/cancelOrder?orderId=${order.id }">
												<button type="button" class="primary-btn cart-btn cart-btn-right">Cancel</button>
											</a>
										</c:if>
										<button type="submit"
											class="primary-btn cart-btn cart-btn-right">
											<span class="icon_loading"></span> Buy Again
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</c:forEach>
		</div>
	</section>
</c:if>
<c:if test="${orders.size()==0 }">
	<!-- Shoping Cart Section Begin -->
	<section class="shoping-cart spad">
		<div class="row">
			<div class="col-lg-12">
				<div class="shoping__cart__btns">
					<a href="/" class="primary-btn cart-btn">CONTINUE SHOPPING</a>
				</div>
			</div>
		</div>
	</section>
</c:if>
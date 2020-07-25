<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg"
	data-setbg="/resources/static/img/breadcrumb.jpg">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<div class="breadcrumb__text">
					<h2>Shopping Cart</h2>
					<div class="breadcrumb__option">
						<a href="/">Home</a> <span>Shopping Cart</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Breadcrumb Section End -->

<c:if test="${user.cartItems.size()>0 }">
	<!-- Shoping Cart Section Begin -->
	<section class="shoping-cart spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="shoping__cart__table">
						<form id="autoSaveCart" action="/auth/autoSaveCart" method="POST">
							<table>
								<thead>
									<tr>
										<th class="shoping__product">Products</th>
										<th>Price</th>
										<th>Quantity</th>
										<th>Total</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${user.cartItems}" var="item">
										<tr>
											<td class="shoping__cart__item"><a href="/product/proDetail?proId=${item.product.id }"><img width="110px" height="110px"
												src="${item.product.images.get(0).image }" alt=""></a>
												<h5>${item.product.name }</h5></td>
											<td class="shoping__cart__price">$${item.product.getDiscountPrice() }</td>
											<td class="shoping__cart__quantity">
												<div class="quantity">
													<div class="pro-qty">
														<input class="cart-quantity" name="cart" type="text"
															value="${item.quantity }">
													</div>
												</div>
											</td>
											<td class="shoping__cart__total">$${item.total}</td>
											<td class="shoping__cart__item__close"><a
												href="/auth/deleteCartItem?itemId=${item.id }"><span
													class="icon_close"></span></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</form>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="shoping__cart__btns">
						<a href="/" class="primary-btn cart-btn">CONTINUE SHOPPING</a>
						<button class="updateCart primary-btn cart-btn cart-btn-right">
							<span class="icon_loading"></span> Update Cart
						</button>
					</div>
				</div>
				<!-- <div class="col-lg-6">
					<div class="shoping__continue">
						<div class="shoping__discount">
							<h5>Discount Codes</h5>
							<form action="#">
								<input type="text" placeholder="Enter your coupon code">
								<button type="submit" class="site-btn">APPLY COUPON</button>
							</form>
						</div>
					</div>
				</div> -->
				<div class="col-lg-6">
					<div class="shoping__checkout">
						<h5>Cart Total</h5>
						<ul>
							<c:set var="total" value="${0}" />
							<c:forEach var="item" items="${user.cartItems}">
								<c:set var="total" value="${total + item.total}" />
							</c:forEach>
							<li>Subtotal <span>$${total }</span></li>
							<li>Total <span>$${total }</span></li>
						</ul>
						<a href="/auth/checkout" class="primary-btn">PROCEED TO
							CHECKOUT</a>
					</div>
				</div>
			</div>
		</div>
	</section>
</c:if>
<c:if test="${user.cartItems.size()==0 }">
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
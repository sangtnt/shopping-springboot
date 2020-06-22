<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Checkout Section Begin -->
<section class="checkout spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h6>
					<span class="icon_tag_alt"></span> Have a coupon? <a href="#">Click
						here</a> to enter your code
				</h6>
			</div>
		</div>
		<div class="checkout__form">
			<h4>Billing Details</h4>
			<form action="/auth/checkout" method="post">
				<div class="row">
					<div class="col-lg-8 col-md-6">
						<div class="checkout__input">
							<p>
								Full Name<span>*</span>
							</p>
							<input name="fullname" type="text" value="${user.fullname }" required>
						</div>
						<div class="checkout__input">
							<p>
								Town/City<span>*</span>
							</p>
							<input name="city" type="text" value="${user.address }" required>
						</div>
						<div class="checkout__input">
							<p>
								District<span>*</span>
							</p>
							<input name="district" type="text"
								class="checkout__input__add" value="${user.address }" required>
						</div>
						<div class="checkout__input">
							<p>
								Address<span>*</span>
							</p>
							<input name="address" type="text"
								class="checkout__input__add" value="${user.address }" required>
						</div>
						<div class="checkout__input">
							<p>
								Phone<span>*</span>
							</p>
							<input name="phone" type="text"
								class="checkout__input__add" value="${user.phone }" required>
						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="checkout__order">
							<h4>Your Order</h4>
							<div class="checkout__order__products">
								Products <span>Total</span>
							</div>
							<ul>
								<c:forEach var="item" items="${user.cartItems }">
									<li>${item.product.name }<span>${item.total }</span>
										<input type="hidden" name="proId" value="${item.product.id }">
										<input type="hidden" name="quantity" value="${item.quantity }">
									</li>
								</c:forEach>
							</ul>
							<c:set var="total" value="${0}" />
							<c:forEach var="item" items="${user.cartItems}">
								<c:set var="total" value="${total + item.total}" />
							</c:forEach>
							<div class="checkout__order__subtotal">
								Subtotal <span>$${total }</span>
							</div>
							<div class="checkout__order__total">
								Total <span>$${total }</span>
							</div>
							<div class="checkout__input__checkbox">
								<label for="payment"> Payment on delivery <input
									type="radio" name="payment" id="payment" value="payondelivery" checked> <span class="checkmark"></span>
								</label>
							</div>
							<!-- <div class="checkout__input__checkbox">
								<label for="paypal"> Paypal <input type="checkbox"
									id="paypal"> <span class="checkmark"></span>
								</label>
							</div> -->
							<button type="submit" class="site-btn">PLACE ORDER</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>
<!-- Checkout Section End -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg"
	data-setbg="/resources/static/img/breadcrumb.jpg">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<div class="breadcrumb__text">
					<h2>${pro.name }</h2>
					<div class="breadcrumb__option">
						<a href="/">Home</a> <a href="/product?catId=${pro.cat.id }">${pro.cat.name }</a>
						<span>${pro.name }</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Breadcrumb Section End -->

<!-- Product Details Section Begin -->
<section class="product-details spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="product__details__pic">
					<div class="product__details__pic__item">
						<img class="product__details__pic__item--large"
							src="${pro.image }" alt="">
					</div>
					<div class="product__details__pic__slider owl-carousel">
						<img data-imgbigurl="img/product/details/product-details-2.jpg"
							src="${pro.image }" alt="">
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="product__details__text">
					<h3>${pro.name }</h3>
					<div class="product__details__rating">
						<c:forEach begin="1" end="${pro.rating }">
							<i class="fa fa-star"></i>
						</c:forEach>
						<c:forEach begin="${pro.rating+1 }" end="5">
							<i class="fa fa-star-o"></i>
						</c:forEach>
						<span>(${pro.reviews.size() } reviews) (Sold ${pro.sold }
							items) (${pro.userLiked.size() }
							likes) (${pro.research }
							researches)</span>
						
					</div>
					<div class="product__details__price">$${pro.price }</div>
					<c:if test="${pro.quantity>0 }">
						<form action="/auth/addToCart" method="POST">
							<input name="proId" type="hidden" value="${pro.id }">
							<div class="product__details__quantity">
								<div class="quantity">
									<div class="pro-qty-myself">
										<input name="quantity" type="text" value="1">
									</div>
								</div>
							</div>

							<button type="submit" class="primary-btn">ADD TO CART</button>

							<c:if test="${user!=null }">
								<c:if test="${ user.checkProLiked(pro)}">
									<a href="/auth/like?proId=${pro.id }" class="heart-icon"><span
										class="icon_heart"></span></a>
								</c:if>
								<c:if test="${ user.checkProLiked(pro)==false}">
									<a href="/auth/like?proId=${pro.id }" class="heart-icon"><span
										class="icon_heart_alt"></span></a>
								</c:if>
							</c:if>
							<c:if test="${user==null }">
								<a href="/auth/like?proId=${pro.id }" class="heart-icon"><span
										class="icon_heart_alt"></span></a>
							</c:if>
						</form>
					</c:if>
					<ul>
						<li><b>Availability</b> <c:if test="${pro.quantity>1 }">
								<span id="pro_quantity">${pro.quantity }</span> items
							</c:if> <c:if test="${pro.quantity==1 }">
								<span id="pro_quantity">${pro.quantity }</span> item
							</c:if> <c:if test="${pro.quantity==0 }">
								<span id="pro_quantity"><samp>Sold out</samp></span>
							</c:if></li>
						<li><b>Shipping</b> <span>${pro.shipping }</span></li>
						<li><b>Origin</b> <span>${pro.origin }</span></li>
						<li><b>Share on</b>
							<div class="share">
								<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
									class="fa fa-twitter"></i></a> <a href="#"><i
									class="fa fa-instagram"></i></a> <a href="#"><i
									class="fa fa-pinterest"></i></a>
							</div></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="product__details__tab">
					<ul class="nav nav-tabs" role="tablist">
						<li class="nav-item"><a class="nav-link active"
							data-toggle="tab" href="#tabs-1" role="tab" aria-selected="true">Description</a>
						</li>
						<li class="nav-item"><a class="nav-link" data-toggle="tab"
							href="#tabs-2" role="tab" aria-selected="false">Seller</a></li>
						<li class="nav-item"><a class="nav-link" data-toggle="tab"
							href="#tabs-3" role="tab" aria-selected="false">Reviews <span>(${pro.reviews.size() })</span></a>
						</li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="tabs-1" role="tabpanel">
							<div class="product__details__tab__desc">
								<p>${pro.description }</p>
							</div>
						</div>
						<div class="tab-pane" id="tabs-2" role="tabpanel">
							<div class="product__details__tab__desc">
								<div class="container-fluid">
									<div class="row">
										<img class="col-xs-1 col-sm-2" src="${pro.user.image }">
										<div class="col-xs-11 col-sm-3">
											<div class="row">
												<div class="col-sm-12">
													<h2>${pro.user.username }</h2>
												</div>
												<div class="col-sm-12">
													<a href="/user/viewShop?username=${pro.user.username }"><button
															class="btn btn-primary">View Shop</button></a>
												</div>
											</div>
										</div>
										<div class="col-xs-11 col-sm-7">
											<div class="row">
												<div class="col-sm-6">
													Products: <span style="color: red">${pro.user.products.size() }</span>
												</div>
												<div class="col-sm-6">
													Attended: <span style="color: red">${pro.user.date}</span>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane" id="tabs-3" role="tabpanel">
							<div class="product__details__tab__desc">
								<p></p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Product Details Section End -->

<!-- Related Product Section Begin -->
<section class="related-product">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title related__product__title">
					<h2>Related Product</h2>
				</div>
			</div>
		</div>
		<div class="row">
			<c:forEach items="${relatedPros }" var="item">
				<div class="col-lg-3 col-md-4 col-sm-6">
					<div class="product__item">
						<div class="product__item__pic set-bg" data-setbg="${item.image }">
							<ul class="product__item__pic__hover">
								<li><a href="/auth/like?proId=${pro.id }"><i class="fa fa-heart"></i></a></li>
								<li>
									<form action="/auth/addToCart" method="post">
										<input name="quantity" value="1" type="hidden"> <input
											name="proId" value="${pro.id }" type="hidden"> <a><i
											class="addToCart fa fa-shopping-cart"></i></a>
									</form>
								</li>
							</ul>
						</div>
						<div class="product__item__text">
							<h6>
								<a href="/product/proDetail?proId=${item.id }">${item.name }</a>
							</h6>
							<h5>$${item.price }</h5>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</section>
<!-- Related Product Section End -->
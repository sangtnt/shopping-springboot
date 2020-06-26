<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="hero">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="hero__item set-bg"
					data-setbg="/resources/static/img/hero/banner.jpg">
					<div class="hero__text">
						<span>FRUIT FRESH</span>
						<h2>
							Vegetable <br />100% Organic
						</h2>
						<p>Free Pickup and Delivery Available</p>
						<a href="#" class="primary-btn">SHOP NOW</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Categories Section Begin -->
<section class="categories">
	<div class="container">
		<div class="row">
			<div class="categories__slider owl-carousel">
				<c:forEach var="cat" items="${cats }">
					<div class="col-lg-3">
						<div class="categories__item set-bg" data-setbg="${cat.image }">
							<h5>
								<a href="/product?catId=${cat.id }">${cat.name }</a>
							</h5>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</section>
<!-- Categories Section End -->

<!-- Featured Section Begin -->
<section class="featured spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title">
					<h2>Most Research</h2>
				</div>
			</div>
		</div>
		<div class="row featured__filter">
			<c:forEach var="pro" items="${pros }">
				<div class="col-lg-3 col-md-4 col-sm-6">
					<div class="featured__item">
						<div class="featured__item__pic set-bg" data-setbg="${pro.image }">
							<ul class="featured__item__pic__hover">
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
						<div class="featured__item__text">
							<h6>
								<a href="/product/proDetail?proId=${pro.id }">${pro.name }</a>
							</h6>
							<h6 style="color: red">
								<c:if test="${pro.research >1}">
									(${pro.research } researches)
								</c:if>
								<c:if test="${pro.research ==1}">
									(${pro.research } research)
								</c:if>
								<c:if test="${pro.research ==0|| pro.research==null}">
									(No research)
								</c:if>
								
								<%-- <c:if test="${pro.usersLiked.size() >1}">
									(${pro.usersLiked.size() } Likes)
								</c:if>
								<c:if test="${pro.usersLiked.size() ==1}">
									(${pro.usersLiked.size() } Like)
								</c:if>
								<c:if test="${pro.usersLiked.size() ==0}">
									(${pro.usersLiked.size() } Like)
								</c:if> --%>
							</h6>
							<h5>$${pro.price }</h5>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</section>
<!-- Featured Section End -->

<!-- Banner Begin -->
<div class="banner">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-6">
				<div class="banner__pic">
					<img src="/resources/static/img/banner/banner-1.jpg" alt="">
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6">
				<div class="banner__pic">
					<img src="/resources/static/img/banner/banner-2.jpg" alt="">
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Banner End -->

<!-- Latest Product Section Begin -->
<section class="latest-product spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-4 col-md-6">
				<div class="latest-product__text">
					<h4>Latest Products</h4>
					<div class="latest-product__slider owl-carousel">
						<c:forEach var="item" items="${latestPros }" varStatus="loop">
							<c:if test="${(loop.index)%3==0 }">
								<div class="latest-product__slider__item">
							</c:if>
							<a href="/product/proDetail?proId=${item.id }" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="${item.image }" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>${item.name }</h6>
									<span>$${item.price }</span>
								</div>
							</a>
							<c:if test="${(loop.index+1)%3==0 ||loop.index+1==latestPros.size()}">
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="latest-product__text">
					<h4>Top Rated Products</h4>
					<div class="latest-product__slider owl-carousel">
						<c:forEach var="item" items="${ratedPros }" varStatus="loop">
							<c:if test="${(loop.index)%3==0 }">
								<div class="latest-product__slider__item">
							</c:if>
							<a href="/product/proDetail?proId=${item.id }" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="${item.image }" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>${item.name }</h6>
									<span>$${item.price }</span>
								</div>
							</a>
							<c:if test="${(loop.index+1)%3==0 ||loop.index+1==ratedPros.size()}">
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="latest-product__text">
					<h4>Bestseller</h4>
					<div class="latest-product__slider owl-carousel">
						<c:forEach var="item" items="${bestSeller }" varStatus="loop">
							<c:if test="${(loop.index)%3==0 }">
								<div class="latest-product__slider__item">
							</c:if>
							<a href="/product/proDetail?proId=${item.id }" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="${item.image }" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>${item.name }</h6>
									<span>$${item.price }</span>
								</div>
							</a>
							<c:if test="${(loop.index+1)%3==0||loop.index+1==bestSeller.size() }">
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Latest Product Section End -->
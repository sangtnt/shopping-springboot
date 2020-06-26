<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Hero Section Begin -->
<section class="hero hero-normal">
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="hero__categories">
					<div class="hero__categories__all">
						<i class="fa fa-bars"></i> <span>All departments</span>
					</div>
					<ul>
						<c:forEach var="cat" items="${cats }">
							<li><a href="/product?catId=${cat.id }">${cat.name }</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="col-lg-9">
				<div class="hero__search">
					<div class="hero__search__form">
						<form action="/product/search" method="GET">
							<div class="hero__search__categories">
								All Categories<!--  <span class="arrow_carrot-down"></span> -->
							</div>
							<input name="name" type="text" placeholder="What do you need?" required>
							<button type="submit" class="site-btn">SEARCH</button>
						</form>
					</div>
					<div class="hero__search__phone">
						<div class="hero__search__phone__icon">
							<i class="fa fa-phone"></i>
						</div>
						<div class="hero__search__phone__text">
							<h5>+65 11.188.888</h5>
							<span>support 24/7 time</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Hero Section End -->
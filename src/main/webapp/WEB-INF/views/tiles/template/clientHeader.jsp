<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Humberger Begin -->
<div class="humberger__menu__overlay"></div>
<div class="humberger__menu__wrapper">
	<div class="humberger__menu__logo">
		<a href="/"><img src="/resources/static/img/logo2.png" alt=""
			height="50px"></a>
	</div>
	<div class="humberger__menu__cart">
		<ul>
			<li><a href="/auth/viewProLike"><i class="fa fa-heart"></i> <span>${sessionScope.likes }</span></a></li>
			<li><a href="/auth/viewCart"><i class="fa fa-shopping-bag"></i> <span>${sessionScope.cartItems }</span></a></li>
		</ul>
	</div>
	<div class="humberger__menu__widget">
		<!-- <div class="header__top__right__language">
			<img src="/resources/static/img/language.png" alt="">
			<div>English</div>
			<span class="arrow_carrot-down"></span>
			<ul>
				<li><a href="#">Spanis</a></li>
				<li><a href="#">English</a></li>
			</ul>
		</div> -->
		<div class="header__top__right__auth">
			<c:if test="${sessionScope.user==null }">
				<a href="/login"><i class="fa fa-user"></i> Login</a>
			</c:if>
			<c:if test="${sessionScope.user!=null }">
				<a href="/logout"><i class="fas fa-sign-out-alt"></i>Logout</a>
			</c:if>
		</div>
	</div>
	<nav class="humberger__menu__nav mobile-menu">
		<ul>
			<li class="header-home"><a href="/">Home</a></li>
			<li class="header-order"><a href="/order">Your Orders</a></li>
		</ul>
	</nav>
	<div id="mobile-menu-wrap"></div>
	<div class="header__top__right__social">
		<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
			class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-linkedin"></i></a>
		<a href="#"><i class="fa fa-pinterest-p"></i></a>
	</div>
	<div class="humberger__menu__contact">
		<ul>
			<li>
				<c:if test="${sessionScope.user!=null }">
					<a href=""><i class="fa fa-user"></i>
						${sessionScope.user.username }</a>
				</c:if>
			</li>
			<li><i class="fa fa-user"></i><a href="#">Seller</a></li>
		</ul>
	</div>
</div>
<!-- Humberger End -->

<!-- Header Section Begin -->
<header class="header">
	<div class="header__top">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="header__top__left">
						<ul>
							<c:if test="${sessionScope.user!=null }">
								<li>
									<a href="">
										<i class="fa fa-user"></i>${sessionScope.user.username }
									</a>
								</li>
							</c:if>
							<li><i class="fa fa-user"></i><a class="seller-link"
								href="#">Seller</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="header__top__right">
						<div class="header__top__right__social">
							<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
								class="fa fa-twitter"></i></a> <a href="#"><i
								class="fa fa-linkedin"></i></a> <a href="#"><i
								class="fa fa-pinterest-p"></i></a>
						</div>
						<!-- <div class="header__top__right__language">
							<img src="/resources/static/img/language.png" alt="">
							<div>English</div>
							<span class="arrow_carrot-down"></span>
							<ul>
								<li><a href="#">Spanis</a></li>
								<li><a href="#">English</a></li>
							</ul>
						</div> -->
						<div class="header__top__right__auth">
							<c:if test="${sessionScope.user==null }">
								<a href="/login"><i class="fa fa-user"></i> Login</a>
							</c:if>
							<c:if test="${sessionScope.user!=null }">
								<a href="/logout"><i class="fas fa-sign-out-alt"></i>Logout</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="header__logo">
					<a href="/"><img src="/resources/static/img/logo2.png" alt=""></a>
				</div>
			</div>
			<div class="col-lg-6">
				<nav class="header__menu">
					<ul>
						<li class="header-home"><a href="/">Home</a></li>
						<li class="header-order"><a href="/order">Your Orders</a></li>
					</ul>
				</nav>
			</div>
			<div class="col-lg-3">
				<div class="header__cart">
					<ul>
						<li><a href="/auth/viewProLike"><i class="fa fa-heart"></i> <span>${sessionScope.likes }</span></a></li>
						<li><a href="/auth/viewCart"><i
								class="fa fa-shopping-bag"></i>
									<span>${sessionScope.cartItems }</span></a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="humberger__open">
			<i class="fa fa-bars"></i>
		</div>
	</div>
</header>
<!-- Header Section End -->
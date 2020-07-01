<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="featured spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title">
					<h2>My Favorite Product</h2>
				</div>
				<div class="featured__controls">
					<ul>
						<li class="active" data-filter="*">All</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row featured__filter">
			<c:forEach var="item" items="${pros }">
				<div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
					<div class="featured__item">
						<div class="featured__item__pic set-bg"
							data-setbg="${item.image }">
							<ul class="featured__item__pic__hover">
								<li><a href="/auth/like?proId=${item.id }"><i
										class="fa fa-heart"></i></a> </li>
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
								<a href="/product/proDetail?proId=${item.id }">${item.name }</a>
							</h6>
							<c:if test="${item.discount>0 }">
								<h5 class="outer">
									<span class="inner">$${item.price }</span>
								</h5>
								<h5>$${item.getDiscountPrice() }</h5>
							</c:if>
							<c:if test="${item.discount==0 || item.discount==null}">
								<h5>$${item.price }</h5>
							</c:if>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</section>
<!-- Featured Section End -->
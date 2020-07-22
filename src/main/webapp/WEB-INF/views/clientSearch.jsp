<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="featured spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title">
					<h2>Results of "<span style="color: red">${name }</span>"</h2>
				</div>
			</div>
		</div>
		<div class="row featured__filter">
			<c:forEach var="pro" items="${pros }">
				<div class="col-lg-3 col-md-4 col-sm-6">
					<div class="featured__item">
						<div class="featured__item__pic set-bg" data-setbg="">
						<a href="/product/proDetail?proId=${pro.id }"><img src="${pro.images.get(0).image }"></a>
							<ul class="featured__item__pic__hover">
								<li><a href="/auth/like?proId=${pro.id }"><i
										class="fa fa-heart"></i></a></li>
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
							<c:if test="${pro.discount>0 }">
								<h5 class="outer">
									<span class="inner">$${pro.price }</span>
								</h5>
								<h5>$${pro.getDiscountPrice() }</h5>
							</c:if>
							<c:if test="${pro.discount==0 || pro.discount==null}">
								<h5>$${pro.price }</h5>
							</c:if>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</section>
<!-- Featured Section End -->
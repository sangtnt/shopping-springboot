<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-fluid">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1>Profile</h1>
				</div>
			</div>
		</div>
		<!-- /.container-fluid -->
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3">

					<!-- Profile Image -->
					<div class="card card-primary card-outline">
						<div class="card-body box-profile">
							<div class="text-center">
								<img class="profile-user-img img-fluid img-circle"
									src="${user.image }" alt="User profile picture">
							</div>

							<h3 class="profile-username text-center">${user.fullname }</h3>
							<ul class="list-group list-group-unbordered mb-3">
								<li class="list-group-item"><b>Products</b> <a
									class="float-right">${user.products.size() }</a></li>
								<li class="list-group-item"><b>Reports</b> <a
									class="float-right">${user.reviews.size() }</a></li>
							</ul>
						</div>
						<!-- /.card-body -->
					</div>
					<!-- /.card -->
				</div>
				<!-- /.col -->
				<div class="col-md-9">
					<div class="card">
						<div class="card-header p-2">
							<ul class="nav nav-pills">
								<li class="nav-item"><a class="nav-link active"
									href="#activity" data-toggle="tab">Products</a></li>
							</ul>
						</div>
						<!-- /.card-header -->
						<div class="card-body">
							<div class="tab-content">
								<div class="active tab-pane" id="activity">
									<div class="container-fluid">
										<div class="row">
											<c:forEach var="pro" items="${user.products }">
												<div class="col-lg-3 col-md-4 col-sm-6">
													<div class="featured__item">
														<div class="featured__item__pic set-bg">
															<a href="/product/proDetail?proId=${pro.id }"> <img
																src="${pro.images.get(0).image }" height="100%"
																class="col-lg-12">
															</a>
															<ul class="featured__item__pic__hover">
																<li><a href="#"><i class="fa fa-heart"></i></a></li>
																<li>
																	<form action="/auth/addToCart" method="post">
																		<input name="quantity" value="1" type="hidden">
																		<input name="proId" value="${pro.id }" type="hidden">
																		<a><i class="addToCart fa fa-shopping-cart"></i></a>
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
								</div>
							</div>
							<!-- /.tab-content -->
						</div>
						<!-- /.card-body -->
					</div>
					<!-- /.card -->
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</section>
	<!-- /.content -->
</div>
<!-- ./wrapper -->

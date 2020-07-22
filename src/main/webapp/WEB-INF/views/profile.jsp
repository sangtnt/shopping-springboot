<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<!--  This file has been downloaded from https://bootdey.com  -->
<!--  All snippets are MIT license https://bootdey.com/license -->
<title>ShelMark</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/resources/static/css/bootstrap.min.css" rel="stylesheet">

<link href="/resources/static/css/font-awesome.min.css" rel="stylesheet">
<style type="text/css">
body {
	margin-top: 20px;
	background: #f8f8f8
}

#myfile {
	display: none;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row flex-lg-nowrap">

			<div class="col">
				<div class="row">
					<div class="col mb-3">
						<div class="card">

							<form class="form" action="/user/editProfile" method="post"  enctype="multipart/form-data">
								<div class="card-body">
									<div class="e-profile">
										<div class="row">
											<div class="col-12 col-sm-auto mb-3">
												<img id="catImg" alt="Add avatar" src="${user.image }"
													height="140px" width="140px" />
											</div>
											<div
												class="col d-flex flex-column flex-sm-row justify-content-between mb-3">
												<div class="text-center text-sm-left mb-2 mb-sm-0">
													<h4 class="pt-sm-2 pb-1 mb-0 text-nowrap">${user.fullname }</h4>
													<p class="mb-0">@${user.username }</p>
													<div class="mt-2">
														<label class="btn btn-primary"> <i
															class="fa fa-fw fa-camera"></i> <span>Change Photo</span>
															<input name="file" id="myfile" type="file">
														</label>
													</div>
												</div>
												<div class="text-center text-sm-right">
													<span class="badge badge-secondary">administrator</span>
													<div class="text-muted">
														<small>Joined ${user.date }</small>
													</div>
												</div>
											</div>
										</div>
										<ul class="nav nav-tabs">
											<li class="nav-item"><a href="" class="active nav-link">Settings</a></li>
										</ul>
										<div class="tab-content pt-3">
											<div class="tab-pane active">
												<div class="row">
													<div class="col">
														<div class="row">
															<div class="col">
																<div class="form-group">
																	<label>Full Name</label> <input class="form-control"
																		type="text" name="fullname" value="${user.fullname }" required>
																</div>
															</div>
														</div>
														<div class="row">
															<div class="col">
																<div class="form-group">
																	<label>Email</label> <input name="email"
																		class="form-control" type="email"
																		value="${user.email }" required>
																</div>
															</div>
														</div>
														<div class="row">
															<div class="col">
																<div class="form-group">
																	<label>Phone</label> <input class="form-control"
																		type="text" name="phone" value="${user.phone }" required>
																</div>
															</div>
															<div class="col">
																<div class="form-group">
																	<label>Address</label> <input class="form-control"
																		type="text" name="address" value="${user.address }" required>
																</div>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col d-flex justify-content-end">
														<button class="btn btn-primary" type="submit">Save
															Changes</button>
														<a href="/back">
															<button class="btn btn-dark" type="button">Back</button>
														</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>

					<div class="col-12 col-md-3 mb-3">
						<div class="card mb-3">
							<div class="card-body">
								<div class="px-xl-3">
									<a href="/logout">
										<button class="btn btn-block btn-secondary">
											<i class="fa fa-sign-out"></i> <span>Logout</span>
										</button>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<script src="/resources/static/js/jquery.min.js"></script>
	<script src="/resources/static/js/bootstrap.min.js"></script>
	<script>
		$('#myfile').change(function() {
			var input = this;
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#catImg').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		})
	</script>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid">
	<form enctype="multipart/form-data" action="/admin/user/createUser" method="post">
		<div class="form-group">
			<label for="username">User Name</label> <input type="text"
				class="form-control" name="username" />
		</div>

		<div class="form-group">
			<label for=password>Password</label> <input type="password"
				class="form-control" name="password" />
		</div>

		<div class="form-group">
			<label for="email">Email</label> <input type="text"
				class="form-control" name="email" />
		</div>

		<div class="form-group">
			<label for="phone">Phone</label> <input type="text"
				class="form-control" name="phone" />
		</div>

		<div class="form-group">
			<label for="gender">Gender</label> <select class="form-control"
				name="gender">
				<option value="male">Male</option>
				<option value="female">Female</option>
			</select>
		</div>
		<div class="form-group">
			<label for="address">Address</label> <input type="text"
				class="form-control" name="address" />
		</div>
		<div class="form-group">
			<label>Image</label> <input name="file" id="myfile" type="file"
				class="form-control">
		</div>
		<div class="form-group">
			<img id="catImg" alt="Add avatar" src="" height="200px" />
		</div>
		<button type="submit" class="btn btn-primary">Finish</button>
		<a href="/admin/user" class="btn btn-danger">Cancel</a>
	</form>
</div>
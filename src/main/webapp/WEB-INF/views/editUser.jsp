<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid">
	<h2>Edit User</h2>
	<form enctype="multipart/form-data" action="/admin/user/editUser" method="post">
		<div class="form-group">
			<label for="username">User Name</label>
			<input value="${user.username }" type="text" class="form-control" name="username" readonly/>
		</div>
		<div class="form-group">
			<label for="email">Email</label>
			<input value="${user.email }" type="email" class="form-control" name="email" />
		</div>
		<div class="form-group">
			<label for="phone">Phone</label>
			<input value="${user.phone }" type="text" class="form-control" name="phone" />
		</div>
		<div class="form-group">
			<label for="phone">Full Name</label>
			<input value="${user.fullname }" type="text" class="form-control" name="fullname" />
		</div>
		<div class="form-group">
			<label for="gender">Gender</label> <select class="form-control"
				name="gender" required>
				<c:if test="${user.gender.equals('male') }">
					<option value="male" selected>Male</option>
					<option value="female">Female</option>
				</c:if>
				<c:if test="${!user.gender.equals('male') }">
					<option value="male">Male</option>
					<option value="female" selected>Female</option>
				</c:if>
			</select>
		</div>
		<div class="form-group">
			<label for="pers">Permission</label> <select multiple class="form-control"
				name="pers" required>
				<c:forEach var="per" items="${pers }">
					<c:if test="${user.getPermissions().contains(per) }">
						<option value="${per.id }" selected>${per.permissionName }</option>
					</c:if>
					<c:if test="${!user.getPermissions().contains(per) }">
						<option value="${per.id }">${per.permissionName }</option>
					</c:if>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="address">Address</label>
			<input value="${user.address }" type="text" class="form-control" name="address" />
		</div>
		<div class="form-group">
			<label>Image</label> <input name="file" id="myfile" type="file"
				class="form-control">
		</div>
		<div class="form-group">
			<img id="catImg" alt="Add avatar" src="${user.image }" height="200px" />
		</div>
		<button type="submit" class="btn btn-primary">Edit</button>
		<a href="/admin/user">
			<button type="button" class="btn btn-danger">Cancel</button>
		</a>
	</form>
</div>
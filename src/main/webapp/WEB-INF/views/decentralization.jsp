<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Begin Page Content -->
<div class="container-fluid">
	<form action="/admin/user/addPermission" method="POST">
		<div class="form-group">
			<label>Username</label> <input name="username" type="text"
				class="form-control" id="exampleInputEmail1" value="${user.username }"
				readonly>
		</div>
		<div class="form-group">
			<label for="exampleFormControlSelect2">Select Permissions</label> <select name="per" multiple class="form-control"
				id="exampleFormControlSelect2">
				<c:forEach var="item" items="${pers }">
					<c:if test="${user.permissions.contains(item) }">
						<option value="${item.id }" selected>${item.permissionName }</option>
					</c:if>
					<c:if test="${!user.permissions.contains(item) }">
						<option value="${item.id }">${item.permissionName }</option>
					</c:if>
				</c:forEach>
			</select>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
		<a href="/admin/user"><button type="button" class="btn btn-danger">Cancel</button></a>
	</form>
</div>
<!-- /.container-fluid -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Begin Page Content -->
<div class="container-fluid">
	<form action="/admin/product/addPro" method="POST"
		enctype="multipart/form-data">
		<input name="proId" type="hidden">
		<div class="form-group">
			<label>Name</label> <input name="proName" type="text"
				class="form-control" id="exampleInputEmail1" required>
		</div>
		<div class="form-group">
			<label>Description</label> <input name="proDescription" type="text"
				class="form-control" id="exampleInputEmail1" required>
		</div>
		<div class="form-group">
			<label>Price</label> <input name="proPrice" type="text"
				class="form-control" id="exampleInputEmail1" required>
		</div>
		<div class="form-group">
			<label>Quantity</label> <input name="proQuantity" type="text"
				class="form-control" id="exampleInputEmail1" required>
		</div>
		<div class="form-group">
			<label>Shipping</label> <input name="proShipping" type="text"
				class="form-control" id="exampleInputEmail1" required>
		</div>
		<div class="form-group">
			<label>Brand</label> <input name="proBrand" type="text"
				class="form-control" id="exampleInputEmail1" required>
		</div>
		<div class="form-group">
			<label>Origin</label> <input name="proOrigin" type="text"
				class="form-control" id="exampleInputEmail1" required>
		</div>
		<div class="form-group">
			<label for="exampleFormControlSelect1">Category</label> <select
				name="catId" class="form-control" id="exampleFormControlSelect1"
				required>
				<c:forEach var="item" items="${cats}">
					<c:if test="${item.id == pro.cat.id}">
						<option value="${item.id }" selected>${item.name }</option>
					</c:if>
					<c:if test="${item.id != pro.cat.id}">
						<option value="${item.id }">${item.name }</option>
					</c:if>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="exampleFormControlSelect1">Discount</label> 
			<select name="discount" class="form-control" id="exampleFormControlSelect1" required>
				<c:forEach var="count" begin="0" end="100">
					<c:if test="${count==pro.discount}">
						<option value="${count}" selected>${count}%</option>
					</c:if>
					<c:if test="${count!=pro.discount }">
						<option value="${count}">${count}%</option>
					</c:if>
				</c:forEach>
			</select>
		</div>
		<div id="file-group" class="form-group">
			<label>Image</label> <input name="file" id="myProFile" type="file"
				class="form-control" multiple required>
		</div>
		<div id="img-group" class="form-group">
			<c:forEach var="image" items="${pro.images }">
				<img src="${image.image }" height="200px" />
			</c:forEach>
		</div>
		<button type="submit" class="btn btn-primary">Add</button>
		<a href="/admin/product"><button type="button"
				class="btn btn-danger">Cancel</button></a>
	</form>
</div>
<!-- /.container-fluid -->
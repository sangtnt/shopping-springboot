
<!-- Begin Page Content -->
<div class="container-fluid">
	<form action="/admin/category/editCat" method="POST" enctype="multipart/form-data">
		<input name="catId" type="hidden" value="${cat.id }">
		<div class="form-group">
			<label>Name</label> <input name="catName" type="text"
				class="form-control" id="exampleInputEmail1" value="${cat.name }">
		</div>
		<div class="form-group">
			<label>Image</label> <input name="file" id="myfile" type="file"
				class="form-control">
		</div>
		<div class="form-group">
			<img id="catImg" src="${cat.image }" height="200px" />
		</div>
		<button type="submit" class="btn btn-primary">Edit</button>
		<a href="/category"><button type="button" class="btn btn-danger">Cancel</button></a>
	</form>
</div>
<!-- /.container-fluid -->

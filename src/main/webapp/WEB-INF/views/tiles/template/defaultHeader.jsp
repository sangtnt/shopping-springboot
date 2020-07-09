<!-- Sidebar -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="/">
		<div class="sidebar-brand-icon">
			<img height="50px" width="50px" src="/resources/static/img/Logo.png" />
		</div>
		<div class="sidebar-brand-text mx-3">ShelMark Admin</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li id="dashboard" class="nav-item"><a class="nav-link" href="/admin"> <i
			class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span></a></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Management</div>

	<!-- Nav Item - Pages Collapse Menu -->
	<c:forEach var="per" items="${userPers}">
		<c:if test="${per.permissionName.equals('PRODUCT MANAGER') }">
			<li id="category" class="nav-item"><a class="nav-link" href="/admin/category"> <i
				class="fas fa-dice-d6"></i> <span>Categories</span>
			</a></li>
			<li id="product" class="nav-item"><a class="nav-link" href="/admin/product"> <i
			class="fas fa-boxes"></i> <span>Products</span>
			</a></li>
		</c:if>
		<c:if test="${per.permissionName.equals('ADMIN') }">
			<li id="user" class="nav-item"><a class="nav-link" href="/admin/user">
				<i class="fas fa-address-card"></i> <span>Users</span>
			</a></li>
			<li id="permission" class="nav-item"><a class="nav-link" href="/admin/permission">
				<i class="fas fa-users"></i> <span>Permissions</span>
			</a></li>
		</c:if>
		<c:if test="${per.permissionName.equals('ORDER MANAGER') }">
			<li id="order" class="nav-item"><a class="nav-link" href="/admin/order"> <i
				class="fas fa-clipboard-list"></i> <span>Orders</span>
			</a></li>
		</c:if>
	</c:forEach>
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

</ul>
<!-- End of Sidebar -->

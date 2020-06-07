<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>
	<!-- Google Font -->
    <link href="<c:url value='https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap'/>" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="<c:url value='/resources/static/css/bootstrap.min.css'/>" type="text/css">
	<link rel="stylesheet" href="<c:url value='/resources/static/css/font-awesome.min.css'/>" type="text/css">
	<link rel="stylesheet" href="<c:url value='/resources/static/css/elegant-icons.css'/>" type="text/css">
    <link rel="stylesheet" href="<c:url value='/resources/static/css/nice-select.css'/>" type="text/css">
    <link rel="stylesheet" href="<c:url value='/resources/static/css/jquery-ui.min.css'/>" type="text/css">
    <link rel="stylesheet" href="<c:url value='/resources/static/css/owl.carousel.min.css'/>" type="text/css">
    <link rel="stylesheet" href="<c:url value='/resources/static/css/slicknav.min.css'/>" type="text/css">
    <link rel="stylesheet" href="<c:url value='/resources/static/css/style.css'/>" type="text/css">
</head>
<body>
	<!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>
    <tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="menu" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
	
	<script src="<c:url value='/resources/static/js/jquery-3.3.1.min.js'/>"></script>
    <script src="<c:url value='/resources/static/js/bootstrap.min.js'/>"></script>
    <script src="<c:url value='/resources/static/js/jquery.nice-select.min.js'/>"></script>
    <script src="<c:url value='/resources/static/js/jquery-ui.min.js'/>"></script>
    <script src="<c:url value='/resources/static/js/jquery.slicknav.js'/>"></script>
    <script src="<c:url value='/resources/static/js/owl.carousel.min.js'/>"></script>
    <script src="<c:url value='/resources/static/js/main.js'/>"></script>
</body>
</html>
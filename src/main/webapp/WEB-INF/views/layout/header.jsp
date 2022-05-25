<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<fmt:setLocale value='<%=request.getParameter("language") %>'/>
<fmt:setBundle basename="bundle.message" var="resourceBundle"/>
<nav class="navbar navbar-expand navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="../webmarket/home">Home</a>
			<a class="navbar-brand" href="../webmarket/findAll"><fmt:message key="products" bundle="${resourceBundle}"/></a>
			<a class="navbar-brand" href="../webmarket/add"><fmt:message key="title" bundle="${resourceBundle}"/></a>
			<a href="?language=ko">Korean</a>|<a href="?language=en">English</a>
		</div>
	</div>
</nav>

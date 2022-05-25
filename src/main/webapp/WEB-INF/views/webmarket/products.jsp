<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../layout/header.jsp" %>
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">상품 목록</h1>
	</div>
</div>
<div class="container">
	<div class="row" align="center">
		<c:forEach items="${products}" var="products">
			<div class="col-md-4">
				<img src="${pageContext.request.contextPath}/upload/${products.filename}" style="width: 100%">
				<h3>${products.pname}</h3>
				<p>${products.description}</p>
				<p>${products.unitprice}원</p>
				<p><a href="findById?id=${products.productId}" class="btn btn-secondary" role="button">상세 정보 &raquo;</a></p>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>
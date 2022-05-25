<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<h1 class="display-3">상세 정보</h1>
	</div>
</div>
<div class="container">
	<div class="row">
			<c:if test="${not empty product}">
				<div class="col-md-5">
					<img src="${pageContext.request.contextPath}/upload/${product.filename}" style="width: 100%">
				</div>
				<div class="col-md-6">
					<h3>${product.pname}</h3>
					<p>${product.description} </p>
					<p> <b>상품코드 :</b> <span class="badge badge-danger">${product.productId}</span> </p>
					<p> <b>제조사 : ${product.manufacturer }</b> </p>
					<p> <b>분류 : ${product.category }</b> </p>
					<p> <b>제고 수 : ${product.unitsInStock }</b> </p>
					<h4>${product.unitprice}원</h4>
					<p> <a href="#" class="btn btn-info">상품 주문 &raquo;</a> </p>
					<p> <a href="findAll" class="btn btn-secondary">상품 목록 &raquo;</a> </p>
				</div>
			</c:if>
			<c:if test="${empty product}">
				<p>존재하지 않는 상품입니다
			</c:if>
	</div>
</div>
</body>
</html>
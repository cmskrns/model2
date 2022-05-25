<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/validation.js"></script>
</head>
<body>
<%@ include file="../layout/header.jsp" %>
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3"><fmt:message key="title" bundle="${resourceBundle}"/></h1>
	</div>
</div>
<div class="container">
	<form name="newProduct" class="form-horizontal" action="${pageContext.request.contextPath}/webmarket/add" method="post" enctype="multipart/form-data">
		<div class=" form-group row">
			<label class="col-sm-2"><fmt:message key="productId"  bundle="${resourceBundle}"/></label>
			<div class="col-sm-3">
				<input type="text" id="productId" name="productId" class="form-control">
			</div>
		</div>
		<div class=" form-group row">
			<label class="col-sm-2"><fmt:message key="pname"  bundle="${resourceBundle}"/></label>
			<div class="col-sm-3">
				<input type="text" id="name" name="pname" class="form-control">
			</div>
		</div>
		<div class=" form-group row">
			<label class="col-sm-2"><fmt:message key="unitprice"  bundle="${resourceBundle}"/></label>
			<div class="col-sm-3">
				<input type="text" id="unitPrice" name="unitprice" class="form-control">
			</div>
		</div>
		<div class=" form-group row">
			<label class="col-sm-2"><fmt:message key="description"  bundle="${resourceBundle}"/></label>
			<div class="col-sm-5">
				<textarea cols="50" rows="2" name="description" class="form-control"></textarea>
			</div>
		</div>
		<div class=" form-group row">
			<label class="col-sm-2"><fmt:message key="manufacturer"  bundle="${resourceBundle}"/></label>
			<div class="col-sm-3">
				<input type="text" name="manufacturer" class="form-control">
			</div>
		</div>
		<div class=" form-group row">
			<label class="col-sm-2"><fmt:message key="category"  bundle="${resourceBundle}"/></label>
			<div class="col-sm-3">
				<input type="text" name="category" class="form-control">
			</div>
		</div>
		<div class=" form-group row">
			<label class="col-sm-2"><fmt:message key="unitsInStock"  bundle="${resourceBundle}"/></label>
			<div class="col-sm-3">
				<input type="text" id="unitInStock" name="unitsInStock" class="form-control">
			</div>
		</div>
		<div class=" form-group row">
			<label class="col-sm-2">><fmt:message key="condition"  bundle="${resourceBundle}"/></label>
			<div class="col-sm-3">
				<input type="radio" name="condition" value="New"><fmt:message key="condition_New"  bundle="${resourceBundle}"/>
				<input type="radio" name="condition" value="Old"><fmt:message key="condition_Old"  bundle="${resourceBundle}"/>
				<input type="radio" name="condition" value="Refurbished"><fmt:message key="condition_Refurbished"  bundle="${resourceBundle}"/>
			</div>
		</div>
		<div class=" form-group row">
			<label class="col-sm-2"><fmt:message key="productImage"  bundle="${resourceBundle}"/></label>
			<div class="col-sm-5">
				<input type="file" name="filename" class="form-control">
			</div>
		</div>
		<div class=" form-group row">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="button" class="btn btn-primary" value="<fmt:message key="button"  bundle="${resourceBundle}"/>" onclick="CheckAddProduct()">
			</div>
		</div>
	</form>
</div>
</body>
</html>
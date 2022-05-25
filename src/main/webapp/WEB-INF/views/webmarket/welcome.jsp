
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<%!
	String greeting = "웹 쇼핑몰에 오신 것을 환영합니다";
	String tegline = "Welcom to Web market!";
%>

<div class="jumbotron">
	<div class="container">
		<h1 class="display-3"><%= greeting %></h1>
	</div>
</div>
<div class="container">
	<div class="text-center">
		<h3><%= tegline %></h3>
	</div>
</div>
<%@ include file="../layout/footer.jsp" %>
</body>
</html>
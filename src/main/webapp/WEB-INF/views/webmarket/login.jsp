<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/webmarket/login" method="post">
<input type="text" name="id">
<input type="text" name="password">
<button>확인</button>
</form>
</body>
</html>
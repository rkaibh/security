<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<form action="/web/security_check" method="post">
		<c:if test="${param.error != null }">
			<p>
				Login Error<br>
				<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null }">
					message : <c:out value="${SPRING_SECURITY_LAST_EXCEPTION != null }">
				</c:out>
				</c:if>
			</p>
		</c:if>
		<p>UserID : <input type="text" name="userId"></p>
		<p>UserPW : <input type="password" name="userPw"></p>
		<button type="submit">로그인</button>
		<a href="/web/signup">회원가입</a>
	</form>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<s:authorize access="isAuthenticated()"> <!-- 인증한 사용자 -->
	<s:authentication property="name"/>
	<a href="security_logout">로그아웃</a>
</s:authorize>

<s:authorize access="hasRole('ROLE_ADMIN')"> <!-- 권한별 화면 처리 -->
	<p>관리자</p>
</s:authorize>

<s:authorize access="isAnonymous()"> <!-- 익명 사용자 -->
	<p>익명임</p>
	<a href="login">로그인</a>
</s:authorize>
</body>
</html>

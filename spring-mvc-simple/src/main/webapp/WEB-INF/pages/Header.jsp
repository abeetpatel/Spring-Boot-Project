<%@page import="com.rays.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty sessionScope.user}">
		<h3>
			<s:message code="header.hii"></s:message>
			,
			<c:out value="${sessionScope.user.firstName}"></c:out>
		</h3>
		<a href="<c:url value="?lang=en"/>"><b><s:message
					code="header.english" /></b></a> | <a href="<c:url value="?lang=hi"/>"><b><s:message
					code="header.hindi" /></b> </a> |
		<a href="<c:url value="/ctl/User"/>"><b><s:message
					code="header.addUser"></s:message></b></a> | <a
			href="<c:url value="/ctl/User/search"/>"><b><s:message
					code="header.userList"></s:message></b></a> | <a
			href="<c:url value="/Login?operation=logout"/>"><b><s:message
					code="header.logout"></s:message></b></a>
	</c:if>
	<c:if test="${empty sessionScope.user}">
		<h3>
			<s:message code="header.hii"></s:message>
			,
			<s:message code="header.guest" />
		</h3>
		<a href="<c:url value="Welcome"/>"><b><s:message
					code="header.welcome" /></b></a>
		<b>|</b>
		<a href="<c:url value="Login"/>"><b><s:message
					code="header.login" /></b></a>
		<b>|</b>
		<a href="<c:url value="?lang=en"/>"><b><s:message
					code="header.english" /></b></a>
		<b>|</b>
		<a href="<c:url value="?lang=hi"/>"><b><s:message
					code="header.hindi" /></b> </a>
	</c:if>
	<hr>
</body>
</html>
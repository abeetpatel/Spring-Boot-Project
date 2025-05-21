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
	<%-- <%@ include file="Header.jsp"%> --%>
	<sf:form method="post" modelAttribute="form">
		<div align="center">
			<h1 style="color: navy">
				<s:message code="user.label.login" />
			</h1>
			<H3 align="center">
				<c:if test="${not empty error}">${error}</c:if>
			</H3>
			<table>
				<tr>
					<th align="left"><s:message code="user.label.loginId" /> :</th>
					<td><sf:input path="login" /></td>
					<td><sf:errors path="login"></sf:errors></td>
				</tr>
				<tr>
					<th align="left"><s:message code="user.label.password" /> :</th>
					<td><sf:input path="password" /></td>
					<td><sf:errors path="password"></sf:errors></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<s:message code="button.signIn" />"> <input
						type="submit" name="operation"
						value="<s:message code="button.signUp" />"></td>
				</tr>
			</table>
		</div>
	</sf:form>
	<%-- <%@ include file="Footer.jsp"%> --%>
</body>
</html>
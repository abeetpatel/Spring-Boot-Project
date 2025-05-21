<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- <%@ include file="Header.jsp"%> --%>
	<sf:form method="post" modelAttribute="form">
		<div align="center">

			<c:if test="${form.id>0}">
				<h1 style="color: navy">
					<s:message code="user.label.updateUser" />
				</h1>
			</c:if>
			<c:if test="${form.id==0}">
				<h1 style="color: navy">
					<s:message code="user.label.addUser" />
				</h1>
			</c:if>
			<table>
				<tr>
					<th align="left"><s:message code="user.label.firstName" /> :</th>
					<td><sf:input path="firstName" /></td>
				</tr>
				<tr>
					<th align="left"><s:message code="user.label.lastName" /> :</th>
					<td><sf:input path="lastName" /></td>
				</tr>
				<tr>
					<th align="left"><s:message code="user.label.login" /> :</th>
					<td><sf:input path="login" /></td>
				</tr>
				<tr>
					<th align="left"><s:message code="user.label.password" /> :</th>
					<td><sf:input path="password" /></td>
				</tr>
				<tr>
					<th align="left"><s:message code="user.label.dob" /> :</th>
					<td><sf:input path="dob" /></td>
				</tr>
				<tr>
					<th align="left"><s:message code="user.label.address" /> :</th>
					<td><sf:input path="address" /></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<s:message code="button.save" />"></td>
				</tr>
			</table>
		</div>
	</sf:form>
	<%-- <%@ include file="Footer.jsp"%> --%>
</body>
</html>
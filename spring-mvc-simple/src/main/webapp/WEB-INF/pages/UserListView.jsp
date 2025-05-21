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
			<h1 style="color: navy">
				<s:message code="user.label.userList" />
			</h1>
		</div>
		<sf:hidden path="pageNo" />
		<table>
			<tr>
				<td><sf:input path="firstName" />&nbsp; &nbsp;</td>
				<td><sf:select path="id">
						<sf:option value="0">-----------select------------</sf:option>
						<sf:options items="${userList}" itemValue="id"
							itemLabel="firstName" />
					</sf:select>&nbsp; &nbsp;</td>
				<td><input type="submit" name="operation"
					value="<s:message code="button.search" />"><input type="submit" name="operation"
					value="<s:message code="button.reset" />"></td>
			</tr>
		</table>
		<br>
		<table style="width: 100%" border="1">
			<tr>
				<th>Select</th>
				<th>ID</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Login</th>
				<th>Password</th>
				<th>DOB</th>
				<th>Address</th>
				<th>Edit</th>
			</tr>
			<c:forEach items="${list}" var="user">
				<tr>
					<td align="center"><sf:checkbox path="ids" value="${user.id}" /></td>
					<td align="center"><c:out value="${user.id }"></c:out></td>
					<td align="center"><c:out value="${user.firstName }"></c:out></td>
					<td align="center"><c:out value="${user.lastName }"></c:out></td>
					<td align="center"><c:out value="${user.login }"></c:out></td>
					<td align="center"><c:out value="${user.password }"></c:out></td>
					<td align="center"><c:out value="${user.dob }"></c:out></td>
					<td align="center"><c:out value="${user.address }"></c:out></td>
					<td align="center"><a
						href="<c:url value="/User?id=${user.id}" />">edit</a></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<table style="width: 100%">
			<tr>
				<td style="width: 30%"><input type="submit" name="operation"
					value="<s:message code="button.previous" />"
					${form.pageNo == 1 ? 'disabled="disabled"' : ''} /></td>
				<td style="width: 30%"><input type="submit" name="operation"
					value="<s:message code="button.add" />"></td>
				<td style="width: 25%"><input type="submit" name="operation"
					value="<s:message code="button.delete" />"></td>
				<td style="text-align: right;"><input type="submit"
					name="operation" value="<s:message code="button.next" />"
					${list.size() < 5 ? 'disabled="disabled"' : ''}></td>
			</tr>
		</table>
	</sf:form>
	<%-- <%@ include file="Footer.jsp"%> --%>
</body>
</html>
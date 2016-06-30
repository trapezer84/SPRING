<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib 	prefix="c"
			uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

	<form name="loginForm" id="loginForm"
			method="post" action="<c:url value="/doLogin"/>" >
		<table style="width: 100%;">
			<c:if test="${ not empty error }">
				<tr>
					<td colspan="2">
						<c:out value="${ error }" />
					</td>
				</tr>
			</c:if>
			<tr>
				<td>ID</td>
				<td>
					<input type="text" name="emailId" id="emailId" />
				</td>
			</tr>
			<tr>
				<td>PASSWORD</td>
				<td>
					<input type="password" name="password" id="password" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인" id="loginBtn" />
				</td>
			</tr>
		</table>
	</form>

</body>
</html>

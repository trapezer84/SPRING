<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib 	prefix="c"
			uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
		$(document).ready(function() {
			
			$("#unregistBtn").click(function() {
				
				if(confirm("정말 탈퇴하시겠습니까?")) {
					location.href = "<c:url value="/member/doUnregist"/>";
				}
				
			});
			
		});
	</script>
</head>
<body>
	
	<form 	name="mypageForm" 
			id="mypageForm" 
			method="post" 
			action="<c:url value="/member/doModify" />" >
		<table style="width:100%;">
			<tr>
				<td>Email</td>
				<td>
					<input type="text" id="emailId" name="emailId" value="${userInfo.emailId }" readonly="readonly" />
				</td>
			</tr>
			<tr>
				<td>Nick Name</td>
				<td>
					<input type="text" id="userName" name="userName" value="${userInfo.userName }"/>
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>
					<input type="password" id="password" name="password" value="${userInfo.password }" />
				</td>
			</tr>
			<tr>
				<td>Password Confirm</td>
				<td>
					<input type="password" id="passwordConfirm" name="passwordConfirm" value="${userInfo.password }" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<!-- <input type="button" value="가입" id="registBtn" /> -->
					<input type="submit" value="수정" id="registBtn" />
					<input type="button" value="탈퇴" id="unregistBtn" />
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>
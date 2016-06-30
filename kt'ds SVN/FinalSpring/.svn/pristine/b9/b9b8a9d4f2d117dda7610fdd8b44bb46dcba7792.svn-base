<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib 	prefix="c"
			uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
		var isDuplicateEmailId = false;
		$(document).ready(function() {
			
			$("#registBtn").click(function() {
				if(isDuplicateEmailId) {
					alert("다른 ID를 사용하세요");
					return;
				}
				
				$("#registForm").submit();
			});
			
			$("#emailId").keyup(function() {
				$.post("<c:url value="/member/checkEmailIdDuplicate"/>", {
					"emailId" : $("#emailId").val()
				}, function(data) {
					isDuplicateEmailId = (data == "true");
					if(!isDuplicateEmailId) {
						$("#duplicateId").text("사용할 수 있는 아이디 입니다.");
					}
					else {
						$("#duplicateId").text("이미 사용중인 아이디 입니다.");
					}
				});
			});
		});
	</script>
</head>
<body>

	<form 	name="registForm" 
			id="registForm" 
			method="post" 
			action="<c:url value="/member/doRegist" />" >
		<table style="width:100%;">
			<tr>
				<td>Email</td>
				<td>
					<input type="text" id="emailId" name="emailId" />
					<span id="duplicateId"></span>
				</td>
			</tr>
			<tr>
				<td>Nick Name</td>
				<td>
					<input type="text" id="userName" name="userName" />
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>
					<input type="password" id="password" name="password" />
				</td>
			</tr>
			<tr>
				<td>Password Confirm</td>
				<td>
					<input type="password" id="passwordConfirm" name="passwordConfirm" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="가입" id="registBtn" />
					<!-- <input type="submit" value="가입" id="registBtn" /> -->
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>
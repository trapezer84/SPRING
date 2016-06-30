<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib 	prefix="c"
			uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">

	$(document).ready(function() {
		$("#writeBtn").click(function() {
			
			if( $("#subject").val() == "" ) {
				alert("제목을 입력하세요.");
				return;
			}
			if( $("#content").val() == "" ) {
				alert("내용을 입력하세요.");
				return;
			}
			
			$("#writeForm").attr("action", "<c:url value="/board/doWrite"/>");
			$("#writeForm").attr("method", "POST");
			$("#writeForm").submit();
		});
	});
	
</script>
</head>
<body>
	<form name="writeForm" id="writeForm">
		<table border="1">
			<tr>
				<th>Subject</th>
				<td>
					<input type="text" name="subject" id="subject" />
				</td>
			</tr>
			<tr>
				<th>Content</th>
				<td>
					<textarea rows="10" cols="40" name="content" id="content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="Write" id="writeBtn" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib 	prefix="c"
			uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">

	$(document).ready(function() {
		$("#modifyBtn").click(function() {
			
			if( $("#subject").val() == "" ) {
				alert("제목을 입력하세요.");
				return;
			}
			if( $("#content").val() == "" ) {
				alert("내용을 입력하세요.");
				return;
			}
			
			$("#modifyForm").attr("action", "<c:url value="/board/doModify"/>");
			$("#modifyForm").attr("method", "POST");
			$("#modifyForm").submit();
		});
	});
	
</script>
</head>
<body>
	<form name="modifyForm" id="modifyForm">
		<input type="hidden" name="articleId" id="articleId" value="${originalArticleInfo.articleId }" />
		<input type="hidden" name="isSecret" id="isSecret" value="${originalArticleInfo.isSecret }" />
		<table border="1">
			<tr>
				<th>Subject</th>
				<td>
					<input type="text" name="subject" id="subject" value="${originalArticleInfo.subject }" />
				</td>
			</tr>
			<tr>
				<th>Content</th>
				<td>
					<textarea rows="10" cols="40" name="content" id="content">${originalArticleInfo.content }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="Modify" id="modifyBtn" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib 	prefix="c"
			uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
		$(document).ready(function() {
			
			$("#cancelBtn").hide();
			
			$("#cancelBtn").click(function() {
				$("#replyId").val("");
				$("#content").val("");
				$("#replyBtn").val("등록");
				
				$(this).hide();
			});
			
			$(".delete").click(function() {
				
				if(confirm("정말 삭제할까요?")) {
					var replyId = $(this).attr("class").split(" ")[1];
					location.href = "<c:url value="/reply/delete/${articleVO.articleId}/" />" + replyId
				}
				
			});
			
			$(".modify").click(function() {
				var replyId = $(this).attr("class").split(" ")[1];
				$.post("<c:url value="/reply/${articleVO.articleId}/" />" + replyId
						, {}
						, function(data) {
							
							$("#cancelBtn").show();
							
							$("#replyId").val(data.replyId);
							$("#content").val(data.content);
							$("#replyBtn").val("수정");
						}
				);
			});
			
			$("#replyBtn").click(function() {
				
				if($("#content").val() == "") {
					alert("댓글 내용을 입력하세요");
					return;
				}
				
				if($("#replyId").val() == "") {
					$("#replyForm").attr("action", "<c:url value="/reply/write"/>");
				}
				else {
					$("#replyForm").attr("action", "<c:url value="/reply/modify"/>");
				}
				
				$("#replyForm").attr("method", "post");
				$("#replyForm").submit();
			});
			
		});
	</script>
</head>
<body>

	<table border="1">
		<tr>
			<th>Subject</th>
			<td>
				<c:out value="${articleVO.subject }" />
			</td>
		</tr>
		<tr>
			<th>Author</th>
			<td>
				<c:out value="${articleVO.userName }" />
				(<c:out value="${articleVO.emailId }" />)
			</td>
		</tr>
		<tr>
			<th>Hit</th>
			<td>
				<c:out value="${articleVO.hit }" />
			</td>
		</tr>
		<tr>
			<th>Created Date</th>
			<td>
				<c:out value="${articleVO.createdDate }" />
			</td>
		</tr>
		<tr>
			<th>Latest Modified Date</th>
			<td>
				<c:out value="${articleVO.modifiedDate }" />
			</td>
		</tr>
		<tr>
			<th>Secret</th>
			<td>
				<c:out value="${articleVO.isSecret }" />
			</td>
		</tr>
		<tr>
			<th>Content</th>
			<td>
				${articleVO.content }
			</td>
		</tr>
	</table>
	
	<table border="1">
		<c:forEach items="${replies}" var="reply">
			<tr>
				<td>
					<b>${reply.memberName}</b> (${reply.createdDate}) 
					<c:if test="${reply.isMyReply}">
						<span class="modify ${reply.replyId}">[수정]</span>
						<span class="delete ${reply.replyId}">[삭제]</span>
					</c:if> 
				</td>
			</tr>
			<tr>
				<td>
					${reply.content}
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<table border="1">
		<tr>
			<td>
				<form name="replyForm" id="replyForm">
					<input type="hidden" id="replyId" name="replyId">
					<input type="hidden" id="articleId" name="articleId" value="<c:out value="${articleVO.articleId}" />">
					<textarea name="content" id="content" rows="5" cols="20"></textarea>
					<input type="button" id="replyBtn" value="등록" />
					<input type="button" id="cancelBtn" value="취소" />
				</form>
			</td>
		</tr>
	</table>
	<a href="<c:url value="/board/modify/${articleVO.articleId }"/>">수정</a> | <a href="<c:url value="/board/delete/${articleVO.articleId }"/>">삭제</a>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">

	$(document).ready( function() {
	});
		
</script>

<title>목록 보기</title>
</head>
<body>
	<h4>List Page</h4>

	<table border="1" align="center">
		<tr>
			<th>Article ID</th>
			<th>Article Number</th>
			<th>Subject</th>
			<th>Writer</th>
			<th>Created Date</th>
			<th>Modified Date</th>
		</tr>
		<c:forEach items="${ articleListVO.articleList}" var="article">
		<tr align="center">
			<td>${ article.articleId }</td>
			<td>${ article.articleNumber }</td>
			<td><a href="/board/detail/${article.articleId}"> ${ article.subject }</a></td>
			<td>${ article.writer }</td>
			<td>${ article.createdDate }</td>
			<td>${ article.modifiedDate }</td>
		</tr>
		</c:forEach>
		<tr align="center">
			<td colspan="5">
				<form id="pagingForm">
					${ articleListVO.paging.getPagingList("pageNo", "[@]", "이전", "다음", "pagingForm") }
				</form>		
			</td>
			<td>
				<a href="/board/write">Write</a>
			</td>
		</tr>
		
	</table>

</body>
</html>
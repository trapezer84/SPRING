<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1" style="text-align: center; border-collapse: collapse;">
		<tr>
			<th>ARTICLE_ID</th>
			<th>ARTICLE_NUMBER</th>
			<th>SUBJECT</th>
			<th>WRITER</th>
			<th>CREATED_DATE</th>
			<th>MODIFIED_DATE</th>
		</tr>
		<c:forEach items="${articleListVO.articleList }" var="article">
		<tr>
			<td>${article.articleId }</td>
			<td>${article.articleNumber }</td>
			<td><a href="/board/detail/${article.articleId }">${article.subject }</a></td>
			<td>${article.writer }</td>
			<td>${article.createdDate }</td>
			<td>${article.modifiedDate }</td>
		</tr>
		</c:forEach>
		<tr>
		<form id="pagingForm">
			<td colspan="6">${articleListVO.paging.getPagingList("pageNo", "[@]", "이전", "다음", "pagingForm") }
			<span style="float:right;"><a href="/board/write">글쓰기</a></span></td>
		</form>
		</tr>
	</table>
</body>
</html>
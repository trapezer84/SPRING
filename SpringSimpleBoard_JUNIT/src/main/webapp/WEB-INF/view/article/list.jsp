<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table style="border: 1px solid black;">
		<tr style="background-color: #333333; color: white;">
			<th>articleId</th>
			<th>articleNumber</th>
			<th>subject</th>
			<th>writer</th>
			<th>description</th>
			<th>createdDate</th>
			<th>modifiedDate</th>
		</tr>
		<c:forEach items="${ articleListVO.articleList }" var="article">
			<tr style="text-align: center;">
				<td>${ article.articleID }</td>
				<td>${ article.articleNumber }</td>
				<td><a href="/board/detail/${ article.articleID }">${ article.subject }
				</a></td>
				<td>${ article.writer }</td>
				<td>${ article.description }</td>
				<td>${ article.createdDate }</td>
				<td>${ article.modifiedDate }</td>
			</tr>
		</c:forEach>
		<tr style="background-color: #ffff33;">
			<td colspan="7" style="text-align: center;">${ articleListVO.paging.getPagingList("pageNo", "[@]", "이전", "다음", "pagingForm") }
			</td>
		</tr>
	</table>
	<a href="/board/write" style="background-color: pink; color: white;">
		글쓰기 </a>
</body>
</html>
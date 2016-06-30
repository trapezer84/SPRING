<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h4>Detail Page</h4>
	<table border="1" align="center">
		<tr>
			<th colspan="6">${ article.subject }</th>
		</tr>
		<tr>
			<th>Article ID</th>
			<th>Article Number</th>
			<th>Description</th>
			<th>Writer</th>
			<th>Created Date</th>
			<th>Modified Date</th>
		</tr>
		<tr align="center">
			<td>${ article.articleId }</td>
			<td>${ article.articleNumber }</td>
			<td>${ article.description }</td>
			<td>${ article.writer }</td>
			<td>${ article.createdDate }</td>
			<td>${ article.modifiedDate }</td>
		</tr>
		<tr align="center">
			<td colspan="2"><a href="/board/modify/${ article.articleId }">Modify</a></td>
			<td colspan="2"><a href="/board/delete/${ article.articleId }">Delete</a></td>
			<td colspan="2"><a href="/board/list">List</a></td>
		</tr>
	
	</table>	
	
</body>
</html>
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
	<div style="margin-left: 15px; margin-bottom: 0px;">
		<a href="/board/detail/delete/${ article.articleID }" style="background-color: pink; color:white; ">
			삭제
		</a> 
		<a href="/board/edit/${ article.articleID }" style="background-color: skyblue; color:white; ">
			수정
		</a>
		<a href="/board/list" style="background-color: green; color:white; ">
			리스트
		</a>
	</div>
	<br/>
	<table style="border: 1px solid black; margin: 15px;">
		<tr style="background-color: #333333; color: white;">
			<th>articleId</th>
			<th>articleNumber</th>
			<th>subject</th>
			<th>writer</th>
			<th>description</th>
			<th>createdDate</th>
			<th>modifiedDate</th>
		</tr>
		<tr style="text-align: center;">
			<td>${ article.articleID }</td>
			<td>${ article.articleNumber }</td>
			<td>${ article.subject }</td>
			<td>${ article.writer }</td>
			<td>${ article.description }</td>
			<td>${ article.createdDate }</td>
			<td>${ article.modifiedDate }</td>
		</tr>
	</table>
</body>
</html>
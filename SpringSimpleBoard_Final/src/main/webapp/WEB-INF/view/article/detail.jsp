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
	<div style="width:30%; heght:100%; border:thin; border-style:double; border-radius: 5px;">
		${article.articleNumber }번글 / ${article.subject }<br/>
		<hr>
		작성자 : ${article.writer }<br/>
		<hr>
		${article.description }<br/>
		<hr>
		생성날짜 : ${article.createdDate }<br/>
		수정날짜 : ${article.modifiedDate } <br/>
		<hr>
		<a href="/board/modify/${article.articleId} ">수정</a>  /
		<a href="/board/doDelete/${article.articleId}">삭제</a>  /
		<a href="/board/list">목록</a>
	</div>
</body>
</html>
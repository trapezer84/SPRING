<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

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
			<form:form commandName="articleVO" 
			method="post" action="/board/doEdit">
				<td style="background-color: lightgray;"><input type="hidden" id="articleID" value="${ article.articleID }" name="articleID"/>${ article.articleID }</td>
				<td style="background-color: lightgray;">${ article.articleNumber }</td>
				<td><input type="text" id="subject" name="subject" value="${article.subject} "/></td>
				<td style="background-color: lightgray;">${ article.writer }</td>
				<td><input type="text" id="description" name="description" value="${article.description}" /></td>
				<td style="background-color: lightgray;">${ article.createdDate }</td>
				<td style="background-color: lightgray;">${ article.modifiedDate }</td>
				<input type="submit" value="수정 완료" />
			</form:form>
		</tr>
	</table>
</body>
</html>
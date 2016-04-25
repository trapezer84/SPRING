<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Write Page</title>
</head>
<body>
	<div style="width:9%; height:100%; border:thin; border-style:double; border-radius: 5px; padding:5px;">
	<form:form commandName="articleVO"
				method="post" action="/board/doWriteAction" >
		<c:if test="${article.articleId ne null }">
			<input type="text" id="subject" name="subject" value="${ article.subject }" /><br/>
			<form:errors path="subject" /><br/>
			
			<input type="text" id="writer" name="writer" value="${ article.writer }" /><br/>
			<form:errors path="writer" /><br/>
			
			<textarea id="description" name="description" >${ article.description }</textarea><br/>
			<input type="hidden" id="articleId" name="articleId" value="${ article.articleId }" />
			<input type="submit" value="수정하기" />
			/ <a href="/board/detail/${article.articleId }">취소</a>
		</c:if>
		<c:if test="${article.articleId eq null }">
			<input type="text" id="subject" name="subject" placeholder="제목을 입력하세요." value="${ articleVO.subject }" /><br/>
			<form:errors path="subject" /><br/>
			
			<input type="text" id="writer" name="writer" placeholder="글쓴이를 입력하세요." value="${ articleVO.writer }" /><br/>
			<form:errors path="writer" /><br/>
			
			<textarea id="description" name="description" placeholder="내용을 입력하세요." >${ articleVO.description }</textarea><br/>
			<input type="submit" value="글쓰기" />
			/ <a href="/board/list">취소</a>
		</c:if> 
	</form:form>
	</div>
</body>
</html>
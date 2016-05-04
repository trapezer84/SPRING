<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>write page</title>
</head>
<body>

[글 작성 페이지]

<form:form commandName="articleVO" method="post" action="/LeinaBoard/doWrite">
	제목 : 
	<input type="text" id="subject" name="subject" value="${articleVO.subject} "/> <br/>
	<form:errors path="subject"/>
	
	글쓴이 : 
	<input type="text" id="writer" name="writer" value="${articleVO.writer}"/> <br/>
	<form:errors path="writer"/>
	
	내용 : 
	<textarea id="description" name="description" value="${articleVO.description}" ></textarea>	<br />
	
	<input type="submit" value="보내기"/>
</form:form>
</body>
</html>
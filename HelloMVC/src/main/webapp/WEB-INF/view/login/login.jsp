<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	로그인 페이지입니다 :) 
	<form:form commandName="loginVO" method="post" action="/HelloMVC/doLogin">
		<input type="text" name="id" placeholder="id"/>
		<form:errors path="id" /> <br/>
		<input type="text" name="password" placeholder="password"/>
		<form:errors path="password" /> <br/>
		<input type="text" name="memberNumber" placeholder="memberNumber"/>
		<form:errors path="memberNumber" /> <br/>
		<input type="checkbox" name="enableAutoLogin" value="true"/>
		<input type="submit" />
		<input type="text" name="hobby" />
		<input type="text" name="hobby" />
		<input type="text" name="hobby" />
	</form:form>
</body>
</html>


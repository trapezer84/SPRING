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
	게시판 목록입니다. <br/>
	${title} <br/>
	${number} <br/>
	${author} <br/>
	
	<c:forEach items="${allEmployees}" var="employee">
		<!--111 --> 
		${employee.employeeId}&nbsp;&nbsp;&nbsp;
		${employee.firstName}&nbsp;&nbsp;&nbsp;
		${employee.lastName}&nbsp;&nbsp;&nbsp;
		${employee.email}&nbsp;&nbsp;&nbsp;
		${employee.salary}&nbsp;&nbsp;&nbsp;
		${employee.commissionPct}&nbsp;&nbsp;&nbsp;
		${employee.hireDate}&nbsp;&nbsp;&nbsp;
		${employee.departmentName}&nbsp;&nbsp;&nbsp; <br/>
	</c:forEach>
</body>
</html>
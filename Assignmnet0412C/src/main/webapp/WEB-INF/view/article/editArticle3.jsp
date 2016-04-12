<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Article 입력 받기3</title>
</head>
<body>
	<form action="/Assignmnet0412C/showArticle3" method="post">
		<table>
		<tr>
			<td style="text-align: center">
				Article을 쓰세요
			</td>
		</tr>
		<tr>
			<td>
				<input type="text" name="subject" placeholder="subject"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="text" name="content" placeholder="content"/>
			</td>
		</tr>
		<tr>
			<td style="text-align: center;">
				<input type="submit" style="width:100%;"/>
			</td>
		</tr>
		</table>
	</form>
</body>
</html>
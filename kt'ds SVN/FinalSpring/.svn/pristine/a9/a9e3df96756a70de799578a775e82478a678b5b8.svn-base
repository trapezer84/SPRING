<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib 	prefix="decorator" 
			uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib	prefix="page"
			uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib 	prefix="c"
			uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="/FinalSpring/resources/js/jquery-1.11.2.js"></script>
	<decorator:head />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><decorator:title default="FinalSpring" /></title>
</head>
<body>
	<div class="pageWrapper" style="width: 900px;">
		<div class="menuWrapper" style="float:left; width:250px;">
			<table style="width:100%;">
				<tr>
					<td>
					<a href="<c:url value="/member/regist"/>">
						회원가입
					</a>
					</td>
				</tr>
				<tr>
					<td>
					<a href="<c:url value="/login"/>">
						로그인
					</a>
					</td>
				</tr>
				<tr>
					<td>
					<a href="<c:url value="/admin/viewOperationHistory"/>">
						Operation History List
					</a>
					</td>
				</tr>
				<tr>
					<td>
					<a href="<c:url value="/board/list/init"/>">
						게시판
					</a>
					</td>
				</tr>
			</table>
		</div>
		<div class="contentWrapper" style="float:left; width:650px;">
			<decorator:body />
		</div>
		<div style="clear:both;"></div>
	</div>
</body>
</html>




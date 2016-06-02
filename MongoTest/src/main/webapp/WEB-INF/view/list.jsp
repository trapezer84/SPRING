<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach items="${memoList}" var="memo">
		<p>
			<a href="/MongoTest/detail/${memo._id}">${memo.memo}</a>
		</p>
	</c:forEach>
	
	<br />
	<form id="searchForm" method="post" action="/MongoTest/list">
		<input type="text" id="searchKeyword" name="searchKeyword" value="${memoSearchVO.searchKeyword}" />
		<input type="button" id="searchBtn" value="검색"> 
		${paging.getPagingList("pageNo","[@]","이전","다음","searchForm")}
	</form>

</body>
</html>
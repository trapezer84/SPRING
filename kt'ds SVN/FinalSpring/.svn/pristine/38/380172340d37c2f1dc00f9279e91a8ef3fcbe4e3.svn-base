<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib 	prefix="c"
			uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
	
		$(document).ready(function() {
			
			$("#searchBtn").click(function() {
				
				var startYear = $("#startYear").val();
				var startMonth = $("#startMonth").val();
				var startDate = $("#startDate").val();
				
				startMonth = fillString(startMonth);
				startDate = fillString(startDate);
				
				var endYear = $("#endYear").val();
				var endMonth = $("#endMonth").val();
				var endDate = $("#endDate").val();
				
				endMonth = fillString(endMonth);
				endDate = fillString(endDate);
				
				var startSearchDate = startYear + startMonth + startDate;
				var endSearchDate = endYear + endMonth + endDate;
				
				startSearchDate = parseInt(startSearchDate);
				endSearchDate = parseInt(endSearchDate);
				
				if(startSearchDate > endSearchDate) {
					alert("기간 검색 범위가 잘못되었습니다.");
					return;
				}
				
				
				
				$("#searchForm").attr("action", "<c:url value="/board/list"/>");
				$("#searchForm").attr("method", "POST");
				$("#searchForm").submit();
			});
			
		});
	
		function fillString(str) {
			
			if(str.length == 1) {
				str = "0" + str;
			}
			
			return str;
		}
		
	</script>
</head>
<body>

	<form name="searchForm" id="searchForm">
		<table style="width:100%;" border="1">
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="subject" id="subject" />
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					<select name="author" id="author">
						<option value="emailId">Email ID</option>
						<option value="name">Name</option>
					</select>
					<input type="text" name="authorKeyword" id="authorKeyword" />
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<input type="text" name="content" id="content" />
				</td>
			</tr>
			<tr>
				<th>비밀글 여부</th>
				<td>
					<select name="isSecret" id="isSecret">
						<option value="" selected="selected">ALL</option>
						<option value="y">Yes</option>
						<option value="n">No</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td>
					<select id="startYear" name="startYear">
						<c:forEach var="year" begin="2010" end="2015" step="1">
							<c:choose>
								<c:when test="${year eq articleSearchVO.startSearchYear}">
									<option value="${year}" selected="selected">${year}</option>
								</c:when>
								<c:otherwise>
									<option value="${year}">${year}</option>
								</c:otherwise>
							</c:choose>
							
						</c:forEach>
					</select>
					Y-
					<select id="startMonth" name="startMonth">
						<c:forEach var="month" begin="01" end="12" step="1">
							<c:choose>
								<c:when test="${month eq articleSearchVO.startSearchMonth}">
									<option value="${month}" selected="selected">${month}</option>
								</c:when>
								<c:otherwise>
									<option value="${month}">${month}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
					M-
					<select id="startDate" name="startDate">
						<c:forEach var="date" begin="01" end="31" step="1">
							<c:choose>
								<c:when test="${date eq articleSearchVO.startSearchDay}">
									<option value="${date}" selected="selected">${date}</option>
								</c:when>
								<c:otherwise>
									<option value="${date}">${date}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
					D
					~
					<select id="endYear" name="endYear">
						<c:forEach var="year" begin="2010" end="2015" step="1">
							<c:choose>
								<c:when test="${year eq articleSearchVO.endSearchYear}">
									<option value="${year}" selected="selected">${year}</option>
								</c:when>
								<c:otherwise>
									<option value="${year}">${year}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
					Y-
					<select id="endMonth" name="endMonth">
						<c:forEach var="month" begin="01" end="12" step="1">
							<c:choose>
								<c:when test="${month eq articleSearchVO.endSearchMonth}">
									<option value="${month}" selected="selected">${month}</option>
								</c:when>
								<c:otherwise>
									<option value="${month}">${month}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
					M-
					<select id="endDate" name="endDate">
						<c:forEach var="date" begin="01" end="31" step="1">
							<c:choose>
								<c:when test="${date eq articleSearchVO.endSearchDay}">
									<option value="${date}" selected="selected">${date}</option>
								</c:when>
								<c:otherwise>
									<option value="${date}">${date}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
					D
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="검색" id="searchBtn" />
				</td>
			</tr>
		</table>
	</form>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${ articleList.articleList }" var="article">
			<tr>
				<td><c:out value="${article.articleId }" /></td>
				<td>
					<a href="<c:url value="/board/detail/${article.articleId }" />">
						<c:out value="${article.subject }" /> (<c:out value="${article.replyCount}"/>)
					</a>
				</td>
				<td><c:out value="${article.userName }" /></td>
				<td><c:out value="${article.hit }" /></td>
				<td><c:out value="${article.modifiedDate }" /></td>
			</tr>
		</c:forEach>
	</table>
	${articleList.paging.getPagingList("pageNo", "[@]", "[이전]", "[다음]", "")}<br/>
	<a href="<c:url value="/board/write" />">글쓰기</a>
</body>
</html>
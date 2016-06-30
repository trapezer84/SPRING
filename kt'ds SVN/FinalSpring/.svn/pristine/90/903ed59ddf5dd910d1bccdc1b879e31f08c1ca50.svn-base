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
				
				var endYear = $("#endYear").val();
				var endMonth = $("#endMonth").val();
				var endDate = $("#endDate").val();
				
				var startSearchDate = startYear + startMonth + startDate;
				var endSearchDate = endYear + endMonth + endDate;
				
				startSearchDate = parseInt(startSearchDate);
				endSearchDate = parseInt(endSearchDate);
				
				if(startSearchDate > endSearchDate) {
					alert("기간 검색 범위가 잘못되었습니다.");
					return;
				}
				
				$("#searchForm").submit();
				
				
			});
			
		});
	</script>
</head>
<body>
	<form 	name="searchForm" 
			id="searchForm" 
			action="<c:url value="/admin/viewOperationHistory"/>" 
			method="POST">
	<table style="width:100%" border="1">
		<tr>
			<td>Email</td>
			<td>
				<input type="text" name="emailId" id="emailId" />
			</td>
		</tr>
		<tr>
			<td>IP</td>
			<td>
				<input type="text" name="ip" id="ip" />
			</td>
		</tr>
		<tr>
			<td>Operation Type</td>
			<td>
				<input type="text" name="operationType" 
							id="operationType" />
			</td>
		</tr>
		<tr>
			<td>Description</td>
			<td>
				<input type="text" name="operationDescription" 
							id="operationDescription" />
			</td>
		</tr>
		<tr>
			<td>Registered Date</td>
			<td>
				<select id="startYear" name="startYear">
					<c:forEach var="year" begin="2010" end="2015" step="1">
						<option value="${year}">${year}</option>
					</c:forEach>
				</select>
				Y-
				<select id="startMonth" name="startMonth">
					<c:forEach var="month" begin="01" end="12" step="1">
						<option value="${month}">${month}</option>
					</c:forEach>
				</select>
				M-
				<select id="startDate" name="startDate">
					<c:forEach var="date" begin="01" end="31" step="1">
						<option value="${date}">${date}</option>
					</c:forEach>
				</select>
				D
				~
				<select id="endYear" name="endYear">
					<c:forEach var="year" begin="2010" end="2015" step="1">
						<option value="${year}">${year}</option>
					</c:forEach>
				</select>
				Y-
				<select id="endMonth" name="endMonth">
					<c:forEach var="month" begin="01" end="12" step="1">
						<option value="${month}">${month}</option>
					</c:forEach>
				</select>
				M-
				<select id="endDate" name="endDate">
					<c:forEach var="date" begin="01" end="31" step="1">
						<option value="${date}">${date}</option>
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
	
	<table style="width:100%;" border="1">
		<tr>
			<th>번호</th>
			<th>Email ID</th>
			<th>IP</th>
			<th>Operation Type</th>
			<th>Desc</th>
			<th>Created Date</th>
		</tr>
		
		<tr>
			<td colspan="6"><c:out value="${totalCount}" /></td>
		</tr>
		
		<c:if test="${empty historyList}">
			<tr>
				<td colspan="6">데이터가 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${not empty historyList}">
			<c:forEach items="${historyList}" var="history">
				<tr>
					<td>${history.historyId}</td>
					<td>${history.emailId}</td>
					<td>${history.ip}</td>
					<td>
						<c:choose>
							<c:when test="${history.operationType eq 'AH'}">
								Board History
							</c:when>
							<c:when test="${history.operationType eq 'MH'}">
								Member History
							</c:when>
							<c:when test="${history.operationType eq 'LH'}">
								Login History
							</c:when>
						</c:choose>
					</td>
					<td>${history.operationDescription}</td>
					<td>${history.createdDate}</td>
				</tr>
			</c:forEach>
		</c:if>
		
		<tr>
			<td colspan="6">
				${paging}
			</td>
		</tr>
		
	</table>

</body>
</html>
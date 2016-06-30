<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/board/resources/js/jquery-1.12.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<decorator:head />
<title><decorator:title default="SimpleBoard" />
</title>
</head>
<body>

	<div id="wrapper" >
		
		<div id="header" >
			<h1>Header</h1>
		</div>
		
		<div id="leftMenu" style="float:left; width:300px;">
			<h3>Menu</h3>
		</div>
		
		<div id="content" style="float:left; width:704px;">
			<decorator:body />
			
		</div>
		
		<div style="clear:both;"></div>
	
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/javascript.js" ></script>
<link type="font" href="https://fonts.googleapis.com/css?family=Amatic+SC|Caveat|Jura|Pacifico|Russo+One|Tangerine" rel="stylesheet">
<title>
	<tiles:getAsString name="title"></tiles:getAsString>
</title>
</head>
<body>
<div class="container">
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
	
	<div class="mainContent">
		<div class="leftSide">
			<tiles:insertAttribute name="leftSide"></tiles:insertAttribute>
		</div>
		<div class="center">
			<tiles:insertAttribute name="body"></tiles:insertAttribute> 
		</div>
		<div class="rightSide">
			<tiles:insertAttribute name="rightSide"></tiles:insertAttribute> 
		</div>
	</div>
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>products Page</h1>
<h2>${ data} </h2>
<c:if test="${ not empty data }">
	<div>Data var</div>
</c:if>

<c:if test="${ not empty ls }">
	<c:forEach items="${ls }" var="item">
		<div>${ item }</div>
	</c:forEach>
</c:if>

</body>
</html>
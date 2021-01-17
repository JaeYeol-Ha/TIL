<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 테스트</title>
</head>
<body>
<h2>&lt;c:set&gt; 태그 예제</h2>
<hr>
<c:set var="color"  value="red-page"  scope="page"/>
<c:set var="color"  value="blue-request" scope="request"/>
<c:set var="color" value="green-session"  scope="session"/>
<c:set var="color"  value="yellow-application"  scope="application"/>

color = ${color} <br>

pageScope.color = ${pageScope.color}<br>
requestScope.color = ${requestScope.color}<br>
sessionScope.color = ${sessionScope.color}<br>
applicationScope.color = ${applicationScope.color}<br>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useBean 액션 태그 예제</title>
</head>
<body>
<h2>useBean 액션 태그 예제</h2>
<hr>
<jsp:useBean id="cnt" class="jspbean.CountVO"  scope="session"/>
<%= cnt.getNumber() %><br>
<% cnt.setNumber(10); %>
<%= cnt.getNumber() %><br>
<% cnt.setNumber(10); %>
<%= cnt.getNumber() %>
</body>
</html>
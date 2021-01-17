<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getProperty  액션 태그 예제</title>
</head>
<body>
<h2>getProperty 액션 태그 예제</h2>
<hr>
<jsp:useBean id="today"  class="jspbean.Today"/>
<h3>
<jsp:getProperty name="today" property="year" />년
<jsp:getProperty name="today" property="month" />월
<jsp:getProperty name="today" property="date" />일
</h3>
</body>
</html>
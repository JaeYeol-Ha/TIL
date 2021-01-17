<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 학습</title>
</head>
<body>
<h2><%= request.getParameter("name") %>님은 D 등급입니다. 꾸준히 노력하세요.</h2>
<a href="/mvc/eduForm.html">성적 입력 화면으로</a>
</body>
</html>
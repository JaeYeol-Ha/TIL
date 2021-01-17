<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>감사인사</title>
</head>
<body>
<%
if(request.getParameter("country").equals("korea")) {
%>
   <%= "감사합니다." %>
<%	
}
else if(request.getParameter("country").equals("english")) {
%>
   <%= "Thank You." %>
<%
}
else if(request.getParameter("country").equals("japan")) {
%>
    <%= "ありがとうございます" %>
<%
}
%>
</body>
</html>

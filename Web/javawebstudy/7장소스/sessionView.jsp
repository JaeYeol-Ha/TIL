<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.CountVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session scope</title>
</head>
<body>
<h2>session scope 객체 공유</h2>
<hr>
<%
	CountVO vo = (CountVO)session.getAttribute("sessionobj");
%>
<h3>추출된 카운트 값 : <%= vo.getNumber() %></h3>
<hr>
<jsp:useBean id="sessionobj"  
            class="model.vo.CountVO" scope="session" />
<h3>추출된 카운트 값(액션태그) : <jsp:getProperty  name="sessionobj"  property="number" /></h3>
<hr>
<h3>추출된 카운트 값(EL) : ${ sessionScope.sessionobj.number }</h3>
</body>
</html>
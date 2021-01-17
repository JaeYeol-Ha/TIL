<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.CountVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application scope</title>
</head>
<body>
<h2>application scope 객체 공유</h2>
<hr>
<%
	CountVO vo = (CountVO)application.getAttribute("applicationobj");
%>
<h3>추출된 카운트 값 : <%= vo.getNumber() %></h3>
<hr>
<jsp:useBean id="applicationobj"  
            class="model.vo.CountVO" scope="application" />
<h3>추출된 카운트 값(액션태그) : <jsp:getProperty  name="applicationobj"  property="number" /></h3>
<hr>
<h3>추출된 카운트 값(EL) : ${ applicationScope.applicationobj.number }</h3>
</body>
</html>
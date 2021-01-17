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
<h2>&lt;c:set&gt;, &lt;c:remove&gt; 그리고 &lt;c:out&gt; 태그</h2>
<hr>
<c:set var="num1" value="20" />
<c:set var="num2">
10.5
</c:set>
<c:set var="today" value="<%= new java.util.Date() %>" />
변수 num1 = ${ num1 } <br>
변수 num2 = <c:out value="${num2}"  /> <br>
변수 num3 = <c:out value="${num3}"  default="기본 값"/> <br>
num1 + num2 = ${num1 + num2} <br>
오늘은 ${today} 입니다.
<hr>
<c:remove var="num1" />
삭제한 후의 num1 = ${num1} <br>
삭제한 후의 num1 + num2 = ${num1 + num2}<br>
삭제한 후의 num1 = <c:out value="${num1}"  default="기본 값"/> 
<hr>
<c:set var="map" value="<%= new java.util.HashMap<String,String>() %>" />
<c:set target="${map}"  property="st1" value="듀크" />
<c:set target="${map}"  property="st2" value="둘리" />
변수 map에 저장된 st1 값: ${map.st1}<br>
변수 map에 저장된 st2 값: ${map.st2}<br>
<hr>
EL 사용 : <c:out value="${param.buyer}"/><br>
스크립트 태그 사용 : <c:out value='<%= request.getParameter("buyer")%>' />
</body>
</html>
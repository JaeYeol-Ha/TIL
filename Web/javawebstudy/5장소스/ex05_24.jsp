<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>setProperty 액션 태그 예제</title>
</head>
<body>
<%
if(request.getMethod().equals("GET")) {
%>
	<h2>요청 폼</h2>
	<hr>
	<form method="POST" action="/edu/jspexam/ex05_24.jsp">
		예약자명 : <input type="text"  name="bookerName" ><br>
		예약칼라 : <input type="color"  name="bookerColor" ><br>
		예약일시 : <input type="datetime-local"  name="bookerDateTime" ><br>
		<input type="submit" value="예약완료">
	</form>
<%
} else {
	request.setCharacterEncoding("utf-8");
%>
	<h2>setProperty 액션 태그 예제</h2>
	<hr>	
	<jsp:useBean id="booker"  class="jspbean.BookerInfo" /> 
	<jsp:setProperty name="booker"  property="bookerName"  
					value='<%= request.getParameter("bookerName") %>' />
	<jsp:setProperty name="booker"  property="bookerColor"  param="bookerColor"  />
	<jsp:setProperty name="booker"  property="bookerDateTime"  />
	예약자명 : <jsp:getProperty name="booker"  property="bookerName" /><br>
	예약칼라 : <jsp:getProperty name="booker"  property="bookerColor" /><br>
	예약일시 : <jsp:getProperty name="booker"  property="bookerDateTime" />
<%
}
%>
</body>
</html>
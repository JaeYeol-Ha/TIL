<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, model.vo.VisitorVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 학습</title>
<style>
	td {
		border-bottom : 1px dotted black;
		padding-right : 20px;
	}
	a {
		text-decoration : none;
	}

</style>
</head>
<body>
<h2>방명록 리스트(1)</h2>
<hr>
<%
	ArrayList<VisitorVO> list = 
	        (ArrayList<VisitorVO>)request.getAttribute("list");
    if(list != null) {
%>
    	<table>
<%
    	for(VisitorVO vo : list) {
%>
			<tr>
				<td><%= vo.getName() %></td>
				<td><%= vo.getWriteDate() %></td>
				<td><%= vo.getContent() %></td>
			</tr>
<%
    	}
%>
	    </table>
<%
    } else {
%>
       <h2>${ msg }</h2>
<%
    }
%>
<hr>
<a href="/mvc/visitorForm.html">방명록 메인화면</a>
</body>
</html>







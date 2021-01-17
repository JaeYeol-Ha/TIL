<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${ pageContext.request.method == 'GET' }">
		<h2>점검하려는 버스의 번호를 입력하세요</h2>
		<hr>
		<form method="POST" action="/edu/jspexam/ex05_40.jsp">
			버스번호 : <input type="number" name="num" min="0" required>
			<input type="submit" value="알아보기">
		</form>	
	</c:when>
	<c:otherwise>
	     <h2>${param.num}번 버스의 정보</h2>
	     <hr>
	     <c:catch var="ex">
	     	<c:import var="xmldata" url="http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList?serviceKey=%2BjzsSyNtwmcqxUsGnflvs3rW2oceFvhHR8AFkM3ao%2Fw50hwHXgGyPVutXw04uAXvrkoWgkoScvvhlH7jgD4%2FRQ%3D%3D&strSrch=${param.num }" />
	        <x:parse xml="${xmldata }" varDom="xdata" />
	        <x:if select="$xdata//headerCd = 0">
	        	<c:set var="busnum" value="${ param.num }"/>
	        	<x:forEach select="$xdata//itemList">
	        		<x:if select="busRouteNm = $busnum">	        		  
	        			버스번호 : <x:out select="busRouteNm"/><br>
     					기점 : <x:out select="stStationNm"/><br>
     					종점 : <x:out select="edStationNm"/><br>
     					라우트아이디 : <x:out select="busRouteId"/><br>
     					회사정보 : <x:out select="corpNm"/><br>
     					배차간격 : <x:out select="term"/><br>
     					<c:set var="outFlag" value="true"/>
	        		</x:if>	        		
	        	</x:forEach>
	        	<c:if test="${ empty outFlag }">
	        		<h3>${ param.num }번 버스의 정보는 존재하지 않아요...</h3>
	        	</c:if>	        
	        </x:if>
	        <x:if select="$xdata//headerCd != 0">
	        	<h3>${ param.num }번 버스의 정보는 존재하지 않아요...</h3>	        
	        </x:if>	        
	     </c:catch>	
	     <c:if test="${ !empty ex }">
	     	<h3>오류 발생 : ${ex}</h3>	     
	     </c:if>
	     <hr>
		 <a href="/edu/jspexam/ex05_40.jsp">입력 화면으로</a>
	</c:otherwise>
</c:choose>
</body>
</html>




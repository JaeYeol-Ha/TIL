<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 테스트</title>
</head>
<body>
<h2>xml 라이브러리  태그 예제</h2>
<hr>
<c:import var="xmldata" url="http://localhost:8000/edu/jspexam/student.xml" charEncoding="UTF-8"/>
<x:parse xml="${xmldata}" varDom="xdata"/> 

<c:catch var="ex">
<x:out select="$xdata//학생[1]/이름" /> <x:out select="$xdata//학생[1]/@번호" /><br> 
<x:out select="$xdata//학생[2]/이름" /> <x:out select="$xdata//학생[2]/@번호" /><br>
<x:out select="$xdata//학생[3]/이름" /> <x:out select="$xdata//학생[3]/@번호" /><br>
<x:out select="$xdata//학생[4]/이름" /> <x:out select="$xdata//학생[4]/@번호" /><br>
<hr>
<x:forEach select="$xdata//학생">
  <x:out select="이름" />
  <x:out select="@번호" /><br>
</x:forEach>
<hr>
<x:forEach select="$xdata//이름[@성별='남']" var="result">
남학생 : <x:out select="text()" /> <br>
</x:forEach>
<hr>

<x:if select="$xdata//학생[@번호='st0004']" >
번호가 st0004 번인 학생 이름 : <x:out select="$xdata//학생[@번호='st0004']/이름" /><br>
</x:if>
<x:choose>
<x:when select="$xdata//학생[@번호='st0005']" >
번호가 st0005 번인 학생 이름 : <x:out select="$xdata//학생[@번호='st0005]/이름" /><br>
</x:when>
<x:otherwise>
<h3>번호가 st0005인 학생 데이타가 존재하지 않습니다!!</h3>
</x:otherwise>
</x:choose> 
</c:catch>
<c:if test="${ex != null}">
<h3>${ex}</h3>
</c:if>
</body>
</html>
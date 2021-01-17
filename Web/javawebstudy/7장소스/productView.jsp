<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose> 
	<c:when  test="${! empty sessionScope.countnum }" >
		<h2>선택된 상품 정보는 다음과 같습니다.</h2>
		<hr>
		선택된 사과의 개수 : ${ sessionScope.countnum.apple }<br>
		선택된 바나나의 개수 : ${ sessionScope.countnum.banana }<br>
		선택된 한라봉의 개수 : ${ sessionScope.countnum.hallabong }<br>
	</c:when>
	<c:otherwise>
	    <h2>장바구니가 비었습니다.</h2>
	</c:otherwise>
</c:choose>
<hr>
<a href="/mvc/productForm.html">상품 선택 화면으로</a>
</body>
</html>







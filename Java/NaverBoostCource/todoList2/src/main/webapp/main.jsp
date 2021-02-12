<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>


<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="utf-8">
<title>나의 해야할 일들</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	<section id="section-style">
		<header>
			<h1 id="mainTitle">나의 해야할 할일들</h1>
		</header>
		<div id="add" onclick="location.href='./RegistServlet'">새로운
			TODO 등록</div>
		<section id="outBox">
			<c:forEach var="type" items="${todoTypes}">
				<section id="${type}">
					<div class="listHeader">${type}</div>
					<c:forEach var="list" items="${todoList}">
						<c:if test="${list.type eq type}">
							<div class="item">
								<h1 class="item-header">${list.title}</h1>
								<div class="item-content">등록날짜:${list.regdate},
									${list.name}, 우선순위 ${list.sequence}</div>
									<button class="back"
										onclick="backButtonClick(${list.id}, this)">←</button>
									<button class="change"
										onclick="changeButtonClick(${list.id}, this)">→</button>
							</div>
						</c:if>
					</c:forEach>
				</section>
			</c:forEach>
			<div style="clear: both; height: 170px"></div>
		</section>
	</section>
	<script src="js/main.js" type="text/javascript"></script>
</body>
</html>

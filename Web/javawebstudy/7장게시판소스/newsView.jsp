<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.NewsVO, java.util.List" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>News 게시판</title>
<style>
header, section, nav {
	width : 80%;
	margin : 10px auto;	
	text-align : center;
}
table {
	margin : 10px auto;	
}

th {   
	border: 1px solid #ddd;
	text-align :center;
	background:#ddd;
	color:purple;
	text-shadow:1px 1px 1px #fff;
}

td {   
	border-bottom : 1px dotted black;
	text-align :center;
}
td:nth-child(5n+1), th:nth-child(5n+1) {
	width : 60px;
}
td:nth-child(5n+2) , th:nth-child(5n+2){	
	width : 300px;
}
td:nth-child(5n+3), th:nth-child(5n+3) {	
	width : 100px;
}
td:nth-child(5n+4), th:nth-child(5n+4) {	
	width : 100px;
}
td:nth-child(5n+5), th:nth-child(5n+5) {	
	width : 60px;
}
.insert {
	display : none;
	/* test-align : center; */
}
input, textarea {
	margin : 3px;
}
a {
	text-decoration : none;
}
a:link, a:active, a:visited {
	color : black;
}
a:hover {
	font-weight : bold;
}
h1 {
	color : purple;
}
.showLine{margin-left:70%;}
</style>
</head>
<body>
<header>
<h1>${ msg }</h1>
</header>

<%
if(request.getAttribute("vo") != null) {
	  NewsVO vo = (NewsVO)request.getAttribute("vo");
%>
<section>
<div>
	<form id="updateform" method="post" action="/mvc/news.do">
		<input type="hidden" name="action" value="update">
		<input type="hidden" name="pgNum" value="${ pgNum }">
		<input type="hidden" name="id" value="<%= vo.getId() %>">
		<input type="text" size="40" name="writer"  value="<%= vo.getWriter() %>"><br>
		<input type="text" size="40"  name="title" value="<%= vo.getTitle() %>"><br>		
		<textarea  cols="42"  rows="7" name="content"><%= vo.getContent() %></textarea><br>		
	</form>	
	<button onclick="location.replace(document.referrer)">확인</button>
	<button onclick="document.getElementById('updateform').submit();">수정</button>
	<button onclick="location.href='/mvc/news.do?action=delete&id=<%= vo.getId() %>&pgNum=${pgNum}'">삭제</button>		
</div>

</section>
<%
} else {
	List<NewsVO> list = (List<NewsVO>) request.getAttribute("list");
	int listsize = 0;
	if(list!=null) listsize =list.size();
%>

<aside class="showLine">
글 개수 : <%=listsize %> (${ totalCount })
</aside>
<section>
<%
	if(list != null) {
%>
		<table>		
		<tr>
			<th>번호<a href="/mvc/news.do?action=sort&key=id">^</a></th>
			<th>제목<a href="/mvc/news.do?action=sort&key=title">^</a></th>
			<th>작성자<a href="/mvc/news.do?action=sort&key=writer">^</a></th>
			<th>작성일<a href="/mvc/news.do?action=sort&key=writedate">^</a></th>
			<th>조회수</th>
		</tr>
<%
		for( NewsVO vo  :   list) {
%>
			<tr>
			<td><%= vo.getId() %></td>			
			<td><a href="/mvc/news.do?action=listone&id=<%= vo.getId() %>&pgNum=${pgNum}"><%= vo.getTitle() %></a></td>
			<td><a href="/mvc/news.do?action=listwriter&writer=<%= vo.getWriter() %>"><%= vo.getWriter() %></a></td>
			<td><%= vo.getWriteDate() %></td>
			<td><%= vo.getViewCount() %></td>
			</tr>
<%
		}
%>		
		</table>
		${ pagelist }
<%
	} else{
		 String snull =(String) request.getAttribute("snull");
		 if(snull!=null){
%>
			<script>
			var m = "<%=snull%>";
			alert(m);
			location.href="/mvc/news.do?pgNum=1";
			</script>
<%
		}
	}
 String stype = request.getParameter("searchType");
%>
<form action="/mvc/news.do">
	<select name="searchType" onchange="">
		<option value="title"
		<%
			if("title".equals(stype))
				out.print("selected=\"selected\"");
			%>>제목</option>
		<option value="content" 
		<%
			if("content".equals(stype))
				out.print("selected=\"selected\"");
			%>>내용</option>	
		<option value="all" 
		<%
			if("all".equals(stype))
				out.print("selected=\"selected\"");
			%>>제목+내용</option>
	</select>
	<%
	String taction = request.getParameter("action");
	if(taction!=null && taction.equals("search")){ %>
		<input type="search" name="key" value="${param.key}">
	<%}else{ %>
		<input type="search" name="key" >
	<%} %>
	<input type="hidden" name="action" value="search">
	<input type="submit" value="뉴스검색">
</form>
</section>
<nav>
<% if (request.getAttribute("etc") != null) {%>
<button onclick="location.href='/mvc/news.do?pgNum=1'">뉴스 홈</button>
<% } %>
<button onclick="displayInputForm(true);">뉴스 작성</button>
</nav>
<%
}
%>	
<section>
<div class="insert">
	<form method="post" action="/mvc/news.do">
		<input type="hidden" name="action" value="insert">
		<input type="text" placeholder="작성자명을 입력해주세요" size="40" name="writer"><br>
		<input type="text" placeholder="제목을 입력해주세요" size="40"  name="title"><br> 
		<textarea  placeholder="내용을 입력해주세요"  cols="41"  rows="7" name="content"></textarea>
		<br>
		<input type="submit" value="저장">
		<input type="reset" value="재작성">
		<button onclick="displayInputForm(false); return false;">취소</button>
	</form>
</div>
</section>
<script>
function displayInputForm(flag) {
	var dom = document.getElementsByTagName("div")[0];
	if(flag)
		dom.style.display='block';
	else 
		dom.style.display='none';
}
</script>
</body>
</html>





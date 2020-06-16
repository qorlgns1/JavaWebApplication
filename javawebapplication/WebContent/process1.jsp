<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//boardnum 이라는 파라미터를 읽기
		String boardnum = request.getParameter("boardnum");
		//nickname 이라는 파라미터를 읽기
		String nickname = request.getParameter("nickname");
		//없는 파라미터 읽기
		String readcnt = request.getParameter("readcnt");
	%>
	
	<p>boardnum:<%=boardnum %></p>
	<p>nickname:<%=nickname %></p>
	<p>readcnt:<%=readcnt %></p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 객체</title>
</head>
<body>
	<%
		String url = application.getInitParameter("url");
	
	%>
	
	<h2>url:<%=url %></h2>
</body>
</html>
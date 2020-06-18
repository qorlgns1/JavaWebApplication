<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>경로 출력</title>
</head>
<body>
	루트 경로(ContextPath):${pageContext.request.contextPath}<br/>
	요청 경로(RequestURI):${pageContext.request.requestURI}<br/>
</body>
</html>
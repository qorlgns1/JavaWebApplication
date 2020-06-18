<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- exception 객체를 사용할 수 있도록 설정 -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외발생(에러메세지가 보이면 새로운창으로 이동)</title>
</head>
<body>
	에러 메시지 : <%=exception.getMessage() %><br/>
</body>
</html>
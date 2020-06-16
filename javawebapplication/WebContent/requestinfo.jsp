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
		//접속한 클라이언트의 IP 주소 가져오기
		String ip = request.getRemoteAddr();
		//컨텍스트 경로
		String contextPath = request.getContextPath();
		//전체 요청 경로
		String requestURI = request.getRequestURI();
		//라우팅 경로 - requestURI에서 contextPath를 제외한 부분
		// contextPath의 길이만큼을 제외하고 잘라내기
		// 선생님버전  : String route = requestURI.substring(contextPath.length());
		String route = requestURI.replace(contextPath,"") ;
		
	%>
	<h2>IP:<%= ip %></h2>
	<h2>서버경로:<%= contextPath %></h2>
	<h2>요청경로:<%= requestURI %></h2>
	<h2>라우팅경로:<%= route%></h2>
	
</body>
</html>
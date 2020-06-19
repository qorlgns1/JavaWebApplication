<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL의 core 기능을 사용할 수 있도록 태그 라이브러리 설정-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
</head>
<body>
	<!-- 로그인 여부는 대부분 session에 로그인을 했을 때 
	로그인과 관련된 어떤 값을 저장해두고 값의 저장 여부에 따라 판단 -->
	<c:if test="${id == null}">
		<a href="${pageContext.request.contextPath}/authentication/login">로그인</a><br/>
	</c:if>
	<c:if test="${id != null}">
		<a href="${pageContext.request.contextPath}/authentication/logout">로그아웃</a><br/>
	</c:if>
		<a href="${pageContext.request.contextPath}/authentication/write">글쓰기</a><br/>

	
	
</body>
</html>
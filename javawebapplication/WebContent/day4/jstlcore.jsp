<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl core 기능 사용을 위한 라이브러리 설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 변수 생성 -->
<c:set var="score" value="87"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core</title>
</head>
<body>
	<!-- score 라는 속성을 출력 -->
	점수:${score}<br/>
	
	<c:set var="id" value="qorlgns1" />
	<!-- id가 있으면 로그아웃 없으면 로그인 -->
	﻿<c:if test="${id == null}">로그인</c:if>
	﻿<c:if test="${id != null}">${id} - 로그아웃</c:if>
	
	<!-- 위와 동일한 처리는 c:choose로 처리 -->
	<c:choose>
		<c:when test="${id == null}">
			로그인
		</c:when>
		<c:otherwise>
			로그아웃
		</c:otherwise>
	</c:choose>
	
	<br/>
	수량:<select name="count">
	<c:forEach begin="1" end="10" var="num">
		<option value="${num}">${num}</option>
	</c:forEach>
	</select>
	
	<%
		String [] ar = {"서울","대전","대구","부산"};
		request.setAttribute("ar", ar);
	%>
	
		<br/>
	지역:<select name="local123">
	<c:forEach var="local123"  items="${ar}">
		<option value="${local123}">${local123}</option>
	</c:forEach>
	</select>

	<%
	Map<String, Object> map1 = new HashMap<>();
	map1.put("name", "Programming Language");
	map1.put("subject", "Java");
	
	Map<String, Object> map2 = new HashMap<>();
	map2.put("name", "Database");
	map2.put("subject", "Oracle");
	
	List<Map<String, Object>> list = new ArrayList<>();
	list.add(map1);
	list.add(map2);
	
	request.setAttribute("list", list);
	
	 %>
	 
	 <table border = "1">
	 	<tr>
	 		<th>언어</th>
	 		<th>과목</th>
	 	</tr>
	 	<c:forEach var="item" items="${list}">
	 	<tr>
	 		<td>${item.name}</td>
	 		<td>${item.subject}</td>
	 	</tr>
	 	</c:forEach>
	 </table>
	 
	 
</body>
</html>
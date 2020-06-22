<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 제어문 사용을 위한 태그 라이브러리를 설저어 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록보기</title>
</head>
<body>
	<h3 align="center">데이터 목록 보기</h3>
	<table align="center">
		<tr>
			<th>코드</th>
			<th>카테고리</th>
			<th>이름</th>
		</tr>
		<c:forEach var="item" items="${list}">
			<tr>
				<td>&nbsp;${item.code}</td>
				<td>&nbsp;${item.category}</td>
				<td>&nbsp;${item.title}</td>
			</tr>	
		</c:forEach>
	
	</table>
</body>
</html>
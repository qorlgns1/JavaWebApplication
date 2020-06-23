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
	<table align="center" border="1">
		<tr>
			<th>코드</th>
			<th>카테고리</th>
			<th>이름</th>
		</tr>
		<c:forEach var="item" items="${list}">
			<tr>
				<td>&nbsp;${item.code}</td>
				<td>&nbsp;${item.category}</td>
				
				<!-- 기본키의 값을 파라미터로 전송 --> 
				<!-- <td><a href="detail?code=${item.code}">${item.title}</a></td>  -->
				<td>&nbsp;<a href="detail/${item.code}">${item.title}</a></td>
			</tr>	
		</c:forEach>
	
	</table>
	<div align = "center">
		<c:if test="${prev == true}">
			<a href="list?no=${startpage-1}">이전</a>
		</c:if>
		
		<c:forEach var="idx" begin="${startpage}"
		end="${endpage}">
			<c:if test="${pageno == idx}">
				${pageno}&nbsp;
			</c:if>
			<c:if test="${pageno != idx}">
				<a href="list?no=${idx}">${idx}</a>&nbsp;
			</c:if>
		</c:forEach>
		
		<c:if test="${next == true}">
			<a href="list?no=${endpage+1}">다음</a>
		</c:if>
	</div>
</body>
</html>
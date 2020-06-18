<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 페이지의 빈 줄을 없애주는 옵션 -->
<!-- <%@ page trimDirectiveWhitespaces="true" %> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>랜덤한 숫자 생성</title>
</head>
<body>
	<%
		//랜덤 객체 생성
		Random random = new Random();
		//1~45 사이의 6개의 랜덤한 숫자를 정렬해서 저장하기
		//숫자는 중복되면 안됨

		//데이터를 저장할 자료구조 생성
		TreeSet<Integer> lotto = new TreeSet<>();
		while (lotto.size() < 6) {
			//Set은 중복된 데이터를 저장하지 않기 때문에 6개가 될 때 까지 수행
			//nextInt는 숫자로 나눈 나머지를 리턴하게 리턴
			lotto.add(random.nextInt(45) + 1);
		}
	%>

	<!-- java 데이터 출력하기 -->
	<h2><%=lotto%></h2>
</body>
</html>
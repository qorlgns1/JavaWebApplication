<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL출력</title>
</head>
<body>
	1개로 구성된 데이터:${scala} <br/>
	배열:${dbms[0]},${dbms[1]},${dbms[2]} <br/>
	<!-- Map은 key를 속성처럼 사용해서 출력 -->
	<!-- DTO도 동일한 방법으로 출력 -->
	map1 : ${map.overloading};<br/>
	map2 : ${map.overriding};<br/>	
	<!-- List 도 인덱스를 이용해서 출력 -->
	List:${list[0].name}:${list[0].subject}<br/>
</body>
</html>
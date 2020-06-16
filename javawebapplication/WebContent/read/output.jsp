<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OOP</title>
</head>
<body>
<%@ page import="java.util.*" %>	
	<%
		//저장된 데이터를 읽어오기
		//데이터를 사용하기 위해서는 원래의 자료형으로 형변환해서
		//가져와야 합니다.
		List<Map<String, Object>> list = (List<Map<String,Object>>)request.getAttribute("list");
		
		//데이터를 출력
		out.print("<h2>객체 지향의 3대 특징</h2>");
		for(Map<String, Object>map: list){
			out.print("<div>" + map.get("name") + ":" + map.get("description") + "</div>");
		}
	%>
</body>
</html>
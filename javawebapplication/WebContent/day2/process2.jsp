<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼의 파라미터 읽기</title>
</head>
<body>
	<%
	
		//파라미터 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//name, gender, hobby 의 값 읽어보기
	 	String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		//hobby는 여러 개를 선택할 수 있으므로 배열로 읽어야 합니다.
		String[] hobby = request.getParameterValues("hobby");
		
		//기훈 버전
		//String temp1 ="";
		//List<String> list = new ArrayList<>();
		//if(hobby!=null){
		//for(String li : hobby){
		//	list.add(li);
		//}
		//}else{
		//	temp1 = "선택하지않음";
		//}
		
		//선생님 버전
		String disp = "";
		if(hobby==null){
			disp= "선택하지 않음";
		}else{
			for(String temp : hobby){
				disp = disp+ temp + "\t";
			}
		}
		
	%>
	
		<p>name:<%=name %></p>
		<p>gender:<%=gender %></p>
		<p>hobby:<%=disp %></p>
</body>
</html>
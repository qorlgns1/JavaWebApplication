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
		//Boolean result = (Boolean)request.getAttribute("result");
	 	Boolean result = (Boolean)session.getAttribute("result");
		if(result == true){
			out.println("회원 가입 성공");
		}else{
			out.println("회원 가입 실패");
		}
	%> 
	 
	 
	 
	
</body>
</html>
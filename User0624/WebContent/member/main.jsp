<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<script>
	//ajax 요청코드
	var request = new XMLHttpRequest();
	
	//ajax 요청 생성
	request.open("get","user/proxy", true);
	
	//요청을 전송
	request.send('');
	
	//요청을 전송하고 응답이 오면 호출될 콜백 메소드 생성
	request.addEventListener('load', function(event){
		alert(event.target.responseText);
	})
		
</script>
</head>
<body>
	<!-- jsp 파일에서 서버에 요청하는 경우는 상대 경로를 이용하지 않는 것이 좋습니다. -->
	<a href="${pageContext.request.contextPath}/user/register">회원가입</a><br/>
	<a href="${pageContext.request.contextPath}/user/login">로그인</a><br/>
</body>
</html>
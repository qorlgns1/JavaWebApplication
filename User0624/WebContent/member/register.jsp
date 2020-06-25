<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<!-- js/register.js 파일의 링크를 설정 -->
<script src="${pageContext.request.contextPath}/member/js/register.js"></script>
</head>
<body>
	<!-- ajax로 요청하는 경우에는 method가 필요없음 
	id 만 설정 - 웹 만 할 때는 method를 post로 설정
	입력하는 폼에 파일이 존재하는 경우는 enctype을 설정해야 합니다.
	설정안하면 파일 업로드 안됨-->
	<form id="registerform" enctype="multipart/form-data">
		<!-- 유효성 검사 내용 출력 -->
		<div id="msg"></div>
		
		이메일<input type="text" name="email" id="email"/>
		<span id="emailmsg"></span><br/>
		비밀번호<input type="password" name="password" id="password"/>
		<div id="passwordmsg"></div>
		비밀번호 확인<input type="password" name="password1" id="password1"/><br/>
		별명<input type="text" name="nickname" id="nickname"/>
		<div id="nicknamemsg"></div>
		이미지<input type="file"name="image" id="image" /><br />
		<!-- 웹 만 한다면 type은 submit -->
		<input type="button" value="회원가입" id="registerbtn"/>
		<input type="button" value="메인으로" id="mainbtn"/>	
		<input type="button" value="로그인" id="loginbtn"/>
	</form>
</body>
</html>




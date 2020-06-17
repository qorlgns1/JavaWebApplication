<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력</title>
</head>
<body>
	<form action="process.jsp" method="post">
		<input type="email" name="email" placeholder="email을 입력하세요" required="required" /><br/>
		<input type="password" name="password" placeholder="password를 입력하세요" required="required" /><br/>
		<input type="text" name="nickname" placeholder="nickname을 입력하세요" required="required" /><br/>

		<input type="submit" value="회원가입" />
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>덧셈</title>
<style>

</style>

<script>
	//스크립트를 위에 작성하면 아래 load를 꼭 사용해야하고
	//스크립트를 아래에 작성하면 load가 필요없이 그냥 사용하면 된다.
	window.addEventListener("load", function(event){
		//폼의 유효성 검사
		//입력 객체나 메시지 출력 객체를 전부 찾아옴
		var num1 = document.getElementById("num1");
		var num2 = document.getElementById("num2");
		var myform = document.getElementById("myform");
		
		//myform의 데이터를 전송하려고 할 때
		
		myform.addEventLlistener("submit", function(event){
			//데이터의 유효성 검사를 수행
			//유효성 검사에 실패하면 - event.preventDefalut()를 호출하면
			//form의 데이터가 전송되지 않음
			
		
		
		})
		
	})

</script>
</head>
<body>
	<form action="process.jsp" method="get" id="myform">
	
		숫자1:<input type="text" id="num1" name="num1"/> <br/>
		숫자2:<input type="text" id="num2" name="num2"/> <br/>
		<input type ="submit" value="덧셈" />
		
	</form>
</body>
</html>
window.addEventListener("load", function(event){

	var loginform = document.getElementById("loginform");
	var email = document.getElementById("email");
	var password = document.getElementById("password");
	var loginbtn = document.getElementById("loginbtn");
	var mainbtn = document.getElementById("mainbtn");
	
	//mainbtn을 클릭하면 메인 화면으로 이동
	mainbtn.addEventListener("click", function(event){
		location.href = "../";
	});
	
	loginbtn.addEventListener("click", function(event){
		
		//loginbtn을 클릭할 때 email 과 password를 서버로 보내서 로그인을 처리
		//ajax 이용
		//1.ajax 객체 생성
		var request = new XMLHttpRequest();
		//2.ajax 요청 설정
		request.open("post","login", true);
		//3.ajax 파라미터 설정
		//GET 방식이면 open 의 URL 뒤에 붙이고
		//POST 방식이면 FormData 객체를 생성하고 send
		var formdata = new FormData(loginform);
		request.send(formdata);
		
		//4.ajax 응답이 온 경우 처리할 콜백함수 등록
		request.addEventListener("load", function(event){
			//로그인 실패한 경우
			if(event.target.responseText.trim().length ==0){
				alert("없는 email이거나 잘못된 비밀번호입니다.")
			}
			//로그인 성공한 경우
			else{
				location.href = "../";
			}
			
		})
		
		
		
	});
	
	
	
	
	
	
	
});





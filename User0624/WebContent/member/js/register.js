//스크립트 링크가 body 위에 있다면 window의 load 이벤트 안에 작성
window.addEventListener('load',function(event){
	//id를 가지고 필요한 객체들을 찾아오기
	var registerform = document.getElementById("registerform");
	
	var msg = document.getElementById("msg");
	
	var email = document.getElementById("email");
	
	var password = document.getElementById("password");
	var passwordmsg = document.getElementById("passwordmsg");
	var password1 = document.getElementById("password1");
	
	var nickname = document.getElementById("nickname");
	var nicknamemsg = document.getElementById("nicknamemsg");
	
	var image = document.getElementById("image");
	
	var registerbtn = document.getElementById("registerbtn");
	var mainbtn = document.getElementById("mainbtn");
	var loginbtn = document.getElementById("loginbtn");
	
	//mainbtn을 클릭하면 메인 화면으로 이동
	mainbtn.addEventListener("click", function(event){
		location.href = "../";
	});
	
	//loginbtn을 클릭하면 login으로 이동하도록 작성
	loginbtn.addEventListener("click", function(event){
		location.href = "#";
	});
	//email 중복검사 통과 여부를 저장할 변수
	var emailcheck = false;
	
	
	//email을 작성하고 포커스가 떠나면 중복검사를 수행
	email.addEventListener("focusout", function(event){
		if(email.value.trim().length==0){
			emailmsg.innerHTML = "이메일을 필수입니다."
			emailmsg.style.color = "red";	
			//검사하지 않도록 리턴
			return;
		}
		//ajax 요청 객체를 생성
		var request = new XMLHttpRequest();
		//요청 생성
		request.open('get','emailcheck?email='+email.value, true);
	
		//요청을 전송
		request.send('');
		//결과를 받기 위한 부분 생성
		request.addEventListener('load', function(event){
			//결과를 파싱
			var data = JSON.parse(event.target.responseText);
			if(data.result == true){
				emailmsg.innerHTML = "사용 가능한 이메일";
				emailmsg.style.color = "green";
				emailcheck = true;
			}else{
				emailmsg.innerHTML = "사용 불가능한 이메일";
				emailmsg.style.color = "red";
				emailcheck = false;
			}
		})
		
	
	});
	
	
	//닉네임 중복 검사 통과여부를 저장할 변수
	var nicknamecheck = false;
	
	//닉네임을 작성하고 포커스를 옮길 때
	nickname.addEventListener("focusout", function(event){
		//입력한 내용이 없을 때는 검사하지 않음
		if(nickname.value.trim().length==0){
			nicknamemsg.innerHTML = "닉네임은 필수입니다."
			nicknamemsg.style.color = "red";	
			//검사하지 않도록 리턴
			return;
		}
		//ajax 요청 객체를 생성
		var request = new XMLHttpRequest();
		//요청 생성
		request.open('get','nicknamecheck?nickname='+nickname.value, true);
	
		//요청을 전송
		request.send('');
		//결과를 받기 위한 부분 생성
		request.addEventListener('load', function(event){
			//결과를 파싱
			var data = JSON.parse(event.target.responseText);
			if(data.result == true){
				nicknamemsg.innerHTML = "사용 가능한 닉네임";
				nicknamemsg.style.color = "green";
				nicknamecheck = true;
			}else{
				nicknamemsg.innerHTML = "사용 불가능한 닉네임";
				nicknamemsg.style.color = "red";
				nicknamecheck = false;
			}
		
		
	})
	});
});
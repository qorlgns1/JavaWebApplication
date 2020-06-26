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
	
	//회원가입 버튼을 누르면
	registerbtn.addEventListener("click", function(event){
		//폼의 데이터를 전송할 때는 유효성 검사를 해주어야 합니다.
		//필수 항목 검사, 형식에 맞는지, 값의 제한이 있는 경우 그 값인지 등
		if(email.value.trim().length < 1){
			emailmsg.innerHTML = "이메일은 필수 항목";
			emailmsg.style.color = "red";
			return;	
		}
		//형식 검사 - 정규식을 이용
		var emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		
		if(emailRegExp.test(email.value) == false){
			emailmsg.innerHTML = "이메일형식에 맞지 않습니다.";
			emailmsg.style.color = "red";
			return;	
			
			
		}
		
		if(emailcheck == false){
			emailmsg.innerHTML = "사용중인 이메일입니다."
			emailmsg.style.color = "red";
			return;	
		}
		if(nicknamecheck == false){
			nicknamemsg.innerHTML = "사용중인 닉네임 입니다."
			nicknamemsg.style.color = "red";
			return;	
		}
		
		//ajax 요청 객체를 생성
		var request = new XMLHttpRequest();
		//요청 생성
		request.open('post','register', true);
		//폼의 데이터 생성
		var formData = new FormData(registerform);
		//요청을 전송
		request.send(formData);
		//데이터를 전송하고 결과를 받아왔을 때
		request.addEventListener('load', function(event){
		var data = JSON.parse(event.target.responseText);	
		if(data.result == true){
			//메인으로 이동
			alert("회원가입이 성공하였습니다.");
			location.href = "../";
			
		}else{
			alert("웹사이트에 오류가 있습니다. 빠른 시일내에 복구하겠습니다.");
			return;
			
		}
	})
	
	
	
	
	
	});
	
});
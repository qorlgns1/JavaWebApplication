<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		//파라미터 읽기
		request.setCharacterEncoding("utf-8");
	
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String idsave = request.getParameter("idsave");
		
		//idsave 의 값을 확인
		//idsave의 value값이 콘솔창에 출력
		//값이 없으면 null이 출력
		System.out.println(idsave);
		
		
		
		//아이디 저장에 체크를 하지 않은 경우
		if(idsave ==null){
			//id를 저장한 쿠키가 있으면 삭제
			
			//모든 쿠키를 전부 가져오기
			Cookie [] cookies = request.getCookies();
			//쿠키가 존재한다면
			if(cookies != null){
				//쿠키를 전부 순회
				for(Cookie cookie : cookies){
					//id 라는 이름의 쿠키가 존재한다면
					if(cookie.getName().equals("id")){
						//쿠키 삭제
						//쿠키는 삭제하는 메소드가 없고
						//수명을 0으로 만들어서 삭제
						cookie.setMaxAge(0);
						response.addCookie(cookie);
						break;
					}
				}
			}
			
		//아이디 저장에 체크 한 경우
		}else{
			//id를 저장한 쿠키를 생성하고 저장
			
			//쿠키를 생성
			Cookie cookie = new Cookie("id",id);
			
			//쿠키를 저장
			response.addCookie(cookie);
		}
		
		//로그인이 되었을 때 필요한 정보를 Session에 저장
		session.setAttribute("id", id);
		session.setAttribute("nickname", "관리자");
		
		
		//결과 페이지로 리다이렉트
		//response.sendRedirect("loginresult.jsp");
		
		//결과 페이지로 리다이렉트 - 로그인 창이 있는 페이지로 돌아가기
		response.sendRedirect("index.jsp");
		
		
		
	%>
</body>
</html>
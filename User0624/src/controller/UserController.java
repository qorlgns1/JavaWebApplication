package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;


@WebServlet({"/index.html" , "/user/*"})
@MultipartConfig(location="C:\\Users\\30409\\git\\JavaWebApplication\\User0624")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserService userService;
	
  
    public UserController() {
       super();
       userService = UserServiceImpl.sharedInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//공통된 부분을 제거한 주소를 만듭니다.
				String contextPath = request.getContextPath();
				System.out.println("controller.contextPath:" +contextPath);
				String requestURI = request.getRequestURI();
				System.out.println("controller.requestURI:" + requestURI);
				//요청을 맞게 작성했는지 확인
				//완성되면 주석 처리
				String command = requestURI.substring(contextPath.length());
				System.out.println("controller.command:" + command);
				String method = request.getMethod();
				System.out.println("controller.method:" + method);
				
				//단순 페이지 이동은 포워딩
				if(command.equals("/index.html")) {
					response.sendRedirect("./");
				}
				
				else if(command.equals("/user/main")) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("../member/main.jsp");
					dispatcher.forward(request, response);
				}
				else if(command.equals("/user/register") && method.equals("GET")) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("../member/register.jsp");
					dispatcher.forward(request, response);
					
				}
				else if(command.equals("/user/register") && method.equals("POST")) {
					//회원가입을 처리해주는 메소드를 호출
					userService.register(request, response);
					RequestDispatcher dispatcher = request.getRequestDispatcher("../member/registerresult.jsp");
					dispatcher.forward(request, response);
					
				}
				else if(command.equals("/user/emailcheck")) {
					userService.emailCheck(request, response);
					//System.out.println("userService.emailCheck.request : " + request);
					//System.out.println("userService.emailCheck.response : " + response);
					RequestDispatcher dispatcher = request.getRequestDispatcher("../member/emailcheck.jsp");
					dispatcher.forward(request, response);
					System.out.println("이메일체크 요청끝");
					
				}
				else if(command.equals("/user/nicknamecheck")) {
					userService.nicknameCheck(request, response);
					RequestDispatcher dispatcher = request.getRequestDispatcher("../member/nicknamecheck.jsp");
					dispatcher.forward(request, response);
				}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

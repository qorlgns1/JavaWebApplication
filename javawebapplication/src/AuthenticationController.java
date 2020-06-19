

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/authentication/*")
public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AuthenticationController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//루트 경로를 찾아오기
		String contextPath = request.getContextPath();
		//사용자의 요청 경로 찾기
		String requestURI = request.getRequestURI();
		//사용자의 요청 경로를 가지고 라우팅을 하는 것이 가능
		//사용자의 요청 경로에는 루트 경로가 포함되어 있습니다.
		//공통된 부분을 제외한 부분만 추출
		//여기까지 작업은 프레임워크가 해줍니다.
		
		
		System.out.println(contextPath);
		System.out.println(requestURI);
		String routePath = requestURI.substring(contextPath.length()+16);
		System.out.println(routePath);
		//전송 방식을 찾아옵니다.
		String method = request.getMethod();
		System.out.println(method);
		
		//포워딩에 사용할 변수
		RequestDispatcher dispatcher = null;
		
		//라우팅
		switch(routePath) {
		//폼 입력과 처리를 해야 하는 요청의 경우는 요청 URL은 동일하게 만들고
		//method 가지고 구분을 해야 합니다.
		case "login" :
			if(method.equals("GET")) {
				dispatcher = request.getRequestDispatcher("../day5/ex/login.jsp");
				dispatcher.forward(request, response);
				
			}else {
				//로그인 처리 - main.jsp로 이동하도록 작성
				//리다이렉트를 할 때 파일로 직접 리다이렉트를 하지 말고
				//요청으로 리다이렉트 한 후 그 요청을 처리하는 곳에서 포워딩
				//하도록 하는 것을 권장합니다.
				response.sendRedirect("main");
				
			}
			break;
		case "main" :
				dispatcher = request.getRequestDispatcher("../day5/ex/main.jsp");
				dispatcher.forward(request, response);
				break;
		case "write" :
			dispatcher = request.getRequestDispatcher("../day5/ex/write.jsp");
			dispatcher.forward(request, response);
			break;		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

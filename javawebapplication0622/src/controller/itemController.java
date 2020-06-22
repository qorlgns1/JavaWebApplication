package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ItemService;
import service.ItemServiceImpl;


@WebServlet({ "/", "/item/*" })
public class itemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//서비스 인스턴스 참조 변수
	private ItemService itemService;
	
    public itemController() {
        super();
        
        itemService = ItemServiceImpl.sharedInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공통된 부분을 제거한 주소를 만듭니다.
		String contextPath = request.getContextPath();
		String requestURI = request.getRequestURI();
		String command = requestURI.substring(contextPath.length());
		//전송 방식을 저장
		String method = request.getMethod();
		
		//시작 요청이 온 경우 index.jsp 페이지로 포워딩
		
		if(command.equals("/")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			
		}else if(command.equals("/item/list")) {
			//전체 데이터를 가져오는 서비스 메소드 호출
			itemService.list(request, response);
			//결과 페이지로 이동
			//현재 요청이 item/list 이므로
			//../view/list.jsp 이면
			//WebContent/view/list.jsp 가 됩니다.
			RequestDispatcher dispatcher = request.getRequestDispatcher("../view/list.jsp");
			dispatcher.forward(request, response);
			
		}else if(command.equals("/item/insert") && method.equals("GET")) {
			//입력 페이지 이동
			RequestDispatcher dispatcher = request.getRequestDispatcher("../view/insert.jsp");
			dispatcher.forward(request, response);
			
		}else if(command.equals("/item/insert") && method.equals("POST")) {
			//삽입을 처리
			itemService.insert(request, response);
			//삽입하고 결과 페이지로 이동
			//작업을 수행했으므로 목록보기로 리다이렉트
			response.sendRedirect("list");
			
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

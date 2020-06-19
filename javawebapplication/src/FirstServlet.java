

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//URL 매핑을 해주는 어노테이션
@WebServlet("/firstservlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //생성자
    public FirstServlet() {
        super();
    }

    //get 방식의 요청이 온 경우 처리하는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	//post 방식의 요청이 온 경우 처리하는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 방식의 요청을 doGet에서 처리할 수 있도록
		//doGet 메소드를 호출
		doGet(request, response);
	}

}

package service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import domain.Item;
 //controller -> service -> serviceimpl -> dao -> daoimpl -> mapper(지금없음) -> 다시 거꾸로 되돌아감
public class ItemServiceImpl implements ItemService {

		private ItemDao itemDao;
		
		private ItemServiceImpl() {
			//Dao 인스턴스를 생성
			itemDao = ItemDao.sharedInstance();
		}
		
		private static ItemService itemService;
		
		public static ItemService sharedInstance() {
			if(itemService == null) {
				itemService = new ItemServiceImpl();
			}
			return itemService;
		}

		@Override
		public void list(HttpServletRequest request, HttpServletResponse response) {
			//1.파라미터 읽기
			int pageno = 1;
			int perpagecnt = 5;
			
			//파라미터로 페이지 번호와 페이지 당 데이터개수가 넘어오면
			//페이지 번호와 페이지당 데이터 개수 변경
			String no = request.getParameter("no");
			String pagecnt = request.getParameter("pagecnt");
			
			if(no != null) {
				pageno = Integer.parseInt(no);
			}
			if(pagecnt != null) {
				perpagecnt = Integer.parseInt(pagecnt);
				
			}
			//2.파라미터 변환 작업이나 알고리즘 처리
			
			//3.호출할 Dao 메소드의 매개변수를 생성
			
			//4.Dao의 메소드를 호출해서 결과를 저장
			List<Item> list = itemDao.list(pageno, perpagecnt);
			
			//전체 데이터 개수를 가져오기
			int totalCount = itemDao.getCount();
			//데이터 출력화면에 표시할 마지막 페이지 번호와 시작 페이지 번호를 생성
			//하나의 페이지에 페이지 번호를 10개씩 출력
			//종료 페이지 번호를 임시로 계산
			//1 - 10, 2 - 10, 12 - 20 , 21 - 30
			int endPage = (int)(Math.ceil(pageno/10.0)*10.0);
			
			
			
			int startPage = endPage - 9;
			
			//전체 페이지 개수 구하기
			int tempEndPage = (int)(Math.ceil(totalCount/(double)perpagecnt));
			//끝나는 페이지 번호가 전체 페이지 개수보다 크면 끝나는 페이지 번호 수정
			if(endPage > tempEndPage) {
				endPage = tempEndPage;
			}
			
			//이전과 다음의 출력 여부 생성
			boolean prev = startPage == 1 ? false : true;
			boolean next = 
				endPage * perpagecnt >= totalCount ? false : true;
			
			
			
			//Dao의 매개변수를 확인
			
			//5.Dao 메소드 호출 결과를 View로 전달하기 위해서
			//request 나 session 에 저장
			
			//포워딩 할 거면 request
			//리다이렉트 할 거면 session
			request.setAttribute("list", list);
			request.setAttribute("startpage", startPage);
			request.setAttribute("endpage", endPage);
			request.setAttribute("pageno", pageno);
			request.setAttribute("prev", prev);
			request.setAttribute("next", next);
			
		}

		@Override
		public void insert(HttpServletRequest request, HttpServletResponse response) {
			//1.파라미터를 읽기
			//파라미터 인코딩
			try {
				request.setCharacterEncoding("utf-8");
				System.out.println("인코딩 설정");
			} catch (UnsupportedEncodingException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			String category = request.getParameter("category");
			System.out.println("itemserviceimpl.category : " + category);
			String title = request.getParameter("title");
			System.out.println("itemserviceimpl.title : " + category);
			String description = request.getParameter("description");
			System.out.println("itemserviceimpl.description : " + description);
			
			//2.파라미터를 가지고 필요한 작업 수행
			//가장 큰 code를 찾아서 +1 을 해서 code에 대입
			int code = itemDao.maxCode() + 1;
			System.out.println("serviceimpl.code: " + code);
			//3.호출할 DAO 메소드의 매개변수를 생성
			Item item = new Item();
			item.setCode(code);
			item.setCategory(category);
			item.setTitle(title);
			item.setDescription(description);
			System.out.println("serviceimpl.item.toString : " + item.toString());
			//4.DAO 메소드를 호출
			int result = itemDao.insert(item);
			
			System.out.println("itemServiceImpl.result: " + result);
			//5.결과를 저장
			request.getSession().setAttribute(
					"result", result);
		}

		
		@Override
		public void detail(HttpServletRequest request, HttpServletResponse response) {
			//서비스를 호출하는지 확인
			//이 코드가 호출되지 않으면 Controller에서 메소드
			//잘못 호출한 것임
			//System.out.println("3:" + "서비스 호출");

			//1.파라미터 읽기
			/*
			try {
				request.setCharacterEncoding("utf-8");
			}catch(Exception e) {
				//System.out.println(e.getMessage());
				e.printStackTrace();
			}
			String code = request.getParameter("code").trim();
			//2.파라미터를 가지고 일반적인 처리
			*/
			
			//URL에서 가장 마지막 부분 가져오기
			//http://localhost:9000/webitem/item/detail/1
			String [] ar = request.getRequestURI().split("/");
			String code = ar[ar.length-1];
			
			//3.DAO 메소드의 매개변수 만들기
			int c = Integer.parseInt(code);
			
			//이 코드가 제대로 호출되지 않으면
			//파라미터를 읽는 부분이나 비지니스 로직 처리에 문제가 발생
			//System.out.println("4:" + "파라미터 확인");
			
			//4.DAO 메소드를 호출해서 결과를 저장
			Item item = itemDao.detail(c);
			
			//결과를 출력
			//DAO가 결과를 제대로 리턴하는지 확인
			//System.out.println("8:" + item);
			
			//5.이동방법에 따라 사용할 데이터를 저장
			request.setAttribute("item", item);
		}

		@Override
		public void update(HttpServletRequest request, HttpServletResponse response) {
			//1.파라미터를 읽기
			//파라미터 인코딩
			try {
				request.setCharacterEncoding("utf-8");
				//System.out.println("인코딩 설정");
			} catch (UnsupportedEncodingException e) {
				//System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			String title = 
				request.getParameter("title");
			String description = 
				request.getParameter("description");
			String code = 
				request.getParameter("code");
			String category = 
					request.getParameter("category");
			
			
			//3.호출할 DAO 메소드의 매개변수를 생성
			Item item = new Item();
			item.setCode(Integer.parseInt(code));
			item.setCategory(category);
			item.setTitle(title);
			item.setDescription(description);
			
			//4.DAO 메소드를 호출
			int result = itemDao.update(item);
			
			//5.결과를 저장
			//웹 사이트만 고려하면 저장할 필요가 없습니다.
			request.getSession().setAttribute("result", result);
		

		}

		@Override
		public void delete(HttpServletRequest request, HttpServletResponse response) {
			String [] ar = request.getRequestURI().split("/");
			String code = ar[ar.length-1];
			
			int result = itemDao.delete(Integer.parseInt(code));
			
			request.getSession().setAttribute("result", result);
		}
}






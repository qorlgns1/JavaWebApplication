package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import domain.Item;

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
		//1. 파라미터 읽기
		
		//2. 파라미터 변환 작업이나 알고리즘 처리
		
		//3. 호출할 Dao 메소드의 매개변수를 생성
		
		//4. Dao의 메소드를 호출해서 결과를 저장
		List<Item> list = itemDao.list();
		
		//5. Dao 메소드 호출 결과를 View로 전달하기 위해서
		//request 나 session 에 저장
		
		//포워딩할 거면 request
		//리다이렉트 할 거면 session
		request.setAttribute("list", list);
		
	}
	@Override
	public void insert(HttpServletRequest request, HttpServletResponse response) {
		//1. 파라미터 읽기
		try {
			request.setCharacterEncoding("utf-8");
		}catch(Exception e) {}
		String category= request.getParameter("category");
		String title= request.getParameter("title");
		String description= request.getParameter("description");
		//2. 파라미터를 가지고 필요한 작업 수행
		//가장 큰 code를 찾아서 +1 을 해서 code에 대입
		int code = itemDao.maxCode() + 1;
	
		//3. 호출할 Dao 메소드의 매개변수를 생성
		Item item = new Item();
		item.setCode(code);
		item.setCategory(category);
		item.setTitle(title);
		item.setDescription(description);
		
		//4. Dao의 메소드를 호출해서 결과를 저장
		int result = itemDao.insert(item);
				
		//5. Dao 메소드 호출 결과를 View로 전달하기 위해서
		request.getSession().setAttribute("result", result);
	}
}

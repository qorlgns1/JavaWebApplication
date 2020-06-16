<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%
	//파라미터 읽기
	String name = request.getParameter("name");
	//콘솔에 출력
	System.out.println("name: " + name);

	//Business Logic 처리
	
	//결과를 생성
	Map<String, Object> oop1 = new HashMap<>();
	oop1.put("name", "encapsulation");
	oop1.put("description", "불필요한 부분은 숨기고 필요한 부분만 외부로 노출해서 클래스를 만드는 것");
	
	Map<String, Object> oop2 = new HashMap<>();
	oop2.put("name", "inheritance");
	oop2.put("description", "하위 클래스가 상위 클래스의 모든 것을 물려받는 것 - 재사용성 증가");
	
	Map<String, Object> oop3 = new HashMap<>();
	oop3.put("name", "polymorphism");
	oop3.put("description", "동일한 메시지에 대하여 다르게 반응하는 성질 - 동일한 코드가 다른 메소드를 호출하는 것");
	
	List<Map<String, Object>> list = new ArrayList<>();
	list.add(oop1);
	list.add(oop2);
	list.add(oop3);
	
	//이동방법에 따라 데이터를 저장
	//포워딩 할 것이라서 request에 저장
	request.setAttribute("list", list);
	
	//결과 페이지로 이동 - 포워딩
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("output.jsp");
	requestDispatcher.forward(request, response);
%>
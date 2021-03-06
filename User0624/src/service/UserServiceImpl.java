package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

import dao.UserDao;
import domain.User;

public class UserServiceImpl implements UserService {
	//Service에서 사용할 UserDao 변수
	private UserDao userDao;
	
	private UserServiceImpl() {
		userDao = UserDao.sharedInstance();
	}
	
	private static UserService userService;
	
	public static UserService sharedInstance() {
		if(userService == null) {
			userService = new UserServiceImpl();
		}
		return userService;
	}

	@Override
	public void emailCheck(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		//1.별도의 작업을 수행해야 하면 처리
		String email = request.getParameter("email");
		//System.out.println("userserviceimplGetParameter.email : "+email);
		//2.별도의 작업을 수행해야 하면 처리
		//암호화, 파일 업로드, 파라미터를 다른 자료형으로 변환
		//업무처리에 필요한 알고리즘
		
		//3.DAO 작업이 필요하면 호출할 DAO의 매개변수를 생성
		
		//4.DAO의 메소드를 호출해서 결과를 변수에 저장
		boolean result = userDao.emailCheck(email);
		//System.out.println("userserviceimpl.result : " + result);
		
		//5.단순 웹 페이지를 위한 서버의 경우는 결과들을 request 나 session에 저장
		//만약에 REST API 서버의 경우는 JSONObject 클래스의 객체를 만들어서 저장한 후 request에 저장합니다.
		//웹 페이지를 위한 로그인의 경우에만 session에 저장하던지 데이터베이스에 로그인 여부를 저장해 놓습니다.
		JSONObject object = new JSONObject();
		object.put("result", result);
		//System.out.println("userServiceImpl.object : "+object);
		//request에 저장
		request.setAttribute("result", object);
	}
	
	@Override
	public void nicknameCheck(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		//1.별도의 작업을 수행해야 하면 처리
		String nickname = request.getParameter("nickname");
		
		//2.별도의 작업을 수행해야 하면 처리
		//암호화, 파일 업로드, 파라미터를 다른 자료형으로 변환
		//업무처리에 필요한 알고리즘
		
		//3.DAO 작업이 필요하면 호출할 DAO의 매개변수를 생성
		
		boolean result = userDao.nicknameCheck(nickname);		
		//5.단순 웹 페이지를 위한 서버의 경우는 결과들을 request 나 session에 저장
		//만약에 REST API 서버의 경우는 JSONObject 클래스의 객체를 만들어서 저장한 후 request에 저장합니다.
		//웹 페이지를 위한 로그인의 경우에만 session에 저장하던지 데이터베이스에 로그인 여부를 저장해 놓습니다.
		JSONObject object = new JSONObject();
		object.put("result", result);
		
		//request에 저장
		request.setAttribute("result", object);
		
	}

	@Override
	public void register(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
			
			String email = request.getParameter("email");
			//System.out.println("UserServiceImpl.email : " + email);
			String password = request.getParameter("password");
			//System.out.println("UserServiceImpl.password : " + password);
			String nickname = request.getParameter("nickname");
			//System.out.println("UserServiceImpl.nickname : " + nickname);
			//파일은 Part로 읽어냅니다.
			Part part = request.getPart("image");
			//System.out.println("UserServiceImpl.part(image) : " + part);
			//파일명 가져오기
			//content-disposition 이라는 헤더의 값 이용
			String contentDisposition = part.getHeader("content-disposition");
			//System.out.println("UserServiceImpl.contentDisposition : " + contentDisposition);
			//form-data;image;"파일명"의 형태의 문자열에서 파일명만 가져오기
			
			//;으로 분리
			String [] splitStr = contentDisposition.split(";");
			//System.out.println("UserServiceImpl.splitStr : " + splitStr);
			//첫번째"와 마지막 "의 위치를 찾음
			int first = splitStr[2].indexOf("\"");
			//System.out.println("UserServiceImpl.first : " + first);
			int last = splitStr[2].lastIndexOf("\"");
			//System.out.println("UserServiceImpl.last : " + last);
			//위치를 가지고 부분 문자열을 가져오기
			String uploadFileName = splitStr[2].substring(first+1, last);
			//System.out.println("UserServiceImpl.uploadFileName : " + uploadFileName);
			String image = null;
			//위의 파일명에 내용이 없으면 파일을 선택하지 않은 것 입니다.
			if(uploadFileName != null && uploadFileName.length() != 0) {
				//확장자 추출하기
				String [] imsi = uploadFileName.split("\\.");
				//System.out.println("UserServiceImpl.imsi : " + imsi);
				String ext = imsi[imsi.length -1];
				//System.out.println("UserServiceImpl.ext : " + ext);
				//새로운 파일명 만들기
				image = UUID.randomUUID() + "." + ext;
				//System.out.println("UserServiceImpl.image : " + image);
				//파일 업로드
				//여기에서는 사용을 안함 - 나중에복습할때 헷갈리지 말것
				File f = new File("C:\\Users\\30409\\git\\JavaWebApplication\\User0624\\" + image);
				
				part.write(image);
			}
			
			//DAO 파라미터 만들기
			User user = new User();
			user.setEmail(email);
			//user.setPassword(password);
			//암호화 해서 저장
			user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
			user.setNickname(nickname);
			user.setImage(image);
			//System.out.println("UserServiceImpl.user : " + user);	
			
			
			//Dao 메소드 호출
			int result = userDao.register(user);
			//System.out.println("UserServiceImpl.result : " + result);
			//결과를 저장
			JSONObject object = new JSONObject();
			if(result>0) {
				object.put("result", true);
			}else {
				object.put("result", false);
			}
			//System.out.println("UserServiceImpl.object : " + object);
			request.setAttribute("result", object);
			
			
		} catch (Exception e) {
			System.out.println("serviceimpl.insert: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Override
	public void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		}catch (Exception e) {
			System.out.println("serviceimpl.login: " + e.getMessage());
			e.printStackTrace();
		}
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("serviceimpl.login.getParameter.email = " + email);
		System.out.println("serviceimpl.login.getParameter.password = " + password);
		//4. DAO 메소드를 호출해서 결과를 저장
		User user = userDao.login(email);
		//5. 결과를 가지고 필요한 처리를 수행
		if(user != null) {
			//비밀번호 확인
			if(BCrypt.checkpw(password, user.getPassword())) {
				//비밀번호가 일치하는 경우
				user.setPassword(null);
			}else {
				user = null;
			}
			
		}
		System.out.println("serviceimpl.login.user = " + user);
		JSONObject object = new JSONObject();
		if(user != null) {
			object.put("email", user.getEmail());
			object.put("nickname", user.getNickname());
			object.put("image", user.getImage());
		}else {
			object = null;
		}
		request.getSession().setAttribute("result", object);
		System.out.println("serviceimpl.login.object = " + object);
	}

	@Override
	public void proxy(HttpServletRequest request, HttpServletResponse response) {
		//Java Application에 구현할 때는 Thread 안에 구현
		//Android Application에 구현할 때는 Thread 안에 구현하고
		//화면에 표시할 때는 Handler를 이용하거나
		//Thread 와 Handler의 조합인 AsyncTask를 이용
		
		try {
			URL url = new URL("http://www.weather.go.kr/weather/forecast/mid-term-xml.jsp?stnid=109");
			//연결 객체를 생성
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			//옵션을 설정
			conn.setConnectTimeout(30000);
			conn.setUseCaches(false);
			//헤더 설정을 해야 하는 경우에는
			conn.setRequestProperty("헤더이름", "헤더값");
			
			//post 전송이면
			//conn.setRequestProperty("POST");
			
			//데이터 읽어오기
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				sb.append(line + "\n");
			}
			br.close();
			conn.disconnect();
			request.setAttribute("result", sb.toString());
			
		}catch (Exception e) {
			System.out.println("serviceimpl.proxy: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
}

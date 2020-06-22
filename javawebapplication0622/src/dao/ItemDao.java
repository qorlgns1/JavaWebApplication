package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Item;



public class ItemDao {
	//데이터베이스 연동에 필요한 변수
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 생성자 - 데이터베이스 드라이버 클래스 로드
	// 한번만 수행하면 되기 때문에 생성자에 작성
	private ItemDao() {
		try {
			// mysql 드라이버 로드
			Class.forName("com.mysql.jdbc.Driver");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

	private static ItemDao itemDao;
	public static ItemDao sharedInstance() {
		if(itemDao==null) {
			itemDao = new ItemDao();
		}
		return itemDao;
	}
	
	//연결 메소드와 해제 메소드
	//연결과 해제는 모든 곳에서 사용이 되는 부분이므로 중복해서
	//코딩하지 않으려고 별도의 메소드로 생성
	//이 메소드는 코드의 중복을 회피할려고 만든 메소드이므로
	//private 으로 생성해서 외부에서 호출하지 못하도록 생성
	private void connect() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?useUnicode=true&chracterEncoding=utf8","root","12345678");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	private void close() {
		try {
			if( rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	//전체 데이터를 조회하는 메소드
	public List<Item> list() {
		//List를 리턴할 때는 null이 리턴될 수 없도록 만들어야 합니다.
		//반복문에 바로 사용했을 때 NullPointerException이 발생하지 않음
		//데이터가 없는 경우의 구분은 size가 0인지 확인
		
		List<Item> list = new ArrayList<Item>();
		connect();
		//예외처리를 하지 않아도 되는 구문이더라도 개발을 할 때는 하는것이 좋습니다.
		//예외가 발생했을 때 발생한 지점이나 오류를 빨리 해석할 수 있기 때문입니다.
		try {
			//SQL을 작성 - 입력받는 데이터는 ?로 작성
			pstmt = con.prepareStatement("select * from item");
			
			//필요한 파라미터 매핑 - ?가 있으면 매핑
			
			//SQL 실행
			rs = pstmt.executeQuery();
			//결과 사용
			//여러 행이 리턴되면 while - 1개의 행이 리턴되면 if
			//이 작업도 프레임워크를 사용하면 하지 않음
			while(rs.next()) {
				//List의 1개의 행 객체 생성
				Item item = new Item();
				//값 채워 넣기
				item.setCode(rs.getInt("code"));
				item.setCategory(rs.getString("category"));
				item.setTitle(rs.getString("title"));
				//리스트에 삽입
				list.add(item);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		close();
		return list;
	}
	
	public int maxCode() {
		int result = 0;
		connect();
		try {
			//SQL을 생성
			pstmt = con.prepareStatement("select max(code) from item");
			//SQL을 실행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("max(code)");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		
		close();
		return result;
	}
	
	public int insert(Item item) {
		//-1로 초기화해서 -1이 리턴되면 작업 실패
		int result = -1;
		connect();
		try {
			//SQL을 생성
			pstmt = con.prepareStatement("insert into item(code, category, title, description) values(?,?,?,?)");
			//?에 값을 바인딩
			pstmt.setInt(1, item.getCode());
			pstmt.setString(2, item.getCategory());
			pstmt.setString(3, item.getTitle());
			pstmt.setString(4, item.getDescription());
			
			//SQL을 실행
			result = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		close();
		return result;
		
	}
	
	
	
	
	
}

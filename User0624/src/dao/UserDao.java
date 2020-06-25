package dao;

public class UserDao extends AbstractDao {
	//Singleton 패턴을 적용하기 위한 코드
	//인스턴스를 하나만 생성하는 디자인 패턴
	//모든 곳에서 공유할 데이터를 갖는 클래스나
	//Entry point(출입구)에 해당하는 클래스 또는
	//서버에서 클라이언트의 요청을 처리하는 클래스는 
	//인스턴스가 1개이면 됩니다.
	private UserDao() {}
	
	private static UserDao userDao;
	
	public static UserDao sharedInstance() {
		if(userDao == null) {
			userDao = new UserDao();
		}
		return userDao;
	}
	
	//email 중복 검사를 위한 메소드
	public boolean emailCheck(String email) {
		System.out.println("userDAO.email: " + email);
		boolean result = false;
		connect();
		try {
			pstmt = con.prepareStatement("select email from user0624 where upper(email)=?");
			//데이터 바인딩
			pstmt.setString(1, email.toUpperCase());
			//SQL 실행
			rs= pstmt.executeQuery();
			//여기 부분은 본인이 결정
			//데이터가 만약 있다면 false를 리턴하기로 내가 정하고
			//데이터가 만약 없다면 true를 리턴하기로 정해보자.
			if(rs.next()) {
				result = false;
			}else {
				result = true;
			}
		}catch(Exception e) {
			System.out.println("DAO클래스 email 중복 검사 실패");
			System.out.println("DAO : " + e.getMessage());
			e.printStackTrace();
		}
		
		close();
		System.out.println("UserDAO 리턴값: " + result);
		return result;
			
	}
	
	//nickname 중복 검사를 위한 메소드
		public boolean nicknameCheck(String nickname) {
			boolean result = false;
			connect();
			try {
				pstmt = con.prepareStatement("select nickname from user0624 where upper(nickname)=?");
				//데이터 바인딩
				pstmt.setString(1, nickname.toUpperCase());
				//SQL 실행
				rs= pstmt.executeQuery();
				//여기 부분은 본인이 결정
				//데이터가 만약 있다면 false를 리턴하기로 내가 정하고
				//데이터가 만약 없다면 true를 리턴하기로 정해보자.
				if(rs.next()) {
					result = false;
				}else {
					result = true;
				}
			}catch(Exception e) {
				System.out.println("DAO클래스 nickname 중복 검사 실패");
				System.out.println("DAO : " + e.getMessage());
				e.printStackTrace();
			}
			
			close();
			return result;
					
		}
}

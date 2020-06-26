package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
//User 에 대한 처리를 하기 위한 메소드 선언을 위한 인터페이스
//메뉴판과 유사한 역할을 수행합니다.
//만드는방법이 모두 보여지는게 아니라 메뉴판처럼 메뉴의 내용만 보여집니다.
	public void emailCheck(HttpServletRequest request, HttpServletResponse response);
	public void nicknameCheck(HttpServletRequest request, HttpServletResponse response);
	public void register(HttpServletRequest request, HttpServletResponse response);

}

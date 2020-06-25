package domain;

import java.sql.Date;

public class User {
	private String email;
	private String password;
	private String nickname;
	private String image;
	private String islogin;
	private String isremove;
	private Date logindate;
	private Date joindate;
	private int isemail;
	
	public User() {
		super();
	}
	public User(String email, String password, String nickname, String image, String islogin, String isremove,
			Date logindate, Date joindate, int isemail) {
		super();
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.image = image;
		this.islogin = islogin;
		this.isremove = isremove;
		this.logindate = logindate;
		this.joindate = joindate;
		this.isemail = isemail;
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", nickname=" + nickname + ", image=" + image
				+ ", islogin=" + islogin + ", isremove=" + isremove + ", logindate=" + logindate + ", joindate="
				+ joindate + ", isemail=" + isemail + "]";
	}
}

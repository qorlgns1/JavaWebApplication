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
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getIslogin() {
		return islogin;
	}
	public void setIslogin(String islogin) {
		this.islogin = islogin;
	}
	public String getIsremove() {
		return isremove;
	}
	public void setIsremove(String isremove) {
		this.isremove = isremove;
	}
	public Date getLogindate() {
		return logindate;
	}
	public void setLogindate(Date logindate) {
		this.logindate = logindate;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public int getIsemail() {
		return isemail;
	}
	public void setIsemail(int isemail) {
		this.isemail = isemail;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", nickname=" + nickname + ", image=" + image
				+ ", islogin=" + islogin + ", isremove=" + isremove + ", logindate=" + logindate + ", joindate="
				+ joindate + ", isemail=" + isemail + "]";
	}
}

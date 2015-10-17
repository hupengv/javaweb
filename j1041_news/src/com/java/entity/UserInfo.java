package com.java.entity;

public class UserInfo {
	private int userId;
	private String userName;
	private String pwd;
	
	public int getUserId() {
		return userId;
	}
	public UserInfo() {
		
	}
	public UserInfo(int userId, String userName, String pwd) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.pwd = pwd;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}

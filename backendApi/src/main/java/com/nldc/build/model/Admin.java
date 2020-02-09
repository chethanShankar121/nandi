package com.nldc.build.model;

public class Admin {
	
	private int id;
	private String userName;
	private String password;
	private String name;
	
	public Admin(int id, String userName, String password, String name) {
		this.setId(id);
		this.setUserName(userName);
		this.setPassword(password);
		this.setName(name);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}

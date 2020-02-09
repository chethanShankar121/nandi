package com.nldc.build.model;

public class AuthModel {
	
	private int authStatus;
	private String authMessage;
	private String sessionID;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AuthModel(int authStatus, String authMessage, String sessionID, String name) {
		this.setAuthStatus(authStatus);
		this.setAuthMessage(authMessage);
		this.setSessionID(sessionID);
		this.setName(name);
	}
	
	public int getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(int authStatus) {
		this.authStatus = authStatus;
	}
	public String getAuthMessage() {
		return authMessage;
	}
	public void setAuthMessage(String authMessage) {
		this.authMessage = authMessage;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

}

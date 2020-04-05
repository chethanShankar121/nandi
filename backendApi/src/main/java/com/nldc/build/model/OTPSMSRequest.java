package com.nldc.build.model;

public class OTPSMSRequest {
	
	String to;
	String sender;
	String body;
	String userName;
	
	public OTPSMSRequest() {}
	
	public OTPSMSRequest(String to, String Sender, String body, String userName) {
		this.setUserName(userName);
		this.setBody(body);
		this.setSender(Sender);
		this.setTo(to);
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to =  "+91" + to;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = "Dear " + this.userName + ", Thank you for registering for the Nandi Construction, Please use the OTP " + body + "for further process.";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}

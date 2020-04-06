package com.nldc.build.model;

public class OTPSMSRequest {
	
	String numbers;
	String sender;
	String message;
	String apikey;
	
	public OTPSMSRequest() {}
	
	public OTPSMSRequest(String numbers, String Sender, String message, String apiKey) {
		this.setApikey(apiKey);
		this.setMessage(message);
		this.setNumbers("91" + numbers);
		this.setSender(Sender);
	}

	public String getNumbers() {
		return numbers;
	}

	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = "Dear Sir/Madam, Thank you for registering to NLDC constructions your mobile verification OTP is " + message;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
}

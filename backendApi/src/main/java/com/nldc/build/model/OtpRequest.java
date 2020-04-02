package com.nldc.build.model;

public class OtpRequest {

	String operation;
	String mobileNumber;
	Long userId;
	String emailId;
	int emailOtp;
	int mobileOtp;

	OtpRequest(String operation, String mobileNumber, Long userId, String emailId, int emailOtp, int mobileOtp) {
		this.setEmailOtp(emailOtp);
		this.setMobileOtp(mobileOtp);
		this.setEmailId(emailId);
		this.setMobileNumber(mobileNumber);
		this.setOperation(operation);
		this.setUserId(userId);
	}
	
	public int getEmailOtp() {
		return emailOtp;
	}

	public void setEmailOtp(int emailOtp) {
		this.emailOtp = emailOtp;
	}

	public int getMobileOtp() {
		return mobileOtp;
	}

	public void setMobileOtp(int mobileOtp) {
		this.mobileOtp = mobileOtp;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}

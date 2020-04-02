package com.nldc.build.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OTP")
public class OTP {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@Column(name="otp")
	String otp;
	
	@Column(name="otpFor")
	String otpFor;
	
	@Column(name="userId")
	Long userId;


	public OTP() {}
	
	public OTP(String otp, String otpFor, Long userId, Long id) {
		this.setId(id);
		this.setOtp(otp);
		this.setOtpFor(otpFor);
		this.setUserId(userId);
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getOtpFor() {
		return otpFor;
	}

	public void setOtpFor(String otpFor) {
		this.otpFor = otpFor;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	

}

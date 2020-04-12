package com.nldc.build.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nldc.build.model.OtpRequest;
import com.nldc.build.model.ResponseModel;
import com.nldc.build.model.User;
import com.nldc.build.security.MD5;
import com.nldc.build.service.SignUpService;

@RestController
public class SignUpController {
	
	@Autowired
	SignUpService signUpService;

	@PostMapping(value="/addUser", consumes="application/json", produces="application/json")
	public ResponseModel addUser(@RequestBody User user) {
		user.setPassword(MD5.getMd5(user.getPassword()));
		return signUpService.addUser(user);
	}
	
	@PostMapping(value="/addUser/sendOtp", consumes="application/json", produces="application/json")
	public ResponseModel sendOtp(@RequestBody OtpRequest otpRequest) {
		if (otpRequest.getUserId() == null || otpRequest.getOperation() == null)
			return new ResponseModel(409, "Missing values", null);
		return signUpService.sendOtp(otpRequest);
	}
	
	@PostMapping(value="/updateUser", consumes="application/json", produces="application/json")
	public ResponseModel updateUser(@RequestBody User user) {
		if(user.getPassword() != null) {
			user.setPassword(MD5.getMd5(user.getPassword()));
		}
		return signUpService.updateUser(user);
	}
	
	@PostMapping(value="/addUser/verifyOtp", consumes="application/json", produces="application/json")
	public ResponseModel verifyOtp(@RequestBody OtpRequest otpRequest) {
		if(otpRequest.getEmailOtp() == 0 || otpRequest.getMobileOtp() == 0 || otpRequest.getUserId() == null)
			return new ResponseModel(409, "Missing values", null);
		return signUpService.verifyOtp(otpRequest);
	}
	
}

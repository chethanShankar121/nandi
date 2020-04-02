package com.nldc.build.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nldc.build.model.ResponseModel;
import com.nldc.build.model.User;
import com.nldc.build.service.SignUpService;

@RestController
public class SignUpController {
	
	@Autowired
	SignUpService signUpService;

	@PostMapping(value="/addUser", consumes="application/json", produces="application/json")
	public ResponseModel addUser(@RequestBody User user) {
		return signUpService.addUser(user);
	}
	
//	@PostMapping(value="/addUser/sendOtp", consumes="application/json", produces="application/json")
//	public ResponseModel sendOtp() {
//		return 
//	}
	
}

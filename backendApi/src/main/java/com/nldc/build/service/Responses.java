package com.nldc.build.service;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.nldc.build.model.ResponseModel;

@Component
public class Responses {
	
	public ResponseModel notAbleToSendMessage() {
		return new ResponseModel(412, "Not able to send message", null);
	}
	
	public ResponseModel userAlreadyExsits(HashMap<String, Object> userDetails) {
		return new ResponseModel(200, "User already exists", userDetails);
	}
	
	public ResponseModel addedUserSuccessFulyy(HashMap<String, Object> userDetails) {
		return new ResponseModel(200, "added User successfully", userDetails);
	}
	
	public ResponseModel userNotFound() {
		return new ResponseModel(200, "User not found", null);
	}

}

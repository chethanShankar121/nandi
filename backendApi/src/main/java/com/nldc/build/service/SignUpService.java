package com.nldc.build.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nldc.build.jparepository.UserJpaRepository;
import com.nldc.build.model.ResponseModel;
import com.nldc.build.model.User;

@Component
public class SignUpService {
	
	@Autowired
	UserJpaRepository userJpaRepository;
	
	public ResponseModel addUser(User user) {
		this.userJpaRepository.save(user);
		HashMap<String, String> userDetails = new HashMap<String, String>();
		userDetails.put("UserId", user.getId() + "");
		return new ResponseModel(200, "added User successfully", userDetails);
	}

}

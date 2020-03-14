package com.nldc.build.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nldc.build.model.User;
import com.nldc.build.security.MD5;
import com.nldc.build.jparepository.UserJpaRepository;
import com.nldc.build.model.AuthModel;

@Component
public class LoginService {
	
	@Autowired
	UserJpaRepository loginJpaRepository;
	
	public AuthModel authoriseUser(User user) {
		user.setPassword(MD5.getMd5(user.getPassword()));
		List<User> loginResults =  loginJpaRepository.loginUser(user.getEmail(), user.getPassword());
		if(loginResults.size() == 1)
			return new AuthModel(200, "Logged In successfully", "", loginResults.get(0).getFirstName() + loginResults.get(0).getLastName(), loginResults.get(0).getAccessRole());
		else
			return new AuthModel(401, "Loging failure", "", "", -1);
	}

}

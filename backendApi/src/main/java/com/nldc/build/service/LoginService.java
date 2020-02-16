package com.nldc.build.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nldc.build.model.User;
import com.nldc.build.model.AuthModel;
import com.nldc.build.dao.LoginDao;

@Component
public class LoginService {
	
	@Autowired
	LoginDao loginDao;
	
	public AuthModel authoriseUser(User user) {
		User loggedinUser = loginDao.authUser(user);
		return new AuthModel(200, "Logged In successfully", "", loggedinUser.getName(), loggedinUser.getAccessRole());
	}

}

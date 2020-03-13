package com.nldc.build.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.nldc.build.model.User;
import com.nldc.build.model.AuthModel;
import com.nldc.build.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping(value="/login", consumes = "application/json", produces = "application/json")
	public AuthModel authAll(@RequestBody User user) {
		return loginService.authoriseUser(user);
	}

}

package com.nldc.build.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.nldc.build.model.Admin;
import com.nldc.build.model.AuthModel;
import com.nldc.build.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping(value="/adminLogin", consumes = "application/json", produces = "application/json")
	public AuthModel authAdmin(@RequestBody Admin admin ) {
		return adminService.authoriseAdmin(admin);
	}

}

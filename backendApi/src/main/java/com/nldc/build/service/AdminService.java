package com.nldc.build.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nldc.build.model.Admin;
import com.nldc.build.model.AuthModel;
import com.nldc.build.dao.AuthAdminDAO;

@Component
public class AdminService {
	
	@Autowired
	AuthAdminDAO authAdminDao;
	
	public AuthModel authoriseAdmin(Admin admin) {
		return authAdminDao.authAdmin(admin);
	}

}

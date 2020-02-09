package com.nldc.build.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.nldc.build.model.Admin;
import com.nldc.build.model.AuthModel;
import com.nldc.build.query.AdminQuery;
import com.nldc.build.security.MD5;

@Repository
public class AuthAdminDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	MD5 md5;
	
	public AuthModel authAdmin(Admin admin) {
		RowCallbackHandler i = null;
		return (AuthModel) jdbcTemplate.query(AdminQuery.ADMIN_LOGIN, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, admin.getUserName());
				ps.setString(2, md5.getMd5(admin.getPassword()));
				
			}
			
		}, rs -> {
			rs.last();
			int size = rs.getRow();
			if(size == 1) { 
				return new AuthModel(200, "Loggedin successfully", "temp", "punith");
			}else {
				return new AuthModel(401, "Login failure", "", "");
			}
		});
	}

}

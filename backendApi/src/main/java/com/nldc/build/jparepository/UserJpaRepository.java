package com.nldc.build.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.nldc.build.model.User;
import com.nldc.build.model.AuthModel;
import com.nldc.build.query.UserQuery;
import com.nldc.build.security.MD5;

@Repository
public class LoginDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	MD5 md5;
	
	public User authUser(User user) {
		RowCallbackHandler i = null;
		return (User) jdbcTemplate.query(UserQuery.LOGIN_QUERY, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, user.getUserName());
				ps.setString(2, md5.getMd5(user.getPassword()));
				
			}
			
		}, rs -> {
			rs.last();
			int size = rs.getRow();
			if(size == 1) { 
				return new User(rs.getInt(1), rs.getString(2), null, rs.getString(3), rs.getInt(5));
			}
			return new User(0, null, null, null, -1);
		});
	}

}

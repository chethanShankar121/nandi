package com.nldc.build.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nldc.build.model.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {
	
	@Query("Select u from User u where u.email = ?1 and u.password = ?2")
	List<User> loginUser(String email, String password);
	
	@Query("Select u from User u where u.phone = ?1 and u.password = ?2")
	List<User> loginUserPhoneNumber(String phoneNumber, String password);
	
}

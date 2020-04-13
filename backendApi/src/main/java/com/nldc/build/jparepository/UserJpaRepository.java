package com.nldc.build.jparepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nldc.build.model.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {
	
	@Query("Select u from User u where u.email = ?1 and u.password = ?2 and email_verifed=true and phone_number_verifed=true")
	List<User> loginUser(String email, String password);
	
	@Query("Select u from User u where u.phone = ?1 and u.password = ?2 and email_verifed=true and phone_number_verifed=true")
	List<User> loginUserPhoneNumber(String phoneNumber, String password);
	
	@Transactional
	@Modifying
	@Query("delete from User u where u.phone = ?1 or u.email = ?2")
	void deleteUnVerifiedUser(String phoneNumber, String email);
	
	@Query("Select u from User u where u.email = ?1 and email_verifed=true")
	List<User> findByEmailVerified(String email);
	
	@Query("Select u from User u where u.phone = ?1 and phone_number_verifed=true")
	List<User> findByPhoneVerified(String phone);
	
}

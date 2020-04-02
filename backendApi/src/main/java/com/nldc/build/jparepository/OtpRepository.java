package com.nldc.build.jparepository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nldc.build.model.OTP;

@Transactional
public interface OtpRepository  extends JpaRepository<OTP, Long> {
	
	void deleteByUserId(Long userId);

}

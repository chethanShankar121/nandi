package com.nldc.build.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nldc.build.jparepository.OtpRepository;
import com.nldc.build.jparepository.UserJpaRepository;
import com.nldc.build.model.OTP;
import com.nldc.build.model.OtpRequest;
import com.nldc.build.model.ResponseModel;
import com.nldc.build.model.User;
import com.nldc.build.security.MailService;
import com.nldc.build.security.SMS;

@Component
public class SignUpService {

	@Autowired
	UserJpaRepository userJpaRepository;

	@Autowired
	OtpRepository otpRepository;

	@Autowired
	SMS sms;

	@Autowired
	MailService mailService;
	
	@Autowired
	Responses responses;	
	
	public ResponseModel addUser(User user) {
		List<User> userWithEmail = this.userJpaRepository.findByEmailVerified(user.getEmail());
		List<User> userWithPhone = this.userJpaRepository.findByPhoneVerified(user.getPhone());
		HashMap<String, Object> userDetails = new HashMap<String, Object>();
		if (userWithEmail.size() > 0) {
			userDetails.put("additonalDetails", userWithEmail.get(0));
			return this.responses.userAlreadyExsits(userDetails);
		}
		if (userWithPhone.size() > 0) {
			userDetails.put("additonalDetails", userWithPhone.get(0));
			return this.responses.userAlreadyExsits(userDetails);
		}
		userDetails.put("additonalDetails", user);
		this.userJpaRepository.deleteUnVerifiedUser(user.getPhone(), user.getEmail());
		this.userJpaRepository.save(user);
		return this.responses.addedUserSuccessFulyy(userDetails);
	}
	
	public ResponseModel updateUser(User user) {
		Optional<User> requestedUser = this.userJpaRepository.findById(user.getId());
		if (!requestedUser.isPresent()) {			
			return this.responses.userNotFound();
		}
		this.userJpaRepository.save(user);
		HashMap<String, Object> userDetails = new HashMap<String, Object>();
		userDetails.put("additonalDetails", user);
		return this.responses.updatedUserSuccessFulyy(userDetails);
	}

	public ResponseModel sendOtp(OtpRequest otpRequest) {
		Optional<User> requestedUser = this.userJpaRepository.findById(otpRequest.getUserId());
		if (requestedUser.isPresent()) {
			this.otpRepository.deleteByUserId(otpRequest.getUserId());
			User user = requestedUser.get();
			if (otpRequest.getOperation().equalsIgnoreCase("both")) {
				try {
					ResponseModel smsResponse = this.sendMobileOtp(user);
					if (smsResponse.getResponseStatus() == 200) {
						return this.sendEmailOtp(user);
					} else {
						return this.responses.notAbleToSendMessage();
					}
				} catch (Exception e) {
					return this.responses.notAbleToSendMessage();
				}
			} else if (otpRequest.getOperation().equalsIgnoreCase("mail")) {
				try {
					return this.sendEmailOtp(user);
				} catch (Exception e) {
					return this.responses.notAbleToSendMessage();
				}
			} else if (otpRequest.getOperation().equalsIgnoreCase("mobile")) {
				try {
					return this.sendMobileOtp(user);
				} catch (Exception e) {
					return this.responses.notAbleToSendMessage();
				}
			}
		} else {
			return this.responses.userNotFound();
		}
		return new ResponseModel(200, "Not able to send sms", null);
	}

	public ResponseModel verifyOtp(OtpRequest otpRequest) {
		Optional<User> verificationUser = this.userJpaRepository.findById(otpRequest.getUserId());
		if (verificationUser.isPresent()) {
			User user = verificationUser.get();
			List<OTP> otps = user.getOtps();
			boolean verified = true;
			for (OTP otp : otps) {
				if(otp.getOtpFor().equals("email")) {	
					if (!otp.getOtp().equals(Integer.toString(otpRequest.getEmailOtp()))) {
						verified = false;
					}
				} else if (otp.getOtpFor().equals("mobile")) {
					if (!otp.getOtp().equals(Integer.toString(otpRequest.getMobileOtp()))) {
						verified = false;
					}
				}
			}
			if (verified) {
				user.setIsEmailVerified(verified);
				user.setIsPhoneNumberVerified(verified);
				this.userJpaRepository.save(user);
				return new ResponseModel(200, "User Verification Completed", null);
			} else {
				return new ResponseModel(200, "User Verification is failed", null);
			}
		} else {
			return new ResponseModel(200, "User not found", null);
		}
	}

	public ResponseModel sendMobileOtp(User user) {
		Random rnd = new Random();
		String mobileOTP = String.format("%06d", rnd.nextInt(999999));
		this.otpRepository.save(new OTP(mobileOTP, "mobile", user.getId(), null));
		return this.sms.sendSms(user.getFirstName() + user.getLastName(), mobileOTP,
				user.getPhone());
	}
	
	public ResponseModel sendEmailOtp(User user) {
		Random rnd = new Random();
		String emailOTP = String.format("%06d", rnd.nextInt(999999));
		this.otpRepository.save(new OTP(emailOTP, "email", user.getId(), null));
		return this.mailService.sendEmail(user, emailOTP);
	}
}

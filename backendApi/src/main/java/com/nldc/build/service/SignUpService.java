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

	public ResponseModel addUser(User user) {
		Optional<User> userWithEmail = this.userJpaRepository.findByEmail(user.getEmail());
		Optional<User> userWithPhone = this.userJpaRepository.findByPhone(user.getPhone());

		if (userWithEmail.isPresent() || userWithPhone.isPresent()) {
			HashMap<String, String> additonalDetails = new HashMap<String, String>();
			additonalDetails.put("redirectTo", "login");
			return new ResponseModel(200, "User already exists", additonalDetails);
		}
		this.userJpaRepository.deleteUnVerifiedUser(user.getPhone(), user.getEmail());
		this.userJpaRepository.save(user);
		HashMap<String, String> userDetails = new HashMap<String, String>();
		userDetails.put("UserId", user.getId() + "");
		userDetails.put("email", user.getEmail());
		userDetails.put("mobile", user.getPhone());
		return new ResponseModel(200, "added User successfully", userDetails);
	}

	public ResponseModel sendOtp(OtpRequest otpRequest) {
		Optional<User> requestedUser = this.userJpaRepository.findById(otpRequest.getUserId());
		if (requestedUser.isPresent()) {
			this.otpRepository.deleteByUserId(otpRequest.getUserId());
			User user = requestedUser.get();
			Random rnd = new Random();
			String mobileOTP = String.format("%06d", rnd.nextInt(999999));
			String emailOTP = String.format("%06d", rnd.nextInt(999999));
			if (otpRequest.getOperation().equalsIgnoreCase("both")) {
				this.otpRepository.save(new OTP(emailOTP, "email", otpRequest.getUserId(), null));
				this.otpRepository.save(new OTP(mobileOTP, "mobile", otpRequest.getUserId(), null));
				try {
					ResponseModel smsResponse = this.sms.sendSms(user.getFirstName() + user.getLastName(), mobileOTP,
							user.getPhone());
					if (smsResponse.getResponseStatus() == 200) {
						return this.mailService.sendEmail(user, emailOTP);
					} else {
						return new ResponseModel(412, "Not able to send message", null);
					}
				} catch (Exception e) {
					System.out.println("OTP Error = " + e.getMessage());
					return new ResponseModel(412, "Not able to send message", null);
				}
			} else if (otpRequest.getOperation().equalsIgnoreCase("mail")) {
				try {
					return this.mailService.sendEmail(user, emailOTP);
				} catch (Exception e) {
					System.out.println("OTP Error = " + e.getMessage());
					return new ResponseModel(412, "Not able to send message", null);
				}
			} else if (otpRequest.getOperation().equalsIgnoreCase("mobile")) {
				try {
					return this.sms.sendSms(user.getFirstName() + user.getLastName(), mobileOTP, user.getPhone());
				} catch (Exception e) {
					System.out.println("OTP Error = " + e.getMessage());
					return new ResponseModel(412, "Not able to send message", null);
				}
			}
		} else {
			return new ResponseModel(200, "User not found", null);
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
				switch (otp.getOtpFor()) {
				case "email":
					if (!otp.getOtp().equals(Integer.toString(otpRequest.getEmailOtp()))) {
						verified = false;
					}
					break;
				case "mobile":
					if (!otp.getOtp().equals(Integer.toString(otpRequest.getMobileOtp()))) {
						verified = false;
					}
					break;
				}
			}
			if (verified) {
				user.setIsEmailVerified(verified);
				user.setIsPhoneNumberVerified(verified);
				this.userJpaRepository.save(user);
				return new ResponseModel(200, "User Verification Completed", null);
			} else {
				return new ResponseModel(200, "User Verification is not completed", null);
			}
		} else {
			return new ResponseModel(200, "User not found", null);
		}
	}

}

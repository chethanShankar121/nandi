package com.nldc.build.security;

import org.springframework.stereotype.Service;

import com.nldc.build.model.ResponseModel;
import com.nldc.build.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class MailService {

		@Autowired
	    private JavaMailSender javaMailSender;
		
		public ResponseModel sendEmail(User user, String otp) {

	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(user.getEmail());

	        msg.setSubject("Nandi Construction Verification");
	        msg.setText("Dear " + user.getFirstName() + user.getLastName() + ",\r\n Thanks for registering for the Nandi Construction.\r\n\r\n\r\n Please use the OTP for completing the signUp process,\r\n your OTP is "+ otp +"\r\n\r\n\r\n Regards,\r\nNandi Team");

	        javaMailSender.send(msg);
	        
	        return new ResponseModel(200, "Mail Sent", null);

	    }

}

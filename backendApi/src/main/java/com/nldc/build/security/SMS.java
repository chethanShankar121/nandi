package com.nldc.build.security;

import java.net.URLEncoder;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nldc.build.model.OTPSMSRequest;
import com.nldc.build.model.ResponseModel;
import com.nldc.build.model.SMSResponse;

@Service
public class SMS {

	public ResponseModel sendSms(String userName, String OTP, String mobileNumber) {
		try {
			String URL = "https://api.textlocal.in/send/?" ;
			
			String apiKey = "apikey=ka7N3TuJ2cw-oHJI2BHqNrzKWT5EEfKVDJHmwEjjNR";
			String message = "&message=Dear Sir/Madam, Thank you for registering to NLDC constructions your mobile verification OTP is " + OTP;
			String sender = "&sender=NANDIL";
			String numbers = "&numbers=91" + mobileNumber;
			
			SMSResponse result = this.sendSMS(URL + apiKey + sender + message + numbers);
			if (result.getStatus().equals("success")) {
				return new ResponseModel(200, "Message Sent Successfully", null);
			}
			return new ResponseModel(400, "Message not sent", null);
		} catch (Exception e) {
			System.out.println("Error SMS " + e);
			return new ResponseModel(400, "Message not sent", null);
		}
	}

	private SMSResponse sendSMS(String URL) {
		RestTemplate restTemplate = new RestTemplate();
		SMSResponse result = restTemplate.postForObject(URL, null,SMSResponse.class);
		return result;
	}

}

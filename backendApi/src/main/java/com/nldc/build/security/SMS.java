package com.nldc.build.security;

import java.net.URLEncoder;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nldc.build.model.ResponseModel;
import com.nldc.build.model.SMSResponse;

@Service
public class SMS {

	public ResponseModel sendSms(String userName,String OTP, String mobileNumber) {
		try {

			String apiKey = "apikey=" + URLEncoder.encode("ka7N3TuJ2cw-HwgrYIL2zRJxJl6XopqhlORDcNKmTS", "UTF-8");
			String message = "&message=" + URLEncoder.encode("Dear Sir/Madam, Thank you for registering to NLDC constructions your mobile verification OTP is " + OTP , "UTF-8");
			String sender = "&sender=" + URLEncoder.encode("NANDIL", "UTF-8");
			String numbers = "&numbers=" + URLEncoder.encode(mobileNumber, "UTF-8");
			
			String URL = "https://api.textlocal.in/send/?";
			System.out.println(URL + apiKey + message +sender+ numbers);
			SMSResponse result = this.sendSMS(URL + apiKey + message +sender+ numbers);
			if(result.getStatus() == "success") {
				return new ResponseModel(200, "Message Sent Successfully", null);
			}
			return new ResponseModel(400, "Message not sent",null);
		} catch (Exception e) {
			System.out.println("Error SMS " + e);
			return new ResponseModel(400, "Message not sent",null);
		}
	}
	
	private SMSResponse sendSMS(String URL) {
	     RestTemplate restTemplate = new RestTemplate();
	     SMSResponse result = restTemplate.getForObject(URL, SMSResponse.class);
	     return result;
	}

}

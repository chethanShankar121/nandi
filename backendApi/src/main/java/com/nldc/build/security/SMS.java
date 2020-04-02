package com.nldc.build.security;

import org.springframework.web.client.RestTemplate;

import com.nldc.build.model.ResponseModel;
import com.nldc.build.model.SMSResponse;

public class SMS {

	public ResponseModel sendSms(String userName,int OTP, String mobileNumber) {
		try {

			String apiKey = "apikey=" + "ka7N3TuJ2cw-IT2cgOfx7KLgBk7OgCIsENxmxrsz2K";
			String message = "&message=" + "is your phone number verification code. Please enter this code in the specified field.Cheers.";
			String sender = "&sender=" + "NANDIL";
			String numbers = "&numbers=" + mobileNumber;
			
			String URL = "https://api.textlocal.in/send/?";
			SMSResponse result = this.sendSMS(URL + apiKey + message + sender+ numbers);
			if(result.getStatus() == "success") {
				return new ResponseModel(200, "Message Sent Successfully", null);
			}
		} catch (Exception e) {
			System.out.println("Error SMS " + e);
			return new ResponseModel(400, "Message not sent",null);
		}
		return null;
	}
	
	private SMSResponse sendSMS(String URL) {

	     RestTemplate restTemplate = new RestTemplate();
	     SMSResponse result = restTemplate.getForObject(URL, SMSResponse.class);
	     return result;
	}

}

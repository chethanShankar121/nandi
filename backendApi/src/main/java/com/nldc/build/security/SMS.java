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

			HttpHeaders headers = new HttpHeaders();
			headers.set("api-key", "A2a1521e71a3e31026e6ca0caf5fbd41c");

			OTPSMSRequest otpSmsRequest = new OTPSMSRequest(mobileNumber, "KLRHXA", OTP, userName);

			HttpEntity<OTPSMSRequest> request = new HttpEntity<>(otpSmsRequest, headers);

			String URL = "https://api.ap.kaleyra.io/v1/HXAP1662922184IN/messages";

			SMSResponse result = this.sendSMS(URL, request);
			if (result.getStatus() == "ok") {
				return new ResponseModel(200, "Message Sent Successfully", null);
			}
			return new ResponseModel(400, "Message not sent", null);
		} catch (Exception e) {
			System.out.println("Error SMS " + e);
			return new ResponseModel(400, "Message not sent", null);
		}
	}

	private SMSResponse sendSMS(String URL, HttpEntity<OTPSMSRequest> request) {
		RestTemplate restTemplate = new RestTemplate();
		SMSResponse result = restTemplate.postForObject(URL, request, SMSResponse.class);
		return result;
	}

}

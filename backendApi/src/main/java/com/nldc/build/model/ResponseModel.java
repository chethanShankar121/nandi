package com.nldc.build.model;

import java.util.HashMap;

public class ResponseModel {
	
	private String responseStatus;
	private String responseMessage;
	private HashMap<String, String> addtionalInfo;
	
	public ResponseModel(String status, String message,HashMap<String, String> addtionalInfo){
		this.setResponseMessage(message);
		this.setResponseStatus(status);
		this.setAddtionalInfo(addtionalInfo);
	}
	
	public HashMap<String, String> getAddtionalInfo() {
		return addtionalInfo;
	}

	public void setAddtionalInfo(HashMap<String, String> addtionalInfo) {
		this.addtionalInfo = addtionalInfo;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}

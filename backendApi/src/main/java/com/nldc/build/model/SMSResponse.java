package com.nldc.build.model;

import java.util.List;

public class SMSResponse {
	
	String status;
	String message;
	List<Data> data;
	
	SMSResponse() {}
	
	SMSResponse(String status, String message, List<Data> data) {
		this.setData(data);
		this.setMessage(message);
		this.setStatus(status);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}
		
}

class Data {
	
	String id;
	String customid;
	String customid1;
	String mobile;
	String status;

	Data() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomid() {
		return customid;
	}

	public void setCustomid(String customid) {
		this.customid = customid;
	}

	public String getCustomid1() {
		return customid1;
	}

	public void setCustomid1(String customid1) {
		this.customid1 = customid1;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
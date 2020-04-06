package com.nldc.build.model;

import java.util.List;

public class SMSResponse {
	
	String status;
	Message message;
	List<Messages> data;
	List<Errors> errors;
	
	SMSResponse() {}
	
	SMSResponse(String status, Message message, List<Messages> data) {
		this.setData(data);
		this.setMessage(message);
		this.setStatus(status);
	}

	public List<Errors> getErrors() {
		return errors;
	}

	public void setErrors(List<Errors> errors) {
		this.errors = errors;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public List<Messages> getData() {
		return data;
	}

	public void setData(List<Messages> data) {
		this.data = data;
	}
		
}

class Message {
	
	String num_parts;
	String sender;
	String content;
	
	Message() {}

	public String getNum_parts() {
		return num_parts;
	}

	public void setNum_parts(String num_parts) {
		this.num_parts = num_parts;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}

class Messages {
	
	String id;
	String recipient;
	
	Messages() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
}

class Errors {
	int code;
	String message;
	
	Errors() {}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

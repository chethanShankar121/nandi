package com.nldc.build.model;

import java.util.List;

public class SMSResponse {
	
	int balance;
	int batch_id;
	int cost;
	int num_messages;
	Message message;
	List<Messages> messages;
	String status;
	List<Error> errors;
	
	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	SMSResponse() {}
	
	SMSResponse(int balance, int batch_id, int cost, int num_messages, Message message, List<Messages> messages, String status) {
		
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getNum_messages() {
		return num_messages;
	}

	public void setNum_messages(int num_messages) {
		this.num_messages = num_messages;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public List<Messages> getMessages() {
		return messages;
	}

	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

class Messages {
	private int id;
	private int recipient;
	
	Messages() {}
	
	Messages(int id, int recipient) {
		this.setId(id);
		this.setRecipient(recipient);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRecipient() {
		return recipient;
	}

	public void setRecipient(int recipient) {
		this.recipient = recipient;
	}
		
}


class Message {
	
	int num_parts;
	String sender;
	String content;
	
	Message() {}
	
	Message(int num_parts, String sender, String content) {
		this.setContent(content);
		this.setSender(sender);
		this.setNum_parts(num_parts);
	}

	public int getNum_parts() {
		return num_parts;
	}

	public void setNum_parts(int num_parts) {
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

class Error {
	int code;
	String message;
	
	Error() {}
	
	Error(int code, String message) {
		this.setCode(code);
		this.setMessage(message);
	}

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

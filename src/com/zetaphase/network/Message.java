package com.zetaphase.network;

public class Message {
	
	private String message;
	private String toAddress;
	
	public Message(String message, String toAddress){
		this.message = message;
		this.toAddress = toAddress;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public String getToAddress(){
		return this.toAddress;
	}
}

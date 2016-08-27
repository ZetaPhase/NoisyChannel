package com.zetaphase.network;

public class Sender extends Thread {
	
	private String myAddress;
	public PortManager portManager;
	
	public Sender(String myAddress, PortManager portManager){
		super();
		this.myAddress = myAddress;
		this.portManager = portManager;
	}
	
	@Override
	public void run(){
		//get my ip address
		//get to ip address
		String toAddress = "192.168.1.69";
		//get message
		String message = "Dave";
		//put message, my ip address, to ip address, into port
		this.portManager.put(this.myAddress, message);;
	}
}

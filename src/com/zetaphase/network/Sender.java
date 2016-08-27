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
		for(int i=0;i<20;i++){
			//get my ip address
			//get to ip address
			String toAddress = "192.168.1.69";
			//get message
			String message = "Dave";
			//put message, my ip address, to ip address, into port
			this.portManager.senderPutMessage(this.myAddress, new Message(message, toAddress));
			System.out.println("I am sending the message!");
			//System.out.println(portManager.senderPorts);
			//System.out.println(portManager.receiverPorts);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

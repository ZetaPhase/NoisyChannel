package com.zetaphase.network;

public class Receiver extends Thread {
	
	PortManager portManager;
	String receiverIP;
	
	public Receiver(String receiverIP, PortManager portManager){
		super();
		this.portManager = portManager;
		this.receiverIP = receiverIP;
	}
	
	@Override
	public void run(){
		while (true){
			Message message = this.portManager.receiverGetMessage(this.receiverIP);
			if (message != null){
				System.out.println("Receiving Message: "+message.getMessage());
			}else{
				System.out.println("null");
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

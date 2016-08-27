package com.zetaphase.network;

public class Network extends Thread {
	
	PortManager portManager;
	
	public Network(PortManager portManager){
		super();
		this.portManager = portManager;
	}
	
	@Override
	public void run(){
		while (true){
			//get out messages from portManager
			Message message = portManager.networkGetMessage();
			//put retrieved message into receiverPort
			portManager.networkPutMessage(message.getToAddress(), message);
		}
	}
	
}

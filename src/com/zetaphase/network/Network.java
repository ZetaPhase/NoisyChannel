package com.zetaphase.network;

import java.util.Random;

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
			if (message != null){
				Random rand = new Random();
				int n = rand.nextInt(100);
				if (n>20){
					portManager.networkPutMessage(message.getToAddress(), message);
				}
			}
		}
	}
	
}

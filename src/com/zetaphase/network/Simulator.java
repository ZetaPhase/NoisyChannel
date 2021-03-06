package com.zetaphase.network;

public class Simulator {

	public static void main(String[] args) {
		//create and start the port manager thread
		PortManager mPortManager = new PortManager();
		//create and start sender thread
		Sender senderThread = new Sender("192.168.1.68", mPortManager);
		senderThread.start();
		//create and start network thread
		Network networkThread = new Network(mPortManager);
		networkThread.start();
		//create and start receiver thread
		Receiver receiverThread = new Receiver("192.168.1.69", mPortManager);
		receiverThread.start();
	}

}

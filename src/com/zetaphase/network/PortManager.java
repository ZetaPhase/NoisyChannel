package com.zetaphase.network;

import java.util.ArrayList;
import java.util.HashMap;

public class PortManager {
	
	private HashMap<String, ArrayList<String>> senderPorts = new HashMap<String, ArrayList<String>>();
	private HashMap<String, ArrayList<String>> receiverPorts = new HashMap<String, ArrayList<String>>();
	
	public void put(String senderIP, String message){
		if (senderPorts.containsKey(senderIP)){
			ArrayList<String> tmp = senderPorts.get(senderIP);
			tmp.add(message);
			senderPorts.put(senderIP, tmp);
		}
	}
}

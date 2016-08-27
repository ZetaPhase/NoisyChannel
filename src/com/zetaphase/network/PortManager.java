package com.zetaphase.network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PortManager {
	
	private HashMap<String, ArrayList<Message>> senderPorts = new HashMap<String, ArrayList<Message>>();
	private HashMap<String, ArrayList<Message>> receiverPorts = new HashMap<String, ArrayList<Message>>();
	
	public void senderPutMessage(String ip, Message message){
		if (! senderPorts.containsKey(ip)){
			senderPorts.put(ip, new ArrayList<Message>());
		}
		senderPorts.get(ip).add(message);
	}
	
	public void networkPutMessage(String ip, Message message){
		if (! receiverPorts.containsKey(ip)){
			receiverPorts.put(ip, new ArrayList<Message>());
		}
		receiverPorts.get(ip).add(message);
	}
	
	public Message networkGetMessage(){
		List keys = new ArrayList(senderPorts.keySet());
		Message result = senderPorts.get(keys.get(0)).get(0);
		senderPorts.get(keys.get(0)).remove(0);
		if (senderPorts.get(keys.get(0)).isEmpty()){
			senderPorts.remove(keys.get(0));
		}
		return result;
	}
	
	public Message receiverGetMessage(String ip){
		Message result = receiverPorts.get(ip).get(0);
		receiverPorts.get(ip).remove(0);
		if (receiverPorts.get(ip).isEmpty()){
			receiverPorts.remove(ip);
		}
		return result;
	}
}

package com.zetaphase.network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PortManager {
	
	public HashMap<String, ArrayList<Message>> senderPorts = new HashMap<String, ArrayList<Message>>();
	public HashMap<String, ArrayList<Message>> receiverPorts = new HashMap<String, ArrayList<Message>>();
	
	public synchronized void senderPutMessage(String ip, Message message){
		if (! senderPorts.containsKey(ip)){
			senderPorts.put(ip, new ArrayList<Message>());
		}
		senderPorts.get(ip).add(message);
	}
	
	public synchronized void networkPutMessage(String ip, Message message){
		if (! receiverPorts.containsKey(ip)){
			receiverPorts.put(ip, new ArrayList<Message>());
		}
		receiverPorts.get(ip).add(message);
	}
	
	public synchronized Message networkGetMessage(){
		if (! senderPorts.isEmpty()){
			List keys = new ArrayList(senderPorts.keySet());
			Message result = senderPorts.get(keys.get(0)).get(0);
			senderPorts.get(keys.get(0)).remove(0);
			if (senderPorts.get(keys.get(0)).isEmpty()){
				senderPorts.remove(keys.get(0));
			}
			return result;
		}
		return null;
	}
	
	public synchronized Message receiverGetMessage(String ip){
		if (! receiverPorts.isEmpty()){
			Message result = receiverPorts.get(ip).get(0);
			receiverPorts.get(ip).remove(0);
			if (receiverPorts.get(ip).isEmpty()){
				receiverPorts.remove(ip);
			}
			return result;
		}
		return null;
	}
}

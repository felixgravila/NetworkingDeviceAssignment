package dao;

import java.util.ArrayList;
import java.util.List;

import model.NetworkingDevice;

public class NetworkingDeviceDao {
	private static NetworkingDeviceDao instance;
	private List<NetworkingDevice> networkingDevices;
	private int nextId;
	
	private NetworkingDeviceDao(){
		networkingDevices = new ArrayList<>();
		nextId = 0; //starts at 0 because getNextId increments it first
	};
	
	//make it a singleton to simulate a persistence layer
	public static NetworkingDeviceDao getInstance(){
		if(instance == null)
			instance = new NetworkingDeviceDao();
		return instance;		
	}
	
	public NetworkingDevice getById(int id){
		for(NetworkingDevice n: networkingDevices)
			if(n.getId()==id)
				return n;
		return null;
	}
	
	public void deleteById(int id){
		for(NetworkingDevice n: networkingDevices)
			if(n.getId()==id){
				networkingDevices.remove(n);
				return;
			}
	}
	
	public List<NetworkingDevice> getNetworkingDevices(){
		return networkingDevices; 
	}
	
	public void addNetworkingDevice(NetworkingDevice net){
		if(net.getId() == 0){ //creating
			net.setId(getNextId());
			networkingDevices.add(net); 
			return;
		}			
		for(NetworkingDevice n: networkingDevices)
			if(n.getId() == net.getId()){ //means updating
				networkingDevices.remove(n);
				networkingDevices.add(net); 
				return;
			}
		networkingDevices.add(net); //just adding a new one
	}
	
	public int getNextId(){
		return ++nextId;
	}
	

}

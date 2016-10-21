package main;

import java.util.ArrayList;

import javax.sound.sampled.Port;

import dao.NetworkingDeviceDao;
import model.NetworkingDevice;
import resource.NetworkingDeviceResource;

public class Main {
	//main place to configure port
	static int port = 80;
	/*
	 * entry point
	 */
	public static void main(String[] args) {
		//start the REST service for networking devices
		NetworkingDeviceResource nrs = new NetworkingDeviceResource(port); 
		initSomeData();
	}
	
	//to have some data
	private static void initSomeData(){
		ArrayList<Long> ports = new ArrayList<>();
		ports.add(4567l);
		NetworkingDevice n1 = new NetworkingDevice("M1", "MM1", "192.168.0.0", ports);
		ports = new ArrayList<>();
		ports.add(8080l);
		ports.add(8081l);
		NetworkingDevice n2 = new NetworkingDevice("M2", "MM2", "192.168.0.1", ports);
		NetworkingDeviceDao.getInstance().addNetworkingDevice(n1);
		NetworkingDeviceDao.getInstance().addNetworkingDevice(n2);
	}
}

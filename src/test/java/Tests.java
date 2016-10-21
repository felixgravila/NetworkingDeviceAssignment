import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.NetworkingDeviceDao;
import model.NetworkingDevice;

public class Tests {
	
	@Before
	public void setUp(){
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

	@Test
	public void testUniqueIds() {
		assert NetworkingDeviceDao.getInstance().getNextId() == NetworkingDeviceDao.getInstance().getNextId()-1;
	}
	
	@Test
	public void testAddWorked(){
		assert NetworkingDeviceDao.getInstance().getNetworkingDevices().size() == 2;
	}
	
	@Test
	public void testDelete(){
		NetworkingDeviceDao.getInstance().getNetworkingDevices().remove(NetworkingDeviceDao.getInstance().getNetworkingDevices().get(0));
		assert NetworkingDeviceDao.getInstance().getNetworkingDevices().size() == 1;
	}
	
	@After
	public void tearDown(){
		NetworkingDeviceDao.getInstance().getNetworkingDevices().clear();
	}

}

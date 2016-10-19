package resource;
import static spark.Spark.*;

import dao.NetworkingDeviceDao;

public class NetworkingDeviceResource {
	public NetworkingDeviceResource() {
		/*
		 * Create a device
		 * Get a device
		 * List devices
		 * Update a device
		 * Upload image (a photograph) of a device
		 * Specify network ports for a device
		 */
		
		get("/NetworkingDevice", (req, res) -> {return NetworkingDeviceDao.getInstance().getNetworkingDevices();});
		
        get("/NetworkingDevice/:id", (req, res) -> {
        	
        	return "Hello NetworkingDevice";
        });
	}
}

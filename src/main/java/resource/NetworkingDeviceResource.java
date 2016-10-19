package resource;
import static spark.Spark.*;

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
		
		
        get("/NetworkingDevice/:id", (req, res) -> {
        	
        	return "Hello NetworkingDevice";
        });
	}
}

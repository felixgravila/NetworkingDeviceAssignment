package resource;

import static spark.Spark.*;
import java.io.InputStream;
import java.util.Arrays;

import javax.servlet.MultipartConfigElement;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.NetworkingDeviceDao;
import model.NetworkingDevice;

public class NetworkingDeviceResource {
	ObjectMapper mapper;

	public NetworkingDeviceResource() {
		mapper = new ObjectMapper();

		// list devices
		get("/NetworkingDevice/all", (req, res) -> {
			return mapper.writeValueAsString(NetworkingDeviceDao.getInstance().getNetworkingDevices());
		});

		// get a device
		get("/NetworkingDevice/byid/:id", (req, res) -> {
			int id = Integer.parseInt(req.params("id"));
			return mapper.writeValueAsString(NetworkingDeviceDao.getInstance().getById(id));
		});

		// creating a device
		post("/NetworkingDevice", (req, res) -> {
			try{
			NetworkingDevice n = mapper.readValue(req.body(), NetworkingDevice.class);
			System.out.println(n);
			NetworkingDeviceDao.getInstance().addNetworkingDevice(n);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "OK";
		});
		
		//deleting a device
		delete("/NetworkingDevice/:id", (req,res) -> {
			int id = Integer.parseInt(req.params("id"));
			NetworkingDeviceDao.getInstance().deleteById(id);
			return "OK";
		});

		// updating device, same code as creating because addNetworkingDevice
		// updates or creates depending on if id exists
		put("/NetworkingDevice", (req, res) -> {
			NetworkingDevice n = mapper.readValue(req.body(), NetworkingDevice.class);
			NetworkingDeviceDao.getInstance().addNetworkingDevice(n);
			return "OK";
		});
		
		//Setting ports
		put("/NetworkingDevice/updatePorts/:id", (req, res) -> {
			Long[] ports = mapper.readValue(req.body(), Long[].class);
			int id = Integer.parseInt(req.params("id"));
			NetworkingDeviceDao.getInstance().getById(id).setPorts(Arrays.asList(ports));
			return "OK";
		});

		// Upload image
		post("/NetworkingDevice/uploadPicture/:id", (req, res) -> {
			req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
			// getPart needs to use same name as input field in form
			try (InputStream input = req.raw().getPart("uploaded_file").getInputStream()) {
				int id = Integer.parseInt(req.params("id"));
				NetworkingDevice n = NetworkingDeviceDao.getInstance().getById(id);
				if (input != null)
					n.setPhoto(input);
			}
			return "OK";
		});
	}
}
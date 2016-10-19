package model;

import java.awt.image.BufferedImage;
import java.util.List;

import dao.NetworkingDeviceDao;

public class NetworkingDevice {
	int id;
	String manufacturer;
	String model;
	String hostname;
	String comment;
	BufferedImage photo;
	List<Long> ports;

	public NetworkingDevice(String manufacturer, String model, String hostname, List<Long> ports) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.hostname = hostname;
		this.ports = ports;
		this.id = NetworkingDeviceDao.getInstance().getNextId(); //emulates a database auto increment
	}

	public int getId() {
		return id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public BufferedImage getPhoto() {
		return photo;
	}

	public void setPhoto(BufferedImage photo) {
		this.photo = photo;
	}

	public List<Long> getPorts() {
		return ports;
	}

	public void setPorts(List<Long> ports) {
		this.ports = ports;
	}

}

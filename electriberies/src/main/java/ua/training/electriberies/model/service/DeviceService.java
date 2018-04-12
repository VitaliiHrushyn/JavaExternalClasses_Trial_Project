package ua.training.electriberies.model.service;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import ua.training.electriberies.model.dao.DAOFactory;
import ua.training.electriberies.model.dao.interfaces.GenericDAO;
import ua.training.electriberies.model.entity.devices.Device;

public class DeviceService {
	
	private static DAOFactory daoFactory = DAOFactory.getInstance();		
	
	/**
	 * Firstly sorts devices which are switched ON after that which are switched OFF
	 */
	private static class DeviceComparator implements Comparator<Device> {
		@Override
		public int compare(Device o1, Device o2) {
			if (o1.isSwitched() && !o2.isSwitched()) {
				return -1;
			}
			else if (!o1.isSwitched() && o2.isSwitched()) {
				return 1;
			} else {
				return o1.getPower() - o2.getPower();
			}
		}			
	}
	
	private static List<Device> getAllDevices() {
		List<Device> devices;
	    try (GenericDAO<Device> deviceDAO = daoFactory.createDeviceDAO()) {
	        devices = deviceDAO.getAll();
	    } catch (Exception e) {
			throw new RuntimeException(e);
		} 	
		return devices; 
	}
	
	static public List<Device> showAllDevises() {
		List<Device> devices = getAllDevices();
		devices.sort(new DeviceComparator());
		return devices;
	}
	
	static public List<Device> findDevises(int powerFrom, int powerTo, int voltageFrom, int voltageTo) {
		List<Device> filteredDevices = new CopyOnWriteArrayList<>();
		for (Device device : getAllDevices()) {
			if (device.match(powerFrom, powerTo, voltageFrom, voltageTo)) {
				filteredDevices.add(device);
			}
		}
		filteredDevices.sort(new DeviceComparator());
		return filteredDevices;
	}
	
	static public int showTotalPower(List<Device> devices) {
		int totalPower = 0;
		for (Device device : devices) {
			totalPower += device.getPower();
		}
		return totalPower;
	}
	
	static public int showCurrentPower(List<Device> devices) {
		int currentPower = 0;
		for (Device device : devices) {
			if (device.isSwitched()) currentPower += device.getPower();
		}
		return currentPower;
	}
}

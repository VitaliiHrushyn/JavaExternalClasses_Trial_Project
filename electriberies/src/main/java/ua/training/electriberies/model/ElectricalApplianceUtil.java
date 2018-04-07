package ua.training.electriberies.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import ua.training.electriberies.model.dao.ElectricalApplianceSourceStub;
import ua.training.electriberies.model.entity.devices.ElectricalAppliance;

public class ElectricalApplianceUtil {
	
	/**
	 * Firstly sorts devices which are switched ON after that which are switched OFF
	 */
	private static class electroComparator implements Comparator<ElectricalAppliance> {
		@Override
		public int compare(ElectricalAppliance o1, ElectricalAppliance o2) {
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
	private static List<ElectricalAppliance> getAllDevices() {
		return Arrays.asList(ElectricalApplianceSourceStub.values());
	}
	
	static public List<ElectricalAppliance> showAllDevises() {
		List<ElectricalAppliance> devices = getAllDevices();
		devices.sort(new electroComparator());
		return devices;
	}
	
	static public List<ElectricalAppliance> findDevises(int powerFrom, int powerTo, int voltageFrom, int voltageTo) {
		List<ElectricalAppliance> filteredDevices = new CopyOnWriteArrayList<>();
		for (ElectricalAppliance device : getAllDevices()) {
			if (device.match(powerFrom, powerTo, voltageFrom, voltageTo)) {
				filteredDevices.add(device);
			}
		}
		filteredDevices.sort(new electroComparator());
		return filteredDevices;
	}
	
	static public int showTotalPower(List<ElectricalAppliance> devices) {
		int totalPower = 0;
		for (ElectricalAppliance device : devices) {
			totalPower += device.getPower();
		}
		return totalPower;
	}
	
	static public int showCurrentPower(List<ElectricalAppliance> devices) {
		int currentPower = 0;
		for (ElectricalAppliance device : devices) {
			if (device.isSwitched()) currentPower += device.getPower();
		}
		return currentPower;
	}
}

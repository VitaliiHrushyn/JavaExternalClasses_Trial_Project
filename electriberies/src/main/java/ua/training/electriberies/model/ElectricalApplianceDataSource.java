package ua.training.electriberies.model;

import java.util.ArrayList;
import java.util.List;

public class ElectricalApplianceDataSource {
	
	private static List<ElectricalAppliance> devices = new ArrayList<>();
	
	static {
		devices.add(new HeatingDevice("heater", 1800, "hall"));
		devices.add(new HeatingDevice("warm floor", 1200, "kitchen"));
		devices.add(new IndustryDevices("machine tool", 3000, "workshop"));
		devices.add(new KitchenAppliance("mixer", 300, "kitchen", 1));
		devices.add(new KitchenAppliance("oven", 2500, "kitchen", 30));
		devices.add(new LightingDevices("bra", 50, "corridor", 600));
		devices.add(new LightingDevices("luster", 350, "hall", 2000));
	}
	
	private ElectricalApplianceDataSource() {
		super();
	}
	
	public static List<ElectricalAppliance> getDevices() {
		return devices;
	}
}

package ua.training.electriberies.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Deprecated
public class ElectricalApplianceDataSource {
	
	private static List<ElectricalApplianceAbstractImp> devices = new CopyOnWriteArrayList<>();
	
	static {
		devices.add(new HeatingDevice("heater", 1800, "hall"));
		devices.add(new HeatingDevice("warm floor", 1200, "kitchen"));
		devices.add(new IndustryDevices("machine tool", 3000, "workshop"));
		devices.add(new KitchenAppliance("mixer", 300, "kitchen", 1));
		devices.add(new KitchenAppliance("oven", 2500, "kitchen", 30));
		devices.add(new LightingDevices("lamp", 50, "corridor", 600));
		devices.add(new LightingDevices("luster", 350, "hall", 2000));
		
		devices.get(1).setSwitched(true);
		devices.get(2).setSwitched(true);
		devices.get(3).setSwitched(true);
		devices.get(4).setSwitched(true);
	}
	
	private ElectricalApplianceDataSource() {
		super();
	}
	
	public static List<ElectricalApplianceAbstractImp> getAllDevices() {
		return devices;
	}
}

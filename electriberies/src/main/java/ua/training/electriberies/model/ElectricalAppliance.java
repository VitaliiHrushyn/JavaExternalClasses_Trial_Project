package ua.training.electriberies.model;

public abstract class ElectricalAppliance {
	
	protected String name;
	protected boolean switched = false;
	protected int power; // watts
	protected int voltage; // volts
	protected String location; // room
	
	public ElectricalAppliance(String name, int power, int voltage, String location) {
		super();
		this.name = name;
		this.power = power;
		this.voltage = voltage;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public boolean isSwitched() {
		return switched;
	}

	public void setSwitched(boolean switched) {
		this.switched = switched;
	}

	public int getPower() {
		return power;
	}

	public int getVoltage() {
		return voltage;
	}

	public String getLocation() {
		return location;
	}
	
	public abstract void doWork();

}

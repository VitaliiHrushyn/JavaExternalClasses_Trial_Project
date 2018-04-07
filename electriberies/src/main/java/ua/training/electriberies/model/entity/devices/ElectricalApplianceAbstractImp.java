package ua.training.electriberies.model.entity.devices;

public abstract class ElectricalApplianceAbstractImp implements ElectricalAppliance {
	
	protected String name;
	protected boolean switched = false;
	protected int power; // watts
	protected int voltage; // volts
	protected String location; // room
	
	public ElectricalApplianceAbstractImp(String name, int power, int voltage, String location) {
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
	
	public boolean match(int powerFrom, int powerTo, int... voltages) {
		return matchPower(powerFrom, powerTo) && matchVoltage(voltages);
	}

	private boolean matchPower(int powerFrom, int powerTo) {
		return this.power >= powerFrom && this.power <= powerTo;
	}
	
	private boolean matchVoltage(int... voltages) {
		for (int i : voltages) {
			if (this.voltage == i) {
				return true;
			}
		}
		return false;
	}

	public abstract String doWork();

}

package ua.training.electriberies.model.entity.devices;

public abstract class DeviceAbstractImp implements Device {
	
	private int id;
	private String name;
	private boolean switched = false;
	private int power; // watts
	private int voltage; // volts
	private String location; // room
	
	public DeviceAbstractImp(String name, int power, int voltage, String location) {
		super();
		this.name = name;
		this.power = power;
		this.voltage = voltage;
		this.location = location;
	}

	public DeviceAbstractImp() {
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}

	public void setLocation(String location) {
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
	
	public abstract String doWork();
	
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

	@Override
	public String toString() {
		return "\nDevice: id=" + id + ", name=" + name + ", switched=" + switched + ", power=" + power
				+ ", voltage=" + voltage + ", location=" + location + ".";
	}


}

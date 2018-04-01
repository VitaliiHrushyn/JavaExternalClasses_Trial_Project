package ua.training.electriberies.model;

public class IndustryDevices extends ElectricalAppliance {
	
	private int rotorSpeed;
	
	public IndustryDevices(String name, int power, String location) {
		super(name, power, 380, location);
		this.rotorSpeed = 800; // defaul value
	}

	public int getRotorSpeed() {
		return rotorSpeed;
	}

	public void setRotorSpeed(int rotorSpeed) {
		this.rotorSpeed = rotorSpeed;
	}

	@Override
	public void doWork() {
		System.out.println(name + " is rotating with speed of " + rotorSpeed);
	}

}

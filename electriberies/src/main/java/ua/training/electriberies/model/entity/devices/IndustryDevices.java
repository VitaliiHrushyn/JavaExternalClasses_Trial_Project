package ua.training.electriberies.model.entity.devices;

public class IndustryDevices extends ElectricalApplianceAbstractImp {
	
	private Integer rotorSpeed;
	
	public IndustryDevices(String name, int power, String location) {
		super(name, power, 380, location);
		this.rotorSpeed = 800; // defaul value
	}

	public Integer getRotorSpeed() {
		return rotorSpeed;
	}

	public void setRotorSpeed(Integer rotorSpeed) {
		this.rotorSpeed = rotorSpeed;
	}

	@Override
	public String doWork() {
		return (switched) ? (name + " is rotating with speed of " + rotorSpeed) : "nothing";
	}

}

package ua.training.electriberies.model.entity.devices;

public class IndustryDevices extends DeviceAbstractImp {
	
	private Integer rotorSpeed = 800;	
	
	
	public IndustryDevices() {
		super();
	}

	public Integer getRotorSpeed() {
		return rotorSpeed;
	}

	public void setRotorSpeed(Integer rotorSpeed) {
		this.rotorSpeed = rotorSpeed;
	}

	@Override
	public String doWork() {
		return (super.isSwitched()) ? (super.getName() + " is rotating with speed of " + rotorSpeed) : "nothing";
	}

}

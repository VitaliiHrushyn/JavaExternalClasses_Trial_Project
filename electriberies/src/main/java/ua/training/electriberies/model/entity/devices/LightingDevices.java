package ua.training.electriberies.model.entity.devices;

public class LightingDevices extends DeviceAbstractImp {	

	private Integer lightOutput = 200; // lumens
	
	public LightingDevices() {
		super();
	}

	public int getLightOutput() {
		return lightOutput;
	}

	@Override
	public String doWork() {
		return (super.isSwitched()) ? (super.getName() + " is lightening of " + lightOutput + " lumens") : "nothing";
	}

}

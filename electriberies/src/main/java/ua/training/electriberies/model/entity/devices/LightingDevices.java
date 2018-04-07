package ua.training.electriberies.model.entity.devices;

public class LightingDevices extends ElectricalApplianceAbstractImp {	

	private Integer lightOutput; // lumens
	
	public LightingDevices(String name, int power, String location, int lightOutput) {
		super(name, power, 220, location);
		this.lightOutput = lightOutput;
	}

	public int getLightOutput() {
		return lightOutput;
	}

	@Override
	public String doWork() {
		return (switched) ? (name + " is lightening of " + lightOutput + " lumens") : "nothing";
	}

}

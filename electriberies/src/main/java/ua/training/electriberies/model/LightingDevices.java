package ua.training.electriberies.model;

public class LightingDevices extends ElectricalAppliance {	

	private int lightOutput; // lumens
	
	public LightingDevices(String name, int power, String location, int lightOutput) {
		super(name, power, 220, location);
		this.lightOutput = lightOutput;
	}

	public int getLightOutput() {
		return lightOutput;
	}

	@Override
	public void doWork() {
		System.out.println(name + "is lightening of " + lightOutput + " lumens");
	}

}

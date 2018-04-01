package ua.training.electriberies.model;

public class HeatingDevice extends ElectricalAppliance {	

	private int temperatura;
	
	public HeatingDevice(String name, int power, String location) {
		super(name, power, 220, location);
		this.temperatura = 20; // default temperatura
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	@Override
	public String doWork() {
		return (switched) ? (name + " is heating with temperature: " + temperatura) : "nothing";
	}

}

package ua.training.electriberies.model.entity.devices;

public class HeatingDevice extends ElectricalApplianceAbstractImp {	

	private Integer temperature;
	
	public HeatingDevice(String name, int power, String location) {
		super(name, power, 220, location);
		this.temperature = 20; // default temperatura
	}

	public int getTemperatura() {
		return temperature;
	}

	public void setTemperatura(Integer temperatura) {
		this.temperature = temperatura;
	}

	@Override
	public String doWork() {
		return (switched) ? (name + " is heating with temperature: " + temperature) : "nothing";
	}

}

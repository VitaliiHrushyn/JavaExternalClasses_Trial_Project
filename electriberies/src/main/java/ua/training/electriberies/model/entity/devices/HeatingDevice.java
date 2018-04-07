package ua.training.electriberies.model.entity.devices;

public class HeatingDevice extends DeviceAbstractImp {	

	private Integer temperature = 20;
	
	public HeatingDevice() {
		super();
	}

	public int getTemperatura() {
		return temperature;
	}

	public void setTemperatura(Integer temperatura) {
		this.temperature = temperatura;
	}

	@Override
	public String doWork() {
		return (super.isSwitched()) ? (super.getName() + " is heating with temperature: " + temperature) : "nothing";
	}

}

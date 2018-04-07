package ua.training.electriberies.model.entity.devices;

public class KitchenAppliance extends DeviceAbstractImp {
	
	private Integer volume = 2; // liters	
	

	public KitchenAppliance() {
		super();
	}

	public int getVolume() {
		return volume;
	}

	@Override
	public String doWork() {
		return (super.isSwitched()) ? (super.getName() + " is cooking " + volume + " liters  of goodies") : "nothing";
	}

}

package ua.training.electriberies.model.entity.devices;

public class KitchenAppliance extends ElectricalApplianceAbstractImp {
	
	private Integer volume; // liters

	public KitchenAppliance(String name, int power, String location, int volume) {
		super(name, power, 220, location);
		this.volume = volume;
	}

	public int getVolume() {
		return volume;
	}

	@Override
	public String doWork() {
		return (switched) ? (name + " is cooking " + volume + " liters  of goodies") : "nothing";
	}

}

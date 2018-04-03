package ua.training.electriberies.model;

public interface ElectricalAppliance {
	
	public String getName();

	public boolean isSwitched();

	public void setSwitched(boolean switched);

	public int getPower() ;
	
	public int getVoltage();

	public String getLocation();
	
	public boolean match(int powerFrom, int powerTo, int voltageFrom, int voltageTo);
	
	public abstract String doWork();

}

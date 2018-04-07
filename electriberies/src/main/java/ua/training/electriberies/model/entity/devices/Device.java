package ua.training.electriberies.model.entity.devices;

public interface Device {
	
	void setId(int id);
	
	int getId();
	
	void setName(String name);
	
	void setPower(int power);
	
	void setVoltage(int voltage);
	
	void setLocation(String location);
	
	String getName();

	boolean isSwitched();

	void setSwitched(boolean switched);

	int getPower() ;
	
	int getVoltage();

	String getLocation();
	
	boolean match(int powerFrom, int powerTo, int... voltages);
	
	abstract String doWork();

}

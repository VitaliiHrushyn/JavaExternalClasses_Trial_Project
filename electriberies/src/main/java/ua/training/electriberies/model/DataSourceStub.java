package ua.training.electriberies.model;

public enum DataSourceStub implements ElectricalAppliance {
	HEATER("heater", false, 1800, 220, "hall", 20, null, null, null) {
		@Override
		public String doWork() {
			return (switched) ? (name + " is heating with temperature: " + temperature) : "nothing";
		}
	},
	WARM_FLOOR("warm floor", true, 1200, 220, "kitchen", 22, null, null, null) {
		@Override
		public String doWork() {
			return (switched) ? (name + " is heating with temperature: " + temperature) : "nothing";
		}
	},
	MACHINE_TOOL("machine tool", true, 3000, 380, "work shop", null, 800, null, null) {
		@Override
		public String doWork() {
			return (switched) ? (name + " is rotating with speed of " + rotorSpeed) : "nothing";
		}
	},
	MIXER("mixer", false, 300, 220, "kitchen", null, null, 1, null) {
		@Override
		public String doWork() {
			return (switched) ? (name + " is cooking " + volume + " liters  of goodies") : "nothing";
		}
	},
	OVEN("oven", true, 2500, 220, "kitchen", null, null, 30, null) {
		@Override
		public String doWork() {
			return (switched) ? (name + " is cooking " + volume + " liters  of goodies") : "nothing";
		}
	},
	LAMP("lamp", true, 50, 220, "corridor", null, null, null, 600) {
		@Override
		public String doWork() {
			return (switched) ? (name + " is lightening of " + lightOutput + " lumens") : "nothing";
		}
	},
	LUSTER("luster", false, 350, 220, "hall", null, null, null, 2000) {
		@Override
		public String doWork() {
			return (switched) ? (name + " is lightening of " + lightOutput + " lumens") : "nothing";
		}
	};
	
	String name;
	boolean switched;
	int power;
	int voltage;
	String location;
	Integer temperature;
	Integer rotorSpeed;
	Integer volume;
	Integer lightOutput;
	
	

	private DataSourceStub(String name, boolean switched, int power, int voltage, String location, Integer temperature,
			Integer rotorSpeed, Integer volume, Integer lightOut) {
		this.name = name;
		this.switched = switched;
		this.power = power;
		this.voltage = voltage;
		this.location = location;
		this.temperature = temperature;
		this.rotorSpeed = rotorSpeed;
		this.volume = volume;
		this.lightOutput = lightOut;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isSwitched() {
		return switched;
	}

	@Override
	public void setSwitched(boolean switched) {
		this.switched = switched;
	}

	@Override
	public int getPower() {
		return power;
	}

	@Override
	public int getVoltage() {
		return voltage;
	}

	@Override
	public String getLocation() {
		return location;
	}

	@Override
	public boolean match(int powerFrom, int powerTo, int voltageFrom, int voltageTo) {
		return ( 
				(this.power >= powerFrom && this.power <= powerTo) &&
				(this.voltage >= voltageFrom && this.voltage <= voltageTo)
			);
	}

	@Override
	public abstract String doWork();

}

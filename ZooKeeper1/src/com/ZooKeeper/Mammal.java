package com.ZooKeeper;

public class Mammal {
	
	protected int energyLevel;
	
	// Every mammal should have an energy level (default 100)
	public Mammal() {
		this.energyLevel = 100;
	}
	
	
	// set the energy level
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	

	// method to display the energy level through the getEnergyLevel
	public int displayEnergy() {
		
		System.out.println("The energy level is:" + this.energyLevel);
		return this.energyLevel;
		
	}
	
}

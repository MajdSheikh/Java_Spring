package com.ZooKeeper;

public class Gorilla extends Mammal {

	// constructor for Gorilla
	public Gorilla() {
		super();
	}
	
	// method for throwing things, which makes the Gorilla lose energy by 5
	public void throwSomething() {
		this.energyLevel -= 5;
		this.displayEnergy();
	} 
	
	// method eat bananas, makes the Gorilla to regain energy by 10
	public void eatBananas( ) {
		this.energyLevel += 10;
		this.displayEnergy();
		
	}
	
	// method climb, makes the Gorilla lose energy by 10
	public void climb() {
		this.energyLevel -= 10;
		this.displayEnergy();
	}
	
	

}

package com.ZooKeeper;

public class Bat extends Mammal{
	
	// constructor for Bat, default energy level is 300
		public Bat() {
			super();
			this.energyLevel = 300;
		}
		
		// method fly, lose energy by 50
		public void fly() {
		     this.energyLevel -= 50;
		     this.displayEnergy();
		    }
		
		// method eatHumans, gain energy by 25
		public void eatHumans() {
		     this.energyLevel += 25;
		     this.displayEnergy();
		    }
		
		// method attackTown, lose energy by 100
		public void attackTown() {
		     this.energyLevel -= 100;
		     this.displayEnergy();
		    }

}

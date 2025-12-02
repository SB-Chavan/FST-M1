package activities;

import java.util.ArrayList;
import java.util.Date;

//

public class Plane {
	
	private ArrayList<String> passengers;
    private int maxPassengers;
    //private Date lastTimeTookOf;
    private Date lastTimeLanded;
	
	public Plane(int maxPassangers) {
		this.maxPassengers = maxPassangers;
		this.passengers = new ArrayList<>();
		
	}
	
	public void onboard(String passenger) {
		if (passengers.size() < maxPassengers) {
			passengers.add(passenger);
		}
		else {
			System.out.println("PLANE IS FULL.");
		}
		
	}
	
	public Date takeOff() {
		return new Date();
		
	}
	
	public void land() {
		this.lastTimeLanded = new Date();
		passengers.clear();
		
	}
	
	public Date getLastTimeLanded() {
		return lastTimeLanded;
		
		
	}
	
	public ArrayList<String> getPassengers(){
		return passengers;
		
	}
	
	
	
}

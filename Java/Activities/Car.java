package activities;

public class Car {

	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	
	public Car() {
		this.tyres = 4;
		this.doors = 4;
	}
	
	
	///Methods 1 2 3
	public void displayCharacteristics() {
		System.out.println("Color of the CAR:" + color);
		System.out.println("Car Transmission:" + transmission);
		System.out.println("Making year:" + this.make);
		System.out.println("Tyre Count:" + this.tyres);
		System.out.println("Total Doors:" + this.doors);
	}
	
	
	//////----2
	public void accelerate() {
		System.out.println("CAR is moving forward.");
	}
	
	////----3
	///
	
	public void brake() {
		System.out.println("Car has stopped.");
		
	}
		
	
	
	
}

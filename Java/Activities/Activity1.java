package activities;

public class Activity1 {

	public static void main(String[] args)
	{
		Car carDetails = new Car();
		
		carDetails.color = "Black";
		carDetails.transmission = "Automatic";
		carDetails.make = 2025;
		
		carDetails.displayCharacteristics();
		carDetails.accelerate();
		carDetails.brake();
	}
	
}

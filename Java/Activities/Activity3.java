package activities;

public class Activity3 {

	public static void main(String[] args) {
		
		double seconds= 1000000000;
		

		double EarthSeconds = 31557600;
		double MercurySeconds = 0.2408467;
		double VenusSeconds = 0.61519726;
		double MarsSeconds = 1.8808158;
		double JupiterSeconds = 11.862615;
		double SaturnSeconds = 29.447498;
		double UranusSeconds = 84.016846;
		double NeptuneSeconds = 164.79132;
		
		System.out.println("Age at Mercury: "+"In Seconds-" + seconds + "In EarthSeconds-" +EarthSeconds + "In MercurySeconds-" + MercurySeconds);
		System.out.println("Age at Venus:" + seconds / VenusSeconds);
		System.out.println("Age at Mars:" + seconds / MarsSeconds);
		System.out.println("Age at Jupiter:" + seconds / JupiterSeconds);
		System.out.println("Age at Saturn:" + seconds / SaturnSeconds);
		System.out.println("Age at Uranus:" + seconds / UranusSeconds);
		System.out.println("Age at Neptune:" + seconds / NeptuneSeconds);
	
	}
}

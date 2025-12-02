package activities;

public class Activity6 {
	public static void main(String[] args) {
		
		
		
		Plane plane = new Plane(10);
		
		
		
		plane.onboard("Sagar");
		plane.onboard("Ganesh");
		plane.onboard("Sandip");
		
		
		
		System.out.println("take-off time:" + plane.takeOff() );
		
		
		System.out.println("list of passengers:" + plane.getPassengers());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		plane.land();
		System.out.println("LandingTime:" + plane.getLastTimeLanded());
		
		
		
	}
}

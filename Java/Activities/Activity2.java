package activities;

public class Activity2 {
	public static void main(String[] args) {
		
		// initialize an array with 6 numbers
		int[] sampleArray = {10,77,10,54,-11,10};
		
		// For counting declare int variable 
		int sum = 0;
		
		////Finding d the all 10's in the array'
		 for (int num : sampleArray) {
			 
			 // Check 10's
			 if (num == 10) {
				 sum = sum + 10;
				 
			 }
		 }
		 
		 //Check count=30
		 
		 if (sum == 30) {
			 
			 System.out.println("The Count Value is 30.");
			 
		 }
		 else {
			 System.out.println("The count is not 30.");
		 }
		 
		
	}
}

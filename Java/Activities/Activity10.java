package activities;

import java.util.HashSet;

public class Activity10 {
	
	public static void main(String[] args) {
		
		HashSet<String> hs = new HashSet<String>();
		
		hs.add("Apple");
		hs.add("Banana");
		hs.add("Cat");
		hs.add("Dog");
		hs.add("Elephant");
		hs.add("Fish");
		
		System.out.println("Hash set values:" + hs);
	
		
		System.out.println("Size of the hash set is : " + hs.size());
		
		
		hs.remove("Banana");
		
		System.out.println("Now updated hash set:" +hs);
		
		if(hs.remove("hat")) {
			System.out.println("The value HAT is removed from hash set");
		}
		else {
			System.out.println("The value HAT is not present in hash set");
		}
		
		boolean checkPresent = hs.contains("Tiger");
		
		System.out.println("Is Tiger value is present in hash set: " + checkPresent);
		
		// Print updated set
		
		System.out.println("Updated Set: " + hs);
		
		
		
	}

}

package activities;

import java.util.HashMap;

public class Activity11 {
	
	public static void main(String[] args) {
		
		HashMap<Integer, String> hashMapColor = new HashMap<Integer, String>();
			
			hashMapColor.put(1, "RED");
			
			hashMapColor.put(2, "PINK");
			
			hashMapColor.put(3, "YELLOW");
			
			hashMapColor.put(4, "PURPLE");
			
			hashMapColor.put(5, "ORANGE");
			
			System.out.println("Current HashMap:" + hashMapColor);
			
			// Removing Yellow color
			
			hashMapColor.remove(4);
			
			// After removing the 4th number color
			
			System.out.println("After removing the 4th the MAP :" + hashMapColor);
			
			// Checking if green exists in map
			
			if(hashMapColor.containsValue("GREEN")) {
				
				System.out.println("GREEN exist in the map");
				
			}
			else{
				
				System.out.println("Green does not exists");
			}
			
			// print the size of the MAP:
			
			System.out.println("SIze of the map is " + hashMapColor.size());
			
		
	}

}

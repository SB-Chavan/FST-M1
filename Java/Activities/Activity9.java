package activities;

import java.util.ArrayList;

public class Activity9 {
	
	public static void main(String[] args) {
		
		ArrayList<String> myList = new ArrayList<String>();
		
		myList.add("SAGAR");
		myList.add("NEHA");
		myList.add("KETAN");
		myList.add("DURWA");
		myList.add("SIYA");
		
		for(String name:myList) {
			System.out.println("Print all names:" + name);
		}
		
		
		System.out.println("3rd Index value: " + myList.get(3));
		
		
		if(myList.contains("KETAB")) {
			
			System.out.println("KETAN is present in the list");
		}
		else {
			System.out.println("KETAN is not present");
		}
		
		
		System.out.println("Size of the Array: " + myList.size());
		
		System.out.println("Removing the 4th index " + myList.remove(4) + "\n" + "After removing the 4th index the array list" +myList);
		
		
	}

}

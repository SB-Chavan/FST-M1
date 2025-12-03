package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomScannerActivity13 {
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Random indexGen = new Random();
		
		
		
        System.out.print("Enter integers please ");
    	System.out.println("(EOF or non-integer to terminate): ");
		
		
		while(scan.hasNextInt()) {
		    list.add(scan.nextInt());
		}
		
		
		Integer nums[] = list.toArray(new Integer[0]);
		int index = indexGen.nextInt(nums.length);
		
		System.out.println("generated index values --> " + index);
		System.out.println("value in the array at that index value--> " + nums[index]);
	
 
	
        scan.close();
		
	}
}

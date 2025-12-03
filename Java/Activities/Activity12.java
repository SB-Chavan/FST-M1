package activities;


interface Addable{
	int add(int a, int b);
}

public class Activity12 {
	
	public static void main(String[] args) {
		
		//create two variables, both of type Addable(the interface)-ad1 and ad2
		//ad1, contains a lambda expression(no body), that saves the result of num1 plus num2
		Addable ad1 = (x, y)->(x+y);
		System.out.println(ad1.add(20, 30));
		
		
		//ad2, contains a lambda function(has a body), that also saves the result of num1 plus num2
		Addable ad2 = (int x, int y) -> {
			return (x + y);
		};
		System.out.println(ad2.add(50, 60));
		
		
		
	}
	
	

}

package activities;

public class Activity8 {
	
	public static void main(String[] args) {
		
		try{
			Activity8.exceptionTest("Will be print to console");
			Activity8.exceptionTest(null);
			
			Activity8.exceptionTest("Won't execute this line ");
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception error in catch block -- message:" + e.getMessage());
		}
		
		
		
	}

	private static void exceptionTest(String string) throws CustomException {
		
		// TODO Auto-generated method stub
		
		if(string == null) {
			throw new CustomException("String value is null");
		}
		else {
			System.out.println(string);
		}
	}

}

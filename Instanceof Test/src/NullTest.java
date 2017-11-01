
public class NullTest {
	private static boolean test (Object obj) {
		if(obj == null)
			System.out.println("null Object");
		
		if(obj instanceof NullTest) 
			System.out.println("NullTest Object");
		
		if(!(obj instanceof NullTest)) 
			System.out.println("Different Object");
				
		return true;
	}
	
	public static void main(String[] args) {
		NullTest t = new NullTest();
		
		test(null);
			//null Object
			//Different Object
		
		test(t);
			//NullTest Object
		
		test("abc");
			//Different Object
	}
}

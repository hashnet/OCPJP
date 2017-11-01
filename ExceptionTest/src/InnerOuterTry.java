
public class InnerOuterTry {
	public static void main(String[] args) {
		System.out.println("Entered main");
		
		try {
			System.out.println("Inside outer try block");
			//throwR();
			
			try {
				System.out.println("Inside inner try block");
				throwR();
				System.out.println("throwR method executed");
			} catch (RuntimeException e) {
				System.out.println("Inside inner catch block");
				throwR();
			} finally {
				System.out.println("Inside inner finally block");
				throwE();
				System.out.println("throwR method executed");
			}
		} catch (RuntimeException e) {
			System.out.println("Inside outer catch for RuntimeException");
			throwR();
		} catch (Exception e) {
			System.out.println("Inside outer catch for Exception");
			throwR();
		} finally {
			System.out.println("Inside outer finally block");
		}
	}
	
	private static void throwR() throws RuntimeException {
		System.out.println("Inside throwR. Throwing RuntimeException");
		
		throw new RuntimeException();
	}
	
	private static void throwE() throws Exception {
		System.out.println("Inside throwE. Throwing Exception");
		
		throw new Exception();
	}
}

/*Program output:
Entered main
Inside outer try block
Inside inner try block
Inside throwR. Throwing RuntimeException
Inside inner catch block
Inside throwR. Throwing RuntimeException
Inside inner finally block
Inside throwE. Throwing Exception
Inside outer catch for Exception
Inside throwR. Throwing RuntimeException
Inside outer finally block
Exception in thread "main" java.lang.RuntimeException
	at InnerOuterTry.throwR(InnerOuterTry.java:36)
	at InnerOuterTry.main(InnerOuterTry.java:27)*/
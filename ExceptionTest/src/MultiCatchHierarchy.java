
public class MultiCatchHierarchy {
	static class ExceptionA extends Exception {}
	static class ExceptionB extends ExceptionA {}
	static class ExceptionC extends Exception {}
	
	static class RuntimeExceptionA extends RuntimeException {}
	static class RuntimeExceptionB extends RuntimeExceptionA {}
	static class RuntimeExceptionC extends RuntimeException {}
	
	public static void main(String[] args) {
		//MultiCatchHierarchy thisObject = new MultiCatchHierarchy();
		System.out.println("Testing Exception");
		
		try {			
		} catch (RuntimeException e) {}
		
//		try {
//		} catch (RuntimeExceptionA | RuntimeException e) {}	//The exception MultiCatchHierarchy.RuntimeExceptionA is already caught by the alternative RuntimeException
		
//		try {
//		} catch (RuntimeExceptionA | RuntimeException e) {}	//The exception MultiCatchHierarchy.RuntimeExceptionA is already caught by the alternative RuntimeException
	
		try {
		} catch (RuntimeExceptionA | RuntimeExceptionC e) {}
		
		try {
		} catch (Exception e) {}
		
//		try {
//		} catch (ExceptionA e) {}	//Unreachable catch block for MultiCatchHierarchy.ExceptionA. This exception is never thrown from the try statement body
		
		try {
			throw new ExceptionA();
		} catch (ExceptionA e) {}
		
		try {
			throw new ExceptionA();
		} catch (Exception e) {}
		
//		try {
//			throw new ExceptionA();	//Unhandled exception type MultiCatchHierarchy.ExceptionA
//		} catch (ExceptionB e) {}
		
		try {
			throw new ExceptionB();
		} catch (ExceptionA e) {}
		
//		try {
//			throw new ExceptionA();
//		} catch (ExceptionA | Exception e) {}	//The exception MultiCatchHierarchy.ExceptionA is already caught by the alternative Exception
		
//		try {
//			throw new ExceptionA();
//		} catch (ExceptionA | ExceptionB e) {}	//The exception MultiCatchHierarchy.ExceptionB is already caught by the alternative MultiCatchHierarchy.ExceptionA
		
//		try {
//			throw new ExceptionA();
//		} catch (ExceptionA | ExceptionC e) {}	//Unreachable catch block for MultiCatchHierarchy.ExceptionC. This exception is never thrown from the try statement body
		
		try {
			letsThrow();
		} catch (ExceptionA | ExceptionC e) {}
	}
	
	private static void letsThrow() throws ExceptionA, ExceptionC {}
}

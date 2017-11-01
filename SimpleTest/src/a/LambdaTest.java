package a;

public class LambdaTest {
	private interface FunctionVoid {
		public void test(int x);
	}
	
	private interface FunctionInt {
		public int test(int x);
	}
	
	/*@FunctionalInterface
	private abstract class ACVoid {		//Compilation fails. Invalid '@FunctionalInterface' annotation; LambdaTest.ACVoid is not a functional interface
		public abstract void test(int x);
	}*/
	
	private static void returnVoid(int x, FunctionVoid fVoid) {
		fVoid.test(x);
		System.out.println("void");
	}
	
	private static void returnInt(int x, FunctionInt fInt) {
		int y = fInt.test(x);
		System.out.println(y);
	}
	
	public static void main(String[] args) {
		//returnVoid(10, a -> a);			//Compilation fails. Void methods cannot return a value
		returnVoid(10, a -> {});
		//returnVoid(10, a -> {return a;});	//Compilation fails. Void methods cannot return a value
		returnVoid(10, a -> {return;});
		
		returnInt(10, a -> a);
		//returnInt(10, a -> {});				//Compilation fails. Void methods cannot return a value
		returnInt(10, a -> {return a;});
		//returnInt(10, a -> {return;});	//Compilation fails. Void methods cannot return a value
	}
}

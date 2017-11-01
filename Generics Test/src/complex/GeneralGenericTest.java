package complex;
class A<T> {
	private T t;
	// private static T tt; 	//Compilation fails. Cannot make a static reference to the non-static type T

	public A(T t) {
		this.t = t;
	}

	public void incompatibles(T[] arr) {	//This is ok
		// T t = new T(); 					//Compilation fails. Cannot instantiate the type T
		//T[] t= new T[0]; 					//Compilation fails for new T[0]. Cannot create a generic array of T
		T[] t = arr;						//This is ok
		// if(t instanceof T) 				//Compilation fails. Cannot perform instanceof check against type parameter T. Use its erasure Object instead since further generic type information will be erased at runtime
	}
}

class B {
	public static <T> T getStaticBack(T t) {
		System.out.println(t);

		return t;
	}

	public <T> T getInstanceBack(T t) {
		System.out.println(t);

		return t;
	}
}

class RawVsPara<T> {
	
}

public class GeneralGenericTest {
	public static void main(String[] args) {
		A<Integer> a = new A<>(new Integer(1));
		// A<int> b = new A<>(1); 				//Compilation fails.
		//a = new A<String>(new String(""));	//Compilation fails. Type mismatch: cannot convert from A<String> to A<Integer>

		RawVsPara<Integer> para1 = new RawVsPara<>();
		RawVsPara<Integer> para2 = new RawVsPara<>();
		RawVsPara raw1 = new RawVsPara();		//Warning: RawVsPara is a raw type. References to generic type RawVsPara<T> should be parameterized
		RawVsPara raw2 = new RawVsPara();		//Warning: RawVsPara is a raw type. References to generic type RawVsPara<T> should be parameterized
		para1 = para2;
		para1 = raw2;							//Type safety: The expression of type RawVsPara needs unchecked conversion to conform to RawVsPara<Integer>
		raw2 = para1;
		raw2 = raw1;
		
		
		B.getStaticBack(1);						//Prints: 1. (1) is passed to the method as Integer
		Integer i1 = B.getStaticBack(1);
		Integer i2 = B.<Integer>getStaticBack(1);
		//Long l1 = B.getStaticBack(1); 		//Compilation fails. Type mismatch: cannot convert from Integer to Long
		//Long l2 = B.<Long>getStaticBack(1);	// Compilation fails. The parameterized method <Long>getStaticBack(Long) of type B is not applicable for the arguments (Integer)
		Long l3 = B.getStaticBack(new Long(1));
		Long l4 = B.<Long>getStaticBack(new Long(1));
		
		B.getStaticBack("1");					//Prints: 1. (1) is passed to the method as String
		String s1 = B.getStaticBack("1");
		//B.<String>getStaticBack(1);			//Compilation fails. The parameterized method <String>getStaticBack(String) of type B is not applicable for the arguments (Integer)
		B.<String>getStaticBack("1"); 			//Prints: 1. (1) is passed to the method as String
		String s2 = B.<String>getStaticBack("1");
		
		String[] s3 = B.<String[]>getStaticBack(new String[]{"a", "b", "c"});
		for(String s : s3) System.out.print(s + " ");	//Prints: a b c
		System.out.println();		
		String[] s4 = B.getStaticBack(new String[]{"d", "e", "f"});
		for(String s : s4) System.out.print(s + " ");	//Prints: d e f
		System.out.println();
		
		new B().getInstanceBack("abc");			//Prints: abc
		new B().<String>getInstanceBack("def"); //Prints: def
	}
}

class A extends Exception {
	public A(Exception e) {
		super(e);
	}
}

class B extends A {
	public B(Exception e) {
		super(e);
	}
}

class C extends B {
	public C(Exception e) {
		super(e);
	}
}

class D extends C {
	public D(Exception e) {
		super(e);
	}
}

public class Wrap {
	public static void main(String[] args) throws Exception{
		throw new A(new B(new C(new D(new RuntimeException()))));
	}
}

/*Output:
	Exception in thread "main" A: B: C: D: java.lang.RuntimeException
		at Wrap.main(Wrap.java:27)
	Caused by: B: C: D: java.lang.RuntimeException
		... 1 more
	Caused by: C: D: java.lang.RuntimeException
		... 1 more
	Caused by: D: java.lang.RuntimeException
		... 1 more
	Caused by: java.lang.RuntimeException
		... 1 more*/

class A {
	public int a = 1;
}

class B extends A {
	public int b = 2;
}

public class C extends B {
	public int c = 3;
	
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		System.out.println(a.a);
		System.out.println(b.a);
		System.out.println(b.b);
		System.out.println(c.a);
		System.out.println(c.b);
		System.out.println(c.c);
		
		a = b;
		System.out.println(a.a);
		a = c;
		System.out.println(a.a);
		b = c;
		System.out.println(b.a);
		System.out.println(b.b);
		
		
		a = new A();
		b = new B();
		c = new C();		
		//b = a; 		//Compilation fails. Type mismatch: cannot convert from A to B
		//b = (B) a; 	//Compilation ok. Runtime exception ClassCastException: A cannot be cast to B
		//c = b; 		//Compilation fails. Type mismatch: cannot convert from B to C
		//c = (C) b;	//Compilation ok. Runtime exception ClassCastException: B cannot be cast to C
		//c = a; 		//Compilation fails. Type mismatch: cannot convert from A to C
		//c = (C) a;	//Compilation ok. Runtime exception ClassCastException: A cannot be cast to C
		a = new B();
		//c = (C) a;		//Compilation ok. Runtime exception ClassCastException: B cannot be cast to C
		
		
		//----------------------------------------------------------------------------------------------------------
		a = new C();
		b = new C();
		c = new C();		
		System.out.println(a.a);
		//System.out.println(a.b);	//Compilation fails. b cannot be resolved or is not a field
		//System.out.println(a.c);	//Compilation fails. c cannot be resolved or is not a field	
		System.out.println(b.a);
		System.out.println(b.b);
		//System.out.println(b.c);	//Compilation fails. c cannot be resolved or is not a field
		System.out.println(c.a);
		System.out.println(c.b);
		System.out.println(c.c);
		
		a = b;
		System.out.println(a.a);
		a = c;
		System.out.println(a.a);
		b = c;
		System.out.println(b.a);
		System.out.println(b.b);
		
		
		a = new C();
		b = new C();
		c = new C();		
		//b = a; 		//Compilation fails. Type mismatch: cannot convert from A to B
		b = (B) a;
		System.out.println(b.a);
		System.out.println(b.b);
		//System.out.println(b.c);	//Compilation fails. c cannot be resolved or is not a field
		//c = b; 		//Compilation fails. Type mismatch: cannot convert from B to C
		c = (C) b;
		System.out.println(c.a);
		System.out.println(c.b);
		System.out.println(c.c);
		//c = a; 		//Compilation fails. Type mismatch: cannot convert from A to C
		c = (C) a;
		System.out.println(c.a);
		System.out.println(c.b);
		System.out.println(c.c);
	}
}

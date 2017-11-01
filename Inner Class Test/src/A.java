
public class A {
	private int x = 10;
	private static int y = 100;
	
	private int mA = 1000;
	
	private class B {
		private int x = 20;
		//private static int y = 200;		//Compilation fails. The field y cannot be declared static in a non-static inner type, unless initialized with a constant expression
		private static final int y = 200;
		
		private int mB = mA * 2;
		
		private class C {
			private int x = 30;
			//private static int y = 300;	//Compilation fails. The field y cannot be declared static in a non-static inner type, unless initialized with a constant expression
			private static final int y = 300;
			
			private int mC = mA + mB;
			
			private void printX() {
				//Instance variable of C
				System.out.println(x);				//Prints: 30
				System.out.println(this.x);			//Prints: 30
				//System.out.println(A.B.C.x); 		//Compilation fails. Cannot make a static reference to the non-static field A.B.C.x
				System.out.println(A.B.C.this.x); 	//Prints: 30
				System.out.println(B.C.this.x);		//Prints: 30
				System.out.println(C.this.x); 		//Prints: 30
				
				//Instance variable of B
				System.out.println(B.this.x);		//Prints: 20
				System.out.println(A.B.this.x);		//Prints: 20
				
				//Instance variable of A
				System.out.println(A.this.x);		//Prints: 10
			
				//Static variable of C
				System.out.println(A.B.C.this.y); 	//Prints: 300
				System.out.println(A.B.C.y);		//Prints: 300
				System.out.println(B.C.y); 			//Prints: 300
				System.out.println(C.y);			//Prints: 300
				System.out.println(y);				//Prints: 300
				
				//Static variable of B
				System.out.println(A.B.y);			//Prints: 200
				System.out.println(B.y); 			//Prints: 200
				
				//Static variable of A
				System.out.println(A.y);			//Prints: 101
				
				//Private members
				System.out.println(mA + ", " + mB + ", " + mC); //Prints: 1000, 2000, 3000
			}
		}
	}
	
	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.x);	//Prints: 10
		System.out.println(a.y); 	//Prints: 100
		System.out.println( ++a.y); //Prints: 101
		
		//A.B b1 = new B();			//Compilation fails. No enclosing instance of type A is accessible. Must qualify the allocation with an enclosing instance of type A (e.g. x.new A() where x is an instance of A).
		A.B b1 = a.new B();		
		B b2 = a.new B();			//Also ok
		b2 = new A().new B();		//Also ok
		System.out.println(b2.x);	//Prints: 20
		System.out.println(b2.y); 	//Prints: 200
		//System.out.println(++b2.y);//Compilation fails. The final field A.B.y cannot be assigned
		
		//A.B.C c1 = a.new C();		////A.C cannot be resolved to a type
		A.B.C c1 = b2.new C();
		B.C c2 = b2.new C();		//Also ok
		//C c2 = b2.new C();		//Compilation fails. C cannot be resolved to a type
		
		c2 = new A().new B().new C();		//Also ok
		c2 = ((new A()).new B()).new C();	//Also ok
		c2 = a.new B().new C();				//Also ok
		System.out.println(c2.x);			//Prints: 30
		System.out.println(c2.y); 			//Prints: 300
		//System.out.println(++c2.y);		//Compilation fails. The final field A.B.C.y cannot be assigned
		
		
		//System.out.println(x);	//Compilation fails. Cannot make a static reference to the non-static field x
		System.out.println(y);		//Prints 101
		
		c2.printX();
	}
	
	public void nonStaticMethod() {
		B b1 = new B();						//ok
		b1 = new A().new B();				//Also ok
		A.B b2 = new B();					//Also ok
		
		//C c1 = new C();					//Compilation fails. C cannot be resolved to a type
		//B.C c1 = new C();					//Compilation fails. C cannot be resolved to a type
		B.C c1 = new B().new C();
		A.B.C c2 = new B().new C();			//Also ok
		A.B.C c3 = new A().new B().new C();	//Also ok
	}
}

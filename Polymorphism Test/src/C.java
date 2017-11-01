class A {
	public char x = 'A';
	public void getX() {
		System.out.println("getX() from A. Value of x = " + x);
	}
}

class B extends A {
	//public char x = 'B';
	public void getX() {
		System.out.println("getX() from B. Value of x = " + x);
	}
}

public class C extends B {
	public char x = 'C';
	public void getX() {
		System.out.println("getX() from C. Value of x = " + x);
	}
	
	public static void main(String[] args) {
		A a = new A();
		System.out.println("Value of a.x = " + a.x);	//prints: Value of a.x = A
		a.getX();										//prints: getX() from A. Value of x = A
		
		B b = new B();
		System.out.println("Value of b.x = " + b.x);	//prints: Value of b.x = A
		b.getX();										//prints: getX() from B. Value of x = A
		
		C c = new C();
		System.out.println("Value of c.x = " + c.x);	//prints: Value of c.x = C
		c.getX();										//prints: getX() from C. Value of x = C
		
		System.out.println("-----------------------------");
		
		A ac = new C();
		System.out.println("Value of ac.x = " + ac.x);	//prints: Value of ac.x = A
		ac.getX();										//prints: getX() from C. Value of x = C
		
		B bc = new C();
		System.out.println("Value of bc.x = " + bc.x);	//prints: Value of bc.x = A
		bc.getX();										//prints: getX() from C. Value of x = C
		
		C cc = new C();
		System.out.println("Value of cc.x = " + cc.x);	//prints: Value of cc.x = C
		cc.getX();										//prints: getX() from C. Value of x = C
		
		System.out.println("-----------------------------");
		
		A aac = new C();
		B bbc = new C();
		C ccc = new C();
		
		aac = bbc;
		System.out.println("Value of aac.x = " + aac.x);	//prints: Value of aac.x = A
		aac.getX();											//prints: getX() from C. Value of x = C
		
		aac = ccc;	
		System.out.println("Value of aac.x = " + aac.x);	//prints: Value of aac.x = A
		aac.getX();											//prints: getX() from C. Value of x = C
		
		bbc = ccc;
		System.out.println("Value of bbc.x = " + bbc.x);	//prints: Value of bbc.x = A
		bbc.getX();											//prints: getX() from C. Value of x = C
		
		System.out.println("-----------------------------");
		
		A aaac = new C();
		B bbbc = new C();
		C cccc = new C();
		
		bbbc = (B)aaac;
		System.out.println("Value of bbbc.x = " + bbbc.x);	//prints: Value of bbbc.x = A
		bbbc.getX();										//prints: getX() from C. Value of x = C
		
		cccc = (C)aaac;
		System.out.println("Value of cccc.x = " + cccc.x);	//prints: Value of cccc.x = C
		cccc.getX();										//prints: getX() from C. Value of x = C
		
		cccc = (C)bbbc;
		System.out.println("Value of cccc.x = " + cccc.x);	//prints: Value of cccc.x = C
		cccc.getX();										//prints: getX() from C. Value of x = C
	}
}

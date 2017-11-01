class A {}
class B extends A {}
class C extends B {}
class D extends B {}
class E extends C {}

interface X {}
class F implements X {}
interface Y {}
class G extends F implements Y {}

public class Main {
	public static void main(String[] args) {
		A a = new C();
		System.out.println(a instanceof Object);	//true
		System.out.println(a instanceof A);			//true
		System.out.println(a instanceof B);			//true
		System.out.println(a instanceof C);			//true
		System.out.println(a instanceof D);			//false
		System.out.println(a instanceof E);			//false
		System.out.println(a instanceof X);			//false
		System.out.println(a instanceof Y);			//false
		//System.out.println(a instanceof F); 		//Compilation fails. Incompatible conditional operand types A and F
		//System.out.println(a instanceof G);		//Compilation fails. Incompatible conditional operand types A and G
		
		C c = new C();		
		System.out.println(c instanceof Object);	//true
		System.out.println(c instanceof A);			//true
		System.out.println(c instanceof B);			//true
		System.out.println(c instanceof C);			//true
		//System.out.println(c instanceof D);		//Compilation fails. Incompatible conditional operand types C and D
		System.out.println(c instanceof E);			//false
		System.out.println(c instanceof X);			//false
		System.out.println(c instanceof Y);			//false
		//System.out.println(c instanceof F); 		//Compilation fails. Incompatible conditional operand types C and F
		//System.out.println(c instanceof G);		//Compilation fails. Incompatible conditional operand types C and G
		
		B b = new B();
		System.out.println(b instanceof Object);	//true
		System.out.println(b instanceof A);			//true
		System.out.println(b instanceof B);			//true
		System.out.println(b instanceof C);			//false
		System.out.println(b instanceof D);			//false
		System.out.println(b instanceof E);			//false
		System.out.println(b instanceof X);			//false
		System.out.println(b instanceof Y);			//false
		//System.out.println(b instanceof F); 		//Compilation fails. Incompatible conditional operand types B and F
		//System.out.println(b instanceof G);		//Compilation fails. Incompatible conditional operand types B and G
		
		b = null;
		System.out.println(b instanceof Object);	//false
		System.out.println(b instanceof A);			//false
		System.out.println(b instanceof B);			//false
		System.out.println(b instanceof C);			//false
		System.out.println(b instanceof D);			//false
		System.out.println(b instanceof E);			//false
		System.out.println(b instanceof X);			//false
		System.out.println(b instanceof Y);			//false
		//System.out.println(b instanceof F); 		//Compilation fails. Incompatible conditional operand types B and F
		//System.out.println(b instanceof G);		//Compilation fails. Incompatible conditional operand types B and G
		
		X x = new F();
		System.out.println(x instanceof Object);	//true
		System.out.println(x instanceof A);			//false
		System.out.println(x instanceof B);			//false
		System.out.println(x instanceof C);			//false
		System.out.println(x instanceof D);			//false
		System.out.println(x instanceof E);			//false
		System.out.println(x instanceof X);			//true
		System.out.println(x instanceof Y);			//false
		System.out.println(x instanceof F); 		//true
		System.out.println(x instanceof G);			//false
		
		F fx = (F)x;
		System.out.println(fx instanceof Object);	//true
		//System.out.println(fx instanceof A);		//Compilation fails. Incompatible conditional operand types F and A
		//System.out.println(fx instanceof B);		//Compilation fails. Incompatible conditional operand types F and B
		//System.out.println(fx instanceof C);		//Compilation fails. Incompatible conditional operand types F and C
		//System.out.println(fx instanceof D);		//Compilation fails. Incompatible conditional operand types F and D
		//System.out.println(fx instanceof E);		//Compilation fails. Incompatible conditional operand types F and E
		System.out.println(fx instanceof X);		//true
		System.out.println(fx instanceof Y);		//false
		System.out.println(fx instanceof F); 		//true
		System.out.println(fx instanceof G);		//false
		
		F f = new F();
		System.out.println(f instanceof Object);	//true
		//System.out.println(f instanceof A);		//Compilation fails. Incompatible conditional operand types F and A
		//System.out.println(f instanceof B);		//Compilation fails. Incompatible conditional operand types F and B
		//System.out.println(f instanceof C);		//Compilation fails. Incompatible conditional operand types F and C
		//System.out.println(f instanceof D);		//Compilation fails. Incompatible conditional operand types F and D
		//System.out.println(f instanceof E);		//Compilation fails. Incompatible conditional operand types F and E
		System.out.println(f instanceof X);			//true
		System.out.println(f instanceof Y);			//false
		System.out.println(f instanceof F); 		//true
		System.out.println(f instanceof G);			//false
		
		Y y = new G();
		System.out.println(y instanceof Object);	//true
		System.out.println(y instanceof A);			//false
		System.out.println(y instanceof B);			//false
		System.out.println(y instanceof C);			//false
		System.out.println(y instanceof D);			//false
		System.out.println(y instanceof E);			//false
		System.out.println(y instanceof X);			//true
		System.out.println(y instanceof Y);			//true
		System.out.println(y instanceof F); 		//true
		System.out.println(y instanceof G);			//true
		
		G g = new G();
		System.out.println(g instanceof Object);	//true
		//System.out.println(g instanceof A);		//Compilation fails. Incompatible conditional operand types G and A
		//System.out.println(g instanceof B);		//Compilation fails. Incompatible conditional operand types G and B
		//System.out.println(g instanceof C);		//Compilation fails. Incompatible conditional operand types G and C
		//System.out.println(g instanceof D);		//Compilation fails. Incompatible conditional operand types G and D
		//System.out.println(g instanceof E);		//Compilation fails. Incompatible conditional operand types G and E
		System.out.println(g instanceof X);			//true
		System.out.println(g instanceof Y);			//true
		System.out.println(g instanceof F); 		//true
		System.out.println(g instanceof G);			//true
	}
}

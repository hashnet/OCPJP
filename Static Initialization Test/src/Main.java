public class Main {
	//static String s1 = "Static Variable " + initI(); //Compilation fails: Cannot make a static reference to the non-static method initI() from the type Main
	static String s2 = "Static Variable " + staticInitI();
	
	String s3 = "Instance Variable " + initI();
	String s4 = "Instance Variable " + staticInitI();
	
	public static void main(String[] args) {
		System.out.println(Main.s2);	//prints 1
		
		//Main.s2 = mod(Main.s2);	//Compilation fails: Cannot make a static reference to the non-static method mod(String) from the type Main
		Main.s2 = staticMod(Main.s2);
		System.out.println(Main.s2);	//prints 2
		
		Main m = new Main();
		System.out.println(m.s3);
		System.out.println(m.s4);
		
		//m.s3 = mod(m.s3);	//Compilation fails. Cannot make a static reference to the non-static method mod(String) from the type Main
		m.s4 = staticMod(m.s4);
		System.out.println(m.s4);	
		
		m.nonStaticMethod();
	}
	
	public void nonStaticMethod() {
		System.out.println(s2);
		s2 = mod(s2);
		System.out.println(s2);
		
		System.out.println(s2);
		s2 = staticMod(s2);
		System.out.println(s2);
		
		System.out.println(s3);
		s3 = mod(s3);
		System.out.println(s3);
		
		System.out.println(s3);
		s3 = mod(s3);
		System.out.println(s3);
		
		System.out.println(s4);
		s4 = staticMod(s4);
		System.out.println(s4);
	}
	
	public String initI() {
		return "Instance Init";
	}
	
	public static String staticInitI() {
		return "Static Init";
	}
	
	public String mod(String x) {
		return x + " Instance Mod";
	}
	
	public static String staticMod(String x) {
		return x + " Static Mod";
	}
}

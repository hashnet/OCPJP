interface AI {
	String get();

	default String getDefault() {
		return "Default AI";
	}
	
	static String getStatic() {
		return "Static AI";
	}
}

interface BI extends AI {
	//int getDefault();	// Compilation fails. It is redeclaring getDefault() of AI as abstract. But return type has to be covariant.
	String getDefault();	//It is redeclaring getDefault() of AI as abstract.
	
	static int getStatic() {	//It is not overriding getStatic() in A. So return type can be anything.
		return 1;
	}
}

class B implements BI {
	@Override
	public String get() {
		return "B";
	}

	@Override
	public String getDefault() {
		return "Default B";
	}
	
	/*@Override
	public String getStatic() {	//Compilation fails. The method getStatic() of type B must override or implement a supertype method
		return "Default B";
	}*/
}

interface CI extends AI {
	//default int getDefault() { return 0;} //It is overriding the getDefault() of AI. So, return type has to be covariant.
	default String getDefault() {	//It is overriding the getDefault() of AI.
		return "Default CI";
	}
}

class C implements CI {
	@Override
	public String get() {
		return "C";
	}
}

interface DI extends AI {
}

class D implements DI {
	@Override
	public String get() {
		return "D";
	}	
}
public class Main {
	public static void main(String[] args) {
		AI b = new B();
		System.out.println(b.get());
		System.out.println(b.getDefault());
		//System.out.println(b.getStatic());//Compilation fails. This static method of interface AI can only be accessed as AI.getStatic
		System.out.println(AI.getStatic());
		System.out.println(BI.getStatic());	//BI doesn't inherit getStatic() of AI. It redefines its own getStatic();
		//System.out.println(CI.getStatic());//Compilation fails. CI doesn't inherit getStatic() of AI.
		
		AI c = new C();
		System.out.println(c.get());
		System.out.println(c.getDefault());	
		
		AI d = new D();
		System.out.println(d.get());
		System.out.println(d.getDefault());	
	}
}

interface one {
	default void go() {}
}
interface two {
	default void go() {}
}
//interface three extends one, two{}	//Compilation fails. Duplicate default methods named go with the parameters () and () are inherited from the types two and one

//class X implements one, two {}	//Compilation fails. Duplicate default methods named go with the parameters () and () are inherited from the types two and one
class X implements one, two {
	public void go() {}
}



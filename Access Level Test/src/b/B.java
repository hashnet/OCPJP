package b;

import a.A;

public class B {
	public static void main(String[] args) {
		A a = new A();		
		a.getPublic();
		//a.getProtected();		//Compilation fails. The method getProtected() from the type A is not visible
		//a.getDefault();		//Compilation fails. The method getDefault() from the type A is not visible
		//a.getPrivate();		//Compilation fails. The method getPrivate() from the type A is not visible
		
		A.getStaticPublic();
		//A.getStaticProtected();//Compilation fails. The method getStaticProtected() from the type A is not visible
		//A.getStaticDefault();	//Compilation fails. The method getStaticProtected() from the type A is not visible
		//A.getStaticPrivate();	//Compilation fails. The method getStaticPrivate() from the type A is not visible
	}
}

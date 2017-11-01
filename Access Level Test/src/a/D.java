package a;

public class D {
	public static void main(String[] args) {
		A a = new A();		
		a.getPublic();
		a.getProtected();
		a.getDefault();
		//a.getPrivate();		//Compilation fails. The method getPrivate() from the type A is not visible
		
		A.getStaticPublic();
		A.getStaticProtected();
		A.getStaticDefault();
		//A.getStaticPrivate();	//Compilation fails. The method getStaticPrivate() from the type A is not visible
	}
}

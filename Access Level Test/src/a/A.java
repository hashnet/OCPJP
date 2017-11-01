package a;

public class A {
	//Instance Methods
	public void getPublic() {
		System.out.println("Instance Public");
	}
	protected void getProtected() {
		System.out.println("Instance Protected");
	}	
	void getDefault() {
		System.out.println("Instance Package Private");
	}	
	private void getPrivate() {
		System.out.println("Instance Private");		
	}	
		
	//Class Methods
	public static void getStaticPublic() {
		System.out.println("Class Public");
	}
	protected static void getStaticProtected() {
		System.out.println("Class Protected");
	}	
	static void getStaticDefault() {
		System.out.println("Class Package Private");
	}	
	private static void getStaticPrivate() {
		System.out.println("Class Private");		
	}	
	
	public static void main(String[] args) {
		A a = new A();		
		a.getPublic();
		a.getProtected();
		a.getDefault();
		a.getPrivate();
		
		getStaticPrivate();
		getStaticDefault();
		getStaticProtected();
		getStaticPublic();		
	}
}

package complex;


class Box<T extends Q> {
	private T t;
	
	public void set(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}

	public void test(Box<T> b) {
		System.out.println(b.get().getClass().getName());
	}
	
	public <T extends Q> void testWithBound(Box<T> b) {
		System.out.println(b.get().getClass().getName());
	}
}


class P {}
class Q extends P {}
class R extends Q {}

public class GenericHierarchyTest {
	public static void main(String[] args) {
		//Box<P> box= new Box<>();		//Cannot infer type arguments for Box<>
		Box<Q> box = new Box<>();		
		//box.set(new P());				//The method set(Q) in the type Box<Q> is not applicable for the arguments (P)
		box.set(new Q());
		System.out.println(box.get().getClass().getName());
		
		box.set(new R());
		System.out.println(box.get().getClass().getName());
		
		/////////////////////////////////////
		Box<Q> qBox = new Box<>();
		Box<R> rBox = new Box<>();
		qBox.set(new Q());
		rBox.set(new R());
		//qBox.test(rBox);			//Compilation fails. The method test(Box<Q>) in the type Box<Q> is not applicable for the arguments (Box<R>)
		qBox.testWithBound(rBox);
	}
}

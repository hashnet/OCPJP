package simple;

interface Callable<T> {
	void call(T name);
}

class CallableA implements Callable<String> {
	@Override
	public void call(String name) {
		System.out.println(name);
	}
}

class CallableB<T> implements Callable<String> {
	@Override
	public void call(String name) {
		System.out.println(name);
	}
	
	public void callMe(T name) {
		call(name.toString());
	}
}

//class CallableC<U> implements Callable<T> {	//Compilation fails. T cannot be resolved to a type
class CallableC<U> implements Callable<U> {	
	@Override
	public void call(U name) {
		System.out.println(name);
	}
}

class CallableD implements Callable {
	@Override
	public void call(Object name) {
		System.out.println((String) name);
	}
}

public class GenericInterfaceTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		CallableA a = new CallableA();
		a.call("a");							//void a.CallableA.call(String name)
		
		CallableB<StringBuilder> bTyped = new CallableB<>();
		bTyped.callMe(new StringBuilder("bTyped"));	//void a.CallableB.callMe(StringBuilder name)
		
		CallableB bUntyped = new CallableB();
		bUntyped.callMe(new StringBuilder("bUntyped"));//void a.CallableB.callMe(Object name)
		
		CallableC<String> cTyped = new CallableC<>();
		cTyped.call("cTyped");					//void a.CallableC.call(String name)
	
		CallableC cUntyped = new CallableC();
		cUntyped.call("cUntyped"); 				//void a.CallableC.call(Object name)
	
		CallableD d = new CallableD();
		d.call("d"); 							//void a.CallableD.call(Object name)
	}	
}

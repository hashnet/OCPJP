package complex;

import java.util.ArrayList;
import java.util.List;

class A {}
class B extends A {}
class C extends B {}
class D extends C {}
class E extends D {}

public class UnboundImutableTest {
	public static void main(String[] args) {
		List<Object> listObject = new ArrayList<Object>();
		List<A> listA = new ArrayList<>();
		List<B> listB = new ArrayList<>();
		List<C> listC = new ArrayList<>();
		List<D> listD = new ArrayList<>();
		List<E> listE = new ArrayList<>();
		
		addToUnBoundedList(listObject);
		addToUnBoundedList(listA);
		addToUnBoundedList(listB);
		addToUnBoundedList(listC);
		addToUnBoundedList(listD);
		addToUnBoundedList(listE);
		
//		addToUpperBoundedList(listObject);	//The method addToUpperBoundedList(List<? extends C>) in the type UnboundImutableTest is not applicable for the arguments (List<Object>
//		addToUpperBoundedList(listA);		//he method addToUpperBoundedList(List<? extends C>) in the type UnboundImutableTest is not applicable for the arguments (List<A>)
//		addToUpperBoundedList(listB);		//he method addToUpperBoundedList(List<? extends C>) in the type UnboundImutableTest is not applicable for the arguments (List<B>)
		addToUpperBoundedList(listC);
		addToUpperBoundedList(listD);
		addToUpperBoundedList(listE);		
		
		addToLowerBoundedList(listObject);
		addToLowerBoundedList(listA);
		addToLowerBoundedList(listB);
		addToLowerBoundedList(listC);		
//		addToLowerBoundedList(listD);		//The method addToLowerBoundedList(List<? super C>) in the type UnboundImutableTest is not applicable for the arguments (List<D>)
//		addToLowerBoundedList(listE);		//The method addToLowerBoundedList(List<? super C>) in the type UnboundImutableTest is not applicable for the arguments (List<E>)
		
		
	}
	
	public static void addToUnBoundedList(List<?> list) {
//		list.add(new B());			//The method add(capture#1-of ?) in the type List<capture#1-of ?> is not applicable for the arguments (B)
//		list.add(new Object());		//The method add(capture#1-of ?) in the type List<capture#1-of ?> is not applicable for the arguments (Object)
//		list.add(new C());			//he method add(capture#1-of ?) in the type List<capture#1-of ?> is not applicable for the arguments (C)
	}
	
	public static void addToUpperBoundedList(List<? extends C> list) {
//		list.add(new Object());		//The method add(capture#1-of ? extends C) in the type List<capture#1-of ? extends C> is not applicable for the arguments (Object)
//		list.add(new C());			//The method add(capture#2-of ? extends C) in the type List<capture#2-of ? extends C> is not applicable for the arguments (C)
//		list.add(new D());			//The method add(capture#1-of ? extends C) in the type List<capture#1-of ? extends C> is not applicable for the arguments (D)
	}
	
	public static void addToLowerBoundedList(List<? super C> list) {
		list.add(new C());
//		list.add(new A());			//The method add(capture#2-of ? super C) in the type List<capture#2-of ? super C> is not applicable for the arguments (A)
		list.add(new D());	
	}
}

package complex;

import java.util.ArrayList;
import java.util.List;

class AA {}
class BB extends AA {}
class CC extends BB {}
class DD extends CC {}
class EE extends DD {}

public class UnboundImutableTest {
	public static void main(String[] args) {
		List<Object> listObject = new ArrayList<Object>();
		List<AA> listA = new ArrayList<>();
		List<BB> listB = new ArrayList<>();
		List<CC> listC = new ArrayList<>();
		List<DD> listD = new ArrayList<>();
		List<EE> listE = new ArrayList<>();
		
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
//		list.add(new BB());			//The method add(capture#1-of ?) in the type List<capture#1-of ?> is not applicable for the arguments (B)
//		list.add(new Object());		//The method add(capture#1-of ?) in the type List<capture#1-of ?> is not applicable for the arguments (Object)
//		list.add(new CC());			//he method add(capture#1-of ?) in the type List<capture#1-of ?> is not applicable for the arguments (C)
	}
	
	public static void addToUpperBoundedList(List<? extends CC> list) {
//		list.add(new Object());		//The method add(capture#1-of ? extends C) in the type List<capture#1-of ? extends C> is not applicable for the arguments (Object)
//		list.add(new CC());			//The method add(capture#2-of ? extends C) in the type List<capture#2-of ? extends C> is not applicable for the arguments (C)
//		list.add(new DD());			//The method add(capture#1-of ? extends C) in the type List<capture#1-of ? extends C> is not applicable for the arguments (D)
	}
	
	public static void addToLowerBoundedList(List<? super CC> list) {
		list.add(new CC());
//		list.add(new AA());			//The method add(capture#2-of ? super C) in the type List<capture#2-of ? super C> is not applicable for the arguments (A)
		list.add(new DD());	
	}
}

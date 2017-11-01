import java.util.*;

public class Main {
	public static void main(String[] args) {
		//Creating List and ArrayList
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<String> list3 = new ArrayList<String>();
		list1 = list2;		//OK
		//list1 = list3;										//Compilation fails. Type mismatch: cannot convert from List<String> to List<Integer>
		
		
		List list4 = new ArrayList(); 							//Compiler warning. List is a raw type. References to generic type List<E> should be parameterized. List is a raw type. References to generic type List<E> should be parameterized.
		list4.add(1);											//Compiler warning. Type safety: The method add(Object) belongs to the raw type List. References to generic type List<E> should be parameterized
		list4.add("One");										//Compiler warning. Type safety: The method add(Object) belongs to the raw type List. References to generic type List<E> should be parameterized
		System.out.println(list4);								//Prints: [1, One]
		System.out.println(list4.getClass().getName()); 		//Prints: java.util.ArrayList
		System.out.println(list4.get(0).getClass().getName());	//Prints: java.lang.Integer
		System.out.println(list4.get(1).getClass().getName());	//Prints: java.lang.String
		//Integer intElement1 = list4.get(0);					//Compilation fails. Type mismatch: cannot convert from Object to Integer
		//String stringElement1 = list4.get(1);					//Compilation fails. Type mismatch: cannot convert from Object to String
		System.out.println(list4.get(0) instanceof Integer);	//Prints: true
		System.out.println(list4.get(1) instanceof String);		//Prints: true
		Integer intElement1 = (Integer) list4.get(0);			//OK
		String stringElement1 = (String) list4.get(1);			//OK
		
		
		List list5 = new ArrayList<Integer>();					//Compiler warning. List is a raw type. References to generic type List<E> should be parameterized
		list5.add(2);											//Compiler warning. Type safety: The method add(Object) belongs to the raw type List. References to generic type List<E> should be parameterized
		list5.add("Two");										//Compiler warning. Type safety: The method add(Object) belongs to the raw type List. References to generic type List<E> should be parameterized
		System.out.println(list5);								//Prints: [2, Two]
		System.out.println(list5.getClass().getName()); 		//Prints: java.util.ArrayList
		System.out.println(list5.get(0).getClass().getName());	//Prints: java.lang.Integer
		System.out.println(list5.get(1).getClass().getName());	//Prints: java.lang.String
		//Integer intElement2 = list5.get(0);					//Compilation fails. Type mismatch: cannot convert from Object to Integer
		//String stringElement2 = list5.get(1);					//Compilation fails. Type mismatch: cannot convert from Object to String
		System.out.println(list5.get(0) instanceof Integer);	//Prints: true
		System.out.println(list5.get(1) instanceof String);		//Prints: true
		Integer intElement2 = (Integer) list5.get(0);			//OK
		String stringElement2 = (String) list5.get(1);			//OK
		
		
		List<Integer> list6 = new ArrayList();					//Compiler warning. Type safety: The expression of type ArrayList needs unchecked conversion to conform to List<Integer>
		list6.add(1);											
		//list6.add("One");										//Compilation fails. The method add(Integer) in the type List<Integer> is not applicable for the arguments (String)
		System.out.println(list6);								//Prints: [1]
		System.out.println(list6.getClass().getName()); 		//java.util.ArrayList
		System.out.println(list6.get(0).getClass().getName());	//Prints: java.lang.Integer
		Integer intElement3 = list6.get(0);					
		System.out.println(list6.get(0) instanceof Integer);	//Prints: true
		//System.out.println(list6.get(0) instanceof String);	//Compilation fails. Incompatible conditional operand types Integer and String
		//String stringElement3 = (String) list6.get(1);		//Compilation fails. Cannot cast from Integer to String
		
		
		List<Integer> list7 = new ArrayList<Integer>();			//OK
		List<Integer> list8 = new ArrayList<>();				//Also OK. Diamond Operator.
		list8 = new ArrayList<>();
		//List<> list9 = new ArrayList<>();						//Compilation fails. Incorrect number of arguments for type List<E>; it cannot be parameterized with arguments <>
				list7.add(1);
		list7.add(2);
		list7.add(3);
		System.out.println(list7);	//Prints: [1, 2, 3]
		
		
		//List<Number> list10 = new ArrayList<String>();		//Compilation fails. Type mismatch: cannot convert from ArrayList<String> to List<Number>
		//List<Number> list10 = new ArrayList<Integer>();		//Compilation fails. Type mismatch: cannot convert from ArrayList<Integer> to List<Number>		
		
		
		//Conversion from List to Array/////////////////////////////////////////////////
		//Method Wrong
		//Integer[] i7 = (Integer[]) list7.toArray(); 			//Exception in thread "main" java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
		//Method One
		Integer[] i7 = new Integer[list7.size()];
		i7 = list7.toArray(i7);
		for(Integer i : i7) System.out.print(i + " "); 			//Prints: 1 2 3
		System.out.println();
		//Method Two
		Integer[] ii7 = list7.toArray(new Integer[list7.size()]);
		for(Integer i : ii7) System.out.print(i + " "); 		//Prints: 1 2 3
		System.out.println();
		//Method Three
		Integer[] iii7 = list7.toArray(new Integer[0]);
		for(Integer i : iii7) System.out.print(i + " "); 		//Prints: 1 2 3
		System.out.println();
		
		
		//Modification of List & Array individually
		//At the moment i7[] = 1 2 3
		//list7 = [1, 2, 3]
		i7[0] = 10;
		list7.set(1, 20);		
		for(Integer i : i7) System.out.print(i + " "); 			//Prints: 10 2 3
		System.out.println();
		System.out.println(list7);								//Prints: [1, 20, 3]
		list7.remove(0);	//Prints: [2, 3]
		for(Integer i : i7) System.out.print(i + " "); 			//Prints: 10 2 3
		System.out.println();
		System.out.println(list7);								//Prints: [20, 3]
		
		
		//Conversion from nonGeneric List to Array
		//int[] i4 = (int[]) list4.toArray();					//Compilation fails. Cannot cast from Object[] to int[]
		//Integer[] i4 = list4.toArray(new Integer[0]);			//Compilation fails. Type mismatch: cannot convert from Object[] to Integer[]
		//Integer[] i4 =(Integer[])list4.toArray(new Object[0]);//Exception in thread "main" java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
		//int[] i5 = (int[]) list5.toArray();					//Compilation fails. Cannot cast from Object[] to int[]
		//Integer[] i5 = list5.toArray(new Integer[0]);			//Compilation fails. Type mismatch: cannot convert from Object[] to Integer[]
		//Integer[] i5 =(Integer[])list5.toArray(new Object[0]);//Exception in thread "main" java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;

		
		//Array backed list/////////////////////////////////////////////////
		//Conversion from Array to List
		Integer[] i1 = new Integer[] {4, 5, 6};
		//ArrayList<Integer> l1 = Arrays.asList(i1);			//Compilation fails. Type mismatch: cannot convert from List<Integer> to ArrayList<Integer>
		List<Integer> l1 = Arrays.asList(i1);
		for(Integer i : i1) System.out.print(i + " ");			//Prints: 4 5 6 
		System.out.println();
		System.out.println(l1);									//Prints: [4, 5, 6]
		//List<String> s1 = Arrays.asList(i1);					//Compilation fails. Type mismatch: cannot convert from List<Integer> to List<String>
		List l2 = Arrays.asList(i1);
		System.out.println(l2);									//Prints: [4, 5, 6]
		System.out.println(l2.get(0).getClass().getName());		//Prints: java.lang.Integer
		
		//Modification of List & Array individually
		i1[0] = 40;
		l1.set(1, 50);
		for(Integer i : i1) System.out.print(i + " ");			//Prints: 40 50 6 
		System.out.println();
		System.out.println(l1);	//Prints: [40, 50, 6]
		//l1.remove(0);											//java.lang.UnsupportedOperationException
		//l1.add(7);											//java.lang.UnsupportedOperationException
				
		//Converting back to Array
		Integer[] i2 = (Integer[])l1.toArray();					//This is ok in contrast to i7
		for(Integer i : i2) System.out.print(i + " ");			//Prints: 40 50 6 
		System.out.println();
	}
}

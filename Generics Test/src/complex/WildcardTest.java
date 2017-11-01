package complex;

import java.util.ArrayList;
import java.util.List;

public class WildcardTest {	
	public static void main(String[] args) {
		List<? extends Integer> lstInt1 = new ArrayList<>();		
		//lstInt1.add(new Integer(1));	//The method add(capture#1-of ? extends Integer) in the type List<capture#1-of ? extends Integer> is not applicable for the arguments (Integer)
		//lstInt1.add(null arg0) : boolean - list
		System.out.println(lstInt1.getClass());		//class java.util.ArrayList
		
		List<? super Integer> lstInt2 = new ArrayList<>();
		lstInt2.add(new Integer(1));
		//lstInt2.add(new Object());		//The method add(capture#5-of ? super Integer) in the type List<capture#5-of ? super Integer> is not applicable for the arguments (Object)
		//lstInt2.add(Integer arg0) : boolean list
		System.out.println(lstInt2.getClass());			//class java.util.ArrayList
		System.out.println(lstInt2.get(0).getClass());	//class java.lang.Integer
	}
}

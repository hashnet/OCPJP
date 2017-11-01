package simple;

import java.util.*;

class X {}
class Y {}

public class LegacyGenericsTest {
	public static void main(String[] args) {
		List xs1 = new ArrayList();
		xs1.add(new X());
		printY(xs1);
		
		
		List xs2 = new ArrayList<Y>();
		xs2.add(new X());
		printY(xs2);
		
		List<X> xs3 = new ArrayList<>();
		xs3.add(new X());
		//printY(xs3);		//The method printY(List<Y>) in the type LegacyGenericsTest is not applicable for the arguments (List<X>)
	}
	
	private static void printY(List<Y> ys) {
		for(Y y : ys) { 	//java.lang.ClassCastException: simple.X cannot be cast to simple.Y
			System.out.println(y);
		}
	}
}

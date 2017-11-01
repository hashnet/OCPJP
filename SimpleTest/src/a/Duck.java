package a;

import java.util.*;

public class Duck implements Comparable<Duck>{
	private String name;
	
	public Duck(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		List<Duck> ducks = new ArrayList<>();
		
		ducks.add(new Duck("cc"));
		ducks.add(new Duck("a"));
		ducks.add(new Duck("bbb"));
		System.out.println(ducks);
		
		Collections.sort(ducks);
		System.out.println(ducks);
		
		Collections.sort(ducks, new Comparator<Duck>() {
			@Override
			public int compare(Duck duck1, Duck duck2) {
				return -duck1.compareTo(duck2);
			}			
		});		
		System.out.println(ducks);
		
		Collections.sort(ducks, (duck1, duck2) -> duck1.name.length() - duck2.name.length());
		System.out.println(ducks);
		
		Comparator<Duck> c = (duck1, duck2) -> duck2.name.length() - duck1.name.length();
		Collections.sort(ducks, c);
		System.out.println(ducks);
				
		System.out.println(c.compare(new Duck("abc"), new Duck("pq")));
	}
	
	@Override
	public String toString(){
		return name;
	}

	@Override
	public int compareTo(Duck o) {
		return name.compareTo(o.name);
	}
}

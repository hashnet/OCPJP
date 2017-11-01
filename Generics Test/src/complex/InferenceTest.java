package complex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Crate<T> {
	private T t;
	
	public void set(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
}

class CrateDemo {
	public static <T> void addCrate(T t, List<Crate<T>> crates) {
		Crate<T> crate = new Crate<>();
		crate.set(t);
		
		crates.add(crate);
	}
	
	public static <T> void printCrates(List<Crate<T>> crates) {
		for(Crate<T> crate : crates) {
			T content = crate.get();
			System.out.println("[" + content.toString() + "]");
		}
	}
}

public class InferenceTest {
	public static void main(String[] args) {
		ArrayList<Crate<Integer>> integerCrates = new ArrayList<>();
		ArrayList<Crate<String>> stringCrates = new ArrayList<>();
		
		CrateDemo.<Integer>addCrate(Integer.valueOf(10), integerCrates);
		CrateDemo.<String>addCrate("10", stringCrates);
		CrateDemo.addCrate(Integer.valueOf(20), integerCrates);
		CrateDemo.addCrate(30, integerCrates);
		//CrateDemo.addCrate("20",integerCrates);		//Compilation fails. The method addCrate(T, List<Crate<T>>) in the type CrateDemo is not applicable for the arguments (String, ArrayList<Crate<Integer>>)
		CrateDemo.addCrate("20", stringCrates);
		CrateDemo.printCrates(integerCrates);	
		CrateDemo.printCrates(stringCrates);
		
	}
}

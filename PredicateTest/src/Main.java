import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import animals.Animal;
import animals.CheckIfHoppable;
import animals.CheckIfSwimmable;
import animals.CheckTrait;

class Test {
	static int x = 0;
}

public class Main extends Test{
	public static void main(String[] args) {
		x = 10;
		
		List<Animal> animals = new ArrayList<Animal>();
		
		animals.add(new Animal("Kangaroo", true, false));
		animals.add(new Animal("Cow", true, true));
		animals.add(new Animal("Rabbit", true, false));
		animals.add(new Animal("Duck", false, true));
		
		System.out.println("Hoppables: ");
		check(animals, new CheckIfHoppable());
		
		System.out.println("Swimables: ");
		check(animals, new CheckIfSwimmable());
		System.out.println();
		
		System.out.println("Not Hoppables: ");
		checkThroughPredicate(animals, a -> !a.isHoppable());
		
		System.out.println("Not Swimables: ");
		checkThroughPredicate(animals, a -> !a.isSwimable());
	}
	
	private static void check(List<Animal> animals, CheckTrait criteria) {
		for(Animal animal : animals) {
			if(criteria.checkATrait(animal)) System.out.println(animal.getSpecies());
		}
	}
	
	private static void checkThroughPredicate(List<Animal> animals, Predicate<Animal> criteria) {
		for(Animal animal : animals) {
			if(criteria.test(animal)) System.out.println(animal.getSpecies());
		}
	}
}

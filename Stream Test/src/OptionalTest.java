import java.util.OptionalInt;
import java.util.stream.IntStream;

public class OptionalTest {
	public static void main(String[] args) {
		IntStream is = IntStream.of(1, 2);
		OptionalInt oi = is.max();
		oi.ifPresent(System.out::println);		//Prints: 2
	    
	    oi = IntStream.empty().max();
//	    System.out.println("oi.getAsInt(): " + oi.getAsInt());		//java.util.NoSuchElementException: No value present
	    
	    oi.ifPresent((i) -> System.out.println("Value present: " + i));
	    
	    System.out.println("oi.orElse(0): " + oi.orElse(0)); 	//Prints: oi.orElse(0): 0
	    
	    System.out.println("oi.orElseGet(() -> 0): " + oi.orElseGet(() -> 0)); 	//Prints: oi.orElseGet(() -> 0): 0
	}
}

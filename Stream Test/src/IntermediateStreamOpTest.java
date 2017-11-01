import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateStreamOpTest {
	public static void main(String[] args) {
		//filter
		Stream.of("Longgggg", "Long......", "Sh")
					.filter(a -> a.length() > 2)
					.forEach(System.out::println);	//Prints: Longgggg Long......
		
		
		//distinct
		Stream.of("a", "a", "b")
			.distinct()
			.forEach(System.out::println); 			//Prints: a b
		
		
		//skip/limit
		Stream.of(1, 2, 3)
			.skip(2).forEach(System.out::println);	//Prints: 3		
		
		Stream.of(1, 2, 3)
			.skip(4).forEach(System.out::println);		//Prints: nothing
		
		Stream.of(1, 2, 3)
			.limit(2).forEach(System.out::println);  	//Prints: 1 2
		
		Stream.of(1, 2, 3)
			.limit(4).forEach(System.out::println);  	//Prints: 1 2 3
		
		Stream.of(1, 2, 3, 4, 5)
			.limit(3)
			.skip(1)
			.forEach(System.out::println);				//Prints: 2 3
		
		Stream.of(1, 2, 3, 4, 5)
			.skip(2)
			.limit(2)
			.forEach(System.out::println);				//Prints: 3 4
		
		Stream.iterate(1, n -> n + 1)
			.skip(5)
			.limit(2)
			.forEach(System.out::println); 				//Prints: 6 7
		
		
		//map
		//<R> Stream<R> map(Function<? super T, ? extends R> mapper)
		Stream.of(1, 2, 3)
			.map(n->n*n)
			.forEach(System.out::println);				//Prints: 1 4 9
		
		Stream.of(1, 2, 3)
			.map(n -> {return (double)n;})
			.forEach(System.out::println); 				//Prints: 1.0 2.0 3.0
		
		Stream.of("1", "22", "333")
			.map(String::length)
			.forEach(System.out::println);				//Prints: 1 2 3
		
		
		//flatMap
		//<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
		Stream<String> streams = Stream.of("abc", "de", "fghi");
		streams.flatMap(x -> x.chars().mapToObj(i -> Character.valueOf((char)i)))
				.forEach(System.out::println);			//Prints: a b c d e f g h i
		
		List<String> zero = Arrays.asList();
		List<String> one = Arrays.asList("AA");
		List<String> two = Arrays.asList("BB", "CC");
		Stream<List<String>> streamOfList = Stream.of(zero, one, two);
		streamOfList.flatMap(l -> l.stream())
			.forEach(System.out::println); 				//Prints: AA BB
			
		
		//sorted
		Stream.of(2, 1, 3)
			.sorted()
			.forEach(System.out::println); 				//Prints: 1 2 3
		
		Stream.of(2, 1, 3)
			.sorted(Comparator.reverseOrder())
			.forEach(System.out::println); 				//Prints: 3 2 1
		
		Stream.of(2, 1, 3)
			.sorted((a, b) -> b - a)
			.forEach(System.out::println); 				//Prints: 3 2 1
		
		Stream.of(2, 1, 3)
			.sorted((a, b) -> -Integer.compare(a, b))
			.forEach(System.out::println); 				//Prints: 3 2 1
	}
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TerminalStreamOpTest {
	public static void main(String[] args) {
		//count
		System.out.println(Stream.empty().count());								//Prints: 0
		System.out.println(Stream.of(1, 2, 3).count());							//Prints: 3
//		System.out.println(Stream.generate(()->1).count());						//Hangs
		
		
		//min/max
		//min gives the first element after applying the Comparator
		//max gives the last element after applying the Comparator
		Stream.of(1, 2, 3).min((a, b) -> a - b).ifPresent(System.out::println);	//Prints: 1
		Stream.of(1, 2, 3).min((a, b) -> b - a).ifPresent(System.out::println);	//Prints: 3
		Stream.of(1, 2, 3).max((a, b) -> a - b).ifPresent(System.out::println);	//Prints: 3
		Stream.of(1, 2, 3).max((a, b) -> b - a).ifPresent(System.out::println);	//Prints: 1
		
//		Stream.empty().min((a, b) -> a - b).ifPresent(System.out::println);		//The operator - is undefined for the argument type(s) java.lang.Object, java.lang.Object
		Stream.empty().min((a, b) -> Integer.valueOf(a.toString()) - Integer.valueOf(b.toString())).ifPresent(System.out::println);	//Prints: nothing
		Stream<Integer> sI = Stream.empty();
		sI.min((a, b) -> a - b).ifPresent(System.out::println);					//Prints: nothing (Comparator is never called)
		
		
		//findAny/findFirst
		Stream.generate(()->1).findAny().ifPresent(System.out::println);		//Prints: 1
		
		
		//anyMatch/allMatch/noneMatch
		Predicate<Integer> pred = x -> x > 5;
		System.out.println(Stream.of(1, 10).anyMatch(pred));					//Prints: true
		System.out.println(Stream.of(1, 10).allMatch(pred));					//Prints: false
		System.out.println(Stream.of(1, 10).noneMatch(pred));					//Prints: false
		//System.out.println(Stream.generate(()-> 1).anyMatch(pred));	 		//Hangs
		System.out.println(Stream.generate(()-> 10).anyMatch(pred));	 		//Prints: true
		//System.out.println(Stream.generate(()-> 10).allMatch(pred));	 		//Hangs
		//System.out.println(Stream.generate(()-> 1).noneMatch(pred));	 		//Hangs
		
		
		//reduce
		//T reduce(T identity, BinaryOperator<T> accumulator)
		String word = Stream.of("X", "Y").reduce("Prefix_", (result, item) -> result.concat(item));
		System.out.println(word);												//Prints: Prefix_XY
		
		word = Stream.of("X", "Y").reduce("Prefix_", String::concat);
		System.out.println(word);												//Prints:Prefix_XY
		
		word = Stream.of("X").reduce("Prefix_", String::concat);
		System.out.println(word);												//Prints: Prefix_X
		
		Stream<String> st1 = Stream.empty();
		word = st1.reduce("Prefix_", String::concat);
		System.out.println(word); 												//Prints: Prefix_
		
		//Optional<T> reduce(BinaryOperator<T> accumulator)
		Stream.of("X", "Y").reduce(String::concat).ifPresent(System.out::println);	//Prints: XY
		
		Stream.of("X").reduce(String::concat).ifPresent(System.out::println);	//Prints: X
		
		Stream<String> st2 = Stream.empty();
		System.out.println(st2.reduce(String::concat).isPresent());				//Prints: false
		
		//<U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
		int totalLen = Stream.of("1", "22", "333").reduce(
				0, 
				(resLen, itemStr)->resLen + itemStr.length(), 
				(result, item)->result + item);
		System.out.println(totalLen);											//Prints: 6
		
		totalLen = Stream.of("1").reduce(
				0, 
				(resLen, itemStr)->resLen + itemStr.length(), 
				(result, item)->result + item);
		System.out.println(totalLen);											//Prints: 1
		
		totalLen = Stream.empty().reduce(
				0, 
				(resLen, itemStr)->resLen + itemStr.toString().length(), 
				(result, item)->result + item);
		System.out.println(totalLen);											//Prints: 0
		
		
		//Collect
		//<R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner)
		Stream.of("1", "22", "333").collect(
				ArrayList<Integer>::new, 
				(list, itemStr)->list.add(itemStr.length()), 
				(listA, listB)->listA.addAll(listB))
		.forEach(item->System.out.println(item.getClass() +":" + item));   		//Prints: class java.lang.Integer:1
																						//class java.lang.Integer:2
																						//class java.lang.Integer:3
	
		Stream.of("1", "22", "333").collect(
				ArrayList<Integer>::new, 
				(list, itemStr)->list.add(itemStr.length()), 
				List::addAll)
		.forEach(item->System.out.println(item.getClass() +":" + item)); 		//Prints: same as above
		
		ArrayList<String> list1 = Stream.of("X", "Y").collect(
				ArrayList<String>::new,
				List::add,
				List::addAll
				);
		
		ArrayList<String> list2 = Stream.of("X", "Y").collect(
				ArrayList<String>::new,
				ArrayList::add,
				ArrayList::addAll
				);
		
		//<R,A> R collect(Collector<? super T, A,R> collector)
		
		List<String> list3 = Stream.of("X", "Y").collect(
				Collectors.toList()
				);
		System.out.println(list3.getClass()); 								 	//Prints: class java.util.ArrayList
																				//It is not guaranteed
		LinkedList<String> list4 = Stream.of("X", "Y").collect(
				Collectors.toCollection(LinkedList<String>::new)
				);
		System.out.println(list4.getClass());									//Pritns: class java.util.LinkedList
																				//It is guaranteed by the Consumer
	}
}

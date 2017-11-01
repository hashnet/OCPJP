import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class StreamSourceTest {
	public static void main(String[] args) {
		//-------------//
		//Finite Stream//
		//-------------//
		
		//Empty Stream
		Stream<Integer> emptyStream = Stream.empty();
		System.out.println(emptyStream);				//Prints: java.util.stream.ReferencePipeline$Head@25154f
		System.out.println(emptyStream.count()); 		//Prints: 0
//		emptyStream.forEach(System.out::println);		//java.lang.IllegalStateException: stream has already been operated upon or closed
														//Exception happens as Stream.count() is a terminal operation
		emptyStream = Stream.empty();
		emptyStream.forEach(System.out::println);		//Prints: nothing
		
		//Single element Stream	
		Stream<Integer> singleStream = Stream.of(1);
		singleStream.forEach(System.out::println);		//Prints: 1
//		System.out.println(singleStream.count());		//java.lang.IllegalStateException: stream has already been operated upon or closed
														//Exception happens as Stream.forEach() is a terminal operation
		singleStream = Stream.of(1);
		System.out.println(singleStream.count());		//Prints: 1
		
		//Multiple element Stream
		Stream<Integer> arrayStream = Stream.of(1, 2, 3);
		System.out.println(arrayStream.count()); 		//Prints: 3
		arrayStream = Stream.of(1, 2, 3);
		arrayStream.forEach(System.out::println);		//Prints: 1 2 3
		
		//Stream from List		
		//int[] intArr = {11, 12, 13};
		//List<Integer> list = Arrays.asList(intArr);	//Compilation fails. Type mismatch: cannot convert from List<int[]> to List<Integer>
		
		Integer[] intArr = {11, 12, 13};
		List<Integer> list = Arrays.asList(intArr);			
		list = Arrays.asList(11, 12, 13);
		
		Stream<Integer> listStream = list.stream();
		Stream<Integer> listParallelStream = list.parallelStream();		
		list.forEach(System.out::println);				//Prints: 11 12 13
		
		//Generic vs NonGeneric Stream
		Stream<Integer> genericstream = list.stream();
		Stream nonGenericStream = list.stream();		//Warning. Stream is a raw type. References to generic type Stream<T> should be parameterized
		
		
		
		//---------------//
		//Infinite Stream//
		//---------------//
		//Stream<Integer> randStream1 = Stream.generate(() -> Math.random());	//Compilation fails. Type mismatch: cannot convert from Stream<Double> to Stream<Integer>
		Stream randStream2 = Stream.generate(() -> Math.random());				//Ok
		Stream<Double> randStream3 = Stream.generate(() -> Math.random());
		Stream<Double> randStream4 = Stream.generate(Math::random);
		//randStream4.forEach(System.out::println);								//Doesn't stop
		
		Stream<Byte> oddStream1 = Stream.iterate((byte)1, n -> (byte)(n + 2));
		//oddStream1.forEach(System.out::println); 								//Doesn't stop
		
		//System.out.println(Stream.iterate(1, n -> n * 10).count());			//Hangs
	}
}

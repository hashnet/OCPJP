package a;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		long[] longPairs = new long[]{4, 5, 2, 1, 1, 3, 2, 5, 4};
		System.out.println((solution(longPairs)));
		//Output: 3
		
		Character[] charPairs = new Character[]{'D', 'E', 'B', 'A', 'A', 'C', 'B', 'E', 'D'};
		longPairs = Arrays
			.asList(charPairs)
			.stream()
			.mapToLong(x -> x)
			.toArray();		
		System.out.println((char)solution(longPairs));
		//Output: C
	}
	
	private static long solution(long[] arr) {
		long result = 0;
		for(long x : arr) {
			result ^= x;
		}
		
		return result;
	}
}

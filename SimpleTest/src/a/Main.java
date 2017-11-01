package a;

public class Main {
	interface Bigger<T extends Number> {
		T bigger(T n1, T n2);
	}
	
	class BiggerImpl<T extends Number> implements Bigger<T> {
		@Override
		public T bigger(T n1, T n2) {
			if(n1.doubleValue() >= n2.doubleValue()) return n1;
			else return n2;
		}
	}
	
	public static void main(String[] args) {
		int i = 30;
		int j = 20;
		
		Main m = new Main();
		int x = findBigger(i, j, m.new BiggerImpl<Integer>());
		System.out.println(x);
		
		int y = findBigger(i, j, new Bigger<Integer>() {
			@Override
			public Integer bigger(Integer n1, Integer n2) {
				if(n1.intValue() >= n2.intValue()) return n1;
				else return n2;
			}});		
		System.out.println(y);	
		
		int z = findBigger(i, j, (Integer n1, Integer n2) -> n1.intValue() > n2.intValue() ? n1 : n2);
		System.out.println(z);
	}
	
	private static int findBigger(int i, int j, Bigger<Integer> big) {
		return (int) big.bigger(i, j);
	}
}

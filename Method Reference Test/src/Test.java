import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface Job {
	int doJob (int a, int b);
}

class Op {
	public static int add(int a, int b) {
		return a + b;
	}
	
	public int mult(int a, int b) {
		return a * b;
	}
}

public class Test {
	private static int p = 10;
	private static int q = 20;
	
	public static void main(String[] args) {
		doMath(30, 40);
	}
	
	private static void doMath(int l, int m) {
		int i1 = compute(new Job(){
			@Override
			public int doJob(int a, int b) {
				return a + b;
			}
		}, l, m);		
		System.out.println(i1);
		
		int i2 = compute((a, b) -> a + b, l, m);
		System.out.println(i2);
		
		int i3 = compute((a, b) -> a + b, p, q);
		System.out.println(i3);
		
		int i4 = compute((a, b) -> Op.add(a, b), l, m);
		System.out.println(i4);
		
		int i5 = compute(Op::add, l, m);
		System.out.println(i5);
		
		int j1 = compute((a, b) -> a * b, l, m);
		System.out.println(j1);
		
		Op operator = new Op();
		int j2 = compute((a, b) -> operator.mult(a, b), l, m);
		System.out.println(j2);
		
		int j3 = compute(operator::mult, l, m);
		System.out.println(j3);
		
		int j4 = compute(new Op()::mult, l, m);
		System.out.println(j4);
		
		Supplier<ArrayList<Integer>> lambda1 = () -> new ArrayList<>();
		Supplier<ArrayList<Integer>> mr1 = ArrayList::new;
		
		Predicate<String> lambda2 = (s) -> s.startsWith(s);
		
		Predicate<String> lambda3 = (s) -> s.startsWith("A");
		Predicate<String> mr3 = String::isEmpty;
	}
	
	private static int compute(Job job, int x, int y) {
		return job.doJob(x, y);
	}
}


public class WithoutAssertion {
	public static void main(String[] args) {
		boolean test = false;
		
		if(!test) throw new AssertionError();
	}
}

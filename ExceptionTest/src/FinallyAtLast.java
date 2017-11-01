
public class FinallyAtLast {
	public static void main(String[] args) {
		try {
			throw new RuntimeException();
		} finally {
			System.out.println("This line is supposed to be executed at all cost.");
		}
	}
}

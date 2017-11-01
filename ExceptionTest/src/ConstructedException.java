
public class ConstructedException extends Exception{

	public ConstructedException() {
		super();
	}
	
	public ConstructedException(Exception e) {
		super(e);
	}
	
	public ConstructedException(String message) {
		super(message);
	}
	
	public static void main(String[] args) throws ConstructedException{
		//throw new ConstructedException();
		/*Output:
			Exception in thread "main" ConstructedException
				at ConstructedException.main(ConstructedException.java:17)*/
				
		//throw new ConstructedException(new RuntimeException());
		/*Output:
			Exception in thread "main" ConstructedException: java.lang.RuntimeException
				at ConstructedException.main(ConstructedException.java:22)
			Caused by: java.lang.RuntimeException
				... 1 more*/
		
		//throw new ConstructedException("Constructed Message");
		/*Output:
			Exception in thread "main" ConstructedException: Constructed Message
				at ConstructedException.main(ConstructedException.java:29)*/
	}
}

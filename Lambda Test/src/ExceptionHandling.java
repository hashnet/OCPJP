import java.io.IOException;
import java.util.*;
import java.util.function.*;

class ExceptionalCreate {
	public static List<String> create() throws IOException {
		return new ArrayList<String>();
	}
}


public class ExceptionHandling {
	public static void handle1() throws IOException {
		ExceptionalCreate.create().stream().count();
	}
	
	public static void handle2() {
		try {
			ExceptionalCreate.create().stream().count();
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		
		try {
			handle1();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		handle2();
		
		
	}
	
	public static void testStreamException() {
//		Supplier<List<String>> s1 = () -> ExceptionalCreate.create();	//Unhandled exception type IOException
	
		Supplier<List<String>> s2 = () -> {
			try {
				return ExceptionalCreate.create();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		};
		
		Supplier<List<String>> s3 = () -> safeCreate();
	}
	
	public static List<String> safeCreate() {
		try {
			return ExceptionalCreate.create();
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
}

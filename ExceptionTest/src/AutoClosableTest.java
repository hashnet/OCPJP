import java.io.FileNotFoundException;
import java.io.IOException;

class Auto implements AutoCloseable {
	@Override
	public void close(){
		System.out.println("Closing Auto.");		
	}	
}

class AutoRuntime implements AutoCloseable {
	@Override
	public void close() throws RuntimeException {
		System.out.println("Closing AutoRuntime.");
	}
}

class AutoIO implements AutoCloseable {
	@Override
	public void close() throws IOException {
		System.out.println("Closing AutoIO.");
	}
}

public class AutoClosableTest {
	public static void main(String[] args) {
		try(Auto a = new Auto()){
			System.out.println("Inside Try.");
			
			throw new RuntimeException();
		} catch (RuntimeException e) {
			System.out.println("Inside Catch.");
		} finally {
			System.out.println("Inside Finally.");
		}		
		/*Output:
			Inside Try.
				Closing Auto.
				Inside Catch.
				Inside Finally.*/
		
		try(Auto a = new Auto()) {
		}
		/*Output:
			Closing Auto.*/
		
		try(AutoRuntime a = new AutoRuntime()) {
		}
		/*Output:
			Closing AutoRuntime.*/
		
		/*try(AutoIO a = new AutoIO()) {	//Compilation fails. Unhandled exception type IOException thrown by automatic close() invocation on a
		}*/
		
		try(AutoIO a = new AutoIO()) {
		} catch(IOException e) {
		}
		/*Output:
		Closing AutoIO.*/
		
		try(AutoIO a = new AutoIO()) {
		} catch(Exception e) {
		}
		/*Output:
		Closing AutoIO.*/
		
		/*try(AutoIO a = new AutoIO()) {	//Compilation fails. Unhandled exception type IOException thrown by automatic close() invocation on a
		} catch(FileNotFoundException e) {
		}*/
	}
}

/*Output:
	Inside Try.
	Closing A.
	Inside Catch.
	Inside Finally.*/


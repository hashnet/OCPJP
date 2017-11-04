//java.lang.Object
//	java.lang.Throwable
//		java.lang.Exception
//			java.io.IOException
//				java.io.FileNotFoundException

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class MultiCatch {
	public static void main(String[] args) {
		try {
		} catch(Exception e) {			
		}
		
		try {
		} catch(RuntimeException e) {
		}
		
		/*try {			
		} catch(IOException e) { 			//Compilation fails. Unreachable catch block for IOException. This exception is never thrown from the try statement body
		}*/
		
		/*try {
		} catch(FileNotFoundException e) {	//Compilation fails. Unreachable catch block for FileNotFoundException. This exception is never thrown from the try statement body
		}*/
		
		/*try {
		} catch(SQLException e) { 			//Compilation fails. Unreachable catch block for SQLException. This exception is never thrown from the try statement body
		}*/
		
		try {
			throwException();
		} catch(FileNotFoundException e) {
		} catch(IOException e) {
		}
		
		/*try {
			throwException();
		} catch(IOException e) {
		} catch(FileNotFoundException e) {	//Compilation fails. Unreachable catch block for FileNotFoundException. It is already handled by the catch block for IOException
		}*/
		
		/*try {
			throwException();
		} catch(FileNotFoundException | IOException e) {	//Compilation fails. The exception FileNotFoundException is already caught by the alternative IOException
		}*/
		
		try {
			throwException();
		} catch(IOException e) {
		}
		
		try {
			throwException();
		} catch(Exception e) {
		}
	}
	
	private static void throwException () throws FileNotFoundException, IOException, RuntimeException {
		//
	}
}

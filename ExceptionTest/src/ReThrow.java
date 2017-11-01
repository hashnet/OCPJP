import java.io.IOException;
import java.sql.SQLException;

public class ReThrow {
	public static void main(String[] args) {
		
	}
	
	private static void method1() throws Exception {
		try {			
		} catch(Exception e) {
			throw e;
		}
		
		try {			
		} catch(RuntimeException e) {
			throw e;
		}
		
		try {
			throw new IOException();
		} catch(IOException e) {
			throw e;
		}
	}
	
	private static void method2() throws IOException {
		try {
			//throw new Exception();
		} catch(Exception e) {
			throw e;
		}
		
		/*try {
			throw new Exception();
		} catch(Exception e) {
			throw e;				//Compilation fails. Unhandled exception type Exception
		}*/
		
		/*try {
			throwEx();
		} catch(Exception e) {		//Compilation fails. Unhandled exception type Exception	
			throw e;
		}*/
		
		try {
		} catch(RuntimeException e) {
			throw e;
		}
				
		/*try {
			throw new SQLException();
		}catch(SQLException e) {
			throw e;				//Compilation fails. Unhandled exception type SQLException
		}*/
		
		/*try {
			throwSQLIO();			//Compilation fails. Unhandled exception type SQLException
		}catch(IOException e) {
			throw e;				//Compilation fails.
		}*/
		
		/*try {
			throwSQLIO();
		}catch(SQLException | IOException e) {
			throw e;				//Compilation fails. Unhandled exception type SQLException
		}*/
		
		/*try {
			throwSQL();
		}catch(SQLException e) {
			throw e; 				//Compilation fails. Unhandled exception type SQLException
		}*/
		
		/*try {
			throwSQL();
		}catch(Exception e) {
			throw e;				//Compilation fails. Unhandled exception type SQLException
		}*/
		
		try {
			throw new IOException();
		}catch(IOException e) {
			throw e;
		}
	}
	
	private static void throwSQLIO() throws SQLException, IOException {}
	private static void throwEx() throws Exception {}
	private static void throwSQL() throws SQLException {}
}

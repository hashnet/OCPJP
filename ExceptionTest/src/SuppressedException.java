import java.io.IOException;
import java.sql.SQLException;

public class SuppressedException {
	class SuppAuto implements AutoCloseable {
		@Override
		public void close () throws IOException {
			throw new IOException ("This is an IOException.");
		}		
	}
	public static void main(String[] args) {
		SuppressedException se = new SuppressedException();
		se.doTry();
	}
	
	public void doTry () {
		/*try (SuppAuto sa = new SuppAuto()){		//Unhandled exception type IOException thrown by automatic close() invocation on sa
			throw new SQLException ("This is an SQLException");
		} catch (SQLException e) {}*/
		
		/*try (SuppAuto sa = new SuppAuto()){		
			throw new SQLException ("This is an SQLException");	//Unhandled exception type SQLException
		} catch (IOException e) {}*/
		
		try (SuppAuto sa = new SuppAuto()){		
			throw new SQLException ("This is an SQLException");	
		} catch (Exception e) {}
		
		try (SuppAuto sa = new SuppAuto()){		
			throw new SQLException ("This is an SQLException");	
		} catch (SQLException | IOException e) {}
		
		try (SuppAuto sa = new SuppAuto()){		
			throw new SQLException ("This is an SQLException");	
		} catch (SQLException e) {			
		} catch (IOException e) {}
		
	}
}

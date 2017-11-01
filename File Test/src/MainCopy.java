import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class MainCopy {
	public static void main(String[] args) {
		File source = new File("src\\Main.java");
		File destination = new File("src\\MainCopy.java");
		
		try {
			copy(source, destination);
			
			copyBuffered(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void copy(File source, File destination) throws IOException {
		try (InputStream in = new FileInputStream(source);
				OutputStream out = new FileOutputStream(destination)) {
			
			int oneBte;
			while((oneBte = in.read()) != -1) {
				out.write(oneBte);
			}
		}
	}
	
	private static void copyBuffered(File source, File destination) throws IOException{
		try (InputStream in = new BufferedInputStream(new FileInputStream(source));
			 OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {
			
			int MAX = 1024;
			byte[] bytes = new byte[MAX];
			int lengthRead;
			while((lengthRead = in.read(bytes)) > 0) {
				out.write(bytes, 0, lengthRead);
				out.flush();
			}
		}
	}
}

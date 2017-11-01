import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


public class Main {
	public static void main(String[] args) {
		File source = new File("files\\input.txt");
		File destination = new File("files\\output.txt");
		
		try {
			//copy(source, destination);	//very slow
			
			copyBuffered(source, destination);	//fast
			
			copyBufferedReaderWriter(source, destination);	//fast
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void copy(File source, File destination) throws IOException {
		try (InputStream in = new FileInputStream(source);
				OutputStream out = new FileOutputStream(destination)) {
			
			int oneByte;
			while((oneByte = in.read()) != -1) {
				out.write(oneByte);
			}
		}
	}
	
	private static void copyBuffered(File source, File destination) throws IOException {
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
	
	private static void copyBufferedReaderWriter(File source, File destination) throws IOException{
		List<String> data = new ArrayList<String>();
		
		data = readBuffered(source);
		
		for(String line : data) {
			System.out.println(line);
		}
		
		writeBuffered(data, destination);
	}
	
	private static List<String> readBuffered(File source) throws IOException {
		List<String> data = new ArrayList<String>();
		
		try(BufferedReader reader = new BufferedReader(new FileReader(source))) {
			String line;
			while((line = reader.readLine()) != null) {
				data.add(line);
			}
		}
		
		return data;
	}
	
	private static void writeBuffered(List<String> data, File destination) throws IOException {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
			for(String line : data) {
				writer.write(line);
				writer.newLine();
			}
		}
	}
}

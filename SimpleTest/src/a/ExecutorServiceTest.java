package a;

import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceTest {
	private static final int MAX = 100;
	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("Start.....................................................");
			service.execute(() -> {
				for(int i=1; i<=MAX; i++) System.out.println("T1: " + i);
			});
			service.execute(() -> {
				for(int i=1; i<=MAX; i++) System.out.println("\t\tT2: " + i);
			});
			service.execute(() -> {
				for(int i=1; i<=MAX; i++) System.out.println("\t\t\t\tT3: " + i);
			});
			System.out.println("End.....................................................");
		} finally {
			if(service != null)	{
				List<Runnable> unexecuted = service.shutdownNow();
			
				for(Runnable r : unexecuted) {
					System.out.println(r);
				}
			}
		}
	}
}

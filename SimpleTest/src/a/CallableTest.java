package a;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.lang3.SystemUtils;

public class CallableTest {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService es = null;
		
		try {
			es = Executors.newSingleThreadExecutor();
			
			Future<Integer> future = es.submit(() -> {
				int j = 0;
				for(int i=0; i<=1000000000; i++) {
					j = i;
				}
				
				return j;
			});
			
			System.out.println("Begin");
			int i = future.get();
			System.out.println(i);
			System.out.println("End");
			
			
			es.submit(() -> {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});

		} finally {
			if(es != null) es.shutdown();
		}
	}
}

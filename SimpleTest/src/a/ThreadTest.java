package a;

public class ThreadTest {
	static int counter = 0;
	static int MAX = 10000000;
	public static void main(String[] args) throws InterruptedException{
		new Thread(()-> {
			for(int i=0; i<=MAX; i++){
				++ThreadTest.counter;
			}
		}).start();
	
	
		while(counter < MAX) {
			System.out.println("Completed " + (int)(((double)counter/MAX) * 100) + "%");
			Thread.sleep(10);
		}
		System.out.println("Completed " + (int)(((double)counter/MAX) * 100) + "%");
	}
}

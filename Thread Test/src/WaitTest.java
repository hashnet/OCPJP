import java.time.LocalTime;

class Box {
	
}

public class WaitTest {
	private static final long T_SLEEP = 2000;
	public static void main(String[] args) {
		Box box = new Box();
		
		new Thread(() -> {
			String str = ": " + Thread.currentThread().getName() + ": ";
			System.out.println(LocalTime.now() + str + "Inside run()");
			synchronized(box) {
				System.out.println(LocalTime.now() + str + "Inside synchronized(box)");
				try {
					System.out.println(LocalTime.now() + str + "Going to sleep");
					Thread.sleep(T_SLEEP);
					System.out.println(LocalTime.now() + str + "Finished sleeping");
				}catch(InterruptedException e) {
					System.out.println(LocalTime.now() + str + "Interrupted.");
				}
			}
		}, "First Sleeping Thread").start();
		
		new Thread(() -> {
			String str = ": " + Thread.currentThread().getName() + ": ";
			System.out.println(LocalTime.now() + str + "Inside run()");
			synchronized(box) {
				System.out.println(LocalTime.now() + str + "Inside synchronized(box)");
				try {
					System.out.println(LocalTime.now() + str + "Going to sleep");
					Thread.sleep(T_SLEEP);
					System.out.println(LocalTime.now() + str + "Finished sleeping");
				}catch(InterruptedException e) {
					System.out.println(LocalTime.now() + str + "Interrupted.");
				}
			}
		}, "Second Sleeping Thread").start();
		
		new Thread(() -> {
			String str = ": " + Thread.currentThread().getName() + ": ";
			System.out.println(LocalTime.now() + str + "Inside run()");
			synchronized(box) {
				System.out.println(LocalTime.now() + str + "Inside synchronized(box)");
				try {
					System.out.println(LocalTime.now() + str + "Going to sleep");
					Thread.sleep(T_SLEEP);
					System.out.println(LocalTime.now() + str + "Finished sleeping");
					System.out.println(LocalTime.now() + str + "Going to notify");
					box.notifyAll();
				}catch(InterruptedException e) {
					System.out.println(LocalTime.now() + str + "Interrupted.");
				}
			}
		}, "Third Sleeping Thread").start();
		
		Thread t4 = new Thread(() -> {
			String str = ": " + Thread.currentThread().getName() + ": ";
			System.out.println(LocalTime.now() + str + "Inside run()");
			synchronized(box) {
				System.out.println(LocalTime.now() + str + "Inside syhnchronized(box)");
				try {
					System.out.println(LocalTime.now() + str + "Going to wait on box");
					box.wait();
					System.out.println(LocalTime.now() + str + "Finished waiting on box");
				} catch (InterruptedException e) {
					System.out.println(LocalTime.now() + str + "Interrupted.");
				}
			}
		}, "First Waiting Thread");
		t4.start();
		
		System.out.println("Inside main");
	
		try {
			t4.join();
		} catch (InterruptedException e) {}
		System.out.println("Finished main");
	}
}

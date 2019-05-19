/**
 * We are creating two threads here using the Runnable interface. The definition of our
 * thread's blueprint starts on line 17. Our thread has a constructor that sets a name for it.
 * Check out the start() and run() methods of the runnable. The run() method loops from 1 to 25
 * and prints out a statement to the console. Notice the sleep() method in line 33.
 * This is what happens when you run this program. The main() thread runs, which creates 
 * the two runnables (line 13 and 15). The Jack thread's run() method gets executed first and
 * it prints "0: Jack" to the console and the thread goes to sleep for 1000ms. During this time,
 * the Jill thread is executed and it prints "0: Jill" to the console and goes to sleep for 1000ms.
 * Then the Jack thread wakes up and does its job. Run the program and check out the output.
 * 
 * Now comment out the lines 39-43. We are not going to make the threads sleep. What do you
 * think will happen to the output? Check it out and see if you understand what's going on.
 */

public class RunnableThread {

	public static void main(String[] args) {
		MyRunnable runnable1 = new MyRunnable("Jack");
		runnable1.start();
		MyRunnable runnable2 = new MyRunnable("Jill");
		runnable2.start();
	}
	
}

class MyRunnable implements Runnable {
	
	Thread myThread;
	private String name;
	MyRunnable(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("Thread running: "+this.name);
		for(int i=0; i<25; i++) {
			System.out.println(i+": "+this.name);
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				System.out.println("Thread has been interrupted");
			}
		}
	}
	
	public void start() {
		System.out.println("Thread "+this.name+" started");
		if(myThread==null) {
			myThread = new Thread(this, this.name);
			myThread.start();
		}
	}
	
}
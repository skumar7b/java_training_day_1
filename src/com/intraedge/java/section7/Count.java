/**
 * There are two threads in play here. Can you recognize them? When you run this Java program,
 * the main() method is called that starts executing your code. This is called the 
 * 'main' thread of execution. Every Java program has ONE main thread of execution. This main
 * thread gets its own stack of memory in the JVM that's shielded from outside influence. 
 * If you look at line 30, we are creating an instance of the Count class. This class
 * happens to represent a thread as it extends the Thread class. Inside the constructor
 * of this class, the start() method is called which will start a new thread and call the run()
 * method. The run() method of the new thread is analogous to the main() method of the Java program.
 * 
 * So there are two threads running concurrently here:
 * 1. the main thread running the main() method
 * 2. the child thread that was spawned off and started in the constructor block (lines 16-20)
 * 
 * These two threads run in completely different stacks in the JVM with no relation to each other.
 * The CPU actually does not run them in parallel. It switches between executing them at an extremely
 * rapid pace that it looks as if they are running in parallel.
 * 
 *  You might get different results for each run of this program. Run the program and try and understand
 *  what it does. 
 */

public class Count extends Thread {
	Count() {
		super();
	    System.out.println("creating the child thread...");
	    start();
	}
	
	public void run() {
		try {
			for (int i=0 ;i<10;i++) {
				System.out.println("printing the count " + i);
				Thread.sleep(1000);
			}
		} catch(InterruptedException e) {
	        System.out.println("child thread interrupted");
	    }
	    System.out.println("child thread run is over" );
	}
	
	public static void main(String args[]) {
		System.out.println("running the main thread...");
		Count cnt = new Count();
	    try {
	    	while(cnt.isAlive()) {
	    		System.out.println("main thread will be alive till the child thread is live");
	    		Thread.sleep(1500);
	    	}
	    } catch(InterruptedException e) {
	    	System.out.println("main thread interrupted");
	    }
	    System.out.println("main thread's run is over" );
	}
}

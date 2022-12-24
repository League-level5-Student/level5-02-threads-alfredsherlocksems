package _04_Thread_Pool.tests;

public class ThreadPoolTester {
	public static void main (String [] args) {
		WorkQueue wq = new WorkQueue();
		System.out.println("Total thread Count: " + wq.getThreadCount());
		wq.shutdown();
	}
}



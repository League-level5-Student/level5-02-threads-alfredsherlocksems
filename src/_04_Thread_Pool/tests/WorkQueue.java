package _04_Thread_Pool.tests;

import java.util.ArrayDeque;

public class WorkQueue implements Runnable{
	private Thread[] threads;
	private volatile boolean isRunning = true; //volatile 
	private ArrayDeque<Job> jobQueue = new ArrayDeque<Job>();
	public WorkQueue() {
		int totalThreads = Runtime.getRuntime().availableProcessors() - 1;
		threads = new Thread[totalThreads];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(this);
			threads[i].start();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isRunning) {
			System.out.println("Output from thread #" + Thread.currentThread().getId());
			synchronized (jobQueue) {
				try {
					jobQueue.wait();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public int getThreadCount()
	{
		return threads.length;
	}
	
	public void shutdown() {
		isRunning = false;
		synchronized (jobQueue) {
			jobQueue.notifyAll();
		}
	}
	
	public void addJob(Job j) {
		synchronized(jobQueue) {
			jobQueue.add(j);
			jobQueue.notify();
		}
	}
}

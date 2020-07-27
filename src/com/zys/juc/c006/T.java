package com.zys.juc.c006;

/*
 * 
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html
 * Monitor: A language level concept
 * A monitor is a collection of procedures, variables, and data structure that are all grouped together in a special kind of module or package.
 * Processes/Threads may call the procedures in a monitor whenever they want to, but they cannot directly access the monitor's internal data structures
 * from procedures declared outside the monitor.
 * Monitors have an important property that makes them useful for achieving mutual exclusion: only one process can be active in a monitor at any instance.
 */

public class T implements Runnable {
	private int count = 10;
	
	@Override
	public synchronized void run() {
		count --;
		System.out.println(Thread.currentThread().getName() + " count =" + count);
	}
	
	public static void main(String[] args) {
		T t = new T();
		for (int i = 0; i < 5; i++) {
			new Thread(t, "Thread" + i).start();
		}
	}
}

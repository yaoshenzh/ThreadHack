package com.zys.juc.c004;

/*
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html
 * You might wonder what happens when a static synchronized method is invoked, since a static method is associated with a class, not an object. 
 * In this case, the thread acquires the intrinsic lock for the Class object associated with the class. 
 * Thus access to class's static fields is controlled by a lock that's distinct from the lock for any instance of the class.
 */

public class T {
	private static int count = 10;
	
	// synchronized method
	public synchronized static void m() {
		count--;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}
	
	public static void mm() {
		// synchronized statement
		synchronized (T.class) { //static 方法锁的是该类本身的Class类
			count--;
			System.out.println(Thread.currentThread().getName() + " count = " + count);
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				m();
			}).start();
		}
		
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				mm();
			}).start();
		}
	}
} 

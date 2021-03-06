package com.zys.juc.c009;

/**
 * A thread cannot acquire a lock owned by another thread. But a thread can acquire a lock that it already owns. 
 * 一个同步方法可以调用另外一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁.
 * 也就是说synchronized获得的锁是可重入的
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html
 * See Reentrant Synchronization section.
 */

public class ReentrantLock {

	public static void main(String[] args) {
		ReentrantLock reentrantLock = new ReentrantLock();
		
		reentrantLock.m2();
	}
	
	public synchronized void m1() {
		System.out.println("m1");
	}
	
	public synchronized void m2() {
		m1();
		System.out.println("m2");
	}

}

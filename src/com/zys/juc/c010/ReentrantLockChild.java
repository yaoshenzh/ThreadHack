package com.zys.juc.c010;

/*
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html
 * See Reentrant Synchronization section.
 * */
public class ReentrantLockChild extends ReentrantLock {

	public ReentrantLockChild() {
	}
	
	public synchronized void mm() {
		System.out.println("child method start");
		super.m();
		System.out.println("child method end");
	}
	
	public static void main(String[] args) {
		ReentrantLockChild reentrantLockChild = new ReentrantLockChild();
		
		reentrantLockChild.mm();
	}

}

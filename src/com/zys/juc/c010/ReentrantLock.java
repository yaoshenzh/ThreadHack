package com.zys.juc.c010;

public class ReentrantLock {
	
	public synchronized void m() {
		System.out.println("parrent function.");
	}

}

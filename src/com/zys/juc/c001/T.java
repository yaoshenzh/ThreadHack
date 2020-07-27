package com.zys.juc.c001;

/**
 * synchronized
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/sync.html
 * 对某个对象加锁
 */

public class T {
	
	private int count = 10;
	private Object o = new Object();
	
	public void m() {
		// synchronized statements must specify the object that provides the intrinsic lock:
		synchronized(o) { //任何线程要执行下面的代码，必须先拿到o的锁
			count--;
			System.out.println(Thread.currentThread().getName() + " count = " + count);
		}
	}
	
}


package com.zys.juc.c005;

/**
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/interfere.html
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/memconsist.html
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html
 * 
 * volatile 作用
 * 1.线程可见性
 * 2.禁止指令重排序
 * 
 * Happens-before relationship is simply a guarantee that memory writes by one specific statement are visible to another specific statement. 
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/memconsist.html
 * */
public class T implements Runnable {
	private /*volatile*/ int count = 100;
	
	@Override
	public /*synchronized*/ void run() {
		count --;
		System.out.println(Thread.currentThread().getName() + " count =" + count);
	}
	
	public static void main(String[] args) {
		T t = new T();
		for (int i = 0; i < 100; i++) {
			new Thread(t, "Thread" + i).start();
		}
	}
}

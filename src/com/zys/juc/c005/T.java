package com.zys.juc.c005;

/**
 * volatile 作用
 * 1.线程可见性
 * 2.禁止指令重排序
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

package com.zys.juc.c004;

public class T {
	private static int count = 10;
	
	public synchronized static void m() {
		count--;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}
	
	public static void mm() {
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

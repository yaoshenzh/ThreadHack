package com.zys.juc.c003;

public class T {
	
	private static int count = 10;
	
	private void m() {
		synchronized (this) { //每次创建一个对象出来加锁比较麻烦，直接把该对象锁了
			//必须拿到this对象的锁才能执行下面的代码
			count--;
			System.out.println(Thread.currentThread().getName() + " count = " + count);
		}
	}
	
	public void n() {
		count++;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				new T().m();
			}).start();
		}
	}
}

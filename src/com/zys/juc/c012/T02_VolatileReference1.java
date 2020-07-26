package com.zys.juc.c012;

import java.util.concurrent.TimeUnit;

/**
 * volatile 引用类型（包括数组）只能保证引用本身的可见性，不能保证内部字段的可见性
 */

public class T02_VolatileReference1 {
	
	boolean running = true;
	private volatile static T02_VolatileReference1 volatileReference1 = new T02_VolatileReference1();
	
	public static void main(String[] args) {
		new Thread(volatileReference1::m, "t1").start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		volatileReference1.running = false;
	}
	
	public void m() {
		System.out.println("m start.");
		
		while (running) {
		}
		
		System.out.println("m finished.");
	}
}

package com.zys.juc.c000;

public class T03_Sleep_Yield_Join {
	public static void main(String[] args) {
//		testSleep();
//		testYield();
		testJoin();
	}
	
	private static void testSleep() {
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("testSleep");
			}
		}).start();
	}
	
	private static void testYield() {
		new Thread(() -> {
			for (int i = 0; i < 8; i++) {
				System.out.println("Thread A");
				if (i % 2 == 0) {
					Thread.yield();
				}
			}
		}).start();
		
		new Thread(() -> {
			for (int i = 0; i < 8; i++) {
				System.out.println("Thread B");
				if (i % 2 == 0) {
					Thread.yield();
				}
			}
		}).start();
	}
	
	private static void testJoin() {
		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(1500);
				System.out.println("t1 wakes up.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(() -> {
			System.out.println("t2 is waiting for t1 to wake up.");
			try {
				t1.join();
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
	}
}

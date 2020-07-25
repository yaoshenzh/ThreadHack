package com.zys.juc.c000;

public class T02_HowToCreateThread {
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			T2 t2 = new T2();
			t2.start();
		}
		
		for (int i = 0; i < 5; i++) {
			T3 t3 = new T3();
			Thread thread = new Thread(t3);
			thread.start();
		}
		
		new Thread(() -> {
			System.out.println("LambdaFunction");
		}).start();
	}

	private static class T2 extends Thread {
		@Override
		public void run() {
			System.out.println("T2");
		}
	}
	
	private static class T3 implements Runnable {
		@Override
		public void run() {
			System.out.println("T3");
		}
	}
}

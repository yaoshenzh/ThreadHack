package com.zys.juc.c000;

public class ThreadState {
	
	public static void main(String[] args) {
		T1 t1 = new T1();
		t1.start();
	}
	
	private static class T1 extends Thread {
		@Override
		public void run() {
			System.out.println(this.getState());
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(this.getState());
		}
	}
	
	
}


package com.zys.juc.c000;

import java.util.concurrent.TimeUnit;

/*
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/procthread.html
 **/
public class T01_WhatIsThread {
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			new T1().start();
			try {
				TimeUnit.MICROSECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("main");
		}
	}
	
	private static class T1 extends Thread {
		@Override
		public void run() {
			try {
				TimeUnit.MICROSECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("T1");
		}
	}
}

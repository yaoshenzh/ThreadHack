package com.zys.juc.c016;

import java.util.concurrent.CountDownLatch;

public class T06_CountDownLatchTest {

	public static void main(String[] args) {
		testCountDownLatch();
		testJoin();
	}
	
	private static void testCountDownLatch() {
		Thread[] threads = new Thread[1000];
		CountDownLatch countDownLatch = new CountDownLatch(threads.length);
		
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(() -> {
				for (int j = 0; j < 1000; j++) {
					int result = 0;
					for (int k = 0; k < 10000; k++) result++;
					countDownLatch.countDown();
				}
			});
		}
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		
        try {
        	countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("end latch");
	}
	
	private static void testJoin() {
        Thread[] threads = new Thread[100];

        for(int i=0; i<threads.length; i++) {
            threads[i] = new Thread(()->{
                int result = 0;
                for(int j=0; j<10000; j++) result += j;
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("end join");
    }


}

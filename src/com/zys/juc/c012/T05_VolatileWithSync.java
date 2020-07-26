package com.zys.juc.c012;

import java.util.ArrayList;
import java.util.List;

/**
 * 对比上一个程序，可以用synchronized解决，synchronized可以保证可见性和原子性，volatile只能保证可见性
 */
public class T05_VolatileWithSync {
	
	private volatile int count = 0;
	private synchronized void m() {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}
	
	List<Thread> threadList = new ArrayList<>();
	
	public static void main(String[] args) {
		T05_VolatileWithSync t04_VolatileWithoutSync = new T05_VolatileWithSync();
		
		for (int i = 0; i < 10; i++) {
			t04_VolatileWithoutSync.threadList.add(new Thread(t04_VolatileWithoutSync::m, "thread" + i));
		}
		
		t04_VolatileWithoutSync.threadList.forEach(o -> o.start());
		
		t04_VolatileWithoutSync.threadList.forEach((o) -> {
			try {
				o.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		System.out.println(t04_VolatileWithoutSync.count);
	}
}

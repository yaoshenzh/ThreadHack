package com.zys.juc.c012;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile并不能保证多个线程共同修改running变量时所带来的不一致问题，也就是说volatile不能替代synchronized
 * 运行下面的程序，并分析结果
 */

public class T04_VolatileWithoutSync {
	
	private volatile int count = 0;
	private void m() {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}
	
	List<Thread> threadList = new ArrayList<>();
	
	public static void main(String[] args) {
		T04_VolatileWithoutSync t04_VolatileWithoutSync = new T04_VolatileWithoutSync();
		
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

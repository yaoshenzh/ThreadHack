
/**
 * 解决同样的问题的更高效的方法，使用AtomXXX类
 * AtomXXX类本身方法都是原子性的，但不能保证多个方法连续调用是原子性的
 */
package com.zys.juc.c013;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class T01_AtomicInteger {

	AtomicInteger count = new AtomicInteger(0);
	List<Thread> threadList = new ArrayList<>();
	
	private void m() {
		for (int i = 0; i < 100000; i++) {
			count.incrementAndGet();
		}
	}
	
	public static void main(String[] args) {
		T01_AtomicInteger t = new T01_AtomicInteger();
		
		for (int i = 0; i < 10; i++) {
			t.threadList.add(new Thread(t::m, "thread" + i));
		}
		
		t.threadList.forEach(o -> o.start());
		
		t.threadList.forEach((o) -> {
			try {
				o.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		System.out.println(t.count);
	}

}

package com.zys.juc.c016;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * reentrant lock用于替代synchronized
 * 本例中由于m1锁定this,只有m1执行完毕的时候,m2才能执行
 * 使用reentrant lock可以完成同样的功能
 * 需要注意的是，必须要必须要必须要手动释放锁
 * 使用syn锁定的话如果遇到异常，jvm会自动释放锁，但是lock必须手动释放锁，因此经常在finally中进行锁的释放
 */
public class T02_ReentrantLock2 {
	
	Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		T02_ReentrantLock2 rl = new T02_ReentrantLock2();
		new Thread(rl::m1).start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(rl::m2).start();
	}
	
	private void m1() {
		try  {
			lock.lock();
			for (int i = 0; i < 2; i++) {
				TimeUnit.SECONDS.sleep(1);
				System.out.println(i);
			} 
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	private void m2() {
		try {
			lock.lock();
			System.out.println("m2 finished.");
		} finally {
			lock.unlock();
		}
	}
}

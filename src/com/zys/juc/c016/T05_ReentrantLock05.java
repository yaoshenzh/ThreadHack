package com.zys.juc.c016;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock还可以指定为公平锁
 */
public class T05_ReentrantLock05 {

	Lock lock = new ReentrantLock(true);

	public static void main(String[] args) {
		T05_ReentrantLock05 t = new T05_ReentrantLock05();

		new Thread(() -> t.m1(), "Thread01").start();
		new Thread(() -> t.m1(), "Thread04").start();
		new Thread(() -> t.m1(), "Thread02").start();
		new Thread(() -> t.m1(), "Thread03").start();
	}

	private synchronized void m1() {
		for (int i = 0; i < 100; i++) {
			lock.lock();
			try {
				System.out.println(Thread.currentThread().getName() + "- aquired lock.");
			} finally {
				lock.unlock();
			}
		}
	}
}

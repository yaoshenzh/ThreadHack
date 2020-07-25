package com.zys.juc.c008;

/**
 * 面试题：模拟银行账户
 * 对业务写方法加锁
 * 对业务读方法不加锁
 * 这样行不行？
 *
 * 容易产生脏读问题（dirtyRead）
 */

public class BankAccount {
	private static int balance;
	
	public static void main(String[] args) {
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(400);
					checkAccount();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
					transfer(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	public /*synchronized*/ static void checkAccount() {
		System.out.println("check balance:" + balance);
	}
	
	public synchronized static void transfer(int amount) {
		balance += 10;
		System.out.println("Current Balance = " + balance);
	}
	
}

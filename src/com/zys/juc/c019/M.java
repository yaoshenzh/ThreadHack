package com.zys.juc.c019;

public class M {
	@Override
	 protected void finalize() throws Throwable {
		System.out.println("GC collected");
	}
}

package com.xiaoxiao.concurrent.lock;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.xiaoxiao.concurrent.thread.PrintUtils;

public class TestSync {
	public static void main(String[] args) {
		//testConflict();
		
		testSyncMinMethod();
	}
	
	private static void testSyncMinMethod() {
		Runnable seller = new Runnable() {
			private Integer ticketCount = 100;
			
			@Override
			public void run() {
				while (ticketCount > 0) {
					int count = getDecreaseCount();
					
					String left = String.format("当前余票为%d张", count);
					PrintUtils.print(Thread.currentThread().getName(), left);
					
				}
			}
			
			private synchronized int getDecreaseCount() {
				return --ticketCount;
			}

		};
		
		new Thread(seller, "售票线程A").start();
		new Thread(seller, "售票线程B").start();
		new Thread(seller, "售票线程C").start();
	}
	
	private static void testConflict() {
		Runnable seller = new Runnable() {
			private Integer ticketCount = 100;
			
//			@Override
//			public void run() {
//				
//				while (ticketCount > 0) {
//					ticketCount--;
//					
//					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
//					String dateTime = sdf.format(new Date());
//					String desc = String.format("%s %s 当前余票为%d张", dateTime, Thread.currentThread().getName(), ticketCount);
//					
//					System.out.println(desc);
//				}
//			}
			
			//指定整个run方法为同步方法，这样同一时刻只允许一个线程执行该方法
			//发现只有线程A在执行，这是因为synchronized管的范围太广了，把整个run方法加锁，
			//如果线程A没有执行完，线程B和线程C就一直在等待
//			@Override
//			public synchronized void run() {
//				while (ticketCount > 0) {
//					ticketCount--;
//					
//					String left = String.format("当前余票为%d张", ticketCount);
//					PrintUtils.print(Thread.currentThread().getName(), left);
//				}
//			}
			
			@Override
			public void run() {
				while (ticketCount > 0) {
					int count;
					//在局部加锁即可
					synchronized (this) {
						count = --ticketCount;
					}
					
					String left = String.format("当前余票为%d张", ticketCount);
					PrintUtils.print(Thread.currentThread().getName(), left);
				}
			}
			
		};
		
		new Thread(seller, "售票线程A").start();
		new Thread(seller, "售票线程B").start();
		new Thread(seller, "售票线程C").start();
	}
}

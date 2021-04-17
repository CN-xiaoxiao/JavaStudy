package com.xiaoxiao.concurrent.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.xiaoxiao.concurrent.thread.PrintUtils;

public class TestScheduled {
	public static void main(String[] args) {
//		testSingleScheduleOnce();
		
//		testMultiScheduleRate();
		
		testMultiScheduleDelay();
	}
	
	//测试延迟一次的单线程定时器
	private static void testSingleScheduleOnce() {
		//创建延迟一次的单线程定时器
		ScheduledExecutorService pool = (ScheduledExecutorService) Executors.newSingleThreadScheduledExecutor();
		
		for (int i = 1; i <= 5; i++) {
			Visit visit = new Visit("延迟一次的单线程定时器", i);
			
			pool.schedule(visit, 1, TimeUnit.SECONDS);
		}
	}
	
	//测试固定速率的多线程定时器
	private static void testMultiScheduleRate() {
		//创建固定速率的多线程定时器
		ScheduledExecutorService pool = (ScheduledExecutorService) Executors.newScheduledThreadPool(3);
		
		for (int i = 1; i <= 5; i++) {
			Visit visit = new Visit("固定速率的多线程定时器", i);
			
			pool.scheduleAtFixedRate(visit, 1, 3, TimeUnit.SECONDS);
		}
	}
	
	//测试固定延迟的多线程定时器
	private static void testMultiScheduleDelay() {
		//创建固定延迟的多线程定时器
		ScheduledExecutorService pool = (ScheduledExecutorService) Executors.newScheduledThreadPool(3);
		
		for (int i = 1; i <= 5; i++) {
			Visit visit = new Visit("固定延迟的多线程定时器", i);
			
			pool.scheduleWithFixedDelay(visit, 1, 3, TimeUnit.SECONDS);
		}
	}
	
	
	private static class Visit implements Runnable {
		//任务名称
		private String name;
		//任务序号
		private int index;
		
		public Visit(String name, int index) {
			this.name = name;
			this.index = index;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			String desc = String.format("%s的第%d个任务到此一游", name, index);
			
			PrintUtils.print(Thread.currentThread().getName(), desc);
		
		}
	};
}

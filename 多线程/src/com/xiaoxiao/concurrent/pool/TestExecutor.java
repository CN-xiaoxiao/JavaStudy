package com.xiaoxiao.concurrent.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.xiaoxiao.concurrent.thread.PrintUtils;

public class TestExecutor {
	public static void main(String[] args) {
		testSinglePool();
		
//		testFixedPool();
		
//		testUnlimitPool();
		
//		testCustomPool();
	}
	
	//测试单线程的线程池
	private static void testSinglePool() {
		//创建只有一个线程的线程池
		ExecutorService pool = (ExecutorService) Executors.newSingleThreadExecutor();
		
		for (int i = 1; i <= 10; i++) {
			Operation operation = new Operation("单线程的线程池", i);
			//命令线程池执行该任务
			pool.execute(operation);
		}
		//关闭线程池
		pool.shutdown();
	}
	
	//测试固定数量的线程池
	private static void testFixedPool() {
		//创建线程数量为3的线程池
		ExecutorService pool = (ExecutorService) Executors.newFixedThreadPool(3);
		
		for (int i = 1; i <= 10; i++) {
			Operation operation = new Operation("单线程的线程池", i);
			//命令线程池执行该任务
			pool.execute(operation);
		}
		//关闭线程池
		pool.shutdown();
	}
	
	//测试无限数量的线程池
	private static void testUnlimitPool() {
		//创建不限制线程数量的线程池
		ExecutorService pool = (ExecutorService) Executors.newCachedThreadPool();
		
		for (int i = 1; i <= 10; i++) {
			Operation operation = new Operation("单线程的线程池", i);
			//命令线程池执行该任务
			pool.execute(operation);
		}
		//关闭线程池
		pool.shutdown();
	}
	
	//测试自定义的线程池
	private static void testCustomPool() {
		//创建自定义规格的线程池
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(19));
		
		for (int i = 1; i <= 10; i++) {
			Operation operation = new Operation("单线程的线程池", i);
			//命令线程池执行该任务
			pool.execute(operation);
		}
		//关闭线程池
		pool.shutdown();
	}
	
	
	private static class Operation implements Runnable {
		//任务名称
		private String name;
		//任务序号
		private int index;
		
		public Operation(String name, int index) {
			this.name = name;
			this.index = index;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			String desc = String.format("%s执行到了第%d个任务", name, index);
			
			PrintUtils.print(Thread.currentThread().getName(), desc);
		}
	};
	
	
}

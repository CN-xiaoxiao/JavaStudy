package com.xiaoxiao.concurrent.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
	public static void main(String[] args) {
		testCallInMain();
	}
	
	private static void testCallInMain() {
		//定义一个Callable代码块，返回100以内的随机整数
		//第一种方式：使用匿名内部类
		Callable<Integer> callable = new Callable<Integer>() {
			public Integer call() {
				int random = new Random().nextInt(100);
				PrintUtils.print(Thread.currentThread().getName(), "任务生成的随机数=" + random);
			
				return random;
			}
		};
		
		//使用lambda表达式
//		Callable<Integer> callable = () -> {
//			int random = new Random().nextInt(100);
//			PrintUtils.print(Thread.currentThread().getName(), "任务生成的随机数=" + random);
//					
//			return random;
//		};
		
		//
		//Callable<Integer> callable = () -> new Random().nextInt(100);
		
		//只有FutureTask才能真正跟踪任务的执行状态。
		//结果：
		// 2021/4/14 上午11:05 main 任务生成的随机数=93
		// 2021/4/14 上午11:05 main 主线程的执行结果=93
		
//		FutureTask<Integer> future = new FutureTask<Integer>(callable);
//		future.run();
//		
//		Integer result;
//		try {
//			result = future.get();
//			PrintUtils.print(Thread.currentThread().getName(), "主线程的执行结果=" + result);
//		} catch (InterruptedException | ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		FutureTask<Integer> future = new FutureTask<Integer>(callable);
		new Thread(future).start();
		
		try {
			Integer result = future.get();
			PrintUtils.print(Thread.currentThread().getName(), "主线程的执行结果=" + result);
			
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			//get方法会一直得到未来任务执行完成
			//由于等待期间可能中断信号，因此这里得捕获中断异常
			e.printStackTrace();
		}
		
		
	}
}

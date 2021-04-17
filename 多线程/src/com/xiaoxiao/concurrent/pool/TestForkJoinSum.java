package com.xiaoxiao.concurrent.pool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class TestForkJoinSum {
	public static void main(String[] args) {
//		testInternalTask();
		
		testPoolTask();
	}
	
	//测试任务自带的线程池框架
	private static void testInternalTask() {
		//下面初始化从0~99的整型数组
		int[] arr = new int[100];
		
		for (int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		
		//创建一个求和的递归任务
		SumTask task = new SumTask(arr, 0, arr.length);
		
		try {
			Integer result = task.invoke();
			System.out.println("最终计算结果: " + result);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//测试任务以外的线程池框架
	private static void testPoolTask() {
		//下面初始化从0~99的整型数组
		int[] arr = new int[100];
		
		for (int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		
		//创建一个求和的递归任务
		SumTask task = new SumTask(arr, 0, arr.length);
		
		//创建一个用于分而治之的线程池
		ForkJoinPool pool = new ForkJoinPool(6);
		
		//命令线程池执行求和任务，并返回存放执行结果的任务对象
		ForkJoinTask<Integer> taskResult = pool.submit(task);
		
		try {
			Integer result = taskResult.get();
			System.out.println("最终计算结果: " + result);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		pool.shutdown();
	}
}

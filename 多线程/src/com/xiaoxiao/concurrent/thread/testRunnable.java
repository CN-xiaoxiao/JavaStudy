package com.xiaoxiao.concurrent.thread;

public class testRunnable {
	public static void main(String[] args) {
		FactorialTask task = new FactorialTask();
		new Thread(task).start();
		

		//通过匿名内部类
		new Thread(new Runnable() {
			public void run() {
				int product = 1;
				
				for (int i = 1; i <= 10; i++) {
					product *= i;
				}
				
				PrintUtils.print(Thread.currentThread().getName(), "阶乘结果 = " + product);
			}
		}).start();
		
		//Lambda表达式
		new Thread(() -> {
			int product = 1;
			
			for (int i = 1; i <= 10; i++) {
				product *= i;
			}
			
			PrintUtils.print(Thread.currentThread().getName(), "阶乘结果 = " + product);
		}).start();
	}
	
	/**
	 * 
	 * 通过Runnable接口创建线程的第一种方式
	 */
	private static class FactorialTask implements Runnable {
		public void run() {
			int product = 1;
			
			for (int i = 1; i <= 10; i++) {
				product *= i;
			}
			
			PrintUtils.print(Thread.currentThread().getName(), "阶乘结果 = " + product);
		}
	}
}

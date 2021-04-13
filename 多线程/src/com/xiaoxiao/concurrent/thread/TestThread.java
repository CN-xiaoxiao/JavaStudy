package com.xiaoxiao.concurrent.thread;

public class TestThread extends Thread{
	
	public static void main(String[] args) {
//		CountThread thread = new CountThread();
//		thread.start();
		
//		testJoin();
		
//		testPriority();
		
//		testActiveCheck();
		
		testPassiveInterrupt();
	}

	/**
	 * 测试插队:
	 * 
	 * 	使用join进行插队操作不一定会成功，
	 *  只是告诉虚拟机，尽量让这个线程先执行。
	 */
	private static void testJoin() {
		CountThread thread1 = new CountThread();
		thread1.start();
		
		CountThread thread2 = new CountThread();
		thread2.start();
		
		try {

			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试线程的优先级：
	 * 
	 * 给线程设置优先级也是和插队差不多，优先级越高就是告诉系
	 * 统多优先执行这个线程，都是不一定都会去先执行这个线程。
	 * 线程设置的优先级的数字越大，优先级越高
	 */
	private static void testPriority() {
		CountThread thread1 = new CountThread();
		thread1.setPriority(1);
		thread1.start();
		
		CountThread thread2 = new CountThread();
		thread2.setPriority(9);
		thread2.start();
	}
	
	/**
	 * 
	 */
	private static void testActiveCheck() {
		//创建一个会自行检测运行标志的线程
		ActiveCheckThread thread = new ActiveCheckThread();
		thread.start();
		
		try {
			thread.sleep(70);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread.setCanRun(false);
	}
	
	/**
	 * 
	 */
	private static void testPassiveInterrupt() {
		PassiveInterruptThread thread = new PassiveInterruptThread();
		thread.start();
		
		try {
			thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread.interrupt();
	}
	
	/**
	 *
	 */
	private static class CountThread extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 100; i++) {
				PrintUtils.print(getName(), "当前计数值为：" + i);
			}
			
		}
	}
	
	/**
	 * 使用标志位来检测线程是否在运行
	 */
	private static class ActiveCheckThread extends Thread {
		//能否运行的标志
		private boolean canRun = true;
		
		//设置当前线程能否进行运行的标志
		public void setCanRun(boolean canRun) {
			this.canRun = canRun;
		}
		
		public void run() {
			for (int i = 0; i < 1000; i++) {
				PrintUtils.print(getName(), "当前计数值为：" + i);
				
				if (!canRun) {
					PrintUtils.print(getName(), "主动停止运行");
					
					break;
				}
			}
		}
	}
	
	/**
	 * Thread类提供了线程中断机制，所以我们只需要捕获中断异常
	 * InterruptedException即可，没有抛出，线程正常运行，抛出，
	 * 我们只需要对其进行妥善处理即可
	 */
	private static class PassiveInterruptThread extends Thread {
		public void run() {
			try {
				for (int i = 0; i < 1000; i++) {
					PrintUtils.print(getName(), "当前计数值为：" + i);
					Thread.sleep(10);
				}
			} catch (InterruptedException e){
				
				PrintUtils.print(getName(), "被中断运行了");
			}
			
		}
	}
}



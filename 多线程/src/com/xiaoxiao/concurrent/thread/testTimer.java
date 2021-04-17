package com.xiaoxiao.concurrent.thread;

import java.util.Timer;
import java.util.TimerTask;

public class testTimer {
	
	public static void main(String[] args) {
		testScheduleOnce();
	}
	
	/**
	 * 两个参数的schedule只调用了一次，而三个参数的schedule在一秒钟内调用了9次
	 * scheduleAtFixedRate在一秒内调用了10次
	 * 
	 * 可以看出schedule方法的下次启动时间与任务执行耗时有关，而scheduleAtFixedRate方法
	 * 与任务耗时无关。
	 */
	private static void testScheduleOnce() {
		//创建一个计数的定时任务
		CountTask timeTask = new CountTask();
		//创建一个定时器
		Timer timer = new Timer();
		
		//命令定时器启动定时任务
		//只调用了一次
		//timer.schedule(timeTask, 50);
		
		//timer.schedule(timeTask, 50, 100);
		
		timer.scheduleAtFixedRate(timeTask, 50, 100);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//取消定时器
		timer.cancel();
	}
	
	
	private static class CountTask extends TimerTask {
		//计数值
		private int count = 0;

		@Override
		public void run() {
			
			PrintUtils.print(Thread.currentThread().getName(), "当前计数值为：" + count);
			
			count++;
		}
	}
}

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
	
	//�����ӳ�һ�εĵ��̶߳�ʱ��
	private static void testSingleScheduleOnce() {
		//�����ӳ�һ�εĵ��̶߳�ʱ��
		ScheduledExecutorService pool = (ScheduledExecutorService) Executors.newSingleThreadScheduledExecutor();
		
		for (int i = 1; i <= 5; i++) {
			Visit visit = new Visit("�ӳ�һ�εĵ��̶߳�ʱ��", i);
			
			pool.schedule(visit, 1, TimeUnit.SECONDS);
		}
	}
	
	//���Թ̶����ʵĶ��̶߳�ʱ��
	private static void testMultiScheduleRate() {
		//�����̶����ʵĶ��̶߳�ʱ��
		ScheduledExecutorService pool = (ScheduledExecutorService) Executors.newScheduledThreadPool(3);
		
		for (int i = 1; i <= 5; i++) {
			Visit visit = new Visit("�̶����ʵĶ��̶߳�ʱ��", i);
			
			pool.scheduleAtFixedRate(visit, 1, 3, TimeUnit.SECONDS);
		}
	}
	
	//���Թ̶��ӳٵĶ��̶߳�ʱ��
	private static void testMultiScheduleDelay() {
		//�����̶��ӳٵĶ��̶߳�ʱ��
		ScheduledExecutorService pool = (ScheduledExecutorService) Executors.newScheduledThreadPool(3);
		
		for (int i = 1; i <= 5; i++) {
			Visit visit = new Visit("�̶��ӳٵĶ��̶߳�ʱ��", i);
			
			pool.scheduleWithFixedDelay(visit, 1, 3, TimeUnit.SECONDS);
		}
	}
	
	
	private static class Visit implements Runnable {
		//��������
		private String name;
		//�������
		private int index;
		
		public Visit(String name, int index) {
			this.name = name;
			this.index = index;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			String desc = String.format("%s�ĵ�%d�����񵽴�һ��", name, index);
			
			PrintUtils.print(Thread.currentThread().getName(), desc);
		
		}
	};
}

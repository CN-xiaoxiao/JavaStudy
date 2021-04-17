package com.xiaoxiao.concurrent.thread;

import java.util.Timer;
import java.util.TimerTask;

public class testTimer {
	
	public static void main(String[] args) {
		testScheduleOnce();
	}
	
	/**
	 * ����������scheduleֻ������һ�Σ�������������schedule��һ�����ڵ�����9��
	 * scheduleAtFixedRate��һ���ڵ�����10��
	 * 
	 * ���Կ���schedule�������´�����ʱ��������ִ�к�ʱ�йأ���scheduleAtFixedRate����
	 * �������ʱ�޹ء�
	 */
	private static void testScheduleOnce() {
		//����һ�������Ķ�ʱ����
		CountTask timeTask = new CountTask();
		//����һ����ʱ��
		Timer timer = new Timer();
		
		//���ʱ��������ʱ����
		//ֻ������һ��
		//timer.schedule(timeTask, 50);
		
		//timer.schedule(timeTask, 50, 100);
		
		timer.scheduleAtFixedRate(timeTask, 50, 100);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ȡ����ʱ��
		timer.cancel();
	}
	
	
	private static class CountTask extends TimerTask {
		//����ֵ
		private int count = 0;

		@Override
		public void run() {
			
			PrintUtils.print(Thread.currentThread().getName(), "��ǰ����ֵΪ��" + count);
			
			count++;
		}
	}
}

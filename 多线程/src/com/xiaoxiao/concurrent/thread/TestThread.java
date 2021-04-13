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
	 * ���Բ��:
	 * 
	 * 	ʹ��join���в�Ӳ�����һ����ɹ���
	 *  ֻ�Ǹ��������������������߳���ִ�С�
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
	 * �����̵߳����ȼ���
	 * 
	 * ���߳��������ȼ�Ҳ�ǺͲ�Ӳ�࣬���ȼ�Խ�߾��Ǹ���ϵ
	 * ͳ������ִ������̣߳����ǲ�һ������ȥ��ִ������̡߳�
	 * �߳����õ����ȼ�������Խ�����ȼ�Խ��
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
		//����һ�������м�����б�־���߳�
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
				PrintUtils.print(getName(), "��ǰ����ֵΪ��" + i);
			}
			
		}
	}
	
	/**
	 * ʹ�ñ�־λ������߳��Ƿ�������
	 */
	private static class ActiveCheckThread extends Thread {
		//�ܷ����еı�־
		private boolean canRun = true;
		
		//���õ�ǰ�߳��ܷ�������еı�־
		public void setCanRun(boolean canRun) {
			this.canRun = canRun;
		}
		
		public void run() {
			for (int i = 0; i < 1000; i++) {
				PrintUtils.print(getName(), "��ǰ����ֵΪ��" + i);
				
				if (!canRun) {
					PrintUtils.print(getName(), "����ֹͣ����");
					
					break;
				}
			}
		}
	}
	
	/**
	 * Thread���ṩ���߳��жϻ��ƣ���������ֻ��Ҫ�����ж��쳣
	 * InterruptedException���ɣ�û���׳����߳��������У��׳���
	 * ����ֻ��Ҫ����������ƴ�����
	 */
	private static class PassiveInterruptThread extends Thread {
		public void run() {
			try {
				for (int i = 0; i < 1000; i++) {
					PrintUtils.print(getName(), "��ǰ����ֵΪ��" + i);
					Thread.sleep(10);
				}
			} catch (InterruptedException e){
				
				PrintUtils.print(getName(), "���ж�������");
			}
			
		}
	}
}



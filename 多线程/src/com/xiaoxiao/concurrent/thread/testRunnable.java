package com.xiaoxiao.concurrent.thread;

public class testRunnable {
	public static void main(String[] args) {
		FactorialTask task = new FactorialTask();
		new Thread(task).start();
		

		//ͨ�������ڲ���
		new Thread(new Runnable() {
			public void run() {
				int product = 1;
				
				for (int i = 1; i <= 10; i++) {
					product *= i;
				}
				
				PrintUtils.print(Thread.currentThread().getName(), "�׳˽�� = " + product);
			}
		}).start();
		
		//Lambda���ʽ
		new Thread(() -> {
			int product = 1;
			
			for (int i = 1; i <= 10; i++) {
				product *= i;
			}
			
			PrintUtils.print(Thread.currentThread().getName(), "�׳˽�� = " + product);
		}).start();
	}
	
	/**
	 * 
	 * ͨ��Runnable�ӿڴ����̵߳ĵ�һ�ַ�ʽ
	 */
	private static class FactorialTask implements Runnable {
		public void run() {
			int product = 1;
			
			for (int i = 1; i <= 10; i++) {
				product *= i;
			}
			
			PrintUtils.print(Thread.currentThread().getName(), "�׳˽�� = " + product);
		}
	}
}

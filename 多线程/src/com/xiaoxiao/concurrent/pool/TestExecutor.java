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
	
	//���Ե��̵߳��̳߳�
	private static void testSinglePool() {
		//����ֻ��һ���̵߳��̳߳�
		ExecutorService pool = (ExecutorService) Executors.newSingleThreadExecutor();
		
		for (int i = 1; i <= 10; i++) {
			Operation operation = new Operation("���̵߳��̳߳�", i);
			//�����̳߳�ִ�и�����
			pool.execute(operation);
		}
		//�ر��̳߳�
		pool.shutdown();
	}
	
	//���Թ̶��������̳߳�
	private static void testFixedPool() {
		//�����߳�����Ϊ3���̳߳�
		ExecutorService pool = (ExecutorService) Executors.newFixedThreadPool(3);
		
		for (int i = 1; i <= 10; i++) {
			Operation operation = new Operation("���̵߳��̳߳�", i);
			//�����̳߳�ִ�и�����
			pool.execute(operation);
		}
		//�ر��̳߳�
		pool.shutdown();
	}
	
	//���������������̳߳�
	private static void testUnlimitPool() {
		//�����������߳��������̳߳�
		ExecutorService pool = (ExecutorService) Executors.newCachedThreadPool();
		
		for (int i = 1; i <= 10; i++) {
			Operation operation = new Operation("���̵߳��̳߳�", i);
			//�����̳߳�ִ�и�����
			pool.execute(operation);
		}
		//�ر��̳߳�
		pool.shutdown();
	}
	
	//�����Զ�����̳߳�
	private static void testCustomPool() {
		//�����Զ�������̳߳�
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(19));
		
		for (int i = 1; i <= 10; i++) {
			Operation operation = new Operation("���̵߳��̳߳�", i);
			//�����̳߳�ִ�и�����
			pool.execute(operation);
		}
		//�ر��̳߳�
		pool.shutdown();
	}
	
	
	private static class Operation implements Runnable {
		//��������
		private String name;
		//�������
		private int index;
		
		public Operation(String name, int index) {
			this.name = name;
			this.index = index;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			String desc = String.format("%sִ�е��˵�%d������", name, index);
			
			PrintUtils.print(Thread.currentThread().getName(), desc);
		}
	};
	
	
}

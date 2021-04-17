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
		//����һ��Callable����飬����100���ڵ��������
		//��һ�ַ�ʽ��ʹ�������ڲ���
		Callable<Integer> callable = new Callable<Integer>() {
			public Integer call() {
				int random = new Random().nextInt(100);
				PrintUtils.print(Thread.currentThread().getName(), "�������ɵ������=" + random);
			
				return random;
			}
		};
		
		//ʹ��lambda���ʽ
//		Callable<Integer> callable = () -> {
//			int random = new Random().nextInt(100);
//			PrintUtils.print(Thread.currentThread().getName(), "�������ɵ������=" + random);
//					
//			return random;
//		};
		
		//
		//Callable<Integer> callable = () -> new Random().nextInt(100);
		
		//ֻ��FutureTask�����������������ִ��״̬��
		//�����
		// 2021/4/14 ����11:05 main �������ɵ������=93
		// 2021/4/14 ����11:05 main ���̵߳�ִ�н��=93
		
//		FutureTask<Integer> future = new FutureTask<Integer>(callable);
//		future.run();
//		
//		Integer result;
//		try {
//			result = future.get();
//			PrintUtils.print(Thread.currentThread().getName(), "���̵߳�ִ�н��=" + result);
//		} catch (InterruptedException | ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		FutureTask<Integer> future = new FutureTask<Integer>(callable);
		new Thread(future).start();
		
		try {
			Integer result = future.get();
			PrintUtils.print(Thread.currentThread().getName(), "���̵߳�ִ�н��=" + result);
			
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			//get������һֱ�õ�δ������ִ�����
			//���ڵȴ��ڼ�����ж��źţ��������ò����ж��쳣
			e.printStackTrace();
		}
		
		
	}
}

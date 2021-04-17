package com.xiaoxiao.concurrent.pool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class TestForkJoinSum {
	public static void main(String[] args) {
//		testInternalTask();
		
		testPoolTask();
	}
	
	//���������Դ����̳߳ؿ��
	private static void testInternalTask() {
		//�����ʼ����0~99����������
		int[] arr = new int[100];
		
		for (int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		
		//����һ����͵ĵݹ�����
		SumTask task = new SumTask(arr, 0, arr.length);
		
		try {
			Integer result = task.invoke();
			System.out.println("���ռ�����: " + result);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//��������������̳߳ؿ��
	private static void testPoolTask() {
		//�����ʼ����0~99����������
		int[] arr = new int[100];
		
		for (int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		
		//����һ����͵ĵݹ�����
		SumTask task = new SumTask(arr, 0, arr.length);
		
		//����һ�����ڷֶ���֮���̳߳�
		ForkJoinPool pool = new ForkJoinPool(6);
		
		//�����̳߳�ִ��������񣬲����ش��ִ�н�����������
		ForkJoinTask<Integer> taskResult = pool.submit(task);
		
		try {
			Integer result = taskResult.get();
			System.out.println("���ռ�����: " + result);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		pool.shutdown();
	}
}

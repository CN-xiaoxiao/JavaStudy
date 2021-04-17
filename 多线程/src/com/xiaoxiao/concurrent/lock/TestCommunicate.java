package com.xiaoxiao.concurrent.lock;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import com.xiaoxiao.concurrent.thread.PrintUtils;

public class TestCommunicate {
	
	//����һ����������
	private final static ReentrantLock reentrantLock = new ReentrantLock();
	
	//��ȡ������������������
	private static Condition condition = reentrantLock.newCondition();
	
	//��Ա���ϰ�֮��ͨ��������ͨ��
	private static Integer salary = 5000;
	
	public static void main(String[] args) {
//		testWaitNotify();
		testCondition();
	}
	
	//����ͨ��Condition��������̼߳�ͨ��
	private static void testCondition() {
		//������Ա�Ĺ�������
		Runnable employee = new Runnable() {
			@Override
			public void run() {
				PrintUtils.print(Thread.currentThread().getName(), "���ŷ�����");
				
				//�Կ�����������
				reentrantLock.lock();
				
				try {
					//�����ڵȴ�����������ź�
					condition.await();
					PrintUtils.print(Thread.currentThread().getName(), "����Դ��");
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				reentrantLock.unlock();
			}
		};
		
		//���������Ĺ�������
		Runnable boss = new Runnable() {

			@Override
			public void run() {
				wait_a_moment();
				
				PrintUtils.print(Thread.currentThread().getName(), "��ʼ������");
				
				reentrantLock.lock();
				wait_a_moment();
				
				condition.signal();
				PrintUtils.print(Thread.currentThread().getName(), "���깤����");
				
				reentrantLock.unlock();
			}
		};
		
		new Thread(employee, "�������Ƶ�Ա��").start();
		new Thread(boss, "�������Ƶ��ϰ�").start();
	}
	
	//����ͨ��wait��notify���������̼߳�ͨ��
	private static void testWaitNotify() {
		//������Ա�Ĺ�������
		Runnable employee = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				PrintUtils.print(Thread.currentThread().getName(), "���ŷ�����");
				
				synchronized (salary) {
					//�ȴ�������
					try {
						salary.wait();
						PrintUtils.print(Thread.currentThread().getName(), "����Դ��");
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		};
		
		//���������Ĺ�������
		Runnable boss = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				wait_a_moment();
				PrintUtils.print(Thread.currentThread().getName(), "��ʼ������");
				
				synchronized (salary) {
					wait_a_moment();
					
					salary.notify();
					
					PrintUtils.print(Thread.currentThread().getName(), "���깤����");
				}
			}
			
		};
		
		new Thread(employee, "ͬ�����Ƶ�Ա��").start();
		new Thread(boss, "ͬ�����Ƶ��ϰ�").start();
	}
	
	//��΢��һ��
	public static void wait_a_moment() {
		//����500���ڵ��������
		int delay = new Random().nextInt(500);
		
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

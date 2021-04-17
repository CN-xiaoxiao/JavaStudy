package com.xiaoxiao.concurrent.lock;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import com.xiaoxiao.concurrent.thread.PrintUtils;

public class TestCommunicate {
	
	//创建一个可重入锁
	private final static ReentrantLock reentrantLock = new ReentrantLock();
	
	//获取可重入锁的条件对象
	private static Condition condition = reentrantLock.newCondition();
	
	//工员与老板之间通过工资条通信
	private static Integer salary = 5000;
	
	public static void main(String[] args) {
//		testWaitNotify();
		testCondition();
	}
	
	//测试通过Condition对象进行线程间通信
	private static void testCondition() {
		//创建雇员的工作任务
		Runnable employee = new Runnable() {
			@Override
			public void run() {
				PrintUtils.print(Thread.currentThread().getName(), "等着发工资");
				
				//对可重入锁加锁
				reentrantLock.lock();
				
				try {
					//这里在等待条件对象的信号
					condition.await();
					PrintUtils.print(Thread.currentThread().getName(), "今晚吃大餐");
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				reentrantLock.unlock();
			}
		};
		
		//创建雇主的工作任务
		Runnable boss = new Runnable() {

			@Override
			public void run() {
				wait_a_moment();
				
				PrintUtils.print(Thread.currentThread().getName(), "开始发工资");
				
				reentrantLock.lock();
				wait_a_moment();
				
				condition.signal();
				PrintUtils.print(Thread.currentThread().getName(), "发完工资了");
				
				reentrantLock.unlock();
			}
		};
		
		new Thread(employee, "加锁机制的员工").start();
		new Thread(boss, "加锁机制的老板").start();
	}
	
	//测试通过wait和notify方法进行线程间通信
	private static void testWaitNotify() {
		//创建雇员的工作任务
		Runnable employee = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				PrintUtils.print(Thread.currentThread().getName(), "等着发工资");
				
				synchronized (salary) {
					//等待发工资
					try {
						salary.wait();
						PrintUtils.print(Thread.currentThread().getName(), "今晚吃大餐");
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		};
		
		//创建雇主的工作任务
		Runnable boss = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				wait_a_moment();
				PrintUtils.print(Thread.currentThread().getName(), "开始发工资");
				
				synchronized (salary) {
					wait_a_moment();
					
					salary.notify();
					
					PrintUtils.print(Thread.currentThread().getName(), "发完工资了");
				}
			}
			
		};
		
		new Thread(employee, "同步机制的员工").start();
		new Thread(boss, "同步机制的老板").start();
	}
	
	//稍微等一下
	public static void wait_a_moment() {
		//生成500以内的随机整数
		int delay = new Random().nextInt(500);
		
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

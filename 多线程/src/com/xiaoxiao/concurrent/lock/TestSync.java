package com.xiaoxiao.concurrent.lock;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.xiaoxiao.concurrent.thread.PrintUtils;

public class TestSync {
	public static void main(String[] args) {
		//testConflict();
		
		testSyncMinMethod();
	}
	
	private static void testSyncMinMethod() {
		Runnable seller = new Runnable() {
			private Integer ticketCount = 100;
			
			@Override
			public void run() {
				while (ticketCount > 0) {
					int count = getDecreaseCount();
					
					String left = String.format("��ǰ��ƱΪ%d��", count);
					PrintUtils.print(Thread.currentThread().getName(), left);
					
				}
			}
			
			private synchronized int getDecreaseCount() {
				return --ticketCount;
			}

		};
		
		new Thread(seller, "��Ʊ�߳�A").start();
		new Thread(seller, "��Ʊ�߳�B").start();
		new Thread(seller, "��Ʊ�߳�C").start();
	}
	
	private static void testConflict() {
		Runnable seller = new Runnable() {
			private Integer ticketCount = 100;
			
//			@Override
//			public void run() {
//				
//				while (ticketCount > 0) {
//					ticketCount--;
//					
//					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
//					String dateTime = sdf.format(new Date());
//					String desc = String.format("%s %s ��ǰ��ƱΪ%d��", dateTime, Thread.currentThread().getName(), ticketCount);
//					
//					System.out.println(desc);
//				}
//			}
			
			//ָ������run����Ϊͬ������������ͬһʱ��ֻ����һ���߳�ִ�и÷���
			//����ֻ���߳�A��ִ�У�������Ϊsynchronized�ܵķ�Χ̫���ˣ�������run����������
			//����߳�Aû��ִ���꣬�߳�B���߳�C��һֱ�ڵȴ�
//			@Override
//			public synchronized void run() {
//				while (ticketCount > 0) {
//					ticketCount--;
//					
//					String left = String.format("��ǰ��ƱΪ%d��", ticketCount);
//					PrintUtils.print(Thread.currentThread().getName(), left);
//				}
//			}
			
			@Override
			public void run() {
				while (ticketCount > 0) {
					int count;
					//�ھֲ���������
					synchronized (this) {
						count = --ticketCount;
					}
					
					String left = String.format("��ǰ��ƱΪ%d��", ticketCount);
					PrintUtils.print(Thread.currentThread().getName(), left);
				}
			}
			
		};
		
		new Thread(seller, "��Ʊ�߳�A").start();
		new Thread(seller, "��Ʊ�߳�B").start();
		new Thread(seller, "��Ʊ�߳�C").start();
	}
}

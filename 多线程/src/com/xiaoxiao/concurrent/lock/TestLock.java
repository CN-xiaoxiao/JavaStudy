package com.xiaoxiao.concurrent.lock;

import java.io.FileOutputStream;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import com.xiaoxiao.concurrent.thread.PrintUtils;

public class TestLock {
	
	private static String mFileName = "../aae.txt";
	
	public static void main(String[] args) {
		testReadWriteLock();
	}
	
	
//	private final static ReentrantLock reentrantLock = new ReentrantLock();
//	
//	public static void main(String[] args) {
//		testReentrantLock();
//	}
//	
//	private static void testReentrantLock() {
//		Runnable seller = new Runnable() {
//			private Integer ticketCount = 100;
//			
//			public void run() {
//				while (ticketCount > 0) {
//					//�Կ�����������
//					reentrantLock.lock();
//					int count = --ticketCount;
//					//�Կ�����������
//					reentrantLock.unlock();
//					
//					String left = String.format("��ǰ��ƱΪ%d��", count);
//					PrintUtils.print(Thread.currentThread().getName(), left);
//					
//				}
//			}
//		};
//		
//		new Thread(seller, "��Ʊ�߳�A").start();
//		new Thread(seller, "��Ʊ�߳�B").start();
//		new Thread(seller, "��Ʊ�߳�C").start();
//	}
	
	private final static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	//��ȡ��д���е�д��
	private final static WriteLock writeLock = readWriteLock.writeLock();
	
	//��ȡ��д���еĶ���
	private final static ReadLock readLock = readWriteLock.readLock();
	
	//����ͨ����д��������Դ��ͻ
	private static void testReadWriteLock() {
		
		Runnable seller = new Runnable() {
			
			private Integer ticketCount = 100;
			
			public void run() {
				while (ticketCount > 0) {
					int count = 0;
					
					try (FileOutputStream fos = new FileOutputStream(mFileName)) {
						//�Զ������������˶���֮�������߳̿��Լ����Ӷ����������ܼ�д��
						readLock.lock();
						
						if (ticketCount <= 0) {
							//�ر��ļ�
							fos.close();
							
							//�Զ�������
							readLock.unlock();
							
							break;
						}
						//�Զ�������
						readLock.unlock();
						
						//��д��������һ������д�����������߳��ڴ˼Ȳ��ܶ��ֲ���д
						writeLock.lock();
						
						count = --ticketCount;
						
						//��д������
						writeLock.unlock();
						
						//���ֽ�����д���ļ������
						fos.write(new String("" + count).getBytes());
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					String left = String.format("��ǰ��ƱΪ%d��", count);
					PrintUtils.print(Thread.currentThread().getName(), left);
					
				}
			}
		};
		
		new Thread(seller, "��Ʊ�߳�A").start();
		new Thread(seller, "��Ʊ�߳�B").start();
		new Thread(seller, "��Ʊ�߳�C").start();
	}
	
}

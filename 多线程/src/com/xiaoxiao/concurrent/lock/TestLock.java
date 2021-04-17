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
//					//对可重入锁加锁
//					reentrantLock.lock();
//					int count = --ticketCount;
//					//对可重入锁解锁
//					reentrantLock.unlock();
//					
//					String left = String.format("当前余票为%d张", count);
//					PrintUtils.print(Thread.currentThread().getName(), left);
//					
//				}
//			}
//		};
//		
//		new Thread(seller, "售票线程A").start();
//		new Thread(seller, "售票线程B").start();
//		new Thread(seller, "售票线程C").start();
//	}
	
	private final static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	//获取读写锁中的写锁
	private final static WriteLock writeLock = readWriteLock.writeLock();
	
	//获取读写锁中的读锁
	private final static ReadLock readLock = readWriteLock.readLock();
	
	//测试通过读写锁避免资源冲突
	private static void testReadWriteLock() {
		
		Runnable seller = new Runnable() {
			
			private Integer ticketCount = 100;
			
			public void run() {
				while (ticketCount > 0) {
					int count = 0;
					
					try (FileOutputStream fos = new FileOutputStream(mFileName)) {
						//对读锁加锁。加了读锁之后，其他线程可以继续加读锁，但不能加写锁
						readLock.lock();
						
						if (ticketCount <= 0) {
							//关闭文件
							fos.close();
							
							//对读锁解锁
							readLock.unlock();
							
							break;
						}
						//对读锁解锁
						readLock.unlock();
						
						//对写锁加锁。一旦加了写锁，则其他线程在此既不能读又不能写
						writeLock.lock();
						
						count = --ticketCount;
						
						//对写锁解锁
						writeLock.unlock();
						
						//把字节数组写入文件输出流
						fos.write(new String("" + count).getBytes());
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					String left = String.format("当前余票为%d张", count);
					PrintUtils.print(Thread.currentThread().getName(), left);
					
				}
			}
		};
		
		new Thread(seller, "售票线程A").start();
		new Thread(seller, "售票线程B").start();
		new Thread(seller, "售票线程C").start();
	}
	
}

package com.xiaoxiao.concurrent.lock;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import com.xiaoxiao.concurrent.thread.PrintUtils;

public class BuyTicket implements Runnable {
	//极有耐心
	public final static int FULL_PAITIENCE = 1;
	//有些耐心
	public final static int SOME_PAITIENCE = 2;
	//缺少耐心
	public final static int LACK_PAITIENCE = 3;
	//接受中断
	public final static int ACCEPT_INTERRUPT = 4;
	//信号量
	private Semaphore semaphore;
	//用户类型
	private int person_type;
	
	public BuyTicket(Semaphore semaphorem , int person_type) {
		this.semaphore = semaphorem;
		this.person_type = person_type;
	}
	
	@Override
	public void run() {
		if (person_type == FULL_PAITIENCE) {
			//尝试向信号源申请许可证，并且不接受中断
			//如果信号源无空闲许可证，那么愿意继续等待直到获得许可证
			semaphore.acquireUninterruptibly();
			
			wait_a_moment();
			PrintUtils.print(Thread.currentThread().getName(), "买到票了");
			
			//释放信号源资源
			semaphore.release();
			
		} else if (person_type == SOME_PAITIENCE) {
			try {
				//尝试向信号源申请许可证，但只愿意等待80毫秒
				//如果在规定时间内获得许可证就返回true，否则就返回false
				boolean result = semaphore.tryAcquire(80, TimeUnit.MILLISECONDS);
				
				//如果已获得许可证
				if (result) {
					wait_a_moment();
					
					PrintUtils.print(Thread.currentThread().getName(), "买到票了");
				} else {
					PrintUtils.print(Thread.currentThread().getName(), "等太久，不买票了");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				semaphore.release();
			}
			
		} else if (person_type == LACK_PAITIENCE) {
			//尝试向信号源立即申请许可证，哪怕一毫秒都不等待
			//获得许可证就返回true，否则就返回false
			boolean result = semaphore.tryAcquire();
			
			if (result) {
				wait_a_moment();
				PrintUtils.print(Thread.currentThread().getName(), "买到票了");
			} else {
				PrintUtils.print(Thread.currentThread().getName(), "一会都不想等，不买票了");
			}
			
			semaphore.release();
		} else if (person_type == ACCEPT_INTERRUPT) {
			//尝试向信号源申请许可证，并且接受中断
			//如果信号源无空闲许可证，那么愿意继续等待，但收到中断信号除外
			try {
				semaphore.acquire();
				wait_a_moment();
				PrintUtils.print(Thread.currentThread().getName(), "买到票了");
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				PrintUtils.print(Thread.currentThread().getName(), "约到顺风车，不买票了");
			} finally {
				semaphore.release();
			}
			
		}
	}
	
	//稍微等一下，模拟窗口买票的时间消耗
	public static void wait_a_moment() {
		//生成100以内的随机整数
		int delay = new Random().nextInt(100);
		
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

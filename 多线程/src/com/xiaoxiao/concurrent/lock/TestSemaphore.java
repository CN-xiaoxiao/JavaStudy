package com.xiaoxiao.concurrent.lock;

import java.util.concurrent.Semaphore;

public class TestSemaphore {
	public static void main(String[] args) {
		testManyTask();
	}
	
	private static void testManyTask() {
		//创建拥有3个许可证的信号源
		Semaphore semaphore = new Semaphore(3);
		
		//一定要买到车票
		BuyTicket alwaysBuy = new BuyTicket(semaphore, BuyTicket.FULL_PAITIENCE);
		
		//为了买车票愿意排队一会儿，但要是等太久，就放弃买票
		BuyTicket awhileBuy = new BuyTicket(semaphore, BuyTicket.SOME_PAITIENCE);
		
		//需要立即买到票，否则马上离开
		BuyTicket immediateBuy = new BuyTicket(semaphore, BuyTicket.LACK_PAITIENCE);
		
		//先排队看看，如果有其他途径可以回家，就不用买票了
		BuyTicket caseBuy = new BuyTicket(semaphore, BuyTicket.ACCEPT_INTERRUPT);
		
		Thread[] caseThread = new Thread[5];
		
		for (int i = 0; i < 20; i++) {
			if (i % 4 == 0) {
				new Thread(alwaysBuy, "一定要买到车票的旅客").start();
				
			} else if (i % 4 == 1) {
				new Thread(awhileBuy, "愿意排一会儿队的旅客").start();
				
			} else if (i % 4 == 2) {
				new Thread(immediateBuy, "需要立即买到票的旅客").start();
				
			} else if (i % 4 == 3) {
				//创建一个接受中断的排队买票线程
				caseThread[i/4] = new Thread(caseBuy, "一边排队一边约顺风车的旅客");
				caseThread[i/4].start();
			}
		}
		
		BuyTicket.wait_a_moment();
		
		for (Thread thread : caseThread) {
			thread.interrupt();
		}
	}
}

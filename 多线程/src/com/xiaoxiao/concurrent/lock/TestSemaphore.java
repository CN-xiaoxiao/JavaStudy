package com.xiaoxiao.concurrent.lock;

import java.util.concurrent.Semaphore;

public class TestSemaphore {
	public static void main(String[] args) {
		testManyTask();
	}
	
	private static void testManyTask() {
		//����ӵ��3�����֤���ź�Դ
		Semaphore semaphore = new Semaphore(3);
		
		//һ��Ҫ�򵽳�Ʊ
		BuyTicket alwaysBuy = new BuyTicket(semaphore, BuyTicket.FULL_PAITIENCE);
		
		//Ϊ����ƱԸ���Ŷ�һ�������Ҫ�ǵ�̫�ã��ͷ�����Ʊ
		BuyTicket awhileBuy = new BuyTicket(semaphore, BuyTicket.SOME_PAITIENCE);
		
		//��Ҫ������Ʊ�����������뿪
		BuyTicket immediateBuy = new BuyTicket(semaphore, BuyTicket.LACK_PAITIENCE);
		
		//���Ŷӿ��������������;�����Իؼң��Ͳ�����Ʊ��
		BuyTicket caseBuy = new BuyTicket(semaphore, BuyTicket.ACCEPT_INTERRUPT);
		
		Thread[] caseThread = new Thread[5];
		
		for (int i = 0; i < 20; i++) {
			if (i % 4 == 0) {
				new Thread(alwaysBuy, "һ��Ҫ�򵽳�Ʊ���ÿ�").start();
				
			} else if (i % 4 == 1) {
				new Thread(awhileBuy, "Ը����һ����ӵ��ÿ�").start();
				
			} else if (i % 4 == 2) {
				new Thread(immediateBuy, "��Ҫ������Ʊ���ÿ�").start();
				
			} else if (i % 4 == 3) {
				//����һ�������жϵ��Ŷ���Ʊ�߳�
				caseThread[i/4] = new Thread(caseBuy, "һ���Ŷ�һ��Լ˳�糵���ÿ�");
				caseThread[i/4].start();
			}
		}
		
		BuyTicket.wait_a_moment();
		
		for (Thread thread : caseThread) {
			thread.interrupt();
		}
	}
}

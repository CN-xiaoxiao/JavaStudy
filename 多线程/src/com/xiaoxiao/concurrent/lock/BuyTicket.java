package com.xiaoxiao.concurrent.lock;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import com.xiaoxiao.concurrent.thread.PrintUtils;

public class BuyTicket implements Runnable {
	//��������
	public final static int FULL_PAITIENCE = 1;
	//��Щ����
	public final static int SOME_PAITIENCE = 2;
	//ȱ������
	public final static int LACK_PAITIENCE = 3;
	//�����ж�
	public final static int ACCEPT_INTERRUPT = 4;
	//�ź���
	private Semaphore semaphore;
	//�û�����
	private int person_type;
	
	public BuyTicket(Semaphore semaphorem , int person_type) {
		this.semaphore = semaphorem;
		this.person_type = person_type;
	}
	
	@Override
	public void run() {
		if (person_type == FULL_PAITIENCE) {
			//�������ź�Դ�������֤�����Ҳ������ж�
			//����ź�Դ�޿������֤����ôԸ������ȴ�ֱ��������֤
			semaphore.acquireUninterruptibly();
			
			wait_a_moment();
			PrintUtils.print(Thread.currentThread().getName(), "��Ʊ��");
			
			//�ͷ��ź�Դ��Դ
			semaphore.release();
			
		} else if (person_type == SOME_PAITIENCE) {
			try {
				//�������ź�Դ�������֤����ֻԸ��ȴ�80����
				//����ڹ涨ʱ���ڻ�����֤�ͷ���true������ͷ���false
				boolean result = semaphore.tryAcquire(80, TimeUnit.MILLISECONDS);
				
				//����ѻ�����֤
				if (result) {
					wait_a_moment();
					
					PrintUtils.print(Thread.currentThread().getName(), "��Ʊ��");
				} else {
					PrintUtils.print(Thread.currentThread().getName(), "��̫�ã�����Ʊ��");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				semaphore.release();
			}
			
		} else if (person_type == LACK_PAITIENCE) {
			//�������ź�Դ�����������֤������һ���붼���ȴ�
			//������֤�ͷ���true������ͷ���false
			boolean result = semaphore.tryAcquire();
			
			if (result) {
				wait_a_moment();
				PrintUtils.print(Thread.currentThread().getName(), "��Ʊ��");
			} else {
				PrintUtils.print(Thread.currentThread().getName(), "һ�ᶼ����ȣ�����Ʊ��");
			}
			
			semaphore.release();
		} else if (person_type == ACCEPT_INTERRUPT) {
			//�������ź�Դ�������֤�����ҽ����ж�
			//����ź�Դ�޿������֤����ôԸ������ȴ������յ��ж��źų���
			try {
				semaphore.acquire();
				wait_a_moment();
				PrintUtils.print(Thread.currentThread().getName(), "��Ʊ��");
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				PrintUtils.print(Thread.currentThread().getName(), "Լ��˳�糵������Ʊ��");
			} finally {
				semaphore.release();
			}
			
		}
	}
	
	//��΢��һ�£�ģ�ⴰ����Ʊ��ʱ������
	public static void wait_a_moment() {
		//����100���ڵ��������
		int delay = new Random().nextInt(100);
		
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

package com.xiaoxiao.concurrent.pool;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer> {
	private static final long serialVersionUID = 1L;
	private static final int THRESHOLD = 20;
	private int src[];
	private int start;
	private int end;
	
	public SumTask(int[] src, int start, int end) {
		this.src = src;
		this.start = start;
		this.end = end;
	}

	//对指定区间的数组元素求和
	private Integer subTotal() {
		Integer sum = 0;
		
		for (int i = start; i < end; i++) {
			sum += src[i];
		}
		
		String desc = String.format("%s 求和结果(%d到%d)=%d", Thread.currentThread().getName(), start, end, sum);
		
		System.out.println(desc);
		
		return sum;
	}
	
	@Override
	protected Integer compute() {
		if ((end - start) <= THRESHOLD) {
			return subTotal();
		} else {
			int middle = (start + end) / 2;
			SumTask left = new SumTask(src, start, middle);
			left.fork();
			
			SumTask right = new SumTask(src, middle, end);
			right.fork();
			
			int sum = left.join() + right.join();
			
			String desc = String.format("%s 求和结果(%d到%d)=%d", Thread.currentThread().getName(), start, end, sum);
			
			System.out.println(desc);
			
			return sum;
		}
	}
}

package com.xiaoxiao.concurrent.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintUtils {
	public static void print(String threadName, String event) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		String dateTime = sdf.format(new Date());
		String desc = String.format("%s %s %s", dateTime, threadName, event);
		
		System.out.println(desc);
	}
}

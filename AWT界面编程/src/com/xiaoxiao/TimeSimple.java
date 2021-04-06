package com.xiaoxiao;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeSimple {
	public static void main(String[] args) {
		//创建一个窗口对象
		final Frame frame = new Frame("测试窗口");
		
		//创建面板对象
		Panel panel = new Panel();
		
		//创建一个按钮
		Button button = new Button("点我");
		
		//设置窗口的大小
		frame.setSize(400,200);
		
		//设置窗口的相对位置
		//将窗口居中
		frame.setLocationRelativeTo(null);
		
		//设置窗口背景色
		frame.setBackground(Color.GREEN);
		
		//将窗口可视化
		frame.setVisible(true);
		
		//为窗口注册监听器
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		
		button.setPreferredSize(new Dimension(200,30));
		
		//为按钮注册监听器
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				button.setLabel(getNowTime() + "单机了按钮");
			}

			private String getNowTime() {
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				
				return sdf.format(new Date());
			}
			
		});
		//在面板上添加按钮
		panel.add(button);
		
		//在窗口上添加面板
		frame.add(panel);	
		
	}
}

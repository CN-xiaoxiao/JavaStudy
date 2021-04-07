package com.xiaoxiao.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestSwing {
	public static void main(String[] args) {
		//创建一个窗口对象
		JFrame frame = new JFrame("测试窗口");
		//点击叉叉退出程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		
		//JFrame 的setBackground方法不起作用，只能在面板中设置
		//frame.setBackground(Color.GREEN);
		
		//创建一个面板
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		
		//创建一个按钮
		JButton button = new JButton("点我!");
		//设置按钮的推荐行高
		button.setPreferredSize(new Dimension(200,30));
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				button.setText(getNowTime() + "单击了按钮");
			}
			
		});
		
		button.setFont(new Font("中号", Font.PLAIN, 16));
		
		panel.add(button);
		
		frame.add(panel);
		//可视化
		frame.setVisible(true);
	}
	
	// 获取当前的时间字符串
	public static String getNowTime() {
		// 创建一个日期格式化的工具
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		// 将当前时间按照指定格式输出格式化后的时间字符串
		return sdf.format(new Date());
	}
}

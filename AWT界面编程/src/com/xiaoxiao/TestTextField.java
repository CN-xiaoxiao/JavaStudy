package com.xiaoxiao;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestTextField {
	public static void main(String[] args) {
		Frame frame = new Frame("文本标签");
		
		frame.setSize(500,100);
		
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		//为窗口注册监听器
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		
		Panel panelCenter = new Panel();
		
		//创建一个单行输入框
		TextField field = new TextField();
		
//		//设置输入框的长度为11个字符
//		field.setColumns(11);
//		
//		//设置输入框允许编辑
//		field.setEditable(true);
		
		//
		field.setColumns(6);
		field.setEchoChar('*');
		field.setEditable(true);
		
		panelCenter.add(field);
		
		frame.add(panelCenter);
		//可视化
		frame.setVisible(true);
	}
}

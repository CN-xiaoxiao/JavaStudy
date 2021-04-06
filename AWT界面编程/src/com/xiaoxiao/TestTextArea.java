package com.xiaoxiao;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestTextArea {
	public static void main(String[] args) {
		Frame frame = new Frame("多行文本框");
		frame.setSize(500, 200);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		//为窗口注册监听器
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		
		Panel panel = new Panel();
		
		Label lable = new Label("请输入评价内容");
		panel.add(lable);
		
		TextArea area = new TextArea();
		
		//设置是否可编辑
		area.setEditable(true);
		
		//设置输入框的长度为20个字符
		area.setColumns(20);
		
		//设置输入框的高度为3个字符
		area.setRows(3);
		
		panel.add(area);
		
		frame.add(panel);
		frame.setVisible(true);
	}
}

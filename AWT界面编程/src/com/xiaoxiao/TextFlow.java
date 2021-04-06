package com.xiaoxiao;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextFlow {
	public static void main(String[] args) {
		Frame frame = new Frame("啦啦啦");
		
		Panel panel = new Panel();
		
		//流式布局
//		FlowLayout layout = new FlowLayout();
//		
//		layout.setAlignment(FlowLayout.LEFT);
//		
//		panel.setLayout(layout);
		
		//网格布局
//		GridLayout layout = new GridLayout(5,1); //创建一个网格布局5行1列
//		layout.setRows(5);
//		layout.setColumns(1);
//		panel.setLayout(layout);
		
		//边界布局
		panel.setLayout(new BorderLayout());
		panel.add(new Button("东边的按钮"), BorderLayout.EAST);
		panel.add(new Button("西边的按钮"), BorderLayout.WEST);
		panel.add(new Button("北边的按钮"), BorderLayout.NORTH);
		panel.add(new Button("南边的按钮"), BorderLayout.SOUTH);
		panel.add(new Button("中间的按钮"), BorderLayout.CENTER);
		
		frame.setSize(400,120);
		
//		panel.add(new Button("第一个按钮"));
//		panel.add(new Button("第二个按钮"));
//		panel.add(new Button("第三个按钮"));
//		panel.add(new Button("第四个按钮"));
//		panel.add(new Button("第五个按钮"));
		
		frame.add(panel);
		
		frame.setVisible(true);
		
		//为窗口注册监听器
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
	}
}

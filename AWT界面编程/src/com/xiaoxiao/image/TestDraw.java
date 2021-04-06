package com.xiaoxiao.image;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestDraw {
	private static DrawView draw = new DrawView();
	
	public static void main(String[] args) {
		Frame frame = new Frame("绘制图形");
		frame.setSize(600,300);
		frame.setLayout(new BorderLayout());
		
		//为窗口注册监听器
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		
		Panel panelTop = new Panel();
		
		panelTop.add(getButton("绘制直线", DrawView.LINE));
		panelTop.add(getButton("画矩形", DrawView.RECT));
		panelTop.add(getButton("画圆角矩形", DrawView.ROUND_RECT));
		panelTop.add(getButton("画椭圆", DrawView.OVAL));
		panelTop.add(getButton("画圆弧", DrawView.ARC));
		panelTop.add(getButton("写汉字", DrawView.TEXT));
		
		Panel panelCenter = new Panel();
		
		frame.add(panelTop, BorderLayout.NORTH);
		draw.setSize(400, 180);
		panelCenter.add(draw);
		frame.add(panelCenter, BorderLayout.CENTER);
		
		Panel panelButton = new Panel();
		Checkbox ck1 = new Checkbox("绘图时填充区域内部");
		ck1.setFont(new Font("", Font.PLAIN, 16));
		ck1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				draw.setFilled(e.getStateChange() == 1 ? true : false);
			}
			
		});
		panelButton.add(ck1);
		frame.add(panelButton, BorderLayout.SOUTH);
		frame.setVisible(true);
	}
	
	//获取指定名称与绘图类型的按钮
	private static Button getButton(String text, int draw_type) {
		Button button = new Button(text);
		button.setFont(new Font("", Font.PLAIN, 16));
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				draw.setDrawType(draw_type);
			}
			
		});
		
		return button;
	}
}

package com.xiaoxiao;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextLabel {
	public static void main(String[] args) {
		Frame frame = new Frame("Label使用");
		
		frame.setSize(600,400);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		//创建一个文本标签
		Label label = new Label("这里查看文字效果");
		
		//设置文本标签的对齐方式
		label.setAlignment(Label.CENTER);
		
		//设置文本标签的推荐行高
		label.setPreferredSize(new Dimension(300, 50));
		
		//
		Panel panelCenter = new Panel();
		
		panelCenter.add(label);
		
		//创建顶部面板
		Panel panelTop = new Panel();
		
		//创建按钮
		Button btn1 = new Button("背景黄色");
		Button btn2 = new Button("前景红色");
		Button btn3 = new Button("背景紫色");
		Button btn4 = new Button("大号斜体");
		Button btn5 = new Button("中号粗体");
		Button btn6 = new Button("恢复原状");
		
		btn1.setFont(new Font("",Font.PLAIN, 16));
		btn1.setForeground(Color.YELLOW);
		btn1.setBackground(Color.BLACK);
		
		btn2.setFont(new Font("",Font.PLAIN, 16));
		btn3.setFont(new Font("",Font.PLAIN, 16));
		btn4.setFont(new Font("",Font.PLAIN, 16));
		btn5.setFont(new Font("",Font.PLAIN, 16));
		btn6.setFont(new Font("",Font.PLAIN, 16));
		
		//给按钮注册单机监听器
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setBackground(Color.YELLOW);
				
			}
			
		});
		
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setForeground(Color.RED);
				
			}
			
		});
		
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Color purple = getColor(255,0,255);
				
				label.setBackground(purple);
				
			}
			
		});
		
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Font italic_big = new Font("大号斜体", Font.ITALIC, 30);
				
				label.setFont(italic_big);
				
			}
			
		});
		
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Font italic_middle = new Font("中号粗体", Font.BOLD, 20);
				
				label.setFont(italic_middle);
				
			}
			
		});
		
		btn6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				label.setBackground(Color.WHITE); // 设置文本标签的背景颜色
				label.setForeground(Color.BLACK); // 设置文本标签的前景颜色
				label.setFont(new Font(null, Font.PLAIN, 12)); // 设置文本标签的字体及颜色
				
			}
			
		});
		
		//在顶部面板上添加按钮
		panelTop.add(btn1);
		panelTop.add(btn2);
		panelTop.add(btn3);
		panelTop.add(btn4);
		panelTop.add(btn5);
		panelTop.add(btn6);

		frame.add(panelCenter, BorderLayout.CENTER);
		
		frame.add(panelTop, BorderLayout.NORTH);
		
		//窗口可视化
		frame.setVisible(true);
		
		//为窗口注册监听器
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
	}
	
	//使用RGB数值获得AWT的元素实例
	public static Color getColor(int red, int green, int blue) {
		float[] hsbs = Color.RGBtoHSB(red, green, blue, null);
		
		Color color = Color.getHSBColor(hsbs[0], hsbs[1], hsbs[2]);
		
		return color;
	}
}

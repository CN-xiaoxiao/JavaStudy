package com.xiaoxiao.widget;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TestRadioButton {
	public static void main(String[] args) {
		JFrame famel = new JFrame("单选框测试");
		famel.setSize(400, 130);
		famel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		famel.setLocationRelativeTo(null);
		famel.setLayout(new BorderLayout());
		
		
		JLabel label = new JLabel("这里查看选择按钮的窗口");
		Font font = new Font("", Font.PLAIN, 16);
		
		//创建中央面板
		JPanel panelCenter = new JPanel();
		panelCenter.add(label);
		
		famel.add(panelCenter, BorderLayout.CENTER);
		
		//创建顶部面板
		JPanel panelTop = new JPanel();
		
		//false表示默认没有选择，若为true则为默认选择
		JRadioButton rb1 = new JRadioButton("烧仙草", false);
		rb1.setFont(font);
		JRadioButton rb2 = new JRadioButton("双皮奶", true);
		rb2.setFont(font);
		JRadioButton rb3 = new JRadioButton("卫龙", false);
		rb3.setFont(font);
		
		panelTop.add(rb1);
		panelTop.add(rb2);
		panelTop.add(rb3);
		
		//创建单选框小组
		ButtonGroup group = new ButtonGroup();
		group.add(rb1);
		group.add(rb2);
		group.add(rb3);
		
		rb1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				label.setText("您点了" + rb1.getText());
			}
			
		});
		
		rb2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				label.setText("您点了" + rb2.getText());
			}
			
		});
		
		rb3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				label.setText("您点了" + rb3.getText());
			}
			
		});
		
		famel.add(panelTop, BorderLayout.NORTH);
		famel.setVisible(true);
	}
}

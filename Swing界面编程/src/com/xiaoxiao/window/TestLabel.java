package com.xiaoxiao.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class TestLabel {
	public static void main(String[] args) {
		JFrame frame = new JFrame("测试文本标签");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,400);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		//创建中央面板
		JPanel panelCenter = new JPanel();
		
		//字体
		Font fontMiddle = new Font("中号", Font.PLAIN, 16);
		
		//
		JLabel label = new JLabel();
		label.setPreferredSize(new Dimension(350,100));
		label.setFont(new Font("楷体", Font.PLAIN, 25));
		
		//\n没有作用！！！
		label.setText("床前明月光，疑是地上霜。\n举头望明月，低头思故乡");
		
		//设置标签文字在水平方向上对齐
		label.setHorizontalAlignment(JLabel.LEFT);
		
		//设置标签文字在垂直方向上对齐
		label.setVerticalAlignment(JLabel.CENTER);
		
		//设置标签为不透明
		label.setOpaque(true);
		
		label.setBackground(Color.WHITE);
		
		panelCenter.add(label);
		
		frame.add(panelCenter, BorderLayout.CENTER);
		
		JPanel JPanelTop = new JPanel();
		
		//不换行
		JButton btn1 = new JButton("不换行");
		btn1.setFont(fontMiddle);
		
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//\n没有作用！！！
				label.setText("床前明月光，疑是地上霜。\n举头望明月，低头思故乡");
			}
			
		});
		JPanelTop.add(btn1);
		
		//自动换行
		JButton btn2 = new JButton("自动换行");
		btn2.setFont(fontMiddle);
		
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				label.setText("<html>床前明月光，疑是地上霜。举头望明月，低头思故乡</html>");
			}
			
		});
		JPanelTop.add(btn2);
		
		//手动换行
		JButton btn3 = new JButton("手动换行");
		btn3.setFont(fontMiddle);
		
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				label.setText("<html>床前明月光，疑是地上霜。<br>举头望明月，低头思故乡</html>");
			}
			
		});
		JPanelTop.add(btn3);
		
		//多彩文字
		JButton btn4 = new JButton("多彩文字");
		btn4.setFont(fontMiddle);
				
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				label.setText("<html><font color='red'>床前明月光，</font><b>疑是地上霜。</b><br>"
						+ "<font color='yellow'>举头望明月，</font><i>低头思故乡</i></html>");
			}
					
		});
		JPanelTop.add(btn4);
				
		frame.add(JPanelTop, BorderLayout.NORTH);
		frame.setVisible(true);
		
	}
}

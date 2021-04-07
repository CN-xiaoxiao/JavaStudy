package com.xiaoxiao.window;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestImage {
	public static void main(String[] args) throws MalformedURLException {
		JFrame frame = new JFrame("Swing图像测试");
		frame.setSize(500, 400);
		
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//创建中央面板
		JPanel JPanelCenter = new JPanel();
		
		//字体
		Font fontMiddle = new Font("中号", Font.PLAIN, 16);
		
		//顶部面板
		JPanel JPanelTop = new JPanel();
		
		//创建一个标签
		JLabel label = new JLabel();
		
		label.setFont(fontMiddle);
		
		//使用网络上的照片
		URL url = new URL("https://www.helloimg.com/images/2021/04/07/BD5OmY.png");
		ImageIcon icon = new ImageIcon(url);
		
		//ImageIcon icon = new ImageIcon("src/com/xiaoxiao/window/apple.png");
		
		String str = "苹果";
		
		
		//图标与文字间的间隔大小
		label.setIconTextGap(10);
		
		JPanelCenter.add(label);
		frame.add(JPanelCenter, BorderLayout.CENTER);
		
		//只有图标
		JButton btn1 = new JButton("只有图标");
		btn1.setFont(fontMiddle); // 设置按钮文字的字体与大小
		btn1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) { 
				// 设置标签的图标
				label.setIcon(icon); 
				 // 设置标签的文本为空，此时不显示文本
				label.setText(null);
			}
		});
		JPanelTop.add(btn1); 
		
		//只有文字
		JButton btn2 = new JButton("只有文字");
		btn2.setFont(fontMiddle); // 设置按钮文字的字体与大小
		btn2.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) { 
				// 设置标签的图标为空，此时不显示图标
				label.setIcon(null); 
				 // 设置标签的文本
				label.setText(str);
			}
		});
		JPanelTop.add(btn2); 
		
		//文字图标都显示 : 左图右字
		JButton btn3 = new JButton("文字图标都显示");
		btn3.setFont(fontMiddle); // 设置按钮文字的字体与大小
		btn3.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) { 
				// 设置标签的文本
				label.setText(str);
				
				// 设置标签的图标
				label.setIcon(icon); 
			
			}
		});
		JPanelTop.add(btn3); 
		
		
		frame.add(JPanelTop, BorderLayout.NORTH);
		
		frame.setVisible(true);
	}
}

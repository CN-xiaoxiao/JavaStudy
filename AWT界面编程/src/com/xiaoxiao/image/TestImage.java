package com.xiaoxiao.image;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestImage {
	public static void main(String[] args) {
		Frame frame = new Frame("图像");
		
		frame.setSize(500, 300);
		//为窗口注册监听器
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		
		Panel panel = new Panel();
		ImageView imageView = new ImageView();
		
		imageView.setSize(450, 300);
		//绝对路径，可相对
		imageView.setImagePath("C:/Users/17375/Pictures/Saved Pictures/123.jpg");
		
		panel.add(imageView);
		frame.add(panel);
		
		frame.setVisible(true);
	}
}

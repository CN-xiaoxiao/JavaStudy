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
		JFrame frame = new JFrame("Swingͼ�����");
		frame.setSize(500, 400);
		
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�����������
		JPanel JPanelCenter = new JPanel();
		
		//����
		Font fontMiddle = new Font("�к�", Font.PLAIN, 16);
		
		//�������
		JPanel JPanelTop = new JPanel();
		
		//����һ����ǩ
		JLabel label = new JLabel();
		
		label.setFont(fontMiddle);
		
		//ʹ�������ϵ���Ƭ
		URL url = new URL("https://www.helloimg.com/images/2021/04/07/BD5OmY.png");
		ImageIcon icon = new ImageIcon(url);
		
		//ImageIcon icon = new ImageIcon("src/com/xiaoxiao/window/apple.png");
		
		String str = "ƻ��";
		
		
		//ͼ�������ּ�ļ����С
		label.setIconTextGap(10);
		
		JPanelCenter.add(label);
		frame.add(JPanelCenter, BorderLayout.CENTER);
		
		//ֻ��ͼ��
		JButton btn1 = new JButton("ֻ��ͼ��");
		btn1.setFont(fontMiddle); // ���ð�ť���ֵ��������С
		btn1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) { 
				// ���ñ�ǩ��ͼ��
				label.setIcon(icon); 
				 // ���ñ�ǩ���ı�Ϊ�գ���ʱ����ʾ�ı�
				label.setText(null);
			}
		});
		JPanelTop.add(btn1); 
		
		//ֻ������
		JButton btn2 = new JButton("ֻ������");
		btn2.setFont(fontMiddle); // ���ð�ť���ֵ��������С
		btn2.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) { 
				// ���ñ�ǩ��ͼ��Ϊ�գ���ʱ����ʾͼ��
				label.setIcon(null); 
				 // ���ñ�ǩ���ı�
				label.setText(str);
			}
		});
		JPanelTop.add(btn2); 
		
		//����ͼ�궼��ʾ : ��ͼ����
		JButton btn3 = new JButton("����ͼ�궼��ʾ");
		btn3.setFont(fontMiddle); // ���ð�ť���ֵ��������С
		btn3.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) { 
				// ���ñ�ǩ���ı�
				label.setText(str);
				
				// ���ñ�ǩ��ͼ��
				label.setIcon(icon); 
			
			}
		});
		JPanelTop.add(btn3); 
		
		
		frame.add(JPanelTop, BorderLayout.NORTH);
		
		frame.setVisible(true);
	}
}

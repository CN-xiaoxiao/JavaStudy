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
		Frame frame = new Frame("Labelʹ��");
		
		frame.setSize(600,400);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		//����һ���ı���ǩ
		Label label = new Label("����鿴����Ч��");
		
		//�����ı���ǩ�Ķ��뷽ʽ
		label.setAlignment(Label.CENTER);
		
		//�����ı���ǩ���Ƽ��и�
		label.setPreferredSize(new Dimension(300, 50));
		
		//
		Panel panelCenter = new Panel();
		
		panelCenter.add(label);
		
		//�����������
		Panel panelTop = new Panel();
		
		//������ť
		Button btn1 = new Button("������ɫ");
		Button btn2 = new Button("ǰ����ɫ");
		Button btn3 = new Button("������ɫ");
		Button btn4 = new Button("���б��");
		Button btn5 = new Button("�кŴ���");
		Button btn6 = new Button("�ָ�ԭ״");
		
		btn1.setFont(new Font("",Font.PLAIN, 16));
		btn1.setForeground(Color.YELLOW);
		btn1.setBackground(Color.BLACK);
		
		btn2.setFont(new Font("",Font.PLAIN, 16));
		btn3.setFont(new Font("",Font.PLAIN, 16));
		btn4.setFont(new Font("",Font.PLAIN, 16));
		btn5.setFont(new Font("",Font.PLAIN, 16));
		btn6.setFont(new Font("",Font.PLAIN, 16));
		
		//����ťע�ᵥ��������
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
				Font italic_big = new Font("���б��", Font.ITALIC, 30);
				
				label.setFont(italic_big);
				
			}
			
		});
		
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Font italic_middle = new Font("�кŴ���", Font.BOLD, 20);
				
				label.setFont(italic_middle);
				
			}
			
		});
		
		btn6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				label.setBackground(Color.WHITE); // �����ı���ǩ�ı�����ɫ
				label.setForeground(Color.BLACK); // �����ı���ǩ��ǰ����ɫ
				label.setFont(new Font(null, Font.PLAIN, 12)); // �����ı���ǩ�����弰��ɫ
				
			}
			
		});
		
		//�ڶ����������Ӱ�ť
		panelTop.add(btn1);
		panelTop.add(btn2);
		panelTop.add(btn3);
		panelTop.add(btn4);
		panelTop.add(btn5);
		panelTop.add(btn6);

		frame.add(panelCenter, BorderLayout.CENTER);
		
		frame.add(panelTop, BorderLayout.NORTH);
		
		//���ڿ��ӻ�
		frame.setVisible(true);
		
		//Ϊ����ע�������
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
	}
	
	//ʹ��RGB��ֵ���AWT��Ԫ��ʵ��
	public static Color getColor(int red, int green, int blue) {
		float[] hsbs = Color.RGBtoHSB(red, green, blue, null);
		
		Color color = Color.getHSBColor(hsbs[0], hsbs[1], hsbs[2]);
		
		return color;
	}
}

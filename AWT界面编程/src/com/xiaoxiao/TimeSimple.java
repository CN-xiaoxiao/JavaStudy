package com.xiaoxiao;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeSimple {
	public static void main(String[] args) {
		//����һ�����ڶ���
		final Frame frame = new Frame("���Դ���");
		
		//����������
		Panel panel = new Panel();
		
		//����һ����ť
		Button button = new Button("����");
		
		//���ô��ڵĴ�С
		frame.setSize(400,200);
		
		//���ô��ڵ����λ��
		//�����ھ���
		frame.setLocationRelativeTo(null);
		
		//���ô��ڱ���ɫ
		frame.setBackground(Color.GREEN);
		
		//�����ڿ��ӻ�
		frame.setVisible(true);
		
		//Ϊ����ע�������
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		
		button.setPreferredSize(new Dimension(200,30));
		
		//Ϊ��ťע�������
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				button.setLabel(getNowTime() + "�����˰�ť");
			}

			private String getNowTime() {
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				
				return sdf.format(new Date());
			}
			
		});
		//���������Ӱ�ť
		panel.add(button);
		
		//�ڴ�����������
		frame.add(panel);	
		
	}
}

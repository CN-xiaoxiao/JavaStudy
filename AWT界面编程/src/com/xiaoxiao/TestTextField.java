package com.xiaoxiao;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestTextField {
	public static void main(String[] args) {
		Frame frame = new Frame("�ı���ǩ");
		
		frame.setSize(500,100);
		
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		//Ϊ����ע�������
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		
		Panel panelCenter = new Panel();
		
		//����һ�����������
		TextField field = new TextField();
		
//		//���������ĳ���Ϊ11���ַ�
//		field.setColumns(11);
//		
//		//�������������༭
//		field.setEditable(true);
		
		//
		field.setColumns(6);
		field.setEchoChar('*');
		field.setEditable(true);
		
		panelCenter.add(field);
		
		frame.add(panelCenter);
		//���ӻ�
		frame.setVisible(true);
	}
}

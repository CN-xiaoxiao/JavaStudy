package com.xiaoxiao;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextFlow {
	public static void main(String[] args) {
		Frame frame = new Frame("������");
		
		Panel panel = new Panel();
		
		//��ʽ����
//		FlowLayout layout = new FlowLayout();
//		
//		layout.setAlignment(FlowLayout.LEFT);
//		
//		panel.setLayout(layout);
		
		//���񲼾�
//		GridLayout layout = new GridLayout(5,1); //����һ�����񲼾�5��1��
//		layout.setRows(5);
//		layout.setColumns(1);
//		panel.setLayout(layout);
		
		//�߽粼��
		panel.setLayout(new BorderLayout());
		panel.add(new Button("���ߵİ�ť"), BorderLayout.EAST);
		panel.add(new Button("���ߵİ�ť"), BorderLayout.WEST);
		panel.add(new Button("���ߵİ�ť"), BorderLayout.NORTH);
		panel.add(new Button("�ϱߵİ�ť"), BorderLayout.SOUTH);
		panel.add(new Button("�м�İ�ť"), BorderLayout.CENTER);
		
		frame.setSize(400,120);
		
//		panel.add(new Button("��һ����ť"));
//		panel.add(new Button("�ڶ�����ť"));
//		panel.add(new Button("��������ť"));
//		panel.add(new Button("���ĸ���ť"));
//		panel.add(new Button("�������ť"));
		
		frame.add(panel);
		
		frame.setVisible(true);
		
		//Ϊ����ע�������
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
	}
}

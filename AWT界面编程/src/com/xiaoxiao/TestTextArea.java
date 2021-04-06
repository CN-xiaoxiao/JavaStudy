package com.xiaoxiao;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestTextArea {
	public static void main(String[] args) {
		Frame frame = new Frame("�����ı���");
		frame.setSize(500, 200);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		//Ϊ����ע�������
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		
		Panel panel = new Panel();
		
		Label lable = new Label("��������������");
		panel.add(lable);
		
		TextArea area = new TextArea();
		
		//�����Ƿ�ɱ༭
		area.setEditable(true);
		
		//���������ĳ���Ϊ20���ַ�
		area.setColumns(20);
		
		//���������ĸ߶�Ϊ3���ַ�
		area.setRows(3);
		
		panel.add(area);
		
		frame.add(panel);
		frame.setVisible(true);
	}
}

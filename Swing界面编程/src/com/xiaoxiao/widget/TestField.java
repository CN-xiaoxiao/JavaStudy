package com.xiaoxiao.widget;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestField {
	public static void main(String[] args) {
		JFrame frame = new JFrame("��������");
		frame.setSize(500,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		
		//���񲼾�
		panel.setLayout(new GridLayout(4, 1));
		
		//�����ı���
		JTextField textField = new JTextField();
		textField.setEditable(true);
		textField.setColumns(11);
		panel.add(textField);
		
		//�����
		JPasswordField passwordField = new JPasswordField();
		passwordField.setEditable(true);
		passwordField.setColumns(6);
		//Ĭ����Բ�㣬���޸�
		//passwordField.setEchoChar('*');
		panel.add(passwordField);
		
		//��������򣬲���������
		JTextArea area = new JTextArea();
		area.setEditable(true);
		area.setColumns(14);
		area.setRows(3);
		//����ÿ���Ƿ���۵�,Ϊtrue�������ַ��ȿؼ���ʱ���Զ�����
		area.setLineWrap(true);
		panel.add(area);
		
		//��������򣬴�������
		JTextArea area2 = new JTextArea();
		area2.setEditable(true);
		area2.setColumns(14);
		area2.setRows(3);
		//����ÿ���Ƿ���۵�,Ϊtrue�������ַ��ȿؼ���ʱ���Զ�����
		area2.setLineWrap(true);
		
		//���ﲻ��Ҫpanel.add(area2); ��Ϊarea2��scroll������
		JScrollPane scroll = new JScrollPane(area2);
		panel.add(scroll);
		
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}

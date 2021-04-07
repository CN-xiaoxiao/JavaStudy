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
		JFrame frame = new JFrame("输入框测试");
		frame.setSize(500,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		
		//网格布局
		panel.setLayout(new GridLayout(4, 1));
		
		//单行文本框
		JTextField textField = new JTextField();
		textField.setEditable(true);
		textField.setColumns(11);
		panel.add(textField);
		
		//密码框
		JPasswordField passwordField = new JPasswordField();
		passwordField.setEditable(true);
		passwordField.setColumns(6);
		//默认是圆点，可修改
		//passwordField.setEchoChar('*');
		panel.add(passwordField);
		
		//多行输入框，不带滚动条
		JTextArea area = new JTextArea();
		area.setEditable(true);
		area.setColumns(14);
		area.setRows(3);
		//设置每行是否可折叠,为true则输入字符比控件长时可自动换行
		area.setLineWrap(true);
		panel.add(area);
		
		//多行输入框，带滚动条
		JTextArea area2 = new JTextArea();
		area2.setEditable(true);
		area2.setColumns(14);
		area2.setRows(3);
		//设置每行是否可折叠,为true则输入字符比控件长时可自动换行
		area2.setLineWrap(true);
		
		//这里不需要panel.add(area2); 因为area2与scroll关联了
		JScrollPane scroll = new JScrollPane(area2);
		panel.add(scroll);
		
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}

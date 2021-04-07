package com.xiaoxiao.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestSwing {
	public static void main(String[] args) {
		//����һ�����ڶ���
		JFrame frame = new JFrame("���Դ���");
		//�������˳�����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		
		//JFrame ��setBackground�����������ã�ֻ�������������
		//frame.setBackground(Color.GREEN);
		
		//����һ�����
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		
		//����һ����ť
		JButton button = new JButton("����!");
		//���ð�ť���Ƽ��и�
		button.setPreferredSize(new Dimension(200,30));
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				button.setText(getNowTime() + "�����˰�ť");
			}
			
		});
		
		button.setFont(new Font("�к�", Font.PLAIN, 16));
		
		panel.add(button);
		
		frame.add(panel);
		//���ӻ�
		frame.setVisible(true);
	}
	
	// ��ȡ��ǰ��ʱ���ַ���
	public static String getNowTime() {
		// ����һ�����ڸ�ʽ���Ĺ���
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		// ����ǰʱ�䰴��ָ����ʽ�����ʽ�����ʱ���ַ���
		return sdf.format(new Date());
	}
}

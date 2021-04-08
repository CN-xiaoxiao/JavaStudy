package com.xiaoxiao.widget;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TestRadioButton {
	public static void main(String[] args) {
		JFrame famel = new JFrame("��ѡ�����");
		famel.setSize(400, 130);
		famel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		famel.setLocationRelativeTo(null);
		famel.setLayout(new BorderLayout());
		
		
		JLabel label = new JLabel("����鿴ѡ��ť�Ĵ���");
		Font font = new Font("", Font.PLAIN, 16);
		
		//�����������
		JPanel panelCenter = new JPanel();
		panelCenter.add(label);
		
		famel.add(panelCenter, BorderLayout.CENTER);
		
		//�����������
		JPanel panelTop = new JPanel();
		
		//false��ʾĬ��û��ѡ����Ϊtrue��ΪĬ��ѡ��
		JRadioButton rb1 = new JRadioButton("���ɲ�", false);
		rb1.setFont(font);
		JRadioButton rb2 = new JRadioButton("˫Ƥ��", true);
		rb2.setFont(font);
		JRadioButton rb3 = new JRadioButton("����", false);
		rb3.setFont(font);
		
		panelTop.add(rb1);
		panelTop.add(rb2);
		panelTop.add(rb3);
		
		//������ѡ��С��
		ButtonGroup group = new ButtonGroup();
		group.add(rb1);
		group.add(rb2);
		group.add(rb3);
		
		rb1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				label.setText("������" + rb1.getText());
			}
			
		});
		
		rb2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				label.setText("������" + rb2.getText());
			}
			
		});
		
		rb3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				label.setText("������" + rb3.getText());
			}
			
		});
		
		famel.add(panelTop, BorderLayout.NORTH);
		famel.setVisible(true);
	}
}

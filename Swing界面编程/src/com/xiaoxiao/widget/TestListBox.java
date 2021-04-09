package com.xiaoxiao.widget;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TestListBox {
	public static void main(String[] args) {
		JFrame frame = new JFrame("�б�����");
		frame.setSize(300, 300);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		Font font = new Font("", Font.PLAIN, 16);
		
		JLabel labelBottom = new JLabel("����鿴�б���ѡ������");
		labelBottom.setFont(font);
		
		//��ӵײ����
		JPanel panelBottom = new JPanel();
		panelBottom.add(labelBottom);
		
		frame.add(panelBottom, BorderLayout.SOUTH);
		
		JLabel labelCenter = new JLabel("����鿴�Ѿ�����ײͣ�");
		labelCenter.setFont(font);
		
		//����������
		JPanel panelCenter = new JPanel();
		panelCenter.add(labelCenter);
		
		frame.add(panelCenter, BorderLayout.CENTER);
		
		//������ߵ����
		JPanel panelLeft = new JPanel();
		
		//����һ���б��ģ��
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listModel.addElement("���ɲ�");
		listModel.addElement("�����̲�");
		listModel.addElement("���¿���");
		listModel.addElement("�ɿڿ���");
		listModel.addElement("ѩ��");
		listModel.addElement("����");

		//����һ���б��
		JList<String> listBox = new JList<String>(listModel);
		panelLeft.add(listBox);
		frame.add(panelLeft, BorderLayout.WEST);
		
		listBox.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				//��ȡ�б����ѡ�������ż�������
				String desc = String.format("�����˵�%d� �ײ�������%s", listBox.getSelectedIndex(), listBox.getSelectedValue());
				labelBottom.setText(desc);
				
				String total = "<html>����ѡ����ײ��б�����: <br>";
				
				//��ȡ�б��������ѡ�����ƴ��html��ʽ��������
				for (String str : listBox.getSelectedValuesList()) {
					total = String.format("%s<center>%s</center>", total, str);
					
				}
				
				total += "</html>";
				
				labelCenter.setText(total);
			}
			
		});
		frame.setVisible(true);
	}
}

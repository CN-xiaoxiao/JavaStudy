package com.xiaoxiao.widget;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestComboBox {
	public static void main(String[] args) {
		JFrame frame = new JFrame("����������");
		frame.setSize(400,130);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		JLabel label = new JLabel("����鿴��ѡ��Ĳ˵�");
		Font font = new Font("", Font.PLAIN, 16);
		
		//�����������
		JPanel panelCenter = new JPanel();
		
		panelCenter.add(label);
		frame.add(panelCenter, BorderLayout.CENTER);
		
		//�����������
		JPanel panelTop = new JPanel();
		
		//����һ��������ģ��
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>();
		comboModel.addElement("���ɲ�");
		comboModel.addElement("�����̲�");
		comboModel.addElement("���¿���");
		comboModel.addElement("�ɿڿ���");
		comboModel.addElement("ѩ��");
		comboModel.addElement("����");
		
		//����һ��������
		JComboBox<String> comboBox = new JComboBox<String>(comboModel);
		comboBox.setFont(font);
		panelTop.add(comboBox);
		
		frame.add(panelTop, BorderLayout.NORTH);
		comboBox.setEditable(false);
		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String desc = String.format("�����˵�%d��, �ײ�������%s", comboBox.getSelectedIndex(), comboBox.getSelectedItem().toString());
				
				label.setText(desc);
			}
			
		});
		
		frame.setVisible(true);
	}
}

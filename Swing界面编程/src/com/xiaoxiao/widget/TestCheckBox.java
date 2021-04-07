package com.xiaoxiao.widget;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestCheckBox {
	public static void main(String[] args) {
		JFrame frame = new JFrame("���Ը�ѡ��");
		
		frame.setSize(450,160);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel labelCenter = new JLabel();
		Font font = new Font("�к�", Font.PLAIN, 16);
		labelCenter.setFont(font);
		
		//�����������
		JPanel panelCenter = new JPanel();
		panelCenter.add(labelCenter);
		frame.add(panelCenter, BorderLayout.CENTER);
		
		JLabel labelButtom = new JLabel("����鿴��Ĳ˵�");
		labelButtom.setFont(font);
		labelButtom.setPreferredSize(new Dimension(420, 30));
		
		//�����ײ����
		JPanel panelButtom = new JPanel();
		panelButtom.add(labelButtom);
		frame.add(panelButtom, BorderLayout.SOUTH);
		
		//�����������
		JPanel panelTop = new JPanel();
		//������ѡ��
		JCheckBox ck1 = new JCheckBox("���Ŷ���");
		JCheckBox ck2 = new JCheckBox("���ɲ�");
		JCheckBox ck3 = new JCheckBox("������");
		panelTop.add(ck1);
		panelTop.add(ck2);
		panelTop.add(ck3);
		frame.add(panelTop, BorderLayout.NORTH);
		
		//������ѡ������
		JCheckBox[] boxArray = new JCheckBox[] {ck1,ck2,ck3};
		
		//��Ӽ�����
		ck1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				labelCenter.setText(String.format("��%s��%s", (e.getStateChange() == 1 ? "��" : "ȡ��"), ck1.getText()));
				labelButtom.setText("��ǰ�ѵ���Ȱ�����" + getCheckedItem(boxArray));
			}
			
		});
		
		ck2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				labelCenter.setText(String.format("��%s��%s", (e.getStateChange() == 1 ? "��" : "ȡ��"), ck2.getText()));
				labelButtom.setText("��ǰ�ѵ���Ȱ�����" + getCheckedItem(boxArray));
			}
			
		});
		
		ck3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				labelCenter.setText(String.format("��%s��%s", (e.getStateChange() == 1 ? "��" : "ȡ��"), ck3.getText()));
				labelButtom.setText("��ǰ�ѵ���Ȱ�����" + getCheckedItem(boxArray));
			}
			
		});
		
		frame.setVisible(true);
	}
	
	//��ȡ�Ѿ�ѡ���Ĳ˵�
	private static String getCheckedItem(JCheckBox[] boxArray) {
		String itemDesc = "";
		//������ѡ������
		for (JCheckBox box : boxArray) {
			//�����ѡ��ѡ��
			if (box.isSelected() == true) {
				if (itemDesc.length() > 0) {
					itemDesc = itemDesc + "��";
				}
				itemDesc = itemDesc + box.getText();
			}
		}
		return itemDesc;
	}
}

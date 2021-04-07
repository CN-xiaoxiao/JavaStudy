package com.xiaoxiao.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class TestLabel {
	public static void main(String[] args) {
		JFrame frame = new JFrame("�����ı���ǩ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,400);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		//�����������
		JPanel panelCenter = new JPanel();
		
		//����
		Font fontMiddle = new Font("�к�", Font.PLAIN, 16);
		
		//
		JLabel label = new JLabel();
		label.setPreferredSize(new Dimension(350,100));
		label.setFont(new Font("����", Font.PLAIN, 25));
		
		//\nû�����ã�����
		label.setText("��ǰ���¹⣬���ǵ���˪��\n��ͷ�����£���ͷ˼����");
		
		//���ñ�ǩ������ˮƽ�����϶���
		label.setHorizontalAlignment(JLabel.LEFT);
		
		//���ñ�ǩ�����ڴ�ֱ�����϶���
		label.setVerticalAlignment(JLabel.CENTER);
		
		//���ñ�ǩΪ��͸��
		label.setOpaque(true);
		
		label.setBackground(Color.WHITE);
		
		panelCenter.add(label);
		
		frame.add(panelCenter, BorderLayout.CENTER);
		
		JPanel JPanelTop = new JPanel();
		
		//������
		JButton btn1 = new JButton("������");
		btn1.setFont(fontMiddle);
		
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//\nû�����ã�����
				label.setText("��ǰ���¹⣬���ǵ���˪��\n��ͷ�����£���ͷ˼����");
			}
			
		});
		JPanelTop.add(btn1);
		
		//�Զ�����
		JButton btn2 = new JButton("�Զ�����");
		btn2.setFont(fontMiddle);
		
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				label.setText("<html>��ǰ���¹⣬���ǵ���˪����ͷ�����£���ͷ˼����</html>");
			}
			
		});
		JPanelTop.add(btn2);
		
		//�ֶ�����
		JButton btn3 = new JButton("�ֶ�����");
		btn3.setFont(fontMiddle);
		
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				label.setText("<html>��ǰ���¹⣬���ǵ���˪��<br>��ͷ�����£���ͷ˼����</html>");
			}
			
		});
		JPanelTop.add(btn3);
		
		//�������
		JButton btn4 = new JButton("�������");
		btn4.setFont(fontMiddle);
				
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				label.setText("<html><font color='red'>��ǰ���¹⣬</font><b>���ǵ���˪��</b><br>"
						+ "<font color='yellow'>��ͷ�����£�</font><i>��ͷ˼����</i></html>");
			}
					
		});
		JPanelTop.add(btn4);
				
		frame.add(JPanelTop, BorderLayout.NORTH);
		frame.setVisible(true);
		
	}
}

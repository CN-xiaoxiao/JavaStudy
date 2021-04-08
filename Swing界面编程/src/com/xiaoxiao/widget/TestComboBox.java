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
		JFrame frame = new JFrame("测试下拉框");
		frame.setSize(400,130);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		JLabel label = new JLabel("这里查看您选择的菜单");
		Font font = new Font("", Font.PLAIN, 16);
		
		//创建中央面板
		JPanel panelCenter = new JPanel();
		
		panelCenter.add(label);
		frame.add(panelCenter, BorderLayout.CENTER);
		
		//创建顶部面板
		JPanel panelTop = new JPanel();
		
		//创建一个下拉框模型
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>();
		comboModel.addElement("烧仙草");
		comboModel.addElement("珍珠奶茶");
		comboModel.addElement("百事可乐");
		comboModel.addElement("可口可乐");
		comboModel.addElement("雪碧");
		comboModel.addElement("拿铁");
		
		//创建一个下拉框
		JComboBox<String> comboBox = new JComboBox<String>(comboModel);
		comboBox.setFont(font);
		panelTop.add(comboBox);
		
		frame.add(panelTop, BorderLayout.NORTH);
		comboBox.setEditable(false);
		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String desc = String.format("您点了第%d项, 套餐名称是%s", comboBox.getSelectedIndex(), comboBox.getSelectedItem().toString());
				
				label.setText(desc);
			}
			
		});
		
		frame.setVisible(true);
	}
}

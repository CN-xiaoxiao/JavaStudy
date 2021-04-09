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
		JFrame frame = new JFrame("列表框测试");
		frame.setSize(300, 300);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		Font font = new Font("", Font.PLAIN, 16);
		
		JLabel labelBottom = new JLabel("这里查看列表框的选择结果：");
		labelBottom.setFont(font);
		
		//添加底部面板
		JPanel panelBottom = new JPanel();
		panelBottom.add(labelBottom);
		
		frame.add(panelBottom, BorderLayout.SOUTH);
		
		JLabel labelCenter = new JLabel("这里查看已经点的套餐：");
		labelCenter.setFont(font);
		
		//添加中央面板
		JPanel panelCenter = new JPanel();
		panelCenter.add(labelCenter);
		
		frame.add(panelCenter, BorderLayout.CENTER);
		
		//创建左边的面板
		JPanel panelLeft = new JPanel();
		
		//创建一个列表框模型
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listModel.addElement("烧仙草");
		listModel.addElement("珍珠奶茶");
		listModel.addElement("百事可乐");
		listModel.addElement("可口可乐");
		listModel.addElement("雪碧");
		listModel.addElement("拿铁");

		//创建一个列表框
		JList<String> listBox = new JList<String>(listModel);
		panelLeft.add(listBox);
		frame.add(panelLeft, BorderLayout.WEST);
		
		listBox.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				//获取列表框内选中项的序号及其描述
				String desc = String.format("您点了第%d项， 套餐名称是%s", listBox.getSelectedIndex(), listBox.getSelectedValue());
				labelBottom.setText(desc);
				
				String total = "<html>您已选择的套餐列表如下: <br>";
				
				//获取列表框内所有选择项，并拼接html格式的描述串
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

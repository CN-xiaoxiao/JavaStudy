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
		JFrame frame = new JFrame("测试复选框");
		
		frame.setSize(450,160);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel labelCenter = new JLabel();
		Font font = new Font("中号", Font.PLAIN, 16);
		labelCenter.setFont(font);
		
		//创建中央面板
		JPanel panelCenter = new JPanel();
		panelCenter.add(labelCenter);
		frame.add(panelCenter, BorderLayout.CENTER);
		
		JLabel labelButtom = new JLabel("这里查看点的菜单");
		labelButtom.setFont(font);
		labelButtom.setPreferredSize(new Dimension(420, 30));
		
		//创建底部面板
		JPanel panelButtom = new JPanel();
		panelButtom.add(labelButtom);
		frame.add(panelButtom, BorderLayout.SOUTH);
		
		//创建顶部面板
		JPanel panelTop = new JPanel();
		//创建复选框
		JCheckBox ck1 = new JCheckBox("麻婆豆腐");
		JCheckBox ck2 = new JCheckBox("烧仙草");
		JCheckBox ck3 = new JCheckBox("清蒸鱼");
		panelTop.add(ck1);
		panelTop.add(ck2);
		panelTop.add(ck3);
		frame.add(panelTop, BorderLayout.NORTH);
		
		//创建复选框数组
		JCheckBox[] boxArray = new JCheckBox[] {ck1,ck2,ck3};
		
		//添加监听器
		ck1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				labelCenter.setText(String.format("您%s了%s", (e.getStateChange() == 1 ? "点" : "取消"), ck1.getText()));
				labelButtom.setText("当前已点菜肴包括：" + getCheckedItem(boxArray));
			}
			
		});
		
		ck2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				labelCenter.setText(String.format("您%s了%s", (e.getStateChange() == 1 ? "点" : "取消"), ck2.getText()));
				labelButtom.setText("当前已点菜肴包括：" + getCheckedItem(boxArray));
			}
			
		});
		
		ck3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				labelCenter.setText(String.format("您%s了%s", (e.getStateChange() == 1 ? "点" : "取消"), ck3.getText()));
				labelButtom.setText("当前已点菜肴包括：" + getCheckedItem(boxArray));
			}
			
		});
		
		frame.setVisible(true);
	}
	
	//获取已经选定的菜单
	private static String getCheckedItem(JCheckBox[] boxArray) {
		String itemDesc = "";
		//遍历复选框数组
		for (JCheckBox box : boxArray) {
			//如果复选框被选中
			if (box.isSelected() == true) {
				if (itemDesc.length() > 0) {
					itemDesc = itemDesc + "、";
				}
				itemDesc = itemDesc + box.getText();
			}
		}
		return itemDesc;
	}
}

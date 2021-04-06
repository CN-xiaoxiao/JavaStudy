package com.xiaoxiao;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestCheckBox {
	public static void main(String[] args) {
		Frame frame = new Frame("选择框");
		frame.setSize(600,200);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		//为窗口注册监听器
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		
		Label labelCenter = new Label("这里查看勾选结果");
		Panel panelCenter = new Panel();
		panelCenter.add(labelCenter);
		frame.add(panelCenter, BorderLayout.CENTER);
		Label labelBotton = new Label("这里查看点的菜单");
		labelBotton.setPreferredSize(new Dimension(420,30));
		Panel panelBotton = new Panel();
		panelBotton.add(labelBotton);
		frame.add(panelBotton, BorderLayout.SOUTH);
		Panel panelTop = new Panel();
		
		Checkbox ck1 = new Checkbox("麻婆豆腐");
		Checkbox ck2 = new Checkbox("清蒸鱼");
		Checkbox ck3 = new Checkbox("红烧肉");
		panelTop.add(ck1);
		panelTop.add(ck2);
		panelTop.add(ck3);
	
		frame.add(panelTop, BorderLayout.NORTH);
		
		Checkbox[] boxArray = new Checkbox[] {ck1, ck2, ck3};
		
		ck1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				labelCenter.setText(String.format("您%s了%s", (e.getStateChange() == 1 ? "点" : "取消"), ck1.getLabel()));
				
				labelBotton.setText("当前已点菜肴包括：" + getCheckedItem(boxArray));
				
			}
			
		});
		
		ck2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				labelCenter.setText(String.format("您%s了%s", (e.getStateChange() == 1 ? "点" : "取消"), ck2.getLabel()));
				
				labelBotton.setText("当前已点菜肴包括：" + getCheckedItem(boxArray));
				
			}
			
		});
		
		ck3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				labelCenter.setText(String.format("您%s了%s", (e.getStateChange() == 1 ? "点" : "取消"), ck3.getLabel()));
				
				labelBotton.setText("当前已点菜肴包括：" + getCheckedItem(boxArray));
				
			}
			
		});
		
		
		frame.setVisible(true);
	}
	
	private static String getCheckedItem(Checkbox[] boxArray) {
		String itemDesc = "";
		
		for (Checkbox box : boxArray) {
			if (box.getState() == true) {
				if (itemDesc.length() > 0) {
					itemDesc = itemDesc + "、";
				}
				
				itemDesc = itemDesc + box.getLabel();
				
			}
		}
		
		return itemDesc;
	}
}

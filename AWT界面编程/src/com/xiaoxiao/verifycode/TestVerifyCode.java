package com.xiaoxiao.verifycode;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TestVerifyCode {
	public static void main(String[] args) {
		//�������ڶ���
		final Frame frame = new Frame("��֤��");
		
		//Ϊ����ע�������
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		
		frame.setSize(400,150);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		CodeView codeView = new CodeView();
		codeView.setSize(200, 50);
		codeView.setDisturbType(CodeView.DOT);
		
		//�����������
		Panel panelCenter = new Panel();
		panelCenter.add(codeView);
		
		frame.add(panelCenter, BorderLayout.CENTER);
		
		//�����������
		Panel panelTop = new Panel();
		
		Button lineButton = new Button("ʹ�ø�����");
		lineButton.setFont(new Font("", Font.PLAIN, 16));
		lineButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				codeView.setDisturbType(CodeView.LINE);
			}
			
		});
		
		panelTop.add(lineButton);
		
		Button dotButton = new Button("ʹ�ø��ŵ�");
		dotButton.setFont(new Font("", Font.PLAIN, 16));
		dotButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				codeView.setDisturbType(CodeView.DOT);
			}
			
		});
		
		panelTop.add(dotButton);
		
		Button saveButton = new Button("������֤��");
		saveButton.setFont(new Font("", Font.PLAIN, 16));
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				File imageFile = new File("..\\" + codeView.getCodeNumber() + ".jpg");
				System.out.println("file_path=" + imageFile.getAbsolutePath());
				
				try {
					ImageIO.write(codeView.getCodeImage(), "jpg", imageFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		panelTop.add(saveButton);
		
		frame.add(panelTop, BorderLayout.NORTH);
		
		frame.setVisible(true);
	}
}

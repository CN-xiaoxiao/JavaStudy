package com.xiaoxiao.image;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TestChange {
	public static void main(String[] args) throws IOException {
		Frame frame = new Frame("��Ƭ�ӹ�");
		
		frame.setSize(520, 340);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		//Ϊ����ע�������
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		
		//����һ��ͼ����ͼ
		ImageView imageView = new ImageView();
		
		//���������е�ͼƬ���ݶ�������ͼ��
		BufferedImage origin = ImageIO.read(TestChange.class.getResourceAsStream("apple.png"));
		System.out.println("getWidth=" + origin.getWidth() + "getHeight=" + origin.getHeight());
		
		//����ͼ����ͼ�Ŀ��
		imageView.setSize(origin.getWidth(), origin.getHeight());
		
		//����ͼ����ͼ�Ļ���ͼ��
		imageView.setImage(origin);
		
		//�����������
		Panel panelCenter = new Panel();
		panelCenter.add(imageView);
		frame.add(panelCenter, BorderLayout.CENTER);
		
		//�����������
		Panel panelTop = new Panel();
		
		//ԭʼͼƬ
		Button originButton = new Button("ԭʼͼƬ");
		originButton.setFont(new Font("", Font.PLAIN, 16));
		originButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				imageView.setSize(origin.getWidth(), origin.getHeight());
				imageView.setImage(origin);
			}
			
		});
		
		panelTop.add(originButton);
		
		//��תͼƬ
		Button rotateButton  = new Button("��תͼƬ");
		rotateButton.setFont(new Font("", Font.PLAIN, 16));
		rotateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				imageView.setSize(origin.getWidth(), origin.getHeight());
				BufferedImage newImage = ImageUtil.rotateImage(origin, 90);
				imageView.setImage(newImage);
			}
			
		});
		panelTop.add(rotateButton);
		
		//����ͼƬ
		Button resizeButton = new Button("����ͼƬ");
		resizeButton.setFont(new Font("", Font.PLAIN, 16));
		resizeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double ratio = 0.75;
				
				imageView.setSize((int)(origin.getWidth()*ratio), (int)(origin.getHeight()*ratio));
				BufferedImage newImage = ImageUtil.resizeImage(origin,ratio);
				imageView.setImage(newImage);
			}
		});
		panelTop.add(resizeButton);
		
		//ƽ��ͼƬ
		Button translateButton = new Button("ƽ��ͼƬ"); // ����һ����ť
		translateButton.setFont(new Font("", Font.PLAIN, 16)); // ���ð�ť�������С
		translateButton.addActionListener(new ActionListener() { // ����ťע��һ������������
			public void actionPerformed(ActionEvent e) { // �����˵����¼�
				// ��ͼ����ͼ�ĳߴ�����Ϊԭͼ��Ŀ��
				imageView.setSize(origin.getWidth(), origin.getHeight());
				// ���ƽ�ƺ����ͼ��
				BufferedImage newImage = ImageUtil.translateImage(origin,
						origin.getWidth() / 2, origin.getHeight() / 2);
				imageView.setImage(newImage); // ����ͼ����ͼ�Ļ���ͼ��
			}
		});
		panelTop.add(translateButton); // �ڶ����������Ӱ�ť
		
		//�ü�ͼ��
		Button clipButton = new Button("����ͼƬ");
		clipButton.setFont(new Font("", Font.PLAIN, 16));
		clipButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double ratio = 0.75;
						
				imageView.setSize((int)(origin.getWidth()*ratio), (int)(origin.getHeight()*ratio));
				BufferedImage newImage = ImageUtil.clipImage(origin,ratio);
				imageView.setImage(newImage);
			}
		});
		panelTop.add(clipButton);
			
		//ˮƽ��ת��Ƭ
		Button flipButton = new Button("��תͼƬ");
		flipButton.setFont(new Font("", Font.PLAIN, 16));
		flipButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				imageView.setSize(origin.getWidth(), origin.getHeight());
				BufferedImage newImage = ImageUtil.flipImage(origin);
				imageView.setImage(newImage);
			}
		});
		panelTop.add(flipButton);
		
		frame.add(panelTop, BorderLayout.NORTH);
		frame.setVisible(true);
	}
}

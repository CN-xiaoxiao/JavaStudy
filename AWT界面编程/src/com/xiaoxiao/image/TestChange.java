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
		Frame frame = new Frame("照片加工");
		
		frame.setSize(520, 340);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		//为窗口注册监听器
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		
		//创建一个图像视图
		ImageView imageView = new ImageView();
		
		//把输入流中的图片数据读到缓存图像
		BufferedImage origin = ImageIO.read(TestChange.class.getResourceAsStream("apple.png"));
		System.out.println("getWidth=" + origin.getWidth() + "getHeight=" + origin.getHeight());
		
		//设置图像视图的宽高
		imageView.setSize(origin.getWidth(), origin.getHeight());
		
		//设置图像视图的缓存图像
		imageView.setImage(origin);
		
		//创建中央面板
		Panel panelCenter = new Panel();
		panelCenter.add(imageView);
		frame.add(panelCenter, BorderLayout.CENTER);
		
		//创建顶部面板
		Panel panelTop = new Panel();
		
		//原始图片
		Button originButton = new Button("原始图片");
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
		
		//旋转图片
		Button rotateButton  = new Button("旋转图片");
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
		
		//缩放图片
		Button resizeButton = new Button("缩放图片");
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
		
		//平移图片
		Button translateButton = new Button("平移图片"); // 创建一个按钮
		translateButton.setFont(new Font("", Font.PLAIN, 16)); // 设置按钮的字体大小
		translateButton.addActionListener(new ActionListener() { // 给按钮注册一个单击监听器
			public void actionPerformed(ActionEvent e) { // 发生了单击事件
				// 将图像视图的尺寸设置为原图像的宽高
				imageView.setSize(origin.getWidth(), origin.getHeight());
				// 获得平移后的新图像
				BufferedImage newImage = ImageUtil.translateImage(origin,
						origin.getWidth() / 2, origin.getHeight() / 2);
				imageView.setImage(newImage); // 设置图像视图的缓存图像
			}
		});
		panelTop.add(translateButton); // 在顶部面板上添加按钮
		
		//裁剪图像
		Button clipButton = new Button("剪切图片");
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
			
		//水平翻转照片
		Button flipButton = new Button("翻转图片");
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

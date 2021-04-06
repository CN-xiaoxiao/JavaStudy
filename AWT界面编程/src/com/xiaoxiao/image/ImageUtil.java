package com.xiaoxiao.image;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImageUtil {
	//��תͼƬ
	public static BufferedImage rotateImage(BufferedImage origin, int rotateDegree) {
		int width = origin.getWidth();
		int height = origin.getHeight();
		int imageType = origin.getType();
		
		//������ԭͼ��ͬ���ߴ����ͼ��
		BufferedImage newImage = new BufferedImage(width, height, imageType);
		
		//��������ȡ��ͼ��Ļ���
		Graphics2D graphics2d = newImage.createGraphics();
		
		graphics2d.rotate(Math.toRadians(rotateDegree), width / 2, height / 2);
		
		graphics2d.drawImage(origin, 0, 0, null);
		
		return newImage;
	}
	
	//����ͼ��
	public static BufferedImage resizeImage(BufferedImage origin, double ratio) {
		int width = origin.getWidth();
		int height = origin.getHeight();
		int imageType = origin.getType();
		
		//�����ߴ��СΪ���ſ�ߵ���ͼ��
		BufferedImage newImage = new BufferedImage((int)(width*ratio), (int)(height*ratio), imageType);
		Graphics2D graphics2d = newImage.createGraphics();
		
		graphics2d.scale(ratio, ratio);
		
		graphics2d.drawImage(origin, 0, 0, null);
		
		return newImage;
	}
	
	//ƽ��ͼƬ
	public static BufferedImage translateImage(BufferedImage origin, int translateX, int translateY) {
		int width = origin.getWidth();
		int height = origin.getHeight();
		int imageType = origin.getType();
		
		//������ԭͼ��ͬ���ߴ����ͼ��
		BufferedImage newImage = new BufferedImage(width, height, imageType);
				
		//��������ȡ��ͼ��Ļ���
		Graphics2D graphics2d = newImage.createGraphics();
				
		graphics2d.translate(translateX, translateY);
				
		graphics2d.drawImage(origin, 0, 0, null);
				
		return newImage;
	}
	//�ü�ͼ��
	public static BufferedImage clipImage(BufferedImage origin, double ratio) {
		int width = origin.getWidth();
		int height = origin.getHeight();
		int imageType = origin.getType();
		
		//�����ߴ��СΪ�ü���������ͼ��
		BufferedImage newImage = new BufferedImage((int)(width*ratio), (int)(height*ratio), imageType);
		Graphics2D graphics2d = newImage.createGraphics();
		
		graphics2d.clipRect(0, 0, (int)(width*ratio), (int)(height*ratio));
		
		graphics2d.drawImage(origin, 0, 0, null);
		
		return newImage;
	}
	
	//ˮƽ��תͼ��
	public static BufferedImage flipImage(BufferedImage origin) {
		int width = origin.getWidth();
		int height = origin.getHeight();
		int imageType = origin.getType();
		
		BufferedImage newImage = new BufferedImage(width, height, imageType);
		Graphics2D graphics2d = newImage.createGraphics();
		//ˮƽ��ת
		graphics2d.drawImage(origin, 0, 0, width, height, width, 0, 0, height, null);
		//��ֱ��ת
		//graphics2d.drawImage(origin, 0, 0, width, height, 0, height, width, 0, null);
		
		return newImage;
	}
}

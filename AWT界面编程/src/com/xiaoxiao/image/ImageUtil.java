package com.xiaoxiao.image;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImageUtil {
	//旋转图片
	public static BufferedImage rotateImage(BufferedImage origin, int rotateDegree) {
		int width = origin.getWidth();
		int height = origin.getHeight();
		int imageType = origin.getType();
		
		//创建与原图像同样尺寸的新图像
		BufferedImage newImage = new BufferedImage(width, height, imageType);
		
		//创建并获取新图像的画笔
		Graphics2D graphics2d = newImage.createGraphics();
		
		graphics2d.rotate(Math.toRadians(rotateDegree), width / 2, height / 2);
		
		graphics2d.drawImage(origin, 0, 0, null);
		
		return newImage;
	}
	
	//缩放图像
	public static BufferedImage resizeImage(BufferedImage origin, double ratio) {
		int width = origin.getWidth();
		int height = origin.getHeight();
		int imageType = origin.getType();
		
		//创建尺寸大小为缩放宽高的新图像
		BufferedImage newImage = new BufferedImage((int)(width*ratio), (int)(height*ratio), imageType);
		Graphics2D graphics2d = newImage.createGraphics();
		
		graphics2d.scale(ratio, ratio);
		
		graphics2d.drawImage(origin, 0, 0, null);
		
		return newImage;
	}
	
	//平移图片
	public static BufferedImage translateImage(BufferedImage origin, int translateX, int translateY) {
		int width = origin.getWidth();
		int height = origin.getHeight();
		int imageType = origin.getType();
		
		//创建与原图像同样尺寸的新图像
		BufferedImage newImage = new BufferedImage(width, height, imageType);
				
		//创建并获取新图像的画笔
		Graphics2D graphics2d = newImage.createGraphics();
				
		graphics2d.translate(translateX, translateY);
				
		graphics2d.drawImage(origin, 0, 0, null);
				
		return newImage;
	}
	//裁剪图像
	public static BufferedImage clipImage(BufferedImage origin, double ratio) {
		int width = origin.getWidth();
		int height = origin.getHeight();
		int imageType = origin.getType();
		
		//创建尺寸大小为裁剪比例的新图像
		BufferedImage newImage = new BufferedImage((int)(width*ratio), (int)(height*ratio), imageType);
		Graphics2D graphics2d = newImage.createGraphics();
		
		graphics2d.clipRect(0, 0, (int)(width*ratio), (int)(height*ratio));
		
		graphics2d.drawImage(origin, 0, 0, null);
		
		return newImage;
	}
	
	//水平翻转图像
	public static BufferedImage flipImage(BufferedImage origin) {
		int width = origin.getWidth();
		int height = origin.getHeight();
		int imageType = origin.getType();
		
		BufferedImage newImage = new BufferedImage(width, height, imageType);
		Graphics2D graphics2d = newImage.createGraphics();
		//水平翻转
		graphics2d.drawImage(origin, 0, 0, width, height, width, 0, 0, height, null);
		//垂直翻转
		//graphics2d.drawImage(origin, 0, 0, width, height, 0, height, width, 0, null);
		
		return newImage;
	}
}

package com.xiaoxiao.verifycode;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 
 * @author xiaoxiao
 * 
 */
public class CodeView extends Component{
	private static final long serialVersionUID = 1L;
	
	//干扰线
	public final static int LINE = 1;
	
	//干扰点
	public final static int DOT = 2;
	
	//验证码字符集合
	private final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	//验证码字符串
	private String verify_code;
	
	//验证码图像
	private BufferedImage verify_image;
	
	//设置干扰类型
	public void setDisturbType(int disturb_type) {
		int width = getWidth();
		int height = getHeight();
		
		//创建默认的缓存图像
		verify_image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		
		//获取缓存图像的画笔
		Graphics2D g2d = verify_image.createGraphics();
		
		//设置画笔的颜色
		g2d.setColor(new Color(250, 250, 250));
		
		//填充背景颜色
		g2d.fillRect(0, 0, width, height);
		
		//
		Random r = new Random();
		if (disturb_type == LINE) {
			//循环绘制10根干扰线
			for (int i = 0; i < 10; i++) {
				g2d.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
				g2d.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
			}
		} else {
			//绘制120个干扰点
			for (int i = 0; i < 120; i++) {
				g2d.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
				g2d.drawOval(r.nextInt(width) - 2, r.nextInt(height) - 2, 2, 2);
			}
		}
		
		//清空验证码字符串
		verify_code = "";
		
		//随机生成4位字符当作验证码
		for (int i = 0; i < 4; i++) {
			verify_code = verify_code + "" + chars.charAt(r.nextInt(chars.length()));
		}
		
		g2d.setFont(new Font("斜体", Font.ITALIC, height / 5 * 4));
		g2d.translate(width / 10,  height / 5);
		g2d.drawString(verify_code, 5, 25);
		
		//重新绘制
		repaint();
	}
	
	//获取验证码图像
	public BufferedImage getCodeImage() {
		return verify_image;
	}
	
	//获取验证码字符串
	public String getCodeNumber() {
		//去掉验证码中的空格
		return verify_code.replace(" ", "");
	}
	
	//绘制控件的方法
	public void paint(Graphics g) {
		if (verify_image != null) {
			g.drawImage(verify_image, 0, 0, null);
		}
	}
	
	//获取控件的推荐宽高
	public Dimension getPreferredSize() {
		if (getWidth() > 0 && getHeight() > 0) {
			return new Dimension(getWidth(), getHeight());
		} else {
			return new Dimension(200, 50);
		}
	}
}

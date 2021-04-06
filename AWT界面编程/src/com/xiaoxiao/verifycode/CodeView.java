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
	
	//������
	public final static int LINE = 1;
	
	//���ŵ�
	public final static int DOT = 2;
	
	//��֤���ַ�����
	private final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	//��֤���ַ���
	private String verify_code;
	
	//��֤��ͼ��
	private BufferedImage verify_image;
	
	//���ø�������
	public void setDisturbType(int disturb_type) {
		int width = getWidth();
		int height = getHeight();
		
		//����Ĭ�ϵĻ���ͼ��
		verify_image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		
		//��ȡ����ͼ��Ļ���
		Graphics2D g2d = verify_image.createGraphics();
		
		//���û��ʵ���ɫ
		g2d.setColor(new Color(250, 250, 250));
		
		//��䱳����ɫ
		g2d.fillRect(0, 0, width, height);
		
		//
		Random r = new Random();
		if (disturb_type == LINE) {
			//ѭ������10��������
			for (int i = 0; i < 10; i++) {
				g2d.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
				g2d.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
			}
		} else {
			//����120�����ŵ�
			for (int i = 0; i < 120; i++) {
				g2d.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
				g2d.drawOval(r.nextInt(width) - 2, r.nextInt(height) - 2, 2, 2);
			}
		}
		
		//�����֤���ַ���
		verify_code = "";
		
		//�������4λ�ַ�������֤��
		for (int i = 0; i < 4; i++) {
			verify_code = verify_code + "" + chars.charAt(r.nextInt(chars.length()));
		}
		
		g2d.setFont(new Font("б��", Font.ITALIC, height / 5 * 4));
		g2d.translate(width / 10,  height / 5);
		g2d.drawString(verify_code, 5, 25);
		
		//���»���
		repaint();
	}
	
	//��ȡ��֤��ͼ��
	public BufferedImage getCodeImage() {
		return verify_image;
	}
	
	//��ȡ��֤���ַ���
	public String getCodeNumber() {
		//ȥ����֤���еĿո�
		return verify_code.replace(" ", "");
	}
	
	//���ƿؼ��ķ���
	public void paint(Graphics g) {
		if (verify_image != null) {
			g.drawImage(verify_image, 0, 0, null);
		}
	}
	
	//��ȡ�ؼ����Ƽ����
	public Dimension getPreferredSize() {
		if (getWidth() > 0 && getHeight() > 0) {
			return new Dimension(getWidth(), getHeight());
		} else {
			return new Dimension(200, 50);
		}
	}
}

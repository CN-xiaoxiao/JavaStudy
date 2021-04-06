package com.xiaoxiao.image;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

public class DrawView extends Component{
	private static final long serialVersionUID = 1L;
	public final static int LINE = 1;
	public final static int RECT = 2;
	public final static int ROUND_RECT = 3;
	public final static int OVAL = 4;
	public final static int ARC = 5;
	public final static int TEXT = 6;
	
	//绘图类型
	private int mDrawType = LINE;
	//是否填充
	private boolean isFilled = false; 
	
	//数字绘图类型
	public void setDrawType(int draw_type) {
		mDrawType = draw_type;
		//重写绘图，此时会接着执行paint方法
		repaint();
	}
	
	//设置是否填充
	public void setFilled(boolean is_filled) {
		isFilled = is_filled;
		repaint();
	}
	
	public void paint(Graphics g) {
		g.translate(0,  0);
		
		if (mDrawType == LINE) {
			g.setColor(Color.BLACK);
			g.drawLine(0, 0, getWidth(), getHeight());
		} else if (mDrawType == RECT) {
			g.setColor(Color.RED);
			
			if (isFilled) {
				g.fillRect(10, 10, getWidth() - 20, getHeight() - 20);
			} else {
				g.drawRect(10, 10, getWidth() - 20, getHeight() - 20);
			}
		} else if (mDrawType == ROUND_RECT) {
			g.setColor(Color.GREEN);
			if (isFilled) {
				g.fillRoundRect(10, 10, getWidth() - 20, getHeight() - 20, 50, 50);
			} else {
				g.drawRoundRect(10, 10, getWidth() - 20, getHeight() - 20, 50, 50);
			}
		} else if (mDrawType == OVAL) {
			g.setColor(Color.BLUE);
			if (isFilled) {
				g.fillOval(10, 10, getWidth() - 20, getHeight() - 20);
			} else {
				g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
			}
		} else if (mDrawType == ARC) {
			g.setColor(Color.PINK);
			
			if (isFilled) {
				g.fillArc(10, 10, getWidth() - 20, getHeight() - 20, 0, 90);
			} else {
				g.drawArc(10, 10, getWidth() - 20, getHeight() - 20, 0, 90);
			}
		} else if (mDrawType == TEXT) {
			g.translate(0, 50); 
			g.setColor(Color.BLACK);
			g.setFont(new Font("KaiTi", Font.BOLD, 70));
			g.drawString("肖肖", 20, 50);
		}
		
	}
	
	@Override
	public Dimension getPreferredSize() {
		if (getWidth() > 0 && getHeight() > 0) {
			 return new Dimension(getWidth(), getHeight());
		} else {
			return new Dimension(400, 400);
		}
	}
}

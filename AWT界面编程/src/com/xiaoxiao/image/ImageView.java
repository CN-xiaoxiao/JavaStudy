package com.xiaoxiao.image;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageView extends Component {

	private static final long serialVersionUID = 1L;
	//ÉùÃ÷Ò»¸ö»º´æÍ¼Ïñ
	private BufferedImage image;
		
	//ÉèÖÃÍ¼Æ¬Â·¾¶
	public void setImagePath(String path) {
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	//ÉèÖÃÍ¼Æ¬µÄÊäÈëÁ÷
	public void setImageStream(InputStream is) {
		try {
			image = ImageIO.read(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//ÉèÖÃ»º´æÍ¼Ïñ
	public void setImage(BufferedImage image) {
		this.image = image;
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		if (image != null) {
			if (getWidth() > 0 && getHeight() > 0) {
				g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
			}else {
				g.drawImage(image, 0, 0, null);
			}
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		if (image != null) {
			if (getWidth() > 0 && getHeight() > 0) {
				return new Dimension(getWidth(), getHeight());
			} else {
				return new Dimension(image.getWidth(), image.getHeight());
			}
		} else {
			return new Dimension(0, 0);
		}
	}
}

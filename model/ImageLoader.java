package model;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	BufferedImage image;
	
	public BufferedImage imageLoader(String pos) {
		
		try {
			image = ImageIO.read(getClass().getResource(pos));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return image;
	}

}

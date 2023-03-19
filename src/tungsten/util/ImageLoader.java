package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public ImageLoader() {
		// TODO Auto-generated constructor stub
	}
	
	public BufferedImage loadImage(String fileName) {
		try {
			BufferedImage img = ImageIO.read(getClass().getResourceAsStream(fileName));
			return img;
		} catch (IOException e) {
			System.out.println("Image Loading Error: " + e.toString());
			return null;
		}
	}
	
	public BufferedImage loadImageFromAbsolutepath(String fileName) {
		try {
			BufferedImage img = ImageIO.read(new File(fileName));
			return img;
		} catch (IOException e) {
			System.out.println("Image Loading Error: " + e.toString());
			return null;
		}
	}
	
	public BufferedImage loadUsingLongWay(String fileName) {
		File f = new File(fileName);
		
		return null;
	}

}

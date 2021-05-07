package model;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Window extends Canvas {

	private static final long serialVersionUID = -1930025309110276219L;
	//	
	public Window(int width, int height, String name, Gioco gioco) {
		
		
		
		JFrame window = new JFrame(name);
		window.setPreferredSize(new Dimension(width,height));
		window.setMinimumSize(new Dimension(width,height));
		window.setMaximumSize(new Dimension(width,height));
		window.setResizable(false);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(gioco);
		//window.pack();
		window.setVisible(true);
		
	}
	
	
	
}

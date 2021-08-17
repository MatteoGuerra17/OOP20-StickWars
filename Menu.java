package model;

import java.awt.Color;
import java.awt.Graphics;

public class Menu {

	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(800, 50, 100, 50);
		g.setColor(Color.white);
		g.drawRect(800, 50, 100, 50);
	}
	
}

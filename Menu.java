package model;

import java.awt.Color;
import java.awt.Graphics;

public class Menu {
	
	private int x, y, width, height;
	
	public Menu(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	

	public void button(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(this.x, this.y, this.width, this.height);
		
		g.setColor(Color.white);
		g.drawRect(this.x, this.y, this.width, this.height); //border
	}



	public void render(Graphics g) {
				
	}
	
}

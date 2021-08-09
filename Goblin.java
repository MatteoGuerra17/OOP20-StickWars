package entity;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import model.GameObject;

public class Goblin extends GameObject{	
	
	public Goblin(int x, int y, ID id) {
		super(x, y, id);
			
		velX = 1;
		velY = 0;
	}

	@Override
	public void tick() {
		x -= velX;
		y -= velY;
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x - 100, (int)y, 16, 16);
		
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}

}

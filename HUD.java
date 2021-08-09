package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HUD {
    
	private int score = 0;
	private Rectangle AlliedBar = new Rectangle(Game.getWidth1() / 30, (int) ( Game.getHeight1() * 0.58), (int) (Game.getWidth1()* 0.09), (int) ( Game.getHeight1() * 0.021 ));
	private Rectangle EnemyBar = new Rectangle((int) (Game.getWidth1() / 1.14), (int) ( Game.getHeight1() * 0.58) , (int) (Game.getWidth1()* 0.09), (int) ( Game.getHeight1() * 0.021 ));
	
	
	public void incrementScore() {	
		score++;
	}
	
	public void render(Graphics g) {
		this.renderTowerLifeBar(g);
		g.setColor(Color.black);
		g.drawString("Score : " + score, 15, 64);
		
		
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void renderTowerLifeBar(Graphics g) {
	    //Draw the life-bars of the towers
	    //Draw the life bar of the allied tower
	    g.setColor(Color.red);
            g.fillRect((int) this.AlliedBar.getX(), (int) this.AlliedBar.getY() , (int) this.AlliedBar.getWidth() , (int) this.AlliedBar.getHeight());
            //Draw a border
            g.setColor(Color.white);
            g.drawRect((int) this.AlliedBar.getX(), (int) this.AlliedBar.getY() , (int) this.AlliedBar.getWidth() , (int) this.AlliedBar.getHeight());
            //Draw the life bar of the enemy tower
            g.setColor(Color.red);
            g.fillRect((int) this.EnemyBar.getX(), (int) this.EnemyBar.getY() , (int) this.EnemyBar.getWidth() , (int) this.EnemyBar.getHeight());
            //Draw a border
            g.setColor(Color.white);
            g.drawRect((int) this.EnemyBar.getX(), (int) this.EnemyBar.getY() , (int) this.EnemyBar.getWidth() , (int) this.EnemyBar.getHeight());
	}
}

package model;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	public float health;
	private int score = 0;
	private int level = 1;
	
	
	public void tick() {	
		//health = Game.clamp(health, 0, 100);
		score++;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 30);
		g.setColor(new Color(100, 255, 0));
		g.fillRect(15, 15, (int)health * 2, 30);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);//border
		
		g.drawString("Score : " + score, 15, 64);
		g.drawString("Level : " + level, 15, 80);
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
}

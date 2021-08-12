package model;

import java.awt.*;
import java.awt.event.*;

public class StartMenu extends MouseAdapter{
	
	private Game game;
	private int xMouse; 
	private int yMouse;
	private int xPlayBtn, yPlayBtn, widthPlayBtn, heightPlayBtn;
	private int xMenuBtn, yMenuBtn, widthMenuBtn, heightMenuBtn;
	private int xQuitBtn, yQuitBtn, widthQuitBtn, heightQuitBtn;
	
	public StartMenu(Game game) {
		this.game = game;
		this.xPlayBtn = game.getWidth()/3;
		this.yPlayBtn = game.getHeight()/4;
		this.widthPlayBtn = game.getWidth()/3;
		this.heightPlayBtn = game.getHeight()/6;
		
		this.xMenuBtn = game.getWidth()/3;
		this.yMenuBtn = game.getHeight()/4 + game.getHeight()/4;
		this.widthMenuBtn = game.getWidth()/3;
		this.heightMenuBtn = game.getHeight()/6;
		
		this.xQuitBtn = game.getWidth()/3;
		this.yQuitBtn = game.getHeight()/4 + 2*(game.getHeight()/4);
		this.widthQuitBtn = game.getWidth()/3;
		this.heightQuitBtn = game.getHeight()/6;
	}

	public void mousePressed(MouseEvent e) {
		this.xMouse = e.getX();
		this.yMouse = e.getY();
		
		if(this.game.getState() == State.Menu) {
			if(check(this.xMouse, this.yMouse, this.xPlayBtn, this.yPlayBtn, this.widthPlayBtn, this.heightPlayBtn)) {
				this.game.setState(State.Game);
			}
		
			if(check(this.xMouse, this.yMouse, this.xQuitBtn, this.yQuitBtn, this.widthQuitBtn, this.heightQuitBtn)) {
				game.stop();
			}
		}
	}
	
	public void mouseRelased(MouseEvent e) {
		
	}
	
	private boolean check(int xMouse, int yMouse, int x, int y, int width, int height) {
		if(xMouse > x && xMouse < x + width) {
			if(yMouse > y && yMouse < y + height) {
				return true;
			}
		}		
		return false;
		
	}
	
	public void render(Graphics g) {
		Font font = new Font("Times New Roman", 1, 100);
		Font font2 = new Font("arial", 1, 50);
		
		g.setColor(Color.red);
		g.setFont(font);
		g.drawString("Menu", game.getWidth()/10 + 3*(game.getWidth()/10) , game.getHeight()/14 + game.getHeight()/14);
		
		g.setColor(Color.white);
		g.setFont(font2);
		g.drawRect(this.xPlayBtn, this.yPlayBtn, this.widthPlayBtn, this.heightPlayBtn);
		g.drawString("Play", game.getWidth()/128 + 57*(game.getWidth()/128), game.getHeight()/14 + 4*(game.getHeight()/14));
		//controlla width stringa
		
		g.drawRect(this.xMenuBtn, this.yMenuBtn, this.widthMenuBtn, this.heightMenuBtn);
		g.drawString("Menu", game.getWidth()/128 + 56*(game.getWidth()/128), game.getHeight()/15 + 8*(game.getHeight()/15));
		
		g.drawRect(this.xQuitBtn, this.yQuitBtn, this.widthQuitBtn, this.heightQuitBtn);
		g.drawString("Quit", game.getWidth()/128 + 57*(game.getWidth()/128), game.getHeight()/14 + 11*(game.getHeight()/14));
	}
	
}

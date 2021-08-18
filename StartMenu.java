package model;

import java.awt.*;
import java.awt.event.*;

public class StartMenu extends MouseAdapter{
	
	private Game game;
	private int xMouse; 
	private int yMouse;
	private int xPlayBtn, yPlayBtn, widthPlayBtn, heightPlayBtn;
	private int xTutorialBtn, yTutorialBtn, widthTutorialBtn, heightTutorialBtn;
	private int xQuitBtn, yQuitBtn, widthQuitBtn, heightQuitBtn;
	private int xDiffBtn, yDiffBtn, widthDiffBtn, heightDiffBtn;
	
	public StartMenu(Game game) {
		this.game = game;
		this.xPlayBtn = game.getWidth()/3;
		this.yPlayBtn = game.getHeight()/4;
		this.widthPlayBtn = game.getWidth()/3;
		this.heightPlayBtn = game.getHeight()/8;
		
		this.xDiffBtn = game.getWidth()/3;
		this.yDiffBtn = game.getHeight()/128 + 68*(game.getHeight()/128);
		this.widthDiffBtn = game.getWidth()/3;
		this.heightDiffBtn = game.getHeight()/8;
		
		this.xTutorialBtn = game.getWidth()/3;
		this.yTutorialBtn = game.getHeight()/128 + 96*(game.getHeight()/128);
		this.widthTutorialBtn = game.getWidth()/3;
		this.heightTutorialBtn = game.getHeight()/8;
		
		this.xQuitBtn = game.getWidth()/3;
		this.yQuitBtn = game.getHeight()/4 + 2*(game.getHeight()/4);
		this.widthQuitBtn = game.getWidth()/3;
		this.heightQuitBtn = game.getHeight()/8;
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
		Font font = new Font("Times New Roman", 1, 75);
		Font font2 = new Font("arial", 1, 25);
		
		g.setColor(Color.red);
		g.setFont(font);
		g.drawString("Menu", game.getWidth()/128 + 53*(game.getWidth()/128), game.getHeight()/128 + 30*(game.getHeight()/128));
		
		g.setColor(Color.white);
		g.setFont(font2);
		g.drawRect(this.xPlayBtn, this.yPlayBtn, this.widthPlayBtn, this.heightPlayBtn);
		g.drawString("Play", game.getWidth()/128 + 62*(game.getWidth()/128), game.getHeight()/128 + 54*(game.getHeight()/128));
		
		g.drawRect(this.xDiffBtn, this.yDiffBtn, this.widthDiffBtn, this.heightDiffBtn);
		g.drawString("Difficulty", game.getWidth()/128 + 58*(game.getWidth()/128), game.getHeight()/128 + 81*(game.getHeight()/128));
		
		g.drawRect(this.xTutorialBtn, this.yTutorialBtn, this.widthTutorialBtn, this.heightTutorialBtn);
		g.drawString("Tutorial", game.getWidth()/128 + 59*(game.getWidth()/128), game.getHeight()/128 + 109*(game.getHeight()/128));
		
		g.drawRect(this.xQuitBtn, this.yQuitBtn, this.widthQuitBtn, this.heightQuitBtn);
		g.drawString("Quit", game.getWidth()/128 + 62*(game.getWidth()/128), game.getHeight()/128 + 137*(game.getHeight()/128));
		
	}
	
}

package entity;

import model.Game;
import model.HUD;
import model.Handler;

public class Spawn {
	private Handler handler;
	private Game game;
	
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, Game game) {
		this.handler = handler;
		this.game = game;
	}
	
	public void tick() {
		scoreKeep++;
		
		if (scoreKeep >= 100) {
			scoreKeep = 0;
		//	hud.setLevel(hud.getLevel() + 1);
			handler.addObject(new Goblin(game.getWidth() - 64, game.getHeight() / 2, ID.Goblin, new HUD()));
		}
	}
}

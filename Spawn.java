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
			handler.addObject(new Goblin(game.getWidth() - 64, game.getHeight() / 2, ID.Goblin));
		}
		handler.addObject(new AlliedTower(Game.getWidth1() / 20, (int) (Game.getHeight1() / 2.55), ID.AlliedTower, new HUD()));
		handler.addObject(new Arch(Game.getWidth1() / 16, (int) (Game.getHeight1() / 3), ID.Arch));
		
//		System.out.println("larghezza nonstatic: " + game.getWidth() + "  larghezza static: " + Game.getWidth1());
//		System.out.println("altezza nonstatic: " + game.getHeight() + "  altezza static: " + Game.getHeight1());
//		game.getWidth() / 90, game.getHeight() / 2
	}
}

package model;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable{
	//
	private static final long serialVersionUID = -3269829814542667897L;
	//
	private static final int WIDTH = 1280;
	private static final int HEIGHT = WIDTH / 16 * 9;					//rapporto 16:9
	private static final String NAME = "StickWars";
	private boolean running = false;
	private BufferedImage sfondo;
	public State gameState = State.Menu;
	private Thread thread;
	
	public Game() {
		
		resLoader();
		this.running = true;
		new Window( WIDTH, HEIGHT, NAME, this);
		
		this.thread = new Thread(this);
		thread.start();
	}

	public static void main(String args[]) {
		
		new Game();
	}
	
	public void start() {
		this.running = true;
	}
	
	public void stop() {
		try {
			thread.join();
			this.running = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		while(this.running) {
			render();
		}
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(2);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		if(this.gameState == State.Menu ) {
			g.setColor(Color.black);
			g.fillRect(0, 0, WIDTH, HEIGHT);
		} else {
			g.drawImage(this.sfondo, 0, 0, WIDTH, HEIGHT, this);
		}
		g.dispose();
		bs.show();
	}
	
	private void resLoader() {
		
		ImageLoader loader = new ImageLoader();
		this.sfondo = loader.imageLoader("/immagini/land.png");
	}
	
}

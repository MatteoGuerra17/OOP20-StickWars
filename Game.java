package model;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import entity.Spawn;

public class Game extends Canvas implements Runnable{
	//
	private static final long serialVersionUID = -3269829814542667897L;
	//
	private final int width = 1280;
	private final int height = this.width / 16 * 9;					//rapporto 16:9
	private static final String NAME = "StickWars";
	private boolean running = false;
	private Image sfondo;
	public State gameState = State.Menu;
	private Thread thread;
	private Menu menu;
	private Spawn spawner;
	private Handler handler;
	
	public Game() {
		handler = new Handler();
		
		resLoader();
		new Window( this.width, this.height, NAME, this);
		
		spawner = new Spawn(handler, this);
		this.menu = new Menu(this);
		this.addMouseListener(menu);
	}
	
	public void start() {
		this.thread = new Thread(this);
		thread.start();
		this.running = true;
	}
	
	public void stop() {
		try {
			thread.join();
			this.running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
        this.requestFocus(); //don't have to click every time to have access to keyboard inputs
        long lastLoopTime = System.nanoTime();
        double amountOFTicks = 60.0;
        double ns = 1000000000 / amountOFTicks;
        long timer = System.currentTimeMillis();
        int frames = 0;
        double delta = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastLoopTime) / ns;
            lastLoopTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0; 
            }
        }
        stop();
    }
	
	private void tick() {
		if(this.gameState == State.Game ) {
			handler.tick();
			spawner.tick();
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
			g.fillRect(0, 0, this.width, this.height);
			menu.render(g);
			
		} else {
			g.clearRect(0,0, this.width, this.height);
			g.drawImage(this.sfondo, 0, 0, this.width, this.height, this);
			handler.render(g);
			
		}
		g.dispose();
		bs.show();	
	}
	
	private void resLoader() {	
		this.sfondo = new ImageIcon(this.getClass().getResource("/land.png")).getImage();
	}
	
	public float clamp(float value, float min, float max) {
		if (value >= max) {
			return max;
		}
		if (value <= min) {
			return min;
		}else {
			return value;
		}
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public State setState(State s) {
		return this.gameState = s;
	}
	
	public State getState() {
		return this.gameState;
	}
	
	public static void main(String args[]) {
		new Game();
	}
	
}

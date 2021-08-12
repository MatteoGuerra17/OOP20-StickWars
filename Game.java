package model;

import java.awt.*;
import java.awt.image.BufferStrategy;

import javax.swing.ImageIcon;

import entity.Spawn;

public class Game extends Canvas implements Runnable{
	//
	private static final long serialVersionUID = -3269829814542667897L;
	//
	final static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private final static int width = (int) screen.getWidth() * 3/4;
        private final static int height = width * 9 / 16;					//rapporto 16:9
	private static final String NAME = "StickWars";
	private boolean running = false;
	private Image sfondo;
	public State gameState = State.Menu;
	private Thread thread;
	private Menu menu;
	private Spawn spawner;
	private Handler handler;
	private HUD hud;
	
	public Game() {
		handler = new Handler();
		this.hud = new HUD();
		resLoader();
		new Window( Game.width, Game.height, NAME, this);
		
		this.spawner = new Spawn(handler, this);
		this.menu = new Menu(this);
		this.addMouseListener(menu);
	}

	public void start() {
		this.thread = new Thread(this);
		//System.out.println("alt: " + height + "  largh: " + width);
		thread.start();
		this.running = true;
	}
	
	public void stop() {
		try {
		        this.running = false;
		        thread.join();
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
			g.fillRect(0, 0, Game.width, Game.height);
			menu.render(g);
			
		} else {
			g.clearRect(0,0, Game.width, Game.height);
			g.drawImage(this.sfondo, 0, 0, Game.width, Game.height, this);
			handler.render(g);
			hud.render(g);
			
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
	
	public static int getWidth1() {
		return width;
	}
	
	public static int getHeight1() {
		return height;
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
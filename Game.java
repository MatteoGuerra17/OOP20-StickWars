package model;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.ImageIcon;

import entity.Spawn;

public class Game extends Canvas implements Runnable, MouseListener{
	//
	private static final long serialVersionUID = -3269829814542667897L;
	//
	final static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH = (int) screen.getWidth() * 3/4;
    public static final int HEIGHT = WIDTH * 9 / 16;					//rapporto 16:9
	private static final String NAME = "StickWars";
	private boolean running = false;
	private Image sfondo;
	public State gameState = State.StartMenu;
	private Thread thread;
	private StartMenu startMenu;
	private Menu menu;
	private Spawn spawner;
	private Handler handler;
	private HUD hud;
	private int xMouse, yMouse;
	private int x = 800;
	private int y = 50;
	private int width = 100;
	private int height = 50;
	
	public Game() {
		this.handler = new Handler();
		this.hud = new HUD();
		resLoader();
		new Window( WIDTH, HEIGHT, NAME, this);
		
		this.spawner = new Spawn(handler, this);
		this.startMenu = new StartMenu(this, NAME);
		this.addMouseListener(startMenu);
		this.menu = new Menu(this.x, this.y, this.width, this.height);
		this.addMouseListener(this);
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
            System.exit(1);
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
			return ;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		if(this.gameState == State.StartMenu ) {
			
			g.setColor(Color.black);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			this.startMenu.render(g);
			
		} else if(this.gameState == State.Menu){
			
			g.clearRect(0,0, WIDTH, HEIGHT);
			g.setColor(Color.cyan);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			this.menu.render(g);
			
		} else {
			
			g.clearRect(0,0, WIDTH, HEIGHT);
			g.drawImage(this.sfondo, 0, 0, WIDTH, HEIGHT, this);
			this.handler.render(g);
			this.hud.render(g);
			this.menu.button(g);
			
		}
		g.dispose();
		bs.show();	
	}
	
	private void resLoader() {
		
		this.sfondo = new ImageIcon(this.getClass().getResource("/land.jpg")).getImage();
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
		
	public State setState(State s) {
		return this.gameState = s;
	}
	
	public State getState() {
		return this.gameState;
	}
	
	public static void main(String args[]) {
		new Game();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.xMouse = e.getX();
		this.yMouse = e.getY();
		
		if(this.check(xMouse, yMouse, this.x, this.y, this.width, this.height)) {
			this.setState(State.Menu);
		}
	}
	
	private boolean check(int xM, int yM, int x, int y, int width, int height) {
		if(xM > x && xM < x + width) {
			if(yM > y && yM < y + height) {
				return true;
			}
		}		
		return false;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	
}
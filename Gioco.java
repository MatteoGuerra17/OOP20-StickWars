package model;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JFrame;

public class Gioco extends Canvas implements Runnable{
	//
	private static final long serialVersionUID = -3269829814542667897L;
	//
	private static final int WIDTH = 1280;
	private static final int HEIGHT = WIDTH / 16 * 9;					//rapporto 16:9
	private static final String NAME = "StickWars";
	private boolean running = false;
	private BufferedImage sfondo;
	
	public Gioco() {
		
		resLoader();
		this.running = true;
		new Window( WIDTH, HEIGHT, NAME, this);
	}

	public static void main(String args[]) {
		
		Gioco gioco = new Gioco();
		
		Thread thread = new Thread(gioco);
		thread.start();
		
	}
	
	public void run() {
		while(this.running) {
			render();
		}
	}
	
	public void render() {
		Graphics g = this.getGraphics();
		g.drawImage(this.sfondo, 0, 0, WIDTH, HEIGHT, this);
		
		g.dispose();
	}
	
	private void resLoader() {
		
		ImageLoader loader = new ImageLoader();
		this.sfondo = loader.imageLoader("/immagini/land.png");
	}
	
}

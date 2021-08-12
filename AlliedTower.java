package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

//import model.Difficulty;
import model.Game;
import model.HUD;
//import model.Menu;
import model.GameObject;

public class AlliedTower extends GameObject{
   
    private Rectangle bounds = new Rectangle(Game.getWidth1() / 20, (int) (Game.getHeight1() / 2.55), Game.getWidth1() / 17 , (int) (Game.getHeight1() / 5.8));
    private float lifePoints = 10_000;
    
    
    public AlliedTower(float x, float y, ID id, HUD hud) {
        super(x, y, id);
//        if (menu.getDifficulty().equals(Difficulty.Normal)) {
//            this.lifePoints = (int) (this.lifePoints * 0.9);
//        } else if (menu.getDifficulty().equals(Difficulty.Hard)) {
//            this.lifePoints = (int) (this.lifePoints * 0.8);
//        }
    }

    @Override
    public void tick() {
//        if (this.lifePoints <= this.lifePoints / 3) {
//            
//        }
    }


    @Override
    public void render(Graphics g) {
        
        //
        g.setColor(Color.blue);
        g.fillRect((int) this.bounds.getX(), (int) this.bounds.getY(), (int) this.bounds.getWidth(), (int) this.bounds.getHeight());
    }


    @Override
    public Rectangle getBounds() {
        return this.bounds;
    }
    
    public float getLifePoints() {
        return this.lifePoints;
    }
}

package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import model.GameObject;

public class Arch extends GameObject{
    
    private Rectangle position;
    
    public Arch(float x, float y, ID id) {
        super(x, y, id);
        this.position = new Rectangle((int) x, (int) y, 0, 0);
        
    }

    @Override
    public void tick() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int) this.position.getX(), (int) this.position.getY(), 50, 50 );
        
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}

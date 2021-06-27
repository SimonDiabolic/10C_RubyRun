package game;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public abstract class BewegtesObjekt
{
    protected int x;
    protected int y;
    protected int oldx;
    protected int oldy;
    protected BufferedImage look;
    BewegtesObjekt (int x, int y)
    {
        this.x = x * Textur.kachelgroesse;
        this.y = y * Textur.kachelgroesse;
        
    }
    public int getX() { return x; }
    public int getY() { return y; }
    public void update()
    {  
      
    }
    public void resetPosition()
    {
     // x=oldx;
     y=oldy;
    }
    public boolean RubinCollection(){return false;}
    public void fallen(){y = y + Textur.kachelgroesse;}
        public void draw(Graphics g)
    {
     g.drawImage(look, x, y, null);
    }
}

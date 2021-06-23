package game;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public abstract class BewegtesObjekt
{
    protected int x;
    protected int y;
    protected BufferedImage look;
    BewegtesObjekt (int x, int y)
    {
        this.x = x * Textur.kachelgroesse;
        this.y = y * Textur.kachelgroesse;
        
    }
        public void draw(Graphics g)
    {
     g.drawImage(look, x, y, null);
    }
}

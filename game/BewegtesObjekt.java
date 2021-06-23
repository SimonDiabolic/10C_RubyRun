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
    public int getX() { return x; }
    public int getY() { return y; }
    public void update()
    {

    
      if(Welt.kacheln[getX()/Textur.kachelgroesse] [(getY()/Textur.kachelgroesse)+1].getLookID() == 0 )
        {
            y = y + Textur.kachelgroesse;
        }   
    }
    public boolean RubinCollection(){return false;}
        public void draw(Graphics g)
    {
     g.drawImage(look, x, y, null);
    }
}

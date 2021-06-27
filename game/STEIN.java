package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class STEIN extends BEWEGTESOBJEKT
{
    STEIN (int x, int y)
    {
        super(x,y);
        look = TEXTUR.stein;
    }
    public void update()
    {
        if(COLLISION.RechteckZuRechteck(SPIELER.getXPos(),SPIELER.getYPos(),10,10,x,y,10,10))
        {
            if(WELT.kacheln[x/TEXTUR.kachelgroesse + SPIELER.getDirection()][y/TEXTUR.kachelgroesse].getLookID()==0 && SPIELER.getDirection() != 0)
              {
                  
                  x = x + SPIELER.getDirection()*TEXTUR.kachelgroesse;
                  
              }
            else
            {
              SPIELER.resetPosition();
            }            
        }
        super.update();
        
    }
    public void draw(Graphics g)
    {
     g.drawImage(look, x, y, null);
    }
    public int getSteinX() { return x; }
    public int getSteinY() { return y; }
}


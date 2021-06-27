package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Stein extends BEWEGTESOBJEKT
{
    Stein (int x, int y)
    {
        super(x,y);
        look = TEXTUR.stein;
    }
    public void update()
    {
        if(Collision.RechteckZuRechteck(Spieler.getXPos(),Spieler.getYPos(),10,10,x,y,10,10))
        {
            if(WELT.kacheln[x/TEXTUR.kachelgroesse + Spieler.getDirection()][y/TEXTUR.kachelgroesse].getLookID()==0 && Spieler.getDirection() != 0)
            {
              x = x + Spieler.getDirection()*TEXTUR.kachelgroesse;
            }
            else
            {
              Spieler.resetPosition();
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


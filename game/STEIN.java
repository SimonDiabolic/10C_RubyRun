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
                  int nextx = x + (SPIELER.getDirection() * TEXTUR.kachelgroesse);
                  int nexty = y;
                  if(WELT.kacheln[nextx/TEXTUR.kachelgroesse] [nexty/TEXTUR.kachelgroesse].getLookID() == 0 )
                  {
                      boolean moveok = true;
                      for (BEWEGTESOBJEKT i : other) 
                      {
                          if (nextx / TEXTUR.kachelgroesse == i.getX() / TEXTUR.kachelgroesse && nexty / TEXTUR.kachelgroesse == i.getY() / TEXTUR.kachelgroesse) 
                          {
                              moveok = false;
                              
                          }
                      }
                      if (moveok)
                      {
                          x = x + (SPIELER.getDirection() * TEXTUR.kachelgroesse);
                      }
                      else
                      {
                          SPIELER.resetPosition();
                      }
                  
                  }
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
    public int getX() { return x; }
    public int getY() { return y; }
    public boolean SpielerAufStein()
    {
     return (getX()==SPIELER.getXPos()) && (getY()==SPIELER.getYPos());
    }
}


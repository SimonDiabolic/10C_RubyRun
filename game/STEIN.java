package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class STEIN extends BEWEGTESOBJEKT
{
    BEWEGTESOBJEKT SteinaufSchlange;
    STEIN (int x, int y)
    {
        super(x,y);
        look = TEXTUR.stein;
        SteinaufSchlange = null;
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
        SteinaufSchlange = null;
        int nextx = x / TEXTUR.kachelgroesse ;
        int nexty = y / TEXTUR.kachelgroesse + 1;
        if(WELT.kacheln[nextx] [nexty].getLookID() == 0 )
        {
            boolean moveok = true;
            for (BEWEGTESOBJEKT i : other) {
                if (nextx == i.getX() / TEXTUR.kachelgroesse && 
                    nexty == i.getY() / TEXTUR.kachelgroesse) {
                    if (i.isteseineSchlange() == false)
                    {
                        moveok = false;
                    }
                    else 
                    {
                        SteinaufSchlange = i;
                        
                    }
                }
            }
            
            if (moveok)
                y = y+20;//nexty * Textur.kachelgroesse;
           
            }
        
    }
    public BEWEGTESOBJEKT SteinAufSchlange()
    {
        return SteinaufSchlange;
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


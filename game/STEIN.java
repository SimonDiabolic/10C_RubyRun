package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;

public class STEIN extends BEWEGTESOBJEKT
{
BEWEGTESOBJEKT SteinaufSchlange;
private boolean justVerschoben;

STEIN (int x, int y)
{
super(x,y);
type = 's';
look = TEXTUR.stein;
SteinaufSchlange = null;

}
public void update()
{
         //Steineverschieben
         if(COLLISION.RechteckZuRechteck(SPIELER.getXPos(),SPIELER.getYPos(),10,10,x,y,10,10))
         {
                int nextx = x + (SPIELER.getDirectionX() * TEXTUR.kachelgroesse);
                int nexty = y;
              if(WELT.kacheln[nextx/TEXTUR.kachelgroesse] [nexty/TEXTUR.kachelgroesse].getLookID() == 0 || 
                    WELT.kacheln[nextx/TEXTUR.kachelgroesse] [nexty/TEXTUR.kachelgroesse].getLookID() == 2 ||
                    WELT.kacheln[nextx/TEXTUR.kachelgroesse] [nexty/TEXTUR.kachelgroesse].getLookID() == 5 ||
                    WELT.kacheln[nextx/TEXTUR.kachelgroesse] [nexty/TEXTUR.kachelgroesse].getLookID() == 6 )
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
                          x = x + (SPIELER.getDirectionX() * TEXTUR.kachelgroesse);
                          justVerschoben = true;
                      }
                      else
                      {
                          SPIELER.resetPosition();
                      }
                  
                 }
                 else {SPIELER.resetPosition();}
            }         
        
      
            SteinaufSchlange = null;
            int nextx = x / TEXTUR.kachelgroesse ;
            int nexty = y / TEXTUR.kachelgroesse + 1;
            int SpielerUnterStein = 0;
            if(WELT.kacheln[nextx] [nexty].getLookID() == 0 || 
            WELT.kacheln[nextx/TEXTUR.kachelgroesse] [nexty/TEXTUR.kachelgroesse].getLookID() == 2 ||
            WELT.kacheln[nextx/TEXTUR.kachelgroesse] [nexty/TEXTUR.kachelgroesse].getLookID() == 5 ||
            WELT.kacheln[nextx/TEXTUR.kachelgroesse] [nexty/TEXTUR.kachelgroesse].getLookID() == 6)
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
            if(SPIELER.getXPos() == x && SPIELER.getYPos() == y+TEXTUR.kachelgroesse) SpielerUnterStein = 1;
            if(SpielerUnterStein != 0)
            {
                moveok = false;
                Timer timer = new Timer();
                timer.schedule(new TimerTask(){
                    public void run()
                     {
                        if(SPIELER.getXPos() == x && SPIELER.getYPos() == y+TEXTUR.kachelgroesse)
                        {
                        y = y+20;
                        y = y+20;
                    }
                    }
                },1000);
            }
            if (moveok)
                   y = y+20;
            if(WELT.kacheln[x/TEXTUR.kachelgroesse] [y/TEXTUR.kachelgroesse].getLookID() == 5)
            {
                x = WELT.telex*TEXTUR.kachelgroesse;  
                y = WELT.teley*TEXTUR.kachelgroesse;  
            }
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


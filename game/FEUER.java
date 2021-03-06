package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
public class FEUER extends BEWEGTESOBJEKT
{
    int bewegungsrichtung;
    char coodaxis;
    int startpunktx;
    int startpunkty;
    FEUER (int x,int y, char coodaxis)
    {
        super(x,y);
        this.coodaxis = coodaxis;
        look = TEXTUR.feuer;
        bewegungsrichtung = 1;
        startpunktx = x * TEXTUR.kachelgroesse;
        startpunkty = y * TEXTUR.kachelgroesse;
    }
    public void update()
        {   
            FeuerBewegung();
        }
    public void draw(Graphics g)
        {
         g.drawImage(look, x, y, null);
        }
    public int getFeuerX() { return x; }
    public int getFeuerY() { return y; }
    public void Warten()
    {
        
    }
    public void FeuerBewegung()
    {
      
        if (coodaxis == 'x')
        {int nextx = x / TEXTUR.kachelgroesse + bewegungsrichtung;
        int nexty = y / TEXTUR.kachelgroesse ;   
        if(bewegungsrichtung == -1 && x % TEXTUR.kachelgroesse != 0)
        {nextx++;}
        boolean moveok = false;
        if(WELT.kacheln[nextx] [nexty].getLookID() == 0)
            {
                moveok = true;
               for (BEWEGTESOBJEKT i : other) {
                    if (nextx == i.getX()/TEXTUR.kachelgroesse && 
                        nexty == i.getY()/TEXTUR.kachelgroesse && this != i)  {
                        moveok = false;
                    }
                }
               if (bewegungsrichtung == 1 && x >= startpunktx + 80) {
                   moveok = false;
                }
               if (bewegungsrichtung == -1 && x <= startpunktx - 80) {
                   moveok = false;
                }
            }
        if(moveok)
            {x = x + 10*bewegungsrichtung;}
            else
            {bewegungsrichtung = bewegungsrichtung*-1;}
        }
        if (coodaxis == 'y')
        {
        int nextx = x / TEXTUR.kachelgroesse ;
        int nexty = y / TEXTUR.kachelgroesse + bewegungsrichtung;
        if(bewegungsrichtung == -1 && y % TEXTUR.kachelgroesse != 0)
        {
            nexty++;
        }
        boolean moveok = false;
        if(WELT.kacheln[nextx] [nexty].getLookID() == 0 )
            {
                moveok = true;
                for (BEWEGTESOBJEKT i : other) {
                    if (nextx == i.getX()/TEXTUR.kachelgroesse && 
                        nexty == i.getY()/TEXTUR.kachelgroesse && this != i)  {
                        moveok = false;
                    }
                }             
               if (bewegungsrichtung == 1 && y >= startpunkty + 80) {
                   moveok = false;
                }
               if (bewegungsrichtung == -1 && y <= startpunkty - 80) {
                   moveok = false;
                }} 
        if(moveok)
            { y = y + 10*bewegungsrichtung;}
            else
            {bewegungsrichtung = bewegungsrichtung*-1;}
        }
        /**if (x==startpunktx&&y==startpunkty)
        {
            try
            {
                TimeUnit.SECONDS.sleep(2);
            }
            catch (java.lang.InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }**/
    }
    
    public boolean SpielerAufFeuer()
        {
         if (COLLISION.RechteckZuRechteck(SPIELER.getXPos(),SPIELER.getYPos(),10,10,x,y,10,10))
            {return true;}
            else
            {return false;}
        }
}

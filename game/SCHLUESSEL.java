package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.LinkedList;

public class SCHLUESSEL extends BEWEGTESOBJEKT
{
  SCHLUESSEL (int x, int y)
  {
      super(x,y);
      look = TEXTUR.key;
        
   }
  public void update()
   {
       super.update();
  }
  public void draw(Graphics g)
  {
   g.drawImage(look, x, y, null);
  }
  public int getRubinX() { return x; }
  public int getRubinY() { return y; }
  public boolean SchluesselCollection()
   {
       if (COLLISION.RechteckZuRechteck(SPIELER.getXPos(),SPIELER.getYPos(),10,10,x,y,10,10))
       {
          return true;
      }
      else
       {
           return false;
       }
   }
}


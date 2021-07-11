package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.LinkedList;

public class RUBIN extends BEWEGTESOBJEKT
{
    RUBIN (int x, int y, boolean BossLevel)
    {
        super(x,y);
          if (BossLevel) look = TEXTUR.RubinBoss;
            else look = TEXTUR.rubin;
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
    public boolean RubinCollection()
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


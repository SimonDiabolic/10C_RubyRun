package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.LinkedList;

public class RUBIN extends BEWEGTESOBJEKT
{
    RUBIN (int x, int y)
    {
        super(x,y);
        look = TEXTUR.rubin;
        
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
        if ((getX()==SPIELER.getXPos()) && (getY()==SPIELER.getYPos()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}


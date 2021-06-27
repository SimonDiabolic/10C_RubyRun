package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.LinkedList;

public class Rubin extends BewegtesObjekt
{
    Rubin (int x, int y)
    {
        super(x,y);
        look = Textur.rubin;
        
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
        if ((getX()==Spieler.getXPos()) && (getY()==Spieler.getYPos()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}


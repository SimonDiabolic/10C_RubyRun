package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.LinkedList;

public class BUSCH extends BEWEGTESOBJEKT
{
    BUSCH (int x, int y)
    {
        super(x,y);
        look = TEXTUR.busch;
        
    }
    public void update()
    {
        
    }
    public void draw(Graphics g)
    {
     g.drawImage(look, x, y, null);
    }
    public int getBuschX() { return x; }
    public int getBuschY() { return y; }
    public boolean BuschDecay()
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


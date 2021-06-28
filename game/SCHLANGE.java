package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.LinkedList;

public class SCHLANGE extends BEWEGTESOBJEKT
{
    private int direction;
    SCHLANGE (int x, int y)
    {
        super(x,y);
        direction = 1;
        look = TEXTUR.schlange;
        
    }
    public void update()
    {   
        
    }
    public void draw(Graphics g)
    {
     g.drawImage(look, x, y, null);
    }
    public int getSchlangeX() { return x; }
    public int getSchlangeY() { return y; }
    public boolean SchlangeSchlaegtSpieler()
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


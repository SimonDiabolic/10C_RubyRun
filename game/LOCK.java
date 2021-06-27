package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class LOCK
{
    private BufferedImage look;
    public int x;
    public int y;
    
    LOCK(int lockx, int locky)
    {
        this.x = lockx;
        this.y = locky;
        look = IMAGELOADER.loadImage("AusgangZu");
    }
    public boolean SpielerAufSchloss()
    {
        if ((x==SPIELER.getXPos()) && (y==SPIELER.getYPos()))
        {
            return true;  
        }
        else
        {
            return false;
        }
    }
     public int getXPos()
    {
     return x;
    }
    public int getYPos()
    {
     return y;
    }
    public void draw(Graphics g)
    {
     g.drawImage(look, x, y, null);
    }
}
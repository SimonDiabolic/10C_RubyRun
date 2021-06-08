package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Lock
{
    private BufferedImage look;
    public int x;
    public int y;
    
    Lock(int lockx, int locky)
    {
        this.x = lockx;
        this.y = locky;
        look = Imageloader.loadImage("AusgangZu");
    }
    public boolean SpielerAufSchloss()
    {
        if ((x==Spieler.getXPos()) && (y==Spieler.getYPos()))
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
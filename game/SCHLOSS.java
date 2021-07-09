package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class SCHLOSS
{
    private BufferedImage look;
    public int x;
    public int y;
    
    SCHLOSS (int x, int y)
    {
        this.x = x;
        this.y = y;
        look = TEXTUR.keySchlossZu;
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

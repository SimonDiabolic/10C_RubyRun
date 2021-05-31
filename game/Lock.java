package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Lock
{
    private BufferedImage look;
    public static int x;
    public static int y;
    static boolean playeraufexit;
    
    Lock(int x, int y)
    {
        this.x = x;
        this.y = y;
        look = Imageloader.loadImage("AusgangZu");
    }
    public void draw(Graphics g)
    {
     g.drawImage(look, x, y, null);
    }
}
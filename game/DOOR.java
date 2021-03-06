package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class DOOR
{
    private BufferedImage look;
    public int x;
    public int y;
    
    DOOR(int doorx, int doory)
    {
        this.x = doorx;
        this.y = doory;
        look = TEXTUR.keyDoor;
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
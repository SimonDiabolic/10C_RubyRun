package game;
//---------------------//
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.FontMetrics;
import java.awt.Color;

//---------------------//
public class HERZ
{
    private int x,y;
    private BufferedImage[] look;
    public int HerzZustand;
    public HERZ(int x, int y, BufferedImage[] look)
    {
        this.y = y;
        this.x = x;
        this.look = look;
    }
    public void draw(Graphics g)
    {
        g.drawImage(look[HerzZustand], x, y, null);
    }
}

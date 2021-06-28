package game;
//---------------------//
import java.awt.image.BufferedImage;
import java.awt.Graphics;

//---------------------//
public class UIBOTTOM
{
    private int x;
    private int y;
    private BufferedImage look;
    
    
    public UIBOTTOM(int x, int y)
    {
        this.x = x; 
        this.y = y;
        look = TEXTUR.bar;
    }
    public void draw(Graphics g)
    {
        g.drawImage(look, x, y, null);
    }
}

package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Stein
{
    private BufferedImage look;
    public int steinposx;
    public int steinposy;

    boolean dropISvalid;

    
    Stein (int steinposx, int steinposy)
    {
        this.steinposx = steinposx * Textur.kachelgroesse;
        this.steinposy = steinposy * Textur.kachelgroesse;
        look = Imageloader.loadImage("stein");
        
    }
    public boolean update()
    {
     return false;
    }
    public void draw(Graphics g)
    {
     g.drawImage(look, steinposx, steinposy, null);
    }
    public int getSteinX() { return steinposx; }
    public int getSteinY() { return steinposy; }
    public boolean SteinSpielerColision()
    {
        if ((steinposx==Spieler.getXPos()) && (steinposy==Spieler.getYPos()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}


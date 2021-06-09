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
    public void update()
    {
        if (Welt.kacheln[steinposx/Textur.kachelgroesse][steinposy/Textur.kachelgroesse+1].getLookID()==0)
        {
            steinposy = steinposy + 10;
        }
    }
    public void move ()
    {
        
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


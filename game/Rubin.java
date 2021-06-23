package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Rubin extends BewegtesObjekt
{
    Rubin (int x, int y)
    {
        super(x,y);
        look = Imageloader.loadImage("rubin");
        
    }
    public boolean RubinCollection()
    {
        if ((getX()==Spieler.getXPos()) && (getY()==Spieler.getYPos()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}


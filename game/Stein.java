package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Stein extends BewegtesObjekt
{
    Stein (int x, int y)
    {
        super(x,y);
        look = Imageloader.loadImage("stein");
    }
    public void update()
    {
        if(Collision.RechteckZuRechteck(Spieler.getXPos(),Spieler.getYPos(),0,0,x,y,0,0))
        {
            if(Welt.kacheln[x/Textur.kachelgroesse + Spieler.getDirection()][y/Textur.kachelgroesse].getLookID()==0 && Spieler.getDirection() != 0)
              {
                  x = x + Spieler.getDirection()*Textur.kachelgroesse;
              }
            else
            {
              Spieler.resetPosition();
            }
            
        }
    }
    public void move ()
    {
        
    }

    public boolean SteinSpielerColision()
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
}


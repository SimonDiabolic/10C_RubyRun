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
        if(Collision.RechteckZuRechteck(Spieler.getXPos(),Spieler.getYPos(),1,1,x,y,1,1))
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
        if (Welt.kacheln[x/Textur.kachelgroesse][y/Textur.kachelgroesse+1].getLookID()==0)
        {
            y = y + Textur.kachelgroesse/2;
        }
    }
    public void draw(Graphics g)
    {
     g.drawImage(look, x, y, null);
    }
    public int getSteinX() { return x; }
    public int getSteinY() { return y; }
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


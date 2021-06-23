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
    public void update()
    {
     if(Welt.kacheln[getRubinX()/Textur.kachelgroesse] [(getRubinY()/Textur.kachelgroesse)+1].getLookID() == 0 )      
     {   
         if (!((getRubinX()==getRubinX()) && (getRubinY()==getRubinY()+1)))
             {
                 y = y + Textur.kachelgroesse;
             }
     }
     
    }
    public void draw(Graphics g)
    {
     g.drawImage(look, x, y, null);
    }
    public int getRubinX() { return x; }
    public int getRubinY() { return y; }
    public boolean RubinCollection()
    {
        if ((getRubinX()==Spieler.getXPos()) && (getRubinY()==Spieler.getYPos()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}


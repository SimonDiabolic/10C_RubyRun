package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Rubin
{
    private BufferedImage look;
    public int rubinposx;
    public int rubinposy;

    boolean dropISvalid;

    
    Rubin (int rubinposx, int rubinposy)
    {
        this.rubinposx = rubinposx * Textur.kachelgroesse;
        this.rubinposy = rubinposy * Textur.kachelgroesse;
        look = Imageloader.loadImage("rubin");
        
    }
    public boolean update()
    {
     // int rubinPositionX = (int) (getRubinX())/Textur.kachelgroesse;
     // int rubinPositionY= (int) ((getRubinY())/Textur.kachelgroesse)+1;
     // if(Welt.kacheln[rubinPositionX] [rubinPositionY].getLookID() == 0)      
     // {   
         // rubinposy = rubinposy + Textur.kachelgroesse;
     // }
     // if(Welt.kacheln[rubinPositionX] [rubinPositionY].getLookID() == 2)      
     // {    
         // rubinposy = rubinposy + Textur.kachelgroesse;
     // }
     // if(Welt.kacheln[rubinPositionX] [rubinPositionY].getLookID() == 4)      
     // {
         // rubinposy = rubinposy + Textur.kachelgroesse;
     // }
     return false;
     
    }
    public void draw(Graphics g)
    {
     g.drawImage(look, rubinposx, rubinposy, null);
    }
    public int getRubinX() { return rubinposx; }
    public int getRubinY() { return rubinposy; }
    public boolean RubinCollection()
    {
        if ((rubinposx==Spieler.getXPos()) && (rubinposy==Spieler.getYPos()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}


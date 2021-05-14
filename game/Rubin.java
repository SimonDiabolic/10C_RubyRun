package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Rubin
{
    private BufferedImage look;
    public static int rubinX;
    public static int rubinY;

    static boolean spieleraufrubin;
    public static int punkte;

    static boolean dropISvalid;

    Rubin (int rubinX, int rubinY)
    {
        this.rubinX = rubinX;
        this.rubinY = rubinY;
        look = Imageloader.loadImage("rubin");

        punkte = 0;
    }
        public boolean update(/*boolean freierFall*/)
    {
     int rubinPositionX = (int) (Rubin.getRubinX())/Textur.kachelgroesse;
     int rubinPositionY= (int) ((Rubin.getRubinY())/Textur.kachelgroesse)+1;
     if(Welt.kacheln[rubinPositionX] [rubinPositionY].getLookID() == 0) return true;     
     if(Welt.kacheln[rubinPositionX] [rubinPositionY].getLookID() == 2)  return true;    
     if(Welt.kacheln[rubinPositionX] [rubinPositionY].getLookID() == 4)  return true;    

        
        // if (freierFall)
        // {
            // rubinY = rubinY + Textur.kachelgroesse;
        // }
        return false;
 
    }
    public void draw(Graphics g)
    {
     g.drawImage(look, (int) rubinX, (int) rubinY, null);
    }
    
    
    
    
    public static int getRubinX() { return rubinX; }
    public static int getRubinY() { return rubinY; }
    public static void SpielerAufRubin()
    {
        if ((rubinX==Spieler.x) && (rubinY==Spieler.y))
        {
            spieleraufrubin = true;
        }
    }
    public static void Aufsammeln()
    {
        if (spieleraufrubin = true)
        {
            punkte = punkte + 1;
        }
    }
    
}


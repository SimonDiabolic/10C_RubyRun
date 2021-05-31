package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Rubin
{
    private BufferedImage look;
    public static int rubinposx;
    public static int rubinposy;

    static boolean spieleraufrubin;
    public static int punkte;

    static boolean dropISvalid;

    
    Rubin (int rubinposx, int rubinposy)
    {
        this.rubinposx = rubinposx;
        this.rubinposy = rubinposy;
        look = Imageloader.loadImage("rubin");
        
        spieleraufrubin = false;
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
            // rubinposy = rubinposy + Textur.kachelgroesse;
        // }
        return false;
     
    }
    public void draw(Graphics g)
    {
     g.drawImage(look, rubinposx, rubinposy, null);
    }
    public static int getRubinX() { return rubinposx; }
    public static int getRubinY() { return rubinposy; }
    public static void RubinCollection()
    {
        if ((rubinposx==Spieler.getXPos()) && (rubinposy==Spieler.getYPos()))
        {
            Tango();
            System.out.println("TANGO!");
            // Welt.Ronnie = null;
        }
        else
        {
            spieleraufrubin = false;
        }
    }
    public static void Tango()
    {           
            punkte = punkte + 1;
            
            System.out.println(punkte);
            
    }
}


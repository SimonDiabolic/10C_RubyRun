package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Rubin
{
    private BufferedImage rubin;
    public static int rubinX;
    public static int rubinY;
    static boolean spieleraufrubin;
    public static int punkte;
    Rubin (int rubinX, int rubinY)
    {
        this.rubinX = rubinX;
        this.rubinY = rubinY;
        rubin = Imageloader.loadImage("rubin");
        punkte = 0;
    }
    public void draw(Graphics g)
    {
     g.drawImage(rubin, (int) rubinX, (int) rubinY, null);
    }
      public static int getRubinX ()
    {
       return rubinX; 
    }
    public static int getRubinY ()
    {
       return rubinY; 
    }
    public static void RubinFall(boolean freierFall)
    {
        if (freierFall)
        {
            
            rubinY = rubinY + Textur.kachelgroesse;
        }
    }
    public static void resetPosition()
    {
     rubinY= rubinY-Textur.kachelgroesse;
    }
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


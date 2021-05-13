package game;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Rubin
{
    private BufferedImage rubin;
    public static int rubinX;
    public static int rubinY;
    static boolean dropISvalid;
    Rubin (int rubinX, int rubinY)
    {
        this.rubinX = rubinX;
        this.rubinY = rubinY;
        rubin = Imageloader.loadImage("rubin");
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
}


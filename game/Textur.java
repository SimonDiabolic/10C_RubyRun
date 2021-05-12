package game;
//---------------------//
import java.awt.image.BufferedImage;
//---------------------//

public class Textur
{
    static BufferedImage ranke = Imageloader.loadImage("rankeHintergrund");
    static BufferedImage wandFuellelement = Imageloader.loadImage("wandFuellelement");
    
    static int kachelgroesse = ranke.getHeight();
    public static         void main(String[] args)
    {
        System.out.println(kachelgroesse);
    }
}
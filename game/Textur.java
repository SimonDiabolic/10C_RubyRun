package game;
//---------------------//
import java.awt.image.BufferedImage;
//---------------------//

public class Textur
{
    static BufferedImage ranke = Imageloader.loadImage("rankeHintergrund");
    static BufferedImage wandFuellelement = Imageloader.loadImage("wandFuellelement");
    static BufferedImage rubin = Imageloader.loadImage("rubin");
    static BufferedImage spawn = Imageloader.loadImage("spawn");
    
    static int kachelgroesse = ranke.getHeight();
    public static         void main(String[] args)
    {
        System.out.println(kachelgroesse);
    }
}

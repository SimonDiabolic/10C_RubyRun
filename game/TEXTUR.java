package game;
//---------------------//
import java.awt.image.BufferedImage;
//---------------------//
/**
 * Läd die Texturen aus dem gfx package und weißt ihnen Attributnamen zu
 */
public class TEXTUR
{
    public static BufferedImage ranke = IMAGELOADER.loadImage("rankeHintergrund");
    public static BufferedImage wandFuellelement = IMAGELOADER.loadImage("wandFuellelement");
    public static BufferedImage rubin = IMAGELOADER.loadImage("rubin");
    public static BufferedImage spawn = IMAGELOADER.loadImage("spawn");
    public static BufferedImage stein = IMAGELOADER.loadImage("stein");
    public static BufferedImage AusgangZU = IMAGELOADER.loadImage("AusgangZU");
    public static BufferedImage AusgangAUF = IMAGELOADER.loadImage("AusgangAUF");
    public static BufferedImage background = IMAGELOADER.loadImage("background");
    public static BufferedImage titel = IMAGELOADER.loadImage("titel");
    public static BufferedImage button = IMAGELOADER.loadImage("button");
    public static BufferedImage buttonmouseover = IMAGELOADER.loadImage("buttonmaus");
    public static BufferedImage buttonpressed = IMAGELOADER.loadImage("buttonpressed");
    public static BufferedImage bar = IMAGELOADER.loadImage("bar");
    public static BufferedImage busch = IMAGELOADER.loadImage("Busch");
    public static BufferedImage saphir = IMAGELOADER.loadImage("saphir");
    public static BufferedImage schlange = IMAGELOADER.loadImage("schlange");
    public static BufferedImage hr = IMAGELOADER.loadImage("Herzrot");
    public static BufferedImage hs = IMAGELOADER.loadImage("Herzschwarz");
    public static BufferedImage map = IMAGELOADER.loadImage("map");
    public static BufferedImage x1 = IMAGELOADER.loadImage("x1");
    public static BufferedImage x2 = IMAGELOADER.loadImage("x2");
    public static BufferedImage next = IMAGELOADER.loadImage("next");
    public static BufferedImage next1 = IMAGELOADER.loadImage("next1");
    public static BufferedImage retry = IMAGELOADER.loadImage("retry");
    public static BufferedImage retry1 = IMAGELOADER.loadImage("retry1");
    /*
     * Gibt die Kachelgröße, gemessen an der Höhe des Kachelbildes aus
     */  
    static int kachelgroesse = ranke.getHeight();  
    // Methode zur Ausgabe der Kachelgröße in der Konsole:
    public static void main(String[] args)
    {
        System.out.println(kachelgroesse);
    }
}

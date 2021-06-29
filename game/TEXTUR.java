package game;
//---------------------//
import java.awt.image.BufferedImage;
//---------------------//
/**
 * Läd die Texturen aus dem gfx package und weißt ihnen Attributnamen zu
 */
public class TEXTUR
{
     static BufferedImage ranke = IMAGELOADER.loadImage("rankeHintergrund");
     static BufferedImage wandFuellelement = IMAGELOADER.loadImage("wandFuellelement");
     static BufferedImage rubin = IMAGELOADER.loadImage("rubin");
     static BufferedImage spawn = IMAGELOADER.loadImage("spawn");
     static BufferedImage stein = IMAGELOADER.loadImage("stein");
     static BufferedImage AusgangZU = IMAGELOADER.loadImage("AusgangZU");
     static BufferedImage AusgangAUF = IMAGELOADER.loadImage("AusgangAUF");
     static BufferedImage background = IMAGELOADER.loadImage("background");
     static BufferedImage titel = IMAGELOADER.loadImage("titel");
     static BufferedImage button = IMAGELOADER.loadImage("button");
     static BufferedImage buttonmouseover = IMAGELOADER.loadImage("buttonmaus");
     static BufferedImage buttonpressed = IMAGELOADER.loadImage("buttonpressed");
     static BufferedImage bar = IMAGELOADER.loadImage("bar");
     static BufferedImage busch = IMAGELOADER.loadImage("Busch");
     static BufferedImage saphir = IMAGELOADER.loadImage("saphir");
     static BufferedImage schlange = IMAGELOADER.loadImage("schlange");
     static BufferedImage hr = IMAGELOADER.loadImage("Herzrot");
     static BufferedImage hs = IMAGELOADER.loadImage("Herzschwarz");
     static BufferedImage map = IMAGELOADER.loadImage("map");
     static BufferedImage x1 = IMAGELOADER.loadImage("x1");
     static BufferedImage x2 = IMAGELOADER.loadImage("x2");
     static BufferedImage next = IMAGELOADER.loadImage("next");
     static BufferedImage next1 = IMAGELOADER.loadImage("next1");
     static BufferedImage retry = IMAGELOADER.loadImage("retry");
     static BufferedImage retry1 = IMAGELOADER.loadImage("retry1");
     static BufferedImage goMenu = IMAGELOADER.loadImage("goMenu");
     static BufferedImage goMenu1 = IMAGELOADER.loadImage("goMenu1");
     static BufferedImage perfekt = IMAGELOADER.loadImage("perfekt");
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

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

package game;
//---------------------//
import java.awt.image.BufferedImage;
//---------------------//
/**
 * Läd die Texturen aus dem gfx package und weißt ihnen Attributnamen zu
 */
public class Textur
{
    static BufferedImage ranke = Imageloader.loadImage("rankeHintergrund");
    static BufferedImage wandFuellelement = Imageloader.loadImage("wandFuellelement");
    static BufferedImage rubin = Imageloader.loadImage("rubin");
    static BufferedImage spawn = Imageloader.loadImage("spawn");
    static BufferedImage stein = Imageloader.loadImage("stein");
    static BufferedImage AusgangZU = Imageloader.loadImage("AusgangZU");
    static BufferedImage AusgangAUF = Imageloader.loadImage("AusgangAUF");
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

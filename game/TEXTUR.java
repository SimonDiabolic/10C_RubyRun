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
     static BufferedImage Türraufrechts = IMAGELOADER.loadImage("Türraufrechts");
     static BufferedImage telea = IMAGELOADER.loadImage("telea");
     static BufferedImage teleb = IMAGELOADER.loadImage("teleb");
     static BufferedImage busch = IMAGELOADER.loadImage("Busch");
     static BufferedImage saphir = IMAGELOADER.loadImage("saphir");
     static BufferedImage schlange = IMAGELOADER.loadImage("schlange");
     
     static BufferedImage background = IMAGELOADER.loadImage("background");
     static BufferedImage titel = IMAGELOADER.loadImage("titel");
     static BufferedImage pause = IMAGELOADER.loadImage("pause");
     static BufferedImage button = IMAGELOADER.loadImage("button");
     static BufferedImage buttonmouseover = IMAGELOADER.loadImage("buttonmaus");
     static BufferedImage buttonpressed = IMAGELOADER.loadImage("buttonpressed");
     static BufferedImage bar = IMAGELOADER.loadImage("bar");

     static BufferedImage hr = IMAGELOADER.loadImage("Herzrot");
     static BufferedImage hs = IMAGELOADER.loadImage("Herzschwarz");
     static BufferedImage map = IMAGELOADER.loadImage("map");
     static BufferedImage x1 = IMAGELOADER.loadImage("x1");
     static BufferedImage x2 = IMAGELOADER.loadImage("x2");
     
     
     static BufferedImage perfekt = IMAGELOADER.loadImage("perfekt");
     static BufferedImage resume = IMAGELOADER.loadImage("resume");
     static BufferedImage resume1 = IMAGELOADER.loadImage("resume1");
     static BufferedImage next = IMAGELOADER.loadImage("next");
     static BufferedImage next1 = IMAGELOADER.loadImage("next1");
     static BufferedImage retry = IMAGELOADER.loadImage("retry");
     static BufferedImage retry1 = IMAGELOADER.loadImage("retry1");
     static BufferedImage goMenu = IMAGELOADER.loadImage("goMenu");
     static BufferedImage goMenu1 = IMAGELOADER.loadImage("goMenu1");
     
     static BufferedImage WASD = IMAGELOADER.loadImage("WASDtoMove");
     static BufferedImage WayBlock = IMAGELOADER.loadImage("StupidYou");
     
     static BufferedImage lvl1busch1 = IMAGELOADER.loadImage("lvl1busch1");
     //static BufferedImage lvl1busch2 = IMAGELOADER.loadImage("lvl1busch2");
     static BufferedImage lvl2figur1 = IMAGELOADER.loadImage("lvl2figur1");
     static BufferedImage lvl2figur2 = IMAGELOADER.loadImage("lvl2figur2");
     static BufferedImage lvl3rubin1 = IMAGELOADER.loadImage("lvl3rubin1");
    // static BufferedImage lvl3rubin2 = IMAGELOADER.loadImage("lvl3rubin2");
    static BufferedImage lvl4schlange1 = IMAGELOADER.loadImage("lvl4schlange1");
    //static BufferedImage lvl4schlange2 = IMAGELOADER.loadImage("lvl4schlange2");
    static BufferedImage lvl5saphir1 = IMAGELOADER.loadImage("lvl5saphir1");
    //static BufferedImage lvl5saphir2 = IMAGELOADER.loadImage("lvl5saphir2");
    static BufferedImage lvl6stein1 = IMAGELOADER.loadImage("lvl6stein1");
    //static BufferedImage lvl6stein2 = IMAGELOADER.loadImage("lvl6stein2");
    static BufferedImage lvl7snake1 = IMAGELOADER.loadImage("lvl7snake1");
    //static BufferedImage lvl7snake2 = IMAGELOADER.loadImage("lvl7snake2");
    static BufferedImage lvl8totenkopf1 = IMAGELOADER.loadImage("lvl8totenkopf1");
    static BufferedImage lvl8totenkopf2 = IMAGELOADER.loadImage("lvl8totenkopf2");
    //static BufferedImage lvl9tempel1 = IMAGELOADER.loadImage("lvl9tempel1");
    //static BufferedImage lvl9tempel2 = IMAGELOADER.loadImage("lvl9tempel2");
    static BufferedImage lvl10vulkan1 = IMAGELOADER.loadImage("lvl10vulkan1");
    static BufferedImage lvl10vulkan2 = IMAGELOADER.loadImage("lvl10vulkan2");
    
     
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

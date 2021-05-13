package game;
//---------------------//
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;
//---------------------//
/**
 * Methode um Bilder aus dem Ordner gfx zu laden:
 * 
 * BezeichnungzuLadenesElementImCode = Imageloader.loadImage("NamezuLadenesElementImOrdner");
 */
public class Imageloader
{
  public static BufferedImage loadImage(String name)
  {
    try
    {
       return ImageIO.read(Imageloader.class.getClassLoader().getResourceAsStream("gfx/"+name+".png"));
    } 
    catch (IOException e) 
    {
       e.printStackTrace();
    }
    return null;
  }
}


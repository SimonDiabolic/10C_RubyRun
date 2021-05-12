package game;
//---------------------//
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;
//---------------------//
/**
 * Methode um bilder aus gfx zu laden:
 * 
 * BezeichnungzuLadenesElement = Imageloader.loadImage("NamezuLadenesElement");
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


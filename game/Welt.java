package game;
//---------------------//
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
//---------------------//
public class Welt
{
  private int weltx;
  private int welty;  
  private Spieler spieler;
  private Kachel[] [] kacheln;
  static int level = 0;
  static int breite;
  static int hoehe;
  
  public Welt()
  {
      spieler = new Spieler(40,0);
      loadNextLevel();
  }
  public void loadNextLevel()
  {
      BufferedImage map = Imageloader.loadImage("devLevel");
      breite = map.getWidth();
      hoehe = map.getHeight();
      kacheln = new Kachel[breite] [hoehe];
      for(int x = 0; x < breite;x++)
      {
         for(int y = 0; y < breite;y++)
         {
             Color c = new Color(map.getRGB(x,y));
             if(c.getRed()==0&&c.getGreen() == 255&& c.getBlue() == 0)      kacheln[x] [y] = new Kachel(x,y,0);
             if(c.getRed()==255&&c.getGreen() == 0&& c.getBlue() == 0)      kacheln[x] [y] = new Kachel(x,y,1);
             if(c.getRed()==255&&c.getGreen() == 0&& c.getBlue() == 255)    kacheln[x] [y] = new Kachel(x,y,2);
             if(c.getRed()==0&&c.getGreen() == 0&& c.getBlue() == 255)      kacheln[x] [y] = new Kachel(x,y,3);
         }
      }
  }
  public void update()
  {
     
      
      spieler.update(true); 
  }
  public void draw(Graphics g)
  {
      for(int x = 0; x < breite;x++)
      {
         for(int y = 0; y < breite;y++)
         {
             kacheln[x] [y].draw(g);
         }
      }
      spieler.draw(g);
  }
}
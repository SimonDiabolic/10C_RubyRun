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
      spieler = new Spieler(40,40);
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
             if(c.getRed()==0&&c.getGreen() == 0&& c.getBlue() == 0)      kacheln[x] [y] = new Kachel(x,y,4);
         }
      }
  }
  public void update()
  {

      spieler.update(true); 
      for(int x = 0; x < 1;x++)
      {
         for(int y = 0; y < 1;y++)
         {
             int spielerposx = (int) (spieler.getXPos())/Textur.kachelgroesse;
             int spielerposy = (int) (spieler.getYPos())/Textur.kachelgroesse;
             if(kacheln[spielerposx] [spielerposy].getLookID() == 1)
             {
                 //System.out.println("Außerhalb des Spielfeldes");
                 spieler.resetPosition();  
             }
         }
      }
      
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

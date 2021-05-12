package game;
//---------------------//
import java.awt.Graphics;
import java.awt.image.BufferedImage;
//---------------------//
public class Welt
{
  private int weltx;
  private int welty;  
  private Spieler spieler;
  private Kachel[] [] kacheln;
  static int breite = 20;
  static int hoehe = 20;
  
  public Welt()
  {
      spieler = new Spieler(40,0);
      kacheln = new Kachel[breite] [hoehe];
      for(int x = 0; x < breite;x++)
      {
         for(int y = 0; y < breite;y++)
         {
             kacheln[x] [y] = new Kachel(x,y,0);
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
package game;
//---------------------//
import java.awt.Graphics;
import java.awt.image.BufferedImage;
//---------------------//
public class Welt
{
  //private Kachel[] [] kacheln;
  //static int breite = 50;
  //static int hoehe = 50;
  private int weltx;
  private int welty;
  private BufferedImage background;
  private Spieler spieler;
  
  public Welt()
  {
      spieler = new Spieler(Main.width/2, Main.height/2);
      background = Imageloader.loadImage("guibackground");
      /*kacheln = new Kachel[breite] [hoehe];
      for(int x = 0; x <breite;x++)
      {
         for(int y = 0; y <breite;y++)
         {
             kacheln[x] [y] = new Kachel(x,y,0);
         }
      }*/
  }
  public void update()
  {
     spieler.update(false); 
  }
  public void draw(Graphics g)
  {
      g.drawImage(background,0,0,null);
      spieler.draw(g);
      /*for(int x = 0; x <breite;x++)
      {
         for(int y = 0; y <breite;y++)
         {
             kacheln[x] [y].draw(g);
         }
      }*/
  }
}

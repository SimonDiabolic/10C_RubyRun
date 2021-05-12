package game;

import java.awt.Graphics;
public class welt
{
  private Kachel[] [] kacheln;
  static int breite = 50;
  static int hoehe = 50;
  
  public welt()
  {
      kacheln = new Kachel[breite] [hoehe];
      for(int x = 0; x <breite;x++)
      {
         for(int y = 0; y <breite;y++)
         {
             kacheln[x] [y] = new Kachel(x,y,0);
         }
      }
      //player = new player();
  }
  public void draw(Graphics g)
  {
      for(int x = 0; x <breite;x++)
      {
         for(int y = 0; y <breite;y++)
         {
             kacheln[x] [y].draw(g);
         }
      }
  }
}

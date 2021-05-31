package game;
//---------------------//
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
//---------------------//
public class Spieler
{
 public static int x;
 public static int y;
 private int oldx;
 private int oldy;
 private int newx;
 private int newy;
 private int width = Textur.kachelgroesse;
 private int height = Textur.kachelgroesse;
 private BufferedImage look;
 public Spieler(int x, int y)
 {
     this/*(Spricht globale Variable an)*/.x = x;
     this.y = y;
     
    look = Imageloader.loadImage("spieler");
    
 }
 public void draw(Graphics g)
 {
     g.drawImage(look, (int) x, (int) y, null);
 }
 public void update(boolean playermove)
 {
     if(playermove)
     {
         if(Keyboard.isKeyPressed(KeyEvent.VK_W)) 
         {newy = 1;}
         if(Keyboard.isKeyPressed(KeyEvent.VK_S))
         {newy = -1;}
         if(Keyboard.isKeyPressed(KeyEvent.VK_D))
         {newx = 1;}
         if(Keyboard.isKeyPressed(KeyEvent.VK_A))
         {newx = -1;}
          oldy = y;
          oldx = x;
         if(newy == -1)
         {y = y+Textur.kachelgroesse; newy = 0;}
         if(newy == 1)
         {y = y-Textur.kachelgroesse; newy = 0;}
         if(newx == 1)
         {x = x+Textur.kachelgroesse; newx = 0;}
         if(newx == -1)
         {x = x-Textur.kachelgroesse; newx = 0;}
     }
 }
 public static int getXPos()
 {
     return x;
 }
 public static int getYPos()
 {
     return y;
 }
 public void resetPosition()
 {
     x=oldx;
     y=oldy;
 }
}


package game;
//---------------------//
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
//---------------------//
public class SPIELER
{
 public static int x;
 public static int y;
 private static int oldx;
 private static int oldy;
 private int newx;
 private int newy;
 private int width = TEXTUR.kachelgroesse;
 private int height = TEXTUR.kachelgroesse;
 public static int direction;
 private BufferedImage look;
 public SPIELER(int x, int y)
 {
     this/*(Spricht globale Variable an)*/.x = x;
     this.y = y;
     
    look = IMAGELOADER.loadImage("spieler");
    
 }
 public void draw(Graphics g)
 {
     g.drawImage(look, (int) x, (int) y, null);
 }
 public void update(boolean playermove)
 {
     if(playermove)
     {
         if(KEYBOARD.isKeyPressed(KeyEvent.VK_W)) 
         {newy = 1;direction = 0;}
         if(KEYBOARD.isKeyPressed(KeyEvent.VK_S))
         {newy = -1;direction = 0;}
         if(KEYBOARD.isKeyPressed(KeyEvent.VK_D))
         {newx = 1; direction = 1;}
         if(KEYBOARD.isKeyPressed(KeyEvent.VK_A))
         {newx = -1; direction = -1;}
          oldy = y;
          oldx = x;
         if(newy == -1)
         {y = y+TEXTUR.kachelgroesse; newy = 0;}
         if(newy == 1)
         {y = y-TEXTUR.kachelgroesse; newy = 0;}
         if(newx == 1)
         {x = x+TEXTUR.kachelgroesse; newx = 0;}
         if(newx == -1)
         {x = x-TEXTUR.kachelgroesse; newx = 0;}
     }
     int spielerposx = (int) (getXPos())/TEXTUR.kachelgroesse;
     int spielerposy = (int) (getYPos())/TEXTUR.kachelgroesse;
     if(WELT.kacheln[spielerposx] [spielerposy].getLookID() == 1)
     {
         resetPosition();  
     }
     if(WELT.kacheln[spielerposx] [spielerposy].getLookID() == 4)
     {
         FRAME.spielzustand = 1;
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
 public static void resetPosition()
 {
     x=oldx;
     y=oldy;
 }
 public static int getDirection()
 {
     return direction;
 }
 
 
  
    
}



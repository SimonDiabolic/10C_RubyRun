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
public static int directionx;
public static int directiony;
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
     {newy = 1;directiony = -1;}
     if(KEYBOARD.isKeyPressed(KeyEvent.VK_S))
     {newy = -1;directiony = 1;}
     if(KEYBOARD.isKeyPressed(KeyEvent.VK_D))
     {newx = 1; directionx = 1;}
     if(KEYBOARD.isKeyPressed(KeyEvent.VK_A))
     {newx = -1; directionx = -1;}
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
 for (BEWEGTESOBJEKT i : BEWEGTESOBJEKT.other) 
 {
                      
     for (BEWEGTESOBJEKT j : BEWEGTESOBJEKT.other) 
     {
         if (directionx != 0 && directiony != 0 && WELT.kacheln[spielerposx][spielerposy].getLookID()!=1 &&
         ((i.getType() == 's' && spielerposx - directionx == i.getX() / TEXTUR.kachelgroesse && spielerposy == i.getY() / TEXTUR.kachelgroesse) || (WELT.kacheln [spielerposx - directionx] 
         [spielerposy].getLookID() == 1) && (j.getType() == 's' && spielerposx == j.getX() / TEXTUR.kachelgroesse && spielerposy - directiony == j.getY() / TEXTUR.kachelgroesse) || 
         WELT.kacheln [spielerposx] [spielerposy - directiony].getLookID() == 1))
         {
             resetPosition ();
                              
             }
             }
                      }
     if (WELT.kacheln[spielerposx - directionx] [spielerposy].getLookID() == 1 && WELT.kacheln[spielerposx] [spielerposy - directiony].getLookID() == 1)
     {
         resetPosition ();
     }
     if(WELT.kacheln[spielerposx] [spielerposy].getLookID() == 1)
     {
         resetPosition();  
     }
     if(WELT.kacheln[spielerposx] [spielerposy].getLookID() == 4)
     {
         FRAME.spielzustand = 3;
         FMENU.WinOrLoose = "win";
         FRAME.welt = null;
     }
     
 }
 public static void resetDirection()
 {
     directionx = 0;
     directiony = 0;
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
 public static int getDirectionX()
 {
     return directionx;
 }
 
 
  
    
}



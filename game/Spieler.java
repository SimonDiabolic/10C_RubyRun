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
 private int x;
 private int y;
 private int xADD;
 private int yADD;
 private int width = 30;
 private int height = 30;
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
         if(Keyboard.isKeyPressed(KeyEvent.VK_W)) y =y-40;
         if(Keyboard.isKeyPressed(KeyEvent.VK_S)) y =y+40;
         if(Keyboard.isKeyPressed(KeyEvent.VK_D)) x =x+40;
         if(Keyboard.isKeyPressed(KeyEvent.VK_A)) x =x-40;
     }
     if(playermove)
     if(x < 0) x = 0;
     if(x + width > Main.width) x = Main.width - width;
     if(y < 0) y = 0;
     if(y + height > Main.height) x = Main.height - height;
 }
}

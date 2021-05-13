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
  public static Kachel[] [] kacheln;
  static int level = 0;
  static int breite;
  static int hoehe;
  private int spawnx;
  private int spawny;
  private static Rubin rubin1;
  public Welt()
  {
      loadNextLevel();
      spieler = new Spieler(spawnx,spawny);
      rubin1 = new Rubin (40,40);
  }
  public void loadNextLevel()
  {
      BufferedImage map = Imageloader.loadImage("devLevel");
      breite = map.getWidth();
      hoehe = map.getHeight();
      kacheln = new Kachel[breite] [hoehe];
      for(int x = 0; x < breite;x++)
      {
         for(int y = 0; y < hoehe;y++)
         {
             Color c = new Color(map.getRGB(x,y));
             if(c.getRed()==0&&c.getGreen() == 255&& c.getBlue() == 0)      kacheln[x] [y] = new Kachel(x,y,0);
             if(c.getRed()==255&&c.getGreen() == 0&& c.getBlue() == 0)      kacheln[x] [y] = new Kachel(x,y,1);
             if(c.getRed()==255&&c.getGreen() == 0&& c.getBlue() == 255)   
             { 
                 // rubinx = x*Textur.kachelgroesse;
                 // rubiny = y*Textur.kachelgroesse;
                 kacheln[x] [y] = new Kachel(x,y,2);
                }
             if(c.getRed()==0&&c.getGreen() == 0&& c.getBlue() == 255)      kacheln[x] [y] = new Kachel(x,y,3);
             if(c.getRed()==0&&c.getGreen() == 0&& c.getBlue() == 255)    
             {
                 spawnx = x*Textur.kachelgroesse;
                 spawny = y*Textur.kachelgroesse;
                 kacheln[x] [y] = new Kachel(x,y,3);
             }
             if(c.getRed()==0&&c.getGreen() == 0&& c.getBlue() == 0)      kacheln[x] [y] = new Kachel(x,y,4);
         }
      }      
  }

  // public static void WasIstUnterRubin()
     // {
     // int rubinPositionX = (int) (Welt.getRubinX())/Textur.kachelgroesse;
     // int rubinPositionY= (int) (Welt.getRubinY())/Textur.kachelgroesse;
     // if(Welt.kacheln[rubinPositionX] [rubinPositionY-1].getLookID() == 0)      
     // {
                 // rubin1.RubinFall(true);
     // }
     // if(Welt.kacheln[rubinPositionX] [rubinPositionY-1].getLookID() == 2)      
     // {
                 // rubin1.RubinFall(true);
     // }
     // if(Welt.kacheln[rubinPositionX] [rubinPositionY-1].getLookID() == 4)      
     // {
                 // rubin1.RubinFall(true);
     // }
     
    //}
    public void update()
  {
     spieler.update(true); 
     int spielerposx = (int) (spieler.getXPos())/Textur.kachelgroesse;
     int spielerposy = (int) (spieler.getYPos())/Textur.kachelgroesse;
     if(kacheln[spielerposx] [spielerposy].getLookID() == 1)
             {
                 //System.out.println("Außerhalb des Spielfeldes");
                 spieler.resetPosition();  
             }
     int rubinPositionX = (int) (Rubin.getRubinX())/Textur.kachelgroesse;
     int rubinPositionY= (int) (Rubin.getRubinY())/Textur.kachelgroesse;
     if(Welt.kacheln[rubinPositionX] [rubinPositionY].getLookID() == 0)      
     {
               
         rubin1.RubinFall(true);
         System.out.println(rubinPositionY);
     }
     if(Welt.kacheln[rubinPositionX] [rubinPositionY].getLookID() == 2)      
     {    
          
         rubin1.RubinFall(true);
         System.out.println(rubinPositionY);
     }
     if(Welt.kacheln[rubinPositionX] [rubinPositionY].getLookID() == 4)      
     {
                 
         rubin1.RubinFall(true);
         System.out.println(rubinPositionY);
     }
     else if (Welt.kacheln[rubinPositionX] [rubinPositionY].getLookID() == 1)
         Rubin.resetPosition();
        
        }
  
  public void draw(Graphics g)
  {
       
      for(int x = 0; x < breite;x++)
      {
         for(int y = 0; y < hoehe;y++)
         {
             kacheln[x] [y].draw(g);
         }      
      }
    
      spieler.draw(g);
      rubin1.draw(g);
  }
  
}

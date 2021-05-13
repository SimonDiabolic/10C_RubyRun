package game;
//---------------------//
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
//---------------------//
/**
 * Die Welt in der ein Level stattfindet 
 */
public class Welt
{
  private Spieler spieler;
  public static Kachel[] [] kacheln;
  static int level = 0;
  static int breite;
  static int hoehe;
  //Koordinaten  
  private int spawnx;
  private int spawny;
  private static Rubin rubin1;
  public Welt()
  {
      loadNextLevel(); //ruft die Methode zum Laden eines neuen Levels auf
      spieler = new Spieler(spawnx,spawny);
      rubin1 = new Rubin (40,40);
  }
  /*
   *  MapLoader -- Läd Levelkarte von gfx/LEVELBEZEICHNUNG und konvertiert diese Pixel für Pixel hierbei gilt:
   *  RGB werte werden als Code benutzt
   */
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
             /**
              * if(c.getRed()==ROTWERT && c.getGreen()==GRUENWERT && c.getBlue()==BLAUWERT) kacheln[x] [y] = new Kachel(POSITIONx,POSITIONy,lookID);
              */
             if(c.getRed()==0   &&c.getGreen() == 255   && c.getBlue() == 0)        kacheln[x] [y] = new Kachel(x,y,0); //LookID 0 = Ranke
             if(c.getRed()==255 &&c.getGreen() == 0     && c.getBlue() == 0)        kacheln[x] [y] = new Kachel(x,y,1); //LookID 1 = FüllelementWand
             if(c.getRed()==255 &&c.getGreen() == 0     && c.getBlue() == 255)      kacheln[x] [y] = new Kachel(x,y,2); //LookID 2 = Rubin
             if(c.getRed()==0   &&c.getGreen() == 0     && c.getBlue() == 255)      kacheln[x] [y] = new Kachel(x,y,3); //LookID 3 = Spawnpunkt
             if(c.getRed()==0   &&c.getGreen() == 0     && c.getBlue() == 0)        kacheln[x] [y] = new Kachel(x,y,4); //LookID 4 = Stein
             
             // /**
              // * Erfragt Koordinaten aller Rubinkacheln (hasRuby(true))
              // */
             // if(c.getRed()==0   &&c.getGreen() == 255   && c.getBlue() == 0)      kacheln[x] [y] = new Kachel(x,y,0);
             // if(c.getRed()==255 &&c.getGreen() == 0     && c.getBlue() == 0)      kacheln[x] [y] = new Kachel(x,y,1);
             // if(c.getRed()==255 &&c.getGreen() == 0     && c.getBlue() == 255)   
             // { 
                 // rubinx = x*Textur.kachelgroesse;
                 // rubiny = y*Textur.kachelgroesse;
                 // kacheln[x] [y] = new Kachel(x,y,2);
             // }
             /**
              * Erfragt Koordinaten der Spawnkachel (Kachel mit der LookID 3) und setzt die Koordinaten für den Spielereinstiegspunkt diesen gleich
              */
             if(c.getRed()==0&&c.getGreen() == 0&& c.getBlue() == 255)    
             {
                 spawnx = x*Textur.kachelgroesse;
                 spawny = y*Textur.kachelgroesse;
                 kacheln[x] [y] = new Kachel(x,y,3);
             }
         }
      }      
  }
  public void update()
  {
     spieler.update(true); 
     int spielerposx = (int) (spieler.getXPos())/Textur.kachelgroesse;
     int spielerposy = (int) (spieler.getYPos())/Textur.kachelgroesse;
     if(kacheln[spielerposx] [spielerposy].getLookID() == 1)
             {
                 spieler.resetPosition();  
             }
     int rubinPositionX = (int) (Rubin.getRubinX())/Textur.kachelgroesse;
     int rubinPositionY= (int) ((Rubin.getRubinY())/Textur.kachelgroesse)+1;
     if(Welt.kacheln[rubinPositionX] [rubinPositionY].getLookID() == 0)      
     {   
         rubin1.RubinFall(true);
     }
     if(Welt.kacheln[rubinPositionX] [rubinPositionY].getLookID() == 2)      
     {    
         rubin1.RubinFall(true);
     }
     if(Welt.kacheln[rubinPositionX] [rubinPositionY].getLookID() == 4)      
     {
         rubin1.RubinFall(true);
     }
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

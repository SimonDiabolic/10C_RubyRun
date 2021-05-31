package game;
//---------------------//
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.util.LinkedList;
import java.util.Iterator;

import java.util.ArrayList;

import java.awt.Shape;
import java.awt.*;

//---------------------//
/**
 * Die Welt in der ein Level stattfindet 
 */
public class Welt
{

      private Spieler spieler;
      public static Kachel[] [] kacheln;
      public LinkedList<Rubin> rubine;
 
      static int breite;
      static int hoehe;
      //Koordinaten  
      private int spawnx;
      private int spawny;
      private int anzahlRubine;
      private int rubinposy;
      private int rubinposx;
      private Rubin theo;
      private Rubin theo1;
      
      //Rubin

      //Koordinaten  
 
  public Welt()
  {
      loadNextLevel(); //ruft die Methode zum Laden eines neuen Levels auf
      spieler = new Spieler(spawnx,spawny);
      rubine.add(new Rubin(spawnx,spawny));
        theo = new Rubin(40, 40);    
        theo1 = new Rubin(80, 40);
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
      rubine = new LinkedList<Rubin>();
           for(int x = 0; x < breite;x++)
              {
                 for(int y = 0; y < hoehe;y++)
                 {
                     Color c = new Color(map.getRGB(x,y));
                     /**
                      * if(c.getRed()==ROTWERT && c.getGreen()==GRUENWERT && c.getBlue()==BLAUWERT) kacheln[x] [y] = new Kachel(POSITIONx,POSITIONy,lookID);
                      */
                     if(c.getRed()==0   &&c.getGreen() == 255   && c.getBlue() == 0)        kacheln[x] [y] = new Kachel(x,y,0,false);   //LookID 0 = Ranke
                     if(c.getRed()==255 &&c.getGreen() == 0     && c.getBlue() == 0)        kacheln[x] [y] = new Kachel(x,y,1,false);   //LookID 1 = FüllelementWand
                     if(c.getRed()==255 &&c.getGreen() == 0     && c.getBlue() == 255)      kacheln[x] [y] = new Kachel(x,y,2,true);    //LookID 2 = Rubin
                     if(c.getRed()==0   &&c.getGreen() == 0     && c.getBlue() == 255)      kacheln[x] [y] = new Kachel(x,y,3,false);   //LookID 3 = Spawnpunkt
                     if(c.getRed()==0   &&c.getGreen() == 0     && c.getBlue() == 0)        kacheln[x] [y] = new Kachel(x,y,4,false);   //LookID 4 = Stein
                     
                     /**
                      * Erfragt Koordinaten aller Rubinkacheln (hasRuby(true))
                      */
                     if(c.getRed()==255 &&c.getGreen() == 0     && c.getBlue() == 255)
                     {
                         anzahlRubine = anzahlRubine+1;
                         rubinposx = x;
                         rubinposy = y;
                         rubine.add(new Rubin(rubinposx,rubinposy));
                         System.out.println("Rubin erzeugt bei:" +rubinposx +" und " + rubinposy + " " +rubine.getLast());       
                     }
                     /**
                      * Erfragt Koordinaten der Spawnkachel (Kachel mit der LookID 3) und setzt die Koordinaten für den Spielereinstiegspunkt diesen gleich
                      */
                     if(c.getRed()==0&&c.getGreen() == 0&& c.getBlue() == 255)    
                     {
                         spawnx = x*Textur.kachelgroesse;
                         spawny = y*Textur.kachelgroesse;
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
      for(int i = 0; i < rubine.size();i++)
          {
                     rubine.get(i).update();
           }
             
     // int rubinPositionX = (int) (Rubin.getRubinX())/Textur.kachelgroesse;
     // int rubinPositionY= (int) ((Rubin.getRubinY())/Textur.kachelgroesse)+1;
     // if(Welt.kacheln[rubinPositionX] [rubinPositionY].getLookID() == 0)      
     // {   
         // // rubin1.RubinFall(true);
     // }
     // if(Welt.kacheln[rubinPositionX] [rubinPositionY].getLookID() == 2)      
     // {    
         // // rubin1.RubinFall(true);
     // }
     // if(Welt.kacheln[rubinPositionX] [rubinPositionY].getLookID() == 4)      
     // {
         // // rubin1.RubinFall(true);
     // }
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
      for(int i = 0; i < rubine.size();i++)
      {
             rubine.get(i).draw(g);
      }
      spieler.draw(g);
  }
}

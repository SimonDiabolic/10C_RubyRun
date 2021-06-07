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
      public LinkedList<Stein> steine;
 
      static int breite;
      static int hoehe; 
      private int spawnx;
      private int spawny;
      private int anzahlRubine;
      private int rubinposy;
      private int rubinposx;
      private int steinposy;
      private int steinposx;

      private int punkte;
      
      private Lock Lock;
      private int spawnLOCKy;
      private int spawnLOCKx;
      private double zuSammelndeRubine;
 
  public Welt()
  {
      loadNextLevel(); //ruft die Methode zum Laden eines neuen Levels auf
      spieler = new Spieler(spawnx,spawny);
      Lock = new Lock(spawnLOCKx,spawnLOCKy);
        
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
      steine = new LinkedList<Stein>();
      punkte = 0;
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
                    if(c.getRed()==255 &&c.getGreen() == 0     && c.getBlue() == 255)      kacheln[x] [y] = new Kachel(x,y,2,true) ;   //LookID 2 = Rubin
                    if(c.getRed()==0   &&c.getGreen() == 0     && c.getBlue() == 255)      kacheln[x] [y] = new Kachel(x,y,3,false);   //LookID 3 = Spawnpunkt
                    if(c.getRed()==0   &&c.getGreen() == 0     && c.getBlue() == 0)        kacheln[x] [y] = new Kachel(x,y,0,false);   //LookID 4 = Stein
                    if(c.getRed()==255   &&c.getGreen() == 255     && c.getBlue() == 0)    kacheln[x] [y] = new Kachel(x,y,6,false);   //LookID 6 = Ausgang
                     /**
                      * Erfragt Koordinaten aller Rubinkacheln (hasRuby(true))
                      */
                     if(c.getRed()==255 &&c.getGreen() == 0     && c.getBlue() == 255)
                     {
                         anzahlRubine++;
                         // System.out.println(anzahlRubine);
                         rubinposx = x;
                         rubinposy = y;
                         rubine.add(new Rubin(rubinposx,rubinposy));
                     }
                     if(c.getRed()==0 &&c.getGreen() == 0     && c.getBlue() == 0)
                     {
                         steinposx = x;
                         steinposy = y;
                         steine.add(new Stein(steinposx,steinposy));
                     }
                      /**
                      * Erfragt Koordinaten der Spawnkachel (Kachel mit der LookID 3) und setzt die Koordinaten für den Spielereinstiegspunkt diesen gleich
                      */
                     if(c.getRed()==0&&c.getGreen() == 0&& c.getBlue() == 255)    
                     {
                         spawnx = x*Textur.kachelgroesse;
                         spawny = y*Textur.kachelgroesse;
                     }
                     /**
                      * Erfragt die Koordinaten des Ausganges und setzt dort ein Schloss
                      */
                     if(c.getRed()==255   &&c.getGreen() == 255     && c.getBlue() == 0)
                     {
                         spawnLOCKx = x*Textur.kachelgroesse;
                         spawnLOCKy = y*Textur.kachelgroesse;
                         
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
     if(kacheln[spielerposx] [spielerposy].getLookID() == 6)
     {
         spieler.resetPosition();  
     }
     for(int x = 0; x < breite;x++)
      {
         for(int y = 0; y < hoehe;y++)
         {

             if(kacheln[x] [y].getLookID() == 6 && punkte >= zuSammelndeRubine)

             {
                 kacheln[x] [y].setLookID(5);    
                 Lock = null;
             }
         }      
      }
    Rubin underPlayer = null;
    for (Rubin r : rubine) {
     r.update();
     if (r.RubinCollection()) 
     {
            underPlayer = r;
     }
        
    } 
    if (underPlayer != null) {
        rubine.remove(underPlayer);
        punkte++;
        double zuSammelndeRubine = Math.round(anzahlRubine*0.75);
        // System.out.println("benötigte Rubine" + zuSammelndeRubine);
    }
    for (Stein s : steine) 
    {
     s.update();
    
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
      for(int i = 0; i < rubine.size();i++)
      {
          Rubin r= rubine.get(i);
          r.draw(g);
      }
      for(int i = 0; i < steine.size();i++)
      {
          Stein s= steine.get(i);
          s.draw(g);
      }
      if(punkte < zuSammelndeRubine) Lock.draw(g);
      spieler.draw(g);
      
    }
  
}

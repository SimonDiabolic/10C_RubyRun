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
      public LinkedList<BewegtesObjekt> zeugs;
 
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
      private int locky;
      private int lockx;
      private double zuSammelndeRubine;
      private boolean LockExists;
 
  public Welt()
  {
      loadNextLevel(); //ruft die Methode zum Laden eines neuen Levels auf
      spieler = new Spieler(spawnx,spawny);
      Lock = new Lock(lockx,locky);
      LockExists = true;
      double zuSammelndeRubine = Math.round(anzahlRubine*0.75); 
      System.out.println("erzeugte Rubine: " + anzahlRubine);  
      System.out.println("zu Sammelnde Rubine: " + zuSammelndeRubine);
      System.out.println("Punkte:" + punkte);
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
      zeugs = new LinkedList<BewegtesObjekt>();
      punkte = 0;
           for(int x = 0; x < breite;x++)
              {
                 for(int y = 0; y < hoehe;y++)
                 {
                     Color c = new Color(map.getRGB(x,y));
                     /**
                      * if(c.getRed()==ROTWERT && c.getGreen()==GRUENWERT && c.getBlue()==BLAUWERT) kacheln[x] [y] = new Kachel(POSITIONx,POSITIONy,lookID);
                      */
                    if(c.getRed()==0   &&c.getGreen() == 255   && c.getBlue() == 0)        kacheln[x] [y] = new Kachel(x,y,0);   //LookID 0 = Ranke
                    if(c.getRed()==255 &&c.getGreen() == 0     && c.getBlue() == 0)        kacheln[x] [y] = new Kachel(x,y,1);   //LookID 1 = FüllelementWand
                    if(c.getRed()==255 &&c.getGreen() == 0     && c.getBlue() == 255)      kacheln[x] [y] = new Kachel(x,y,0);   //LookID 0
                    if(c.getRed()==0   &&c.getGreen() == 0     && c.getBlue() == 255)      kacheln[x] [y] = new Kachel(x,y,2);   //LookID 2 = Spawnpunkt
                    if(c.getRed()==0   &&c.getGreen() == 0     && c.getBlue() == 0)        kacheln[x] [y] = new Kachel(x,y,0);   //LookID 0
                    if(c.getRed()==255   &&c.getGreen() == 255     && c.getBlue() == 0)    kacheln[x] [y] = new Kachel(x,y,3);   //LookID 3 = Ausgang
                    if(c.getRed()==250   &&c.getGreen() == 255     && c.getBlue() == 0)    kacheln[x] [y] = new Kachel(x,y,4);   //LookID 4 = AusgangControll
                     /**
                      * Erfragt Koordinaten aller Rubinkacheln (hasRuby(true))
                      */
                     if(c.getRed()==255 &&c.getGreen() == 0 && c.getBlue() == 255)
                     {
                         anzahlRubine++;
                         rubinposx = x;
                         rubinposy = y;
                         zeugs.add(new Rubin(rubinposx,rubinposy));
                     }
                     if(c.getRed()==0 &&c.getGreen() == 0   && c.getBlue() == 0)
                     {
                         steinposx = x;
                         steinposy = y;
                         zeugs.add(new Stein(steinposx,steinposy));
                     }
                      /**
                      * Erfragt Koordinaten der Spawnkachel (Kachel mit der LookID 2) und setzt die Koordinaten für den Spielereinstiegspunkt diesen gleich
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
                         lockx = x*Textur.kachelgroesse;
                         locky = y*Textur.kachelgroesse;
                         
                     }
              }
               }
       

  }
  public void update()
  {
      spieler.update(true); 
      BewegtesObjekt underPlayer = null;
      for (BewegtesObjekt z : zeugs) {
         z.update();
         if (z.RubinCollection()) 
         {
            underPlayer = z;
         }
        
      } 
       // for(int i = 0; i < zeugs.size();i++)
        // {
        // BewegtesObjekt a = zeugs.get(i); 
           // for(int j = 0; j < zeugs.size();j++)
        // {
          // BewegtesObjekt b = zeugs.get(j);
          // if (!((a.getX()==b.getX()) && (a.getY()==b.getY()+Textur.kachelgroesse) /*&&(Welt.kacheln[a.getX()/Textur.kachelgroesse] [(a.getY()/Textur.kachelgroesse)+1].getLookID() == 0 )*/))
          // {
            // a.y = a.y + Textur.kachelgroesse;
          // }
        // }
        // }
      
      if (underPlayer != null) {
        zeugs.remove(underPlayer);
        punkte++;
        System.out.println("Punkte: " + punkte);
        double zuSammelndeRubine = Math.round(anzahlRubine*0.75);
        if(punkte >= zuSammelndeRubine && LockExists == true )
            {    
             Lock = null;
             System.out.println("Schloss entfernt");
             LockExists = false;
            }
      }
      double zuSammelndeRubine = Math.round(anzahlRubine*0.75);
      if(punkte < zuSammelndeRubine)
      {
        if(Lock.SpielerAufSchloss())
        {
            spieler.resetPosition();
        }
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
      for(int i = 0; i < zeugs.size();i++)
      {
          BewegtesObjekt r= zeugs.get(i);
          r.draw(g);
          
      }
      double zuSammelndeRubine = Math.round(anzahlRubine*0.75);
      if(punkte < zuSammelndeRubine)
      {
          Lock.draw(g);
      }
      spieler.draw(g);
      
    }
  
}
package game;
//---------------------//
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.util.LinkedList;
import java.util.Iterator;
import java.text.DecimalFormat;

import java.util.ArrayList;

import java.awt.Shape;
import java.awt.*;

//---------------------//
/**
 * Die Welt in der ein Level stattfindet 
 */
public class WELT
{

      private SPIELER spieler;
      public static KACHEL[] [] kacheln;
      public LinkedList<BEWEGTESOBJEKT> zeugs;
 
      static int breite;
      static int hoehe; 
      private int spawnx;
      private int spawny;
      public static int anzahlRubine;
      public static int anzahlSaphire;
      
      public static int telex;
      public static int teley;
      
      public static int punkte;
      public static int leben;
      public static int keys;
      private int damage;
      private Font font;
      private FontMetrics fm;
      
      static String level;
      private AUSGANG Ausgang;
      private SCHLOSS schloss;
      private DOOR door;
      private int ausgangy;
      private int ausgangx;
      private double zuSammelndeRubine;
      private boolean AusgangExists;
      public static UIBOTTOM uibottom;
      
      public static boolean tutorial;
      public static boolean bosslevel;
      TUTORIAL tut;
  public WELT()
  {
      loadNextLevel(); //ruft die Methode zum Laden eines neuen Levels auf
      spieler = new SPIELER(spawnx,spawny);
      Ausgang = new AUSGANG(ausgangx,ausgangy);
      AusgangExists = true;
      if(tutorial) tut = new TUTORIAL();
      font = new Font("Monospaced", Font.BOLD,26); 
  }

  /*
   *  MapLoader -- Läd Levelkarte von gfx/LEVELBEZEICHNUNG und konvertiert diese Pixel für Pixel hierbei gilt:
   *  RGB werte werden als Code benutzt
   */
  public void loadNextLevel()
  {
      String karte = LEVELWAHL.level;
      BufferedImage map = IMAGELOADER.loadImage(karte);
      breite = map.getWidth();
      hoehe = map.getHeight();
      uibottom = new UIBOTTOM(0,800);
      kacheln = new KACHEL[breite] [hoehe];
      zeugs = new LinkedList<BEWEGTESOBJEKT>();
      anzahlRubine = 0;
      punkte = 0;
      damage = 0;
      leben = 5;
      
           for(int x = 0; x < breite;x++)
              {
                 for(int y = 0; y < hoehe;y++)
                 {
                     kacheln[x] [y] = null;
                     
                     Color c = new Color(map.getRGB(x,y));
                     /**
                      * if(c.getRed()==ROTWERT && c.getGreen()==GRUENWERT && c.getBlue()==BLAUWERT) kacheln[x] [y] = new Kachel(POSITIONx,POSITIONy,lookID);
                      */
                    if(c.getRed()==150   &&c.getGreen() == 150   && c.getBlue() == 150)    kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0 = Ranke
                    if(c.getRed()==255 &&c.getGreen() == 115    && c.getBlue() == 0)       kacheln[x] [y] = new KACHEL(x,y,1);   //LookID 1 = FüllelementWand
                    if(c.getRed()==0   &&c.getGreen() == 150     && c.getBlue() == 150)    kacheln[x] [y] = new KACHEL(x,y,2);   //LookID 2 = Spawnpunkt
                    if(c.getRed()==255   &&c.getGreen() == 255     && c.getBlue() == 0)    kacheln[x] [y] = new KACHEL(x,y,3);   //LookID 3 = Ausgang
                    if(c.getRed()==255   &&c.getGreen() == 20     && c.getBlue() == 0)     kacheln[x] [y] = new KACHEL(x,y,3);   //LookID 3 = AusgangRechts
                    if(c.getRed()==250   &&c.getGreen() == 255     && c.getBlue() == 0)    kacheln[x] [y] = new KACHEL(x,y,4);   //LookID 4 = AusgangControll
                    if(c.getRed()==250   &&c.getGreen() == 250     && c.getBlue() == 250)  kacheln[x] [y] = new KACHEL(x,y,5);   //LookID 5 = Teleportstein A
                    if(c.getRed()==200  &&c.getGreen() == 200     && c.getBlue() == 200)   kacheln[x] [y] = new KACHEL(x,y,6);   //LookID 6 = Teleportstein B
                    if(c.getRed()==40   &&c.getGreen() == 100    && c.getBlue() == 40)     kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0; Busch
                    if(c.getRed()==200   &&c.getGreen() == 100    && c.getBlue() == 200)   kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0; Feuer
                    if(c.getRed()==200   &&c.getGreen() == 150    && c.getBlue() == 200)   kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0; Feuer
                    if(c.getRed()==255   &&c.getGreen() == 0    && c.getBlue() == 0)       kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0; Rubin
                    if(c.getRed()==0 &&c.getGreen() == 0     && c.getBlue() == 255)        kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0; Saphir
                    if(c.getRed()==0   &&c.getGreen() == 0     && c.getBlue() == 0)        kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0; Stein
                    if(c.getRed()==0   &&c.getGreen() == 255     && c.getBlue() == 0)      kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0; Schlange
                    if(c.getRed()==0   &&c.getGreen() == 250     && c.getBlue() == 0)      kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0; Schlange
                    if(c.getRed()==1   &&c.getGreen() == 1    && c.getBlue() == 1)         kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0; Schlüssel
                    if(c.getRed()==2   &&c.getGreen() == 2    && c.getBlue() == 2)         kacheln[x] [y] = new KACHEL(x,y,7);   //LookID 0; Schlüoss (Y-1 == Tür!)
                    if(c.getRed()==50   &&c.getGreen() == 50    && c.getBlue() == 50)      kacheln[x] [y] = new KACHEL(x,y,1);   //LookID 1; Wand für Bosslevel
                    if(c.getRed()==150   &&c.getGreen() == 250    && c.getBlue() == 350)   kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0; Weg für Bosslevel
                    if(c.getRed()==75   &&c.getGreen() == 75    && c.getBlue() == 75)      kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0; Stein für Bosslevel
                    if(c.getRed()==75   &&c.getGreen() == 150    && c.getBlue() == 75)     kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0; Rubin für Bosslevel
                    if(c.getRed()==75   &&c.getGreen() == 75    && c.getBlue() == 150)     kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0; Busch für Bosslevel
                    if(c.getRed()==200   &&c.getGreen() == 400    && c.getBlue() == 200)   kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0; Schlange für Bosslevel
                    
                    if (kacheln[x] [y] == null) {
                        System.out.println("red= " + c.getRed() + " "  + "green= " + c.getGreen() + " " + "blue= " + c.getBlue() + " ");
                    }
                        /**
                      * Erstellt alle Objekte die von BEWWEGTESOBJEKT erben
                      */
                     if(c.getRed()==255 &&c.getGreen() == 0 && c.getBlue() == 0)
                     {
                         anzahlRubine++;
                         zeugs.add(new RUBIN(x,y,false));
                     }
                     
                     if(c.getRed()==75 &&c.getGreen() == 150 && c.getBlue() == 75)
                     {
                         anzahlRubine++;
                         zeugs.add(new RUBIN(x,y,true));
                     }
                     if(c.getRed()==0 &&c.getGreen() == 0   && c.getBlue() == 0)
                     {
                         zeugs.add(new STEIN(x,y));
                     }
                     if(c.getRed()==200 &&c.getGreen() == 100   && c.getBlue() == 200)
                     {
                         zeugs.add(new FEUER(x,y,'x'));
                     }
                     if(c.getRed()==200 &&c.getGreen() == 150   && c.getBlue() == 200)
                     {
                         zeugs.add(new FEUER(x,y,'y'));
                     }
                     if(c.getRed()==40   &&c.getGreen() == 100    && c.getBlue() == 40)
                     {
                         zeugs.add(new BUSCH(x,y));                         
                     }
                     if(c.getRed()==0   &&c.getGreen() == 0    && c.getBlue() == 255)
                     {
                         anzahlSaphire++;
                         zeugs.add(new SAPHIR(x,y));                         
                     }
                     if(c.getRed()==0   &&c.getGreen() == 255    && c.getBlue() == 0)
                     {
                         zeugs.add(new SCHLANGE(x,y,'y'));                         
                     }
                     if(c.getRed()==0   &&c.getGreen() == 250    && c.getBlue() == 0)
                     {
                         zeugs.add(new SCHLANGE(x,y,'x'));                         
                     }
                     if(c.getRed()==1   &&c.getGreen() == 1    && c.getBlue() == 1)
                     {
                         zeugs.add(new SCHLUESSEL(x,y));                         
                     }
                     if(c.getRed()==2   &&c.getGreen() == 2    && c.getBlue() == 2)
                     {
                         schloss = new SCHLOSS(x*TEXTUR.kachelgroesse,y*TEXTUR.kachelgroesse);
                         door = new DOOR(x*TEXTUR.kachelgroesse,y*TEXTUR.kachelgroesse+TEXTUR.kachelgroesse);
                     }
                     
                      /**
                      * Erfragt Koordinaten der Spawnkachel (Kachel mit der LookID 2) und setzt die Koordinaten für den Spielereinstiegspunkt diesen gleich
                      */
                     if(c.getRed()==0&&c.getGreen() == 150&& c.getBlue() == 150)    
                     {
                         spawnx = x*TEXTUR.kachelgroesse;
                         spawny = y*TEXTUR.kachelgroesse;
                     }
                     /**
                      * Erfragt die Koordinaten des Ausganges und setzt dort ein Schloss
                      */
                     if(c.getRed()==255   &&c.getGreen() == 255     && c.getBlue() == 0)
                     {
                         ausgangx = x*TEXTUR.kachelgroesse;
                         ausgangy = y*TEXTUR.kachelgroesse;
                     }
                     
                     if(c.getRed()==200   &&c.getGreen() == 200     && c.getBlue() == 200)
                     {
                         telex = x;
                         teley = y;
                     }
                     
              }
         }
         for (BEWEGTESOBJEKT i : zeugs) {
           i.setOther(zeugs);
         }

  }
  public void update()
  {
      spieler.update(true); 
      BEWEGTESOBJEKT SpielerAufRubin = null;
      BEWEGTESOBJEKT SpielerAufBusch = null;
      BEWEGTESOBJEKT SpielerAufSaphir = null;
      BEWEGTESOBJEKT SteinAufSchlange = null;
      BEWEGTESOBJEKT SpielerHatKey = null;
      
      double zuSammelndeRubine = Math.round(anzahlRubine*0.75);
      for (BEWEGTESOBJEKT i : zeugs) {
         i.update();
         if (i.SteinAufSchlange() != null)
         {
             SteinAufSchlange = i.SteinAufSchlange(); 
         }
         if (i.RubinCollection()) 
         {
            SpielerAufRubin = i;
         }
         if (i.SaphirCollection()) 
         {
            SpielerAufSaphir = i;
         }
         if (i.BuschDecay()) 
         {
            SpielerAufBusch = i;
         }
         if (i.SchluesselCollection()) 
         {
            SpielerHatKey = i;
         }
         
         if (i.SpielerAufStein() || i.SchlangeSchlaegtSpieler()|| i.SpielerAufFeuer())
         {
             damage++;
             if (damage == 1)
             {
                 leben--;
                 uibottom.lebenNehmen();
                 damage = 0;
                 
                 
                 if (leben == 0)
                 {
                     FRAME.spielzustand = 3;
                     LEVELCOMPLETE.WinOrLoose = "loose";
                     FRAME.welt = null;
                    }
                }
         }
      } 
      if (SpielerAufRubin != null) {
        zeugs.remove(SpielerAufRubin);
        punkte++;
        if(punkte >= zuSammelndeRubine && AusgangExists == true )
            {    
             Ausgang = null;
             AusgangExists = false;
            }
      }
      if(SteinAufSchlange != null) {
        zeugs.remove(SteinAufSchlange);              
      }
      if (SpielerAufSaphir != null) {
        zeugs.remove(SpielerAufSaphir);
        LEVELWAHL.saphire++;
        
      }
      if (SpielerAufBusch != null) 
      {
          zeugs.remove(SpielerAufBusch);
      }
      if(SpielerHatKey != null) {
        zeugs.remove(SpielerHatKey);  
        keys++;
      } 
      if(door != null && COLLISION.RechteckZuRechteck(SPIELER.getXPos(),SPIELER.getYPos(),10,10,door.x,door.y,10,10))
      {
          spieler.resetPosition();
      }
      if(keys < 1)
      {
        if(schloss != null && schloss.SpielerAufSchloss())
        {
            spieler.resetPosition();
        }
      }
      else if(schloss != null && schloss.SpielerAufSchloss())
      {
          schloss = null;
          door = null;
          keys--;
      }
      
      if(punkte < zuSammelndeRubine)
      {
        if(Ausgang.SpielerAufAusgang())
        {
            spieler.resetPosition();
        }
      }
      uibottom.update();
      
  }
  public void draw(Graphics g)
  {    
      uibottom.draw(g);
      for(int x = 0; x < breite;x++)
      {
         for(int y = 0; y < hoehe;y++)
         {
             kacheln[x] [y].draw(g);
         }      
      }
      for(int i = 0; i < zeugs.size();i++)
      {
          BEWEGTESOBJEKT r= zeugs.get(i);
          r.draw(g);
          
      }
      double zuSammelndeRubine = Math.round(anzahlRubine*0.75);
      if(punkte < zuSammelndeRubine)
      {
          Ausgang.draw(g);
      }
      if(door != null)
      {
          door.draw(g);
      }
      if(schloss != null)
      {
          schloss.draw(g);
      }
      if(tutorial)tut.draw(g);
      spieler.draw(g);
      DecimalFormat twodigits = new DecimalFormat("00");
      String score = twodigits.format(punkte) +"/"+twodigits.format((int)zuSammelndeRubine);
      String scoreSaphir = twodigits.format(LEVELWAHL.saphire);
      g.setColor(Color.BLACK);
      g.setFont(font);
      fm = g.getFontMetrics();
      g.drawString(score, 2+fm.stringWidth(score)/2, 858+g.getFont().getSize());
      g.drawString(scoreSaphir, 122+fm.stringWidth(score)/2, 858+g.getFont().getSize());
    }
  
  
}
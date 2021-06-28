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
      private int anzahlRubine;

      
      public int punkte;
      private int leben;
      private int damage;
      private Font font;
      private FontMetrics fm;
      
      static String level;
      private LOCK Lock;
      private int locky;
      private int lockx;
      private double zuSammelndeRubine;
      private boolean LockExists;
      private UIBOTTOM uibottom;
      
      
 
  public WELT()
  {
      loadNextLevel(); //ruft die Methode zum Laden eines neuen Levels auf
      spieler = new SPIELER(spawnx,spawny);
      Lock = new LOCK(lockx,locky);
      LockExists = true;
      
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
      punkte = 0;
      damage = 0;
      leben = 5;
           for(int x = 0; x < breite;x++)
              {
                 for(int y = 0; y < hoehe;y++)
                 {
                     Color c = new Color(map.getRGB(x,y));
                     /**
                      * if(c.getRed()==ROTWERT && c.getGreen()==GRUENWERT && c.getBlue()==BLAUWERT) kacheln[x] [y] = new Kachel(POSITIONx,POSITIONy,lookID);
                      */
                    if(c.getRed()==150   &&c.getGreen() == 150   && c.getBlue() == 150)    kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0 = Ranke
                    if(c.getRed()==255 &&c.getGreen() == 115    && c.getBlue() == 0)       kacheln[x] [y] = new KACHEL(x,y,1);   //LookID 1 = FüllelementWand
                    if(c.getRed()==0   &&c.getGreen() == 150     && c.getBlue() == 150)    kacheln[x] [y] = new KACHEL(x,y,2);   //LookID 2 = Spawnpunkt
                    if(c.getRed()==255   &&c.getGreen() == 255     && c.getBlue() == 0)    kacheln[x] [y] = new KACHEL(x,y,3);   //LookID 3 = Ausgang
                    if(c.getRed()==250   &&c.getGreen() == 255     && c.getBlue() == 0)    kacheln[x] [y] = new KACHEL(x,y,4);   //LookID 4 = AusgangControll
                    if(c.getRed()==40   &&c.getGreen() == 100    && c.getBlue() == 40)     kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0; Busch
                    if(c.getRed()==255   &&c.getGreen() == 0    && c.getBlue() == 0)       kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0; Rubin
                    if(c.getRed()==0 &&c.getGreen() == 0     && c.getBlue() == 255)        kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0; Saphir
                    if(c.getRed()==0   &&c.getGreen() == 0     && c.getBlue() == 0)        kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0; Stein
                    if(c.getRed()==0   &&c.getGreen() == 255     && c.getBlue() == 0)      kacheln[x] [y] = new KACHEL(x,y,0);   //LookID 0; Schlange
                     /**
                      * Erstellt alle Objekte die von BEWWEGTESOBJEKT erben
                      */
                     if(c.getRed()==255 &&c.getGreen() == 0 && c.getBlue() == 0)
                     {
                         anzahlRubine++;
                         zeugs.add(new RUBIN(x,y));
                     }
                     if(c.getRed()==0 &&c.getGreen() == 0   && c.getBlue() == 0)
                     {
                         zeugs.add(new STEIN(x,y));
                     }
                     if(c.getRed()==40   &&c.getGreen() == 100    && c.getBlue() == 40)
                     {
                         zeugs.add(new BUSCH(x,y));                         
                     }
                     if(c.getRed()==0   &&c.getGreen() == 0    && c.getBlue() == 255)
                     {
                         zeugs.add(new SAPHIR(x,y));                         
                     }
                     if(c.getRed()==0   &&c.getGreen() == 255    && c.getBlue() == 0)
                     {
                         zeugs.add(new SCHLANGE(x,y));                         
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
                         lockx = x*TEXTUR.kachelgroesse;
                         locky = y*TEXTUR.kachelgroesse;
                         
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
      double zuSammelndeRubine = Math.round(anzahlRubine*0.75);
      for (BEWEGTESOBJEKT i : zeugs) {
         i.update();
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
         if (i.SpielerAufStein() || i.SchlangeSchlaegtSpieler())
         {
             damage++;
             if (damage == 5)
             {
                 leben--;
                 uibottom.lebenNehmen();
                 damage = 0;
                 
                 if (leben == 0)
                 {
                     FRAME.spielzustand = 1;
                    }
                }
         }
      } 
      if (SpielerAufRubin != null) {
        zeugs.remove(SpielerAufRubin);
        punkte++;
        if(punkte >= zuSammelndeRubine && LockExists == true )
            {    
             Lock = null;
             LockExists = false;
            }
      }
      if (SpielerAufSaphir != null) {
        zeugs.remove(SpielerAufSaphir);
        LEVELWAHL.saphire++;
        
      }
      if (SpielerAufBusch != null) 
      {
          zeugs.remove(SpielerAufBusch);
      }
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
          Lock.draw(g);
      }
      spieler.draw(g);
      DecimalFormat twodigits = new DecimalFormat("00");
      String score = twodigits.format(punkte) +"/"+(int)zuSammelndeRubine;
      String scoreSaphir = twodigits.format(LEVELWAHL.saphire);
      g.setColor(Color.BLACK);
      g.setFont(font);
      fm = g.getFontMetrics();
      g.drawString(score, 2+fm.stringWidth(score)/2, 858+g.getFont().getSize());
      g.drawString(scoreSaphir, 122+fm.stringWidth(score)/2, 858+g.getFont().getSize());
    }
    
  
}
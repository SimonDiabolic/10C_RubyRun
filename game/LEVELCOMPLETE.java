package game;
//---------------------//
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.FontMetrics;

//---------------------//

public class LEVELCOMPLETE
{
    private BufferedImage background;
    private BufferedImage title;
    private BufferedImage perfekt;
    private BUTTON[] buttons;
    public static int hoehe;
    public static int breite;
    public static String WinOrLoose;
    public static String rubine;
    public static String saphire;
    public static String damage;
    private Font f;
    private Font font;
    private FontMetrics fm;
    
    public static boolean Rperfekt;
    public static boolean Sperfekt;
    public static boolean Hperfekt;
    
    public LEVELCOMPLETE()
    {
        background = game.TEXTUR.background;
        title = game.TEXTUR.titel;
        perfekt = TEXTUR.perfekt;
        BufferedImage[] texturen = {TEXTUR.next, TEXTUR.next1, TEXTUR.next2};
        BufferedImage[] texturen1 = {TEXTUR.retry, TEXTUR.retry1, TEXTUR.retry2};
        BufferedImage[] texturen2 = {TEXTUR.goMenu, TEXTUR.goMenu1, TEXTUR.goMenu2};
  
        f = new Font("Monospaced",Font.BOLD + Font.ITALIC/*Fett/Kursiv*/,25/*Schriftgröße*/);
        font = new Font("Monospaced",Font.BOLD/*Fett/Kursiv*/,30/*Schriftgröße*/);
        
        buttons = new BUTTON[3];
        buttons[0] = new BUTTON(502, 691, "", texturen, f); 
        buttons[1] = new BUTTON(150, 691, "", texturen1, f);
        buttons[2] = new BUTTON(315, 691, "", texturen2, f);
        
        rubine = "Rubine: " +WELT.punkte +"/" + WELT.anzahlRubine;
        saphire = "Saphire: " +LEVELWAHL.saphire +"/" + WELT.anzahlSaphire;
        damage = "Hits: " + (5-WELT.leben);

        breite = background.getWidth();
        hoehe = background.getHeight();
    }
    public void draw(Graphics g)
    {
        g.drawImage(background, 0, 0, breite, hoehe, null); 
        g.drawImage(title, breite/2 - title.getWidth()/2, 155, null);
        g.setColor(Color.BLACK);
        g.setFont(font);
        fm = g.getFontMetrics();
        g.drawString(rubine,MENU.breite/2 -fm.stringWidth(rubine)/2,330);
        g.drawString(saphire,MENU.breite/2 -fm.stringWidth(saphire)/2,460);
        g.drawString(damage,MENU.breite/2 -fm.stringWidth(damage)/2,590);
        for(int i = 0; i < buttons.length;i++)
      {
        buttons[i].draw(g);
      }
      if(WELT.punkte == WELT.anzahlRubine)g.drawImage(perfekt,MENU.breite/2 - perfekt.getWidth()/2,350, null); 
      if(LEVELWAHL.saphire == WELT.anzahlSaphire)g.drawImage(perfekt,MENU.breite/2 -perfekt.getWidth()/2,480, null);
      if(WELT.leben == 5)g.drawImage(perfekt,MENU.breite/2 -perfekt.getWidth()/2,610, null);
    }
    public void update()
    {
          for(int i = 0; i < buttons.length;i++)
      {
          if(buttons[i].update())
          {
              if (i == 0) {LEVELWAHL.loadLevel(LEVELWAHL.currentLevel+1);FRAME.spielzustand = 2;FRAME.fmenu = null;
                  if(WELT.tutorial) 
                  WELT.tutorial = false;} //nächstes Level
              else if (i == 1){FRAME.spielzustand = 2;FRAME.fmenu = null;} //restartet das level
              else if (i == 2){FRAME.spielzustand = 1; FRAME.fmenu = null;
                  if(WELT.tutorial) 
                  WELT.tutorial = false;
                if(WELT.bosslevel) 
                  WELT.bosslevel = false;} //Geht zur Levelwahl
          }
      }
    }
  }

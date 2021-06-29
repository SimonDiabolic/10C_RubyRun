package game;
//---------------------//
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.FontMetrics;

//---------------------//

public class FMENU
{
    private BufferedImage background;
    private BufferedImage title;
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
    public FMENU()
    {
        background = game.TEXTUR.background;
        title = game.TEXTUR.titel;
        BufferedImage[] texturen1 = {TEXTUR.next, TEXTUR.next1, TEXTUR.next1};
        BufferedImage[] texturen = {TEXTUR.retry, TEXTUR.retry1, TEXTUR.retry1};
  
     f = new Font("Monospaced",Font.BOLD + Font.ITALIC/*Fett/Kursiv*/,25/*Schriftgröße*/);
     font = new Font("Monospaced",Font.BOLD + Font.ITALIC/*Fett/Kursiv*/,25/*Schriftgröße*/);
        
        buttons = new BUTTON[2];
        buttons[0] = new BUTTON(126, 730, "", texturen, f); 
        buttons[1] = new BUTTON(545, 730, "", texturen1, f); 
        
      if(WELT.punkte == WELT.anzahlRubine) {Rperfekt = true;}
      else Rperfekt = false;
      if(LEVELWAHL.saphire == WELT.anzahlSaphire) {Sperfekt = true;}
      else Sperfekt = false;
      if(WELT.leben != 0) {Hperfekt = false;}
      else Hperfekt = true;
        
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
        g.drawString(rubine,MENU.breite/2 -fm.stringWidth(rubine)/2,310);
        g.drawString(saphire,MENU.breite/2 -fm.stringWidth(saphire)/2,460);
        g.drawString(damage,MENU.breite/2 -fm.stringWidth(damage)/2,610);
        for(int i = 0; i < buttons.length;i++)
      {
        buttons[i].draw(g);
      }
    }
    public void update()
    {
          for(int i = 0; i < buttons.length;i++)
      {
          if(buttons[i].update())
          {
              if (i == 0) {game.FRAME.spielzustand = 1; FRAME.fmenu = null;}
              else if (i == 1){FRAME.spielzustand = 2;FRAME.fmenu = null;}
          }
      }
    }
}

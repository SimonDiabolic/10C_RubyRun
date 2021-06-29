package game;
//---------------------//
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

//---------------------//

public class FMENU
{
    private BufferedImage background;
    private BufferedImage title;
    private BUTTON[] buttons;
    public static int hoehe;
    public static int breite;
    public static String WinOrLoose;
    public String rubine;
    private Font f;
    
    
    public FMENU()
    {
        int x = MENU.breite/2 + 400/2;
        
        background = game.TEXTUR.background;
        title = game.TEXTUR.titel;
        BufferedImage[] texturen1 = {TEXTUR.next, TEXTUR.next1, TEXTUR.next1};
        BufferedImage[] texturen = {TEXTUR.retry, TEXTUR.retry1, TEXTUR.retry1};
  
        Font f = new Font("Monospaced",Font.BOLD + Font.ITALIC/*Fett/Kursiv*/,25/*Schriftgröße*/);
        
        buttons = new BUTTON[2];
        buttons[0] = new BUTTON(126, 730, "", texturen, f); 
        buttons[1] = new BUTTON(545, 730, "", texturen1, f); 
        
  

        breite = background.getWidth();
        hoehe = background.getHeight();
    }
    public void draw(Graphics g)
    {
        g.drawImage(background, 0, 0, breite, hoehe, null); 
        g.drawImage(title, breite/2 - title.getWidth()/2, 155, null);
 
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

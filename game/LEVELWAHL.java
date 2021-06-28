package game;
//---------------------//
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Font;

//---------------------//

public class LEVELWAHL
{
    private BufferedImage background;
    private BufferedImage title;
    private BUTTON[] buttons;
    public static int hoehe;
    public static int breite;
    
    public LEVELWAHL()
    {
        buttons = new BUTTON[3];
        BufferedImage[] texturen = {TEXTUR.button, TEXTUR.buttonmouseover, TEXTUR.buttonpressed};  
        
        Font f = new Font("SansSerif",Font.BOLD + Font.ITALIC/*Fett/Kursiv*/,25/*Schriftgröße*/);
        
        // buttons[0] = new BUTTON(200, "Spiel starten", texturen, f); 
        // buttons[1] = new BUTTON(350, "Spiel beenden", texturen, f); 
        // buttons[2] = new BUTTON(500, "About", texturen, f); 
        
        background = TEXTUR.background;
        title = TEXTUR.titel;
        breite = background.getWidth();
        hoehe = background.getHeight();
        
    }
    public void draw(Graphics g)
    {
        g.drawImage(background, 0, 0, breite, hoehe, null); 
        g.drawImage(title, breite/2 - title.getWidth()/2, 10, null);
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
              if (i == 0) FRAME.spielzustand = 1;
              else if (i == 1) System.exit(0);
              else if (i == 2);
          }
      }
    }
}

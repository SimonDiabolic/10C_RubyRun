package game;
//---------------------//
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Font;

//---------------------//

public class LEVELWAHL
{
    private BufferedImage background;
    private BufferedImage map;
    private BufferedImage title;
    private BUTTON[] buttons;
    public static int hoehe;
    public static int breite;
    
    public LEVELWAHL()
    {
        buttons = new BUTTON[3];
        BufferedImage[] texturen = {TEXTUR.x1, TEXTUR.x2,TEXTUR.x2};  
        
        Font f = new Font("SansSerif",Font.BOLD + Font.ITALIC/*Fett/Kursiv*/,25/*Schriftgröße*/);
        
        buttons[0] = new BUTTON(135,195, "", texturen, f); 
        buttons[1] = new BUTTON(280,210, "", texturen, f); 
        buttons[2] = new BUTTON(426,195, "", texturen, f); 
        
        background = TEXTUR.background;
        map = TEXTUR.map;
        title = TEXTUR.titel;
        breite = background.getWidth();
        hoehe = background.getHeight();
        
    }
    public void draw(Graphics g)
    {
        g.drawImage(background, 0, 0, breite, hoehe, null); 
        g.drawImage(map, breite/2 - map.getWidth()/2, hoehe/2 - map.getHeight()/2, null);
        g.drawImage(title, breite/2 - title.getWidth()/2, 15, null);
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
              if (i == 0) FRAME.spielzustand = 2;
              else if (i == 1) System.exit(0);
              else if (i == 2);
          }
      }
    }
}

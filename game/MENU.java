package game;
//---------------------//
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Font;

//---------------------//

public class MENU
{
    private BufferedImage background;
    private BufferedImage title;
    private BUTTON[] buttons;
    public static int hoehe;
    public static int breite;
    
    public MENU()
    {
        buttons = new BUTTON[3];
        BufferedImage[] texturen = {game.TEXTUR.button, game.TEXTUR.buttonmouseover, game.TEXTUR.buttonpressed};  
        
        Font f = new Font("SansSerif",Font.BOLD + Font.ITALIC/*Fett/Kursiv*/,25/*Schriftgröße*/);
        
        int x = MENU.breite/2 + 400/2;
        
        buttons[0] = new BUTTON(x,310, "Spiel starten", texturen, f); 
        buttons[1] = new BUTTON(x,460, "Spiel beenden", texturen, f); 
        buttons[2] = new BUTTON(x,610, "Tutorial", texturen, f); 
        
        background = game.TEXTUR.background;
        title = game.TEXTUR.titel;
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
              if (i == 0) game.FRAME.spielzustand = 1;
              else if (i == 1) System.exit(0);
              else if (i == 2){game.FRAME.spielzustand = 5;LEVELWAHL.loadLevel(0);WELT.tutorial = true;}
          }
      }
    }
}

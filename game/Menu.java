package game;
//---------------------//
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Font;

//---------------------//

public class Menu
{
    private BufferedImage background;
    private BufferedImage title;
    private Button[] buttons;
    public static int hoehe;
    public static int breite;
    
    public Menu()
    {
        buttons = new Button[3];
        BufferedImage[] texturen = {Textur.button, Textur.buttonmouseover, Textur.buttonpressed};  
        
        Font f = new Font("SansSerif",0/*Fett/Kursiv*/,0/*Schriftgröße*/);
        
        buttons[0] = new Button(200, "Spiel starten", texturen, f); 
        buttons[1] = new Button(350, "Spiel beenden", texturen, f); 
        buttons[2] = new Button(500, "About", texturen, f); 
        
        background = Textur.background;
        title = Textur.titel;
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
              if (i == 0) Frame.spielzustand = 1;
              else if (i == 1) System.exit(0);
              else if (i == 2);
          }
      }
    }
}

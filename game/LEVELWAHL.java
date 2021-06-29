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
    private game.BUTTON[] buttons;
    public static int hoehe;
    public static int breite;
    public static String level;
    public static int saphire;
    public static int currentLevel;
    public LEVELWAHL()
    {
        buttons = new game.BUTTON[10];
        BufferedImage[] texturen = {game.TEXTUR.x1, game.TEXTUR.x2,game.TEXTUR.x2};  
        
        Font f = new Font("SansSerif",Font.BOLD + Font.ITALIC/*Fett/Kursiv*/,25/*Schriftgröße*/);
        
        buttons[0] = new game.BUTTON(135,197, "", texturen, f); 
        buttons[1] = new game.BUTTON(280,212, "", texturen, f); 
        buttons[2] = new game.BUTTON(426,197, "", texturen, f);
        buttons[3] = new game.BUTTON(560,238, "", texturen, f); 
        buttons[4] = new game.BUTTON(544,367, "", texturen, f); 
        buttons[5] = new game.BUTTON(415,445, "", texturen, f); 
        buttons[6] = new game.BUTTON(220,440, "", texturen, f); 
        buttons[7] = new game.BUTTON(157,545, "", texturen, f); 
        buttons[8] = new game.BUTTON(280,630, "", texturen, f); 
        buttons[9] = new game.BUTTON(543,665, "", texturen, f); 
        
        background = game.TEXTUR.background;
        map = game.TEXTUR.map;
        title = game.TEXTUR.titel;
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
              if (i == 0)      {level=("lvl/level"+ (i+1)); game.FRAME.spielzustand = 2;currentLevel=(i+1);}
              else if (i == 1) {level=("lvl/level"+ (i+1)); game.FRAME.spielzustand = 2;currentLevel=(i+1);}
              else if (i == 2) {level=("lvl/level"+ (i+1)); game.FRAME.spielzustand = 2;currentLevel=(i+1);}
              else if (i == 3) {level=("lvl/level"+ (i+1)); game.FRAME.spielzustand = 2;currentLevel=(i+1);}
              else if (i == 4) {level=("lvl/level"+ (i+1)); game.FRAME.spielzustand = 2;currentLevel=(i+1);}
              else if (i == 5) {level=("lvl/level"+ (i+1)); game.FRAME.spielzustand = 2;currentLevel=(i+1);}
              else if (i == 6) {level=("lvl/level"+ (i+1)); game.FRAME.spielzustand = 2;currentLevel=(i+1);}
              else if (i == 7) {level=("lvl/level"+ (i+1)); game.FRAME.spielzustand = 2;currentLevel=(i+1);}
              else if (i == 8) {level=("lvl/level"+ (i+1)); game.FRAME.spielzustand = 2;currentLevel=(i+1);}
              else if (i == 9) {level=("lvl/level"+ (i+1)); game.FRAME.spielzustand = 2;currentLevel=(i+1);}
          }
      }
    }
    public static void loadLevel(int lvl)
    {
        level=("lvl/level"+ lvl); FRAME.spielzustand = 2;currentLevel++;
    }
}

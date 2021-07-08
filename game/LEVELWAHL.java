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
        BufferedImage[] lvl1 = {TEXTUR.lvl1busch1,TEXTUR.lvl1busch1,TEXTUR.lvl1busch1};
        BufferedImage[] lvl2 = {TEXTUR.lvl2figur1,TEXTUR.lvl2figur2,TEXTUR.lvl2figur2};
        BufferedImage[] lvl3 = {TEXTUR.lvl3rubin1, TEXTUR.lvl3rubin2,TEXTUR.lvl3rubin1};
        BufferedImage[] lvl4 = {TEXTUR.lvl4schlange1, TEXTUR.lvl4schlange1,TEXTUR.lvl4schlange1};
        BufferedImage[] lvl5 = {TEXTUR.lvl5saphir1, TEXTUR.lvl5saphir1,TEXTUR.lvl5saphir1};
        BufferedImage[] lvl6 = {TEXTUR.lvl6stein1, TEXTUR.lvl6stein1,TEXTUR.lvl6stein1};
        BufferedImage[] lvl7 = {TEXTUR.lvl7snake1, TEXTUR.lvl7snake2,TEXTUR.lvl7snake1};
        BufferedImage[] lvl8 = {TEXTUR.lvl8totenkopf1, TEXTUR.lvl8totenkopf2,TEXTUR.lvl8totenkopf1};
        BufferedImage[] lvl9 = {TEXTUR.x1, TEXTUR.x2,TEXTUR.x2};
        BufferedImage[] lvl10 ={TEXTUR.lvl10vulkan1, TEXTUR.lvl10vulkan2,TEXTUR.lvl10vulkan2};
        
        Font f = new Font("SansSerif",Font.BOLD + Font.ITALIC/*Fett/Kursiv*/,25/*Schriftgröße*/);
        
        buttons[0] = new game.BUTTON(180,190, "", lvl1, f); 
        buttons[1] = new game.BUTTON(285,212, "", lvl2, f); 
        buttons[2] = new game.BUTTON(426,197, "", lvl3, f);
        buttons[3] = new game.BUTTON(530,238, "", lvl4, f); 
        buttons[4] = new game.BUTTON(544,367, "", lvl5, f); 
        buttons[5] = new game.BUTTON(380,445, "", lvl6, f); 
        buttons[6] = new game.BUTTON(220,450, "", lvl7, f); 
        buttons[7] = new game.BUTTON(185,550, "", lvl8, f); 
        buttons[8] = new game.BUTTON(325,640, "", lvl9, f); 
        buttons[9] = new game.BUTTON(510,675, "", lvl10, f); 
        
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

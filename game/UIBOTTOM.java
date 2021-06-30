package game;
//---------------------//
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.awt.Font;

//---------------------//
public class UIBOTTOM
{
    private int x;
    private int y;
    private BufferedImage l1;
    private HERZ[] herzen;
    int i = 0;
    private BUTTON[] buttons;
    private Font f;
    public UIBOTTOM(int x, int y)
    {
        this.x = x; 
        this.y = y;
        l1 = TEXTUR.bar;
        f = new Font("Monospaced",Font.BOLD + Font.ITALIC/*Fett/Kursiv*/,25/*Schriftgröße*/);
        
        BufferedImage[] texturen1 = {TEXTUR.retry, TEXTUR.retry1, TEXTUR.retry1};
        BufferedImage[] HerzZustand = {TEXTUR.hr, TEXTUR.hs};
        herzen = new HERZ[5];
        
        buttons =  new BUTTON[1];
        buttons[0] = new BUTTON(300,825, "", texturen1, f);
        
        herzen[0] = new HERZ(440,825, HerzZustand); 
        herzen[1] = new HERZ(500,825, HerzZustand); 
        herzen[2] = new HERZ(560,825, HerzZustand); 
        herzen[3] = new HERZ(620,825, HerzZustand);  
        herzen[4] = new HERZ(680,825, HerzZustand);

    }
    public void draw(Graphics g)
    {
      g.drawImage(l1, x, y, null);
        // for(int i = 0; i < buttons.length;i++)
      // {
          // buttons[i].draw(g);
      // }
        for(int i = 0; i < herzen.length;i++)
      {
          herzen[i].draw(g);
      }
    }
    public void update()
    {
            for(int i = 0; i < buttons.length;i++)
      {
          if(buttons[i].update())
          {
            if (i == 1){FRAME.spielzustand = 2;FRAME.fmenu = null;}
          }
      } 
    }
    public void lebenNehmen()
    {
          herzen[i].HerzZustand = 1;
          i++;
    }
    
}

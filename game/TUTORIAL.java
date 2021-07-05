package game;
//---------------------//
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

//---------------------//

public class TUTORIAL
{
    private BufferedImage WASD;
    public TUTORIAL()
    {
        WASD = TEXTUR.WASD;
        
    }
    public void draw(Graphics g)
    {
      if(SPIELER.getXPos()==80 && SPIELER.getYPos() == 40)
      {
          g.drawImage(WASD, 800/2 - WASD.getWidth()/2, 700, null);
      }
    }
    public void update()
    {
      if(SPIELER.getXPos()==360 && SPIELER.getYPos() == 40)
        {
            for(int i= 0; i<4;i++)
            {
                
            }
        }
    }
    void gehen()
    {
    }
}

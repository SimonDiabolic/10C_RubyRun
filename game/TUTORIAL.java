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
    private BufferedImage WayBlock;
    private boolean drawWayBlock;
    private boolean FirstWayBlock;
    public TUTORIAL()
    {
        WASD = TEXTUR.WASD;
        WayBlock = TEXTUR.WayBlock;
        FirstWayBlock = true;
    }
    public void draw(Graphics g)
    {
      if(SPIELER.getXPos()==80 && SPIELER.getYPos() == 40)
      {
          g.drawImage(WASD, 800/2 - WASD.getWidth()/2, 700, null);
      }
      if(SPIELER.getXPos()==280 && SPIELER.getYPos() == 80)
      {
          g.drawImage(WASD, 800/2 - WASD.getWidth()/2, 700, null);
      }
      if(SPIELER.getXPos()==440 && SPIELER.getYPos() == 80)
      {
          g.drawImage(WASD, 800/2 - WASD.getWidth()/2, 700, null);
      }
      if(SPIELER.getXPos()==400 && SPIELER.getYPos() == 240)
      {
          g.drawImage(WASD, 800/2 - WASD.getWidth()/2, 700, null);
      }
      if(SPIELER.getXPos()==320 && SPIELER.getYPos() == 240)
      {
          g.drawImage(WASD, 800/2 - WASD.getWidth()/2, 700, null);
      }
      if(SPIELER.getXPos()==560 && SPIELER.getYPos() == 400)
      {
          g.drawImage(WASD, 800/2 - WASD.getWidth()/2, 700, null);
      }
      if(SPIELER.getXPos()==480 && SPIELER.getYPos() == 560)
      {
          g.drawImage(WASD, 800/2 - WASD.getWidth()/2, 700, null);
      }
      if(SPIELER.getXPos()==280 && SPIELER.getYPos() == 640)
      {
          g.drawImage(WASD, 800/2 - WASD.getWidth()/2, 700, null);
      }
      if(SPIELER.getXPos()==120 && SPIELER.getYPos() == 640)
      {
          g.drawImage(WASD, 800/2 - WASD.getWidth()/2, 700, null);
      }
    
    }
}

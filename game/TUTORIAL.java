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
    private BufferedImage T2;
    private BufferedImage T3;
    private BufferedImage T4;
    private BufferedImage T5;
    private BufferedImage T6;
    private BufferedImage T7;
    private BufferedImage T8;
    private BufferedImage T9;
    private BufferedImage WayBlock;
    private boolean drawWayBlock;
    private boolean FirstWayBlock;
    private boolean drawWASD;
    public TUTORIAL()
    {
        WASD = TEXTUR.WASD;
        WayBlock = TEXTUR.WayBlock;
        T2 = TEXTUR.T2;
        T3 = TEXTUR.T3;
        T4 = TEXTUR.T4;
        T5 = TEXTUR.T5;
        T6 = TEXTUR.T6;
        T7 = TEXTUR.T7;
        T8 = TEXTUR.T8;
        T9 = TEXTUR.T9;
        FirstWayBlock = true;
        drawWASD = true;
    }
    public void draw(Graphics g)
    {
      if(SPIELER.getXPos()==80 && SPIELER.getYPos() == 40 && drawWASD)
      {
          Timer timer = new Timer();
          g.drawImage(WASD, 800/2 - WASD.getWidth()/2, 700, null);
                timer.schedule(new TimerTask(){
                    public void run()
                    {
                        drawWASD = false;
                    }
                },1000);
                
                
      }
      if(SPIELER.getXPos()==320 && SPIELER.getYPos() == 80)
      {
          g.drawImage(T2, 800/2 - T2.getWidth()/2, 700, null);
      }
      if(SPIELER.getXPos()==440 && SPIELER.getYPos() == 80)
      {
          g.drawImage(T3, 800/2 - T3.getWidth()/2, 700, null);
      }
      if(SPIELER.getXPos()==400 && SPIELER.getYPos() == 240)
      {
          g.drawImage(T4, 800/2 - T4.getWidth()/2, 700, null);
      }
      if(SPIELER.getXPos()==360 && SPIELER.getYPos() == 240)
      {
          g.drawImage(T5, 800/2 - T5.getWidth()/2, 700, null);
      }
      if(SPIELER.getXPos()==520 && SPIELER.getYPos() == 400)
      {
          g.drawImage(T6, 800/2 - T6.getWidth()/2, 700, null);
      }
      if(SPIELER.getXPos()==480 && SPIELER.getYPos() == 560)
      {
          g.drawImage(WayBlock, 800/2 - WayBlock.getWidth()/2, 700, null);
      }
      if(SPIELER.getXPos()==360 && SPIELER.getYPos() == 640)
      {
          g.drawImage(T7, 800/2 - T7.getWidth()/2, 700, null);
      }
      if(SPIELER.getXPos()==320 && SPIELER.getYPos() == 640)
      {
          g.drawImage(T8, 800/2 - T8.getWidth()/2, 700, null);
      }
      if(SPIELER.getXPos()==120 && SPIELER.getYPos() == 640)
      {
          g.drawImage(T9, 800/2 - T9.getWidth()/2, 700, null);
      }
    
    }
}

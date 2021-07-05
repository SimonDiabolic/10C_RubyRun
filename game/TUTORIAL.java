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
      if(drawWayBlock)
      {
          g.drawImage(WayBlock, 800/2 - WayBlock.getWidth()/2, 700, null);
          Timer timer = new Timer();
                timer.schedule(new TimerTask(){
                    public void run()
                        {
                          drawWayBlock = false;
                        }
                },2000);
      }
    }
    public void update()
    {
        if(SPIELER.getXPos()==360 && SPIELER.getYPos() == 40 && FirstWayBlock)
            {
                Timer timer = new Timer();
                timer.schedule(new TimerTask(){
                    public void run()
                        {
                          gehen();
                        }
                },100);
            }
        if(SPIELER.getXPos()==400 && SPIELER.getYPos() == 40&& FirstWayBlock)
            {
                Timer timer = new Timer();
                timer.schedule(new TimerTask(){
                    public void run()
                        {
                          gehen();
                        }
                },100);
            }
        if(SPIELER.getXPos()==440 && SPIELER.getYPos() == 40&& FirstWayBlock)
            {
                Timer timer = new Timer();
                timer.schedule(new TimerTask(){
                    public void run()
                        {
                          gehen();
                        }
                },100);
            }
        if(SPIELER.getXPos()==480 && SPIELER.getYPos() == 40&& FirstWayBlock)
            {
                Timer timer = new Timer();
                timer.schedule(new TimerTask(){
                    public void run()
                        {
                          gehen();
                        }
                },100);
            }
        if(SPIELER.getXPos()==520 && SPIELER.getYPos() == 40&& FirstWayBlock)
            {
                Timer timer = new Timer();
                timer.schedule(new TimerTask(){
                    public void run()
                        {
                          gehen();
                        }
                },100);
                drawWayBlock = true;
                FirstWayBlock = false;
            }
    }
    void gehen()
    {
        SPIELER.x = SPIELER.x +40;SPIELER.directionx = 1;
    }
}

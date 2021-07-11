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
    private boolean drawT1;
    private boolean drawT2;
    private boolean drawT3;
    private boolean drawT4;
    private boolean drawT5;
    private boolean drawT6;
    private boolean drawT7;
    private boolean drawT8;
    private boolean drawT9;
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
        drawT2 = true;
        drawT3 = true;
        drawT4 = true;
        drawT5 = true;
        drawT6 = true;
        drawT7 = true;
        drawT8 = true;
        drawT9 = true;
        drawWayBlock = true;
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
                },2500);
      }
      if(SPIELER.getXPos()==320 && SPIELER.getYPos() == 80 && drawT2)
      {
          Timer timer = new Timer();
          g.drawImage(T2, 800/2 - T2.getWidth()/2, 700, null);
          timer.schedule(new TimerTask(){
                    public void run()
                    {
                        drawT2 = false;
                    }
                },2500);
      }
      if(SPIELER.getXPos()==440 && SPIELER.getYPos() == 80 && drawT3)
      {
          Timer timer = new Timer();
          g.drawImage(T3, 800/2 - T3.getWidth()/2, 700, null);
          timer.schedule(new TimerTask(){
                    public void run()
                    {
                        drawT3 = false;
                    }
                },2500);
      }
      if(SPIELER.getXPos()==400 && SPIELER.getYPos() == 240 && drawT4)
      {
          Timer timer = new Timer();
          g.drawImage(T4, 800/2 - T4.getWidth()/2, 700, null);
          timer.schedule(new TimerTask(){
                    public void run()
                    {
                        drawT4 = false;
                    }
                },2500);
      }
      if(SPIELER.getXPos()==360 && SPIELER.getYPos() == 240 && drawT5)
      {
          Timer timer = new Timer();
          g.drawImage(T5, 800/2 - T5.getWidth()/2, 700, null);
          timer.schedule(new TimerTask(){
                    public void run()
                    {
                        drawT5 = false;
                    }
                },2500);
      }
      if(SPIELER.getXPos()==520 && SPIELER.getYPos() == 400 && drawT6)
      {
          Timer timer = new Timer();
          g.drawImage(T6, 800/2 - T6.getWidth()/2, 700, null);
          timer.schedule(new TimerTask(){
                    public void run()
                    {
                        drawWASD = false;
                    }
                },2500);
      }
      if(SPIELER.getXPos()==480 && SPIELER.getYPos() == 560 && drawWayBlock)
      {
          Timer timer = new Timer();
          g.drawImage(WayBlock, 800/2 - WayBlock.getWidth()/2, 700, null);
          timer.schedule(new TimerTask(){
                    public void run()
                    {
                        drawWayBlock = false;
                    }
                },2500);
      }
      if(SPIELER.getXPos()==360 && SPIELER.getYPos() == 640 && drawT7)
      {
          Timer timer = new Timer();
          g.drawImage(T7, 800/2 - T7.getWidth()/2, 700, null);
          timer.schedule(new TimerTask(){
                    public void run()
                    {
                        drawT7 = false;
                    }
                },2500);
      }
      if(SPIELER.getXPos()==320 && SPIELER.getYPos() == 640 && drawT8)
      {
          Timer timer = new Timer();
          g.drawImage(T8, 800/2 - T8.getWidth()/2, 700, null);
          timer.schedule(new TimerTask(){
                    public void run()
                    {
                        drawT8 = false;
                    }
                },2500);
      }
      if(SPIELER.getXPos()==120 && SPIELER.getYPos() == 640 && drawT9)
      {
          Timer timer = new Timer();
          g.drawImage(T9, 800/2 - T9.getWidth()/2, 700, null);
          timer.schedule(new TimerTask(){
                    public void run()
                    {
                        drawT9 = false;
                    }
                },2500);
      }
    
    }
}

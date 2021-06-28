package game;
//---------------------//
import javax.swing.JFrame;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.KeyEvent;
//---------------------//
public class FRAME extends JFrame
{
  private BufferStrategy strat;
  private WELT welt;
  private MENU menu;
  private LEVELWAHL levelwahl;
  static int spielzustand;
  
  public FRAME()
  {
      super("RubyRun");
      KEYBOARD kb = new KEYBOARD();
      addKeyListener(kb);
      addMouseMotionListener(kb);
      addMouseListener(kb);
      menu = new MENU();
      levelwahl = new LEVELWAHL();
      WELT welt = null;
      

      
  }
  public void makestrat()
  {
      createBufferStrategy(2);
      strat = getBufferStrategy();
  }
  public void repaint()
  {
      Graphics g = strat.getDrawGraphics();
      draw(g);
      g.dispose();
      strat.show();
  }
  public void draw(Graphics g)
  {
      switch (spielzustand)
      {
          case 0:
              menu.draw(g);
                          break;
          case 1:
              levelwahl.draw(g);
                          break;                
          case 2:
              if(welt == null) {welt = new WELT();}
              welt.draw(g);
                          break;
                          
         
                                  
          default:
        
          break;
      }
  }
  public void update()
  {
      switch (spielzustand)
      {
          case 0:
              menu.update();
                          break;
          case 1:
              levelwahl.update();
                          break;
                          
          case 2:
              welt.update();
              if(KEYBOARD.isKeyPressed(KeyEvent.VK_ESCAPE)) spielzustand = 0;
                          break;
          default:
          
          break;
      }
  }

}


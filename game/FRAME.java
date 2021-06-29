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
  public static WELT welt;
  private MENU menu;
  private LEVELWAHL levelwahl;
  public static FMENU fmenu;
  public static int spielzustand;
  public FRAME()
  {
      super("RubyRun");
      KEYBOARD kb = new KEYBOARD();
      addKeyListener(kb);
      addMouseMotionListener(kb);
      addMouseListener(kb);
      menu = new MENU();
      

      
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
              if(levelwahl == null) {levelwahl = new LEVELWAHL();}
              levelwahl.draw(g);
                          break;                
          case 2:
              if(welt == null) {welt = new WELT();}
              welt.draw(g);
                          break;
          case 3:
              if(fmenu == null) {fmenu = new FMENU();}
              fmenu.draw(g);
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
          case 3:
              fmenu.update();
                          break;
          default:
          
          break;
      }
  }

}


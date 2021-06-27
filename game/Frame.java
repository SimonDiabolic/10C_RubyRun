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
public class Frame extends JFrame
{
  private BufferStrategy strat;
  private WELT welt;
  private Menu menu;
  static int spielzustand;
  public Frame()
  {
      super("RubyRun");
      Keyboard kb = new Keyboard();
      addKeyListener(kb);
      addMouseMotionListener(kb);
      addMouseListener(kb);
      welt = new WELT();
      menu = new Menu();
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
              welt.update();
              if(Keyboard.isKeyPressed(KeyEvent.VK_ESCAPE)) spielzustand = 0;
                          break;
          default:
          
          break;
      }
  }
}


package game;
//---------------------//
import javax.swing.JFrame;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
//---------------------//
public class Frame extends JFrame
{
  private BufferStrategy strat;
  private Welt welt;
  public Frame()
  {
      super("RubyRun");
      addKeyListener(new Keyboard());
      welt = new Welt();
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
      welt.draw(g);
  }
  public void update()
  {
      welt.update();
  }
}


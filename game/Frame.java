package game;
import javax.swing.JFrame;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Color;
public class Frame extends JFrame
{
  private BufferStrategy strat;
  private Spieler spieler;
  public Frame()
  {
      super("RubyRun");
      
      addKeyListener(new Keyboard());
      
      spieler = new Spieler(300,300);
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
      g.setColor(Color.BLACK);
      g.fillRect(0,0,Main.width,Main.height);
      spieler.draw(g);
  }
  public void update()
  {
      spieler.update();
  }
}

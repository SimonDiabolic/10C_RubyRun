package game;
//---------------------//
import java.awt.image.BufferedImage;
import java.awt.Graphics;
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
      
    }
}

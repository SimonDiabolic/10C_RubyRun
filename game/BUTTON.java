package game
;
//---------------------//
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.FontMetrics;
import java.awt.Color;

//---------------------//
public class BUTTON
{
    private int x,y;
    private Font font;
    private FontMetrics fm;
    private String name;
    private BufferedImage[] look;
    private int ButtonStatus;
    private Color color;
    public BUTTON(int x, int y, String name, BufferedImage[] look, Font font)
    {
        this.y = y;
        this.x = x;
        this.name = name;
        this.look = look;
        this.font = font;
        
        
    }
    public void draw(Graphics g)
    {
        g.setFont(font);
        fm = g.getFontMetrics();
        g.drawImage(look[ButtonStatus], x, y, null);
        g.setColor(Color.BLACK);
        g.drawString(name,x + look[ButtonStatus].getWidth()/2 - fm.stringWidth(name)/2,
                y + look[ButtonStatus].getHeight()/2 + font.getSize()/2-3);
    }
    public boolean update()
    {
         if(game.KEYBOARD.getButton() != 1&& ButtonStatus == 2)
         {
             ButtonStatus = 0;
             return true;
         }
        
         ButtonStatus = 0;
         int MausX = game.KEYBOARD.getMouseX();
         int MausY = game.KEYBOARD.getMouseY();
         if(game.COLLISION.RechteckZuRechteck(MausX,MausY, 0, 0, x, y, look[ButtonStatus].getWidth(), 
                     look[ButtonStatus].getHeight()))
                     {
                        if(game.KEYBOARD.getButton() == 1) ButtonStatus = 2;
                        else ButtonStatus = 1;
                     }
         return false;
    }
}

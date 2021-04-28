import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class gui extends JPanel implements ActionListener
{
    Image hintergrund;
    
    Timer time;
    int key;
    
    //gibt Position von "guibackground" aus
    int x_background;
    int y_background;
    
    //Variable für Bewegungsrichtung, überprüfung in class Keystroke
    int motiony;
    int motionx;
    
    //Position des Hintergrundes, wird mit motionx und motiony verrechnet
    int backgroundy;
    int backgroundx;
    public gui()
    {
        key = 0;
        motionx = 0;
        motiony = 0;
        
        setFocusable(true);
        ImageIcon u = new ImageIcon("guibackground.jpg");
        hintergrund = u.getImage();
        addKeyListener(new Keystroke());
        
        time = new Timer(5,this);
        time.start();
    }
    public void actionPerformed(ActionEvent x)
    {
        movement();
        repaint();
    }
    public void paint (Graphics g)
    {
        super.paint(g);
        
        Graphics2D f2 =(Graphics2D)g;
        
        
        /*if(getPosBackground() == 1000+ (anzahl *6432))
        {
            anzahl += 1;
            nx = 0;
        }
        if(getPosBackground() == 1000+ (anzahl2 *6432))
        {
            anzahl2 += 1;
            nx2 = 0;
        }
        if(getPosBackground() >= 1000)
        {
            f2.drawImage(hintergrund,1608-nx,y_background,null);
        }
        */
        f2.drawImage(hintergrund,backgroundx,backgroundy,null);
    }
    public void movement()
    {
        backgroundy += motiony;
        backgroundx += motionx;
    }
    private int getPosBackground()
    {
        return x_background|y_background;
    }
    
    //Steht Aus: Auslagern in seperate Klasse
    private class Keystroke extends KeyAdapter
    {
        public Keystroke()
        {
            
        }
        public void keyPressed(KeyEvent which)
            {
            key = which.getKeyCode();
            if(key == KeyEvent.VK_A)
            {
                motionx = 1;
            }
            if(key == KeyEvent.VK_D)
            {
                motionx = -1;
            }
            if(key == KeyEvent.VK_S)
            {
                motiony = -1;
            }
            if(key == KeyEvent.VK_W)
            {
                motiony = 1;
            }
        }
        public void keyReleased(KeyEvent which)
            {
               if(key==KeyEvent.VK_D||key==KeyEvent.VK_A||key==KeyEvent.VK_W||key==KeyEvent.VK_S)
               {
                   motionx = 0;
                   motiony = 0;
               }
            }
    }
}


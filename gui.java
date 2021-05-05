import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class gui extends JPanel implements ActionListener
{
    //______________________________________________________
    private static final int rasterGroesse = 40;
    private static final int hoeheFenster = rasterGroesse * 20;
    private static final int breiteFenster = rasterGroesse * 26;
    private static gui g = null;
    private JFrame fenster = null;
    
    //_____Test^ 
    
    Image hintergrund;
    Image spielfigur;
    
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
    
    //int spielfigurx;
    //int spielfigury;
    public gui()
    {
        key = 0;
        motionx = 0;
        motiony = 0;
        
        setFocusable(true);
        
        ImageIcon u = new ImageIcon("guibackground.jpg");
        hintergrund = u.getImage();
        
        ImageIcon s = new ImageIcon("guiSpielfigur1.png");
        spielfigur = s.getImage();
        
        addKeyListener(new Keystroke());
        
        time = new Timer(5,this);
        time.start();
        //____________________________________________________________
        fenster = new JFrame ("Zeichenfläche");
        fenster. setResizable (false);
        fenster. setVisible (true);
        fenster. setLayout (null);
        fenster. getContentPane (). setBackground (new Color (240, 240, 240));
        Insets i = fenster.getInsets();
        fenster. setSize (breiteFenster, hoeheFenster + i.top);         // Ausgleich für Fenstertitel
        
        JComponent hintergrund = new JComponent ()
        {
             /**
             * Zeichnet das Hintergrundmuster.
             */
            public void paintComponent (Graphics g)
            {
                g. setColor (Color. lightGray);
                for (int i = 1; i <= hoeheFenster / (rasterGroesse * 2); i++)
                {
                    g. drawLine (0, hoeheFenster / 2 + i * rasterGroesse, breiteFenster - 1, hoeheFenster / 2 + i * rasterGroesse);
                    g. drawLine (0, hoeheFenster / 2 - i * rasterGroesse, breiteFenster - 1, hoeheFenster / 2 - i * rasterGroesse);
                }
                for (int i = 1; i <= breiteFenster / (rasterGroesse * 2); i++)
                {
                    g. drawLine (breiteFenster / 2 + i * rasterGroesse, 0, breiteFenster / 2 + i * rasterGroesse, hoeheFenster - 1);
                    g. drawLine (breiteFenster / 2 - i * rasterGroesse, 0, breiteFenster / 2 - i * rasterGroesse, hoeheFenster - 1);
                }
                g. setColor (Color. lightGray);
                g. drawLine (0, hoeheFenster / 2, breiteFenster - 1, hoeheFenster / 2);
                g. drawLine (breiteFenster / 2, 0, breiteFenster / 2, hoeheFenster - 1);
            }
        };
        hintergrund. setVisible (true);
        hintergrund. setSize (breiteFenster, hoeheFenster);
        hintergrund. setLocation (0, 0);
        fenster. add (hintergrund);
        
        //Test^____________________________________
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
        f2.drawImage(spielfigur,10,10,null);
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


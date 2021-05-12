package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class startmenu extends JFrame implements ActionListener {
 
    private JButton gamestart;
    private JButton exit;
    private static final int rasterGroesse = 40;
    private static final int hoeheFenster = rasterGroesse * 20;
    private static final int breiteFenster = rasterGroesse * 26;
    private static gui g = null;
    //**private JButton test;
      
    public static void main(String[] args) {
     
     startmenu startmenu = new startmenu("RubyRun - Menü");
     startmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     startmenu.setSize(400,400);
     startmenu.setLayout(null);
     startmenu.setVisible(true);   
     
    }
    public startmenu (String title) {
     super(title);
     
     gamestart = new JButton("Spiel starten");
     gamestart.setBounds(120,40,160,40);
     gamestart.addActionListener(this);
     
     add(gamestart);
     
     exit = new JButton("Menü verlassen");
     exit.setBounds(120,120,160,40);
     exit.addActionListener(this);
     add(exit); 
     
     /**test = new JButton("");
     test.setBounds(120,200,50,50);
     add(test); */
     
    }
    public static void game() {
        JFrame game = new JFrame("RubyRun");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(800,800);
        game.setVisible(true);
        
        
        //____________________________________________________________
        //game = new JFrame ("Zeichenfläche");
        game. setResizable (false);
        game. setVisible (true);
        game. setLayout (null);

        //hintergrund.setVisible (true);
        //hintergrund.setSize (breiteFenster, hoeheFenster);
        //hintergrund.setLocation (0, 0);
        game.add(new gui());
        
        //Test^____________________________________
        
    }
    @Override
    public void actionPerformed(ActionEvent i)
    {
            
    if(i.getSource()==gamestart) {
        game();
    
    }
    if(i.getSource()==exit) {
        System.exit(0);
    
    } 
        
    }
}




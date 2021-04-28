import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class startmenu extends JFrame implements ActionListener {
 
    private JButton gamestart;
    private JButton exit;
      
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
     
    }
    public static void game() {
        JFrame game = new JFrame("RubyRun");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(1608,1050);
        game.setVisible(true);
        game.add(new gui());
        
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




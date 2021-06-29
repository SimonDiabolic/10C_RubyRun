package game;

public class MAIN
{
  static int width = 800;
  static int height = 920;
  
  public static void main(String[] args)
  {
     FRAME f = new FRAME();
     
     f.setDefaultCloseOperation(3); //3 entspricht EXOIT_ON_CLOSE
     f.setSize(width,height);
     f.setLayout(null);  
     f.setLocationRelativeTo(null);
     f.setResizable(false);
     // f.setUndecorated(true);
     f.setVisible(true);
     
     f.makestrat();
     while(true)
     {
         f.update();
         
         f.repaint();
         
         SPIELER.resetDirection();
         try
         {
             Thread.sleep(150);
         }  catch (InterruptedException e)
         {
             e.printStackTrace();
         }
     }
  }
}


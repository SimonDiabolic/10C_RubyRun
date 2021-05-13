package game;

public class Main
{
  static int width = 800;
  static int height = 800;
  
  public static void main(String[] args)
  {
     Frame f = new Frame();
     
     f.setDefaultCloseOperation(3); //3 entspricht EXOIT_ON_CLOSE
     f.setSize(width,height);
     f.setLayout(null);  
     f.setLocationRelativeTo(null);
     f.setResizable(false);
     f.setUndecorated(true);
     f.setVisible(true);
     
     f.makestrat();
     
     while(true)
     {
         f.update();
         
         f.repaint();
         
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

